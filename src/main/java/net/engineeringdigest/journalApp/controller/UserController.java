package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.service.WeatherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    WeatherService weatherService;
    @PutMapping
    public ResponseEntity<?> updateUser (@RequestBody User newUser)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User oldUser = userService.findByUserName(userName);
        oldUser.setUserName(newUser.getUserName());
        oldUser.setPassword(newUser.getPassword());
        userService.saveUser(oldUser);

        return new ResponseEntity<>(oldUser,HttpStatus.NO_CONTENT);

    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting ="";
        if(weatherResponse!=null){
            greeting=", Todays Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName()+greeting,HttpStatus.OK);
    }







}