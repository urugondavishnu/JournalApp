package net.engineeringdigest.journalApp.scheduler;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.repository.UserRepoIMPL;
import net.engineeringdigest.journalApp.services.EmailServices;
import net.engineeringdigest.journalApp.services.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class userScheduler {

    @Autowired
    private EmailServices emailServices;

    @Autowired
    private UserRepoIMPL userRepoIMPL;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;


    @Scheduled(cron = "0 0/30 * ? * *")
    public void fetchUsersAndSendSAMail(){
        List<User> userSA = userRepoIMPL.getUserSA();

        for (User user : userSA){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<String> filteredEntries = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getContent()).collect(Collectors.toList());
            String entry = String.join(" ", filteredEntries);
            String sentiment = sentimentAnalysisService.getSentiment(entry);
            emailServices.sendEmail(user.getEmail(), "Sentiment for last 7 days", sentiment);

        }
    }

    @Scheduled(cron = "0 0/10 * ? * *") // the cache refreshes every 10 mins
    public void clearAppCache(){
        appCache.init();
    }
}
