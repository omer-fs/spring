package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve been from spring container
        Coach coach = context.getBean("myCoach",Coach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        //close the context
        context.close();
    }
}
