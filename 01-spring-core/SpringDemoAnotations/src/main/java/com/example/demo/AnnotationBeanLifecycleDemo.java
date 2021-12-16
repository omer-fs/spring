package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanLifecycleDemo {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean form the spring container
        Coach coach = context.getBean("tennisCoach",Coach.class);
        // call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //close the context
        context.close();
    }
}
