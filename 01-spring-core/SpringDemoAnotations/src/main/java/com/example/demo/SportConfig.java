package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.example.demo")
//The above line is used to demonstrate Inversion of control using the annotations form Java Config file
//
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return  new SadFortuneService();
    }

    // define bean for swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
