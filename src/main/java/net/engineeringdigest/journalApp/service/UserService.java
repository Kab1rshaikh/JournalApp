package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    // This service class calls repository class

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public boolean saveNewUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);

            return true;

        } catch (Exception e) {
            log.info("Error in saveNewUser");
            log.error("Error occured for name {} :",user.getUserName(),e);
            log.debug("jfadakga");
            log.trace("faefesrb");
            log.warn("wdwgreb");

            return false;
        }
    }
    public void saveAdmin(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }
    public void saveUser(User user){
       //user.setPassword(passwordEncoder.encode(user.getPassword()));
       //user.setRoles(Arrays.asList("USER"));
       userRepo.save(user);
    }

    public List<User> getALl()
    {
        return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);

    }
    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }






}
