package net.engineeringdigest.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
//@ComponentScan(basePackages = "net.engineeringdigest.journalApp")
@EnableTransactionManagement
@EnableScheduling
public class JournalApplication {

    public static void main(String[] args) {

       SpringApplication.run(JournalApplication.class, args);
       //API Key weather - 6462f2d8328f098476daaae8b30947ef
       //API key Qoutes - qsMMvkJdRgjfuNomaf2tZw==QWMJBfYEgfp2JzwQ


    }


    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }

    @Bean
    public RestTemplate restTemplate(){
         return  new RestTemplate();
    }
}