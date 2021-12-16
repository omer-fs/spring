package com.example.demo;

import javax.sound.midi.Track;

public class TrackCoach implements Coach{
    private FortuneService fortuneService;

    TrackCoach(){

    }
    TrackCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it! " + fortuneService.getFortune();
    }

    //add an init method
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }
    //add a destroy method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
