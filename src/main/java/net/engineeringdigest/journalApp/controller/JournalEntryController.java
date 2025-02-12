//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.Entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntries = new HashMap();
//
//    @GetMapping //("/abc") // Now the path is /journal/abc
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//    // If at the URL, get is selected, then the above will be used
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
////        journalEntries.put(myEntry.getId(), myEntry); commented because the id is changed from long to String.
//        return true;
//    }
////    If at the URL, post is selected, then the above will be used
////    Through postman, post is selected and the conetent written in it is used to put in the createEntry class
////    @RequestBody JournalEntry basically takes the content according to JournalEntry manner
//
//    @GetMapping("/id/{myID}")
//    public JournalEntry getJournalentryBYID(@PathVariable Long myID){
//        return journalEntries.get(myID);
//    }
//
//    @DeleteMapping("/id/{myID}")
//    public JournalEntry deleteEntryByID(@PathVariable Long myID){
//        return journalEntries.remove(myID);
//    }
//
//    @PutMapping("/id/{id}")
//    public JournalEntry updateHournalByID(@PathVariable Long id, @RequestBody JournalEntry myEntry){
//        return  journalEntries.put(id,myEntry);
//    }
//
//}
