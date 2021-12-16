package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    //create an array of strings
    private String[] data = {
            "Beware of the wolf in Sheep's clothing",
            "Diligence is the mother of good luck",
            "The Journey is the reward"
    };

    // random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        //pick a random string from the array
        int index = random.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }
}
