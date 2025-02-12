package net.engineeringdigest.journalApp.services;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//    each logger has a different instance for different class. so keep it private
//    logger should not be re-assigned. So final
//    we want only one instance for the class JournalEntryService class. So, static

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e){
            log.error("Error Ocuured for {} : ", user.getUserName(), e);
            log.info("hahaha");
            log.warn("hahaha");
            log.debug("hahaha");
            log.trace("hahaha");
            return false;
        }
    }


    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ADMIN", "USER"));
        userRepo.save(user);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

    public List<User> getAll(){
         return userRepo.findAll();
    }

    public Optional<User> findByID(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteByID(ObjectId id){
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}
