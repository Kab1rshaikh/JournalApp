package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    // This service class calls repository class

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userservice;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {

        try {
            User user = userservice.findByUserName(userName);
            JournalEntry saved = journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(saved);
            //user.setUserName(null);
            userservice.saveUser(user);//for saving the same user with new journal entry

        } catch (Exception e) {
            throw new RuntimeException("Error occured in JournalEntryService saveEntry",e);
        }
    }



    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);

    }

    public List<JournalEntry> getALl(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            User user = userservice.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed) {
                userservice.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry"+e);
        }
        return removed;

    }




}
