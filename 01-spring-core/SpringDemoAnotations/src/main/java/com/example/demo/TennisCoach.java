package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
// making the scope prototype creates new instance every time meaning creating different object every time a bean is created
public class TennisCoach implements Coach{
    // add @Autowired to demonstrate the field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("TennisCoach: Inside default constructor");
    }

    // define init method to denote the beginning of the lifecycle of the bean
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("TennisCoach: Inside of doMyStartupStuff()");
    }
    // define destroy method to denote the ending of the lifecycle of the bean
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("TennisCoach: Inside of doMyCleanupStuff");
    }




    // define a setter method to demonstrate setter injection
    /*
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService){
        System.out.println("TennisCoach: Inside method doSomeCrazyStuff()");
        this.fortuneService = fortuneService;
    }
    */

//    define a parameterized constructor to demonstrate the constructor injection
    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    */
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
