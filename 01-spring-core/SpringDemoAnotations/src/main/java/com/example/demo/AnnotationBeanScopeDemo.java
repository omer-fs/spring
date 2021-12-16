package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        // calling methods on the bean
        boolean result = (theCoach == alphaCoach);
        // printout the results of our comparison
        System.out.println("\nPointing to the same object: "+result);
        System.out.println("\nMemory location for theCoach: "+theCoach);
        System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
        //close context
        context.close();
    }
}
