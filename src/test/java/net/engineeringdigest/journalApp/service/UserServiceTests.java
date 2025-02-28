package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;


    @Disabled
    @BeforeEach// we also have @AfterEach for opposite
    public void setUp(){
        // this test will run before each test below
    }

    @Disabled
    @BeforeAll // we also have @AfterAll for opposite
    public static void newUp(){
        //this test will run before

    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){

        //assertTrue(userService.saveNewUser(user));
    }


    // this annotation tells springboot to skip this function for testing
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4",
            "3,3,9"
    })
    @Disabled
    public void testSum(int a, int b, int expected){
       // assertEquals(expected,a+b,"failed for"+ a+b);
    }


}
