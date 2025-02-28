package net.engineeringdigest.journalApp.service;


import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Disabled
public class UserDetailsServiceImplMock {


    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Mock
    UserRepo userRepo;

    @Disabled
    @BeforeEach
    void  setUpAll(){
        //MockitoAnnotations.initMocks(this);
    }


    @Disabled
    @Test
    void loadUserByUserNameTest(){
      /* when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ram").password("Ram").roles(new ArrayList<>()).build());
       UserDetails user = userDetailsService.loadUserByUsername("ram");
        assertNotNull(user);*/
    }


}
