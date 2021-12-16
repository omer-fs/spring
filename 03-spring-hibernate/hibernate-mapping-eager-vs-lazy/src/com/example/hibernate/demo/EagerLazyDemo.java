package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            // during eager fetch all the data from the database is already is loaded by this time, we need not visit the database again
            // during lazy fetch courses are loaded only on demand, hibernate uses querying to get the courses on demand
            System.out.println("luv2code: Instructor: " + tempInstructor);

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            // option 1: call getter method while session is open
            System.out.println("luv2code: The session is now Closed");
            // the below line will not fail since the courses are already loaded in the memory

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();


            System.out.println("luv2code: Done!");
        }
        finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}




