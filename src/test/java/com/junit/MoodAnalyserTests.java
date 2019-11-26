package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTests {
    @Test
    public void givenMsg_shouldReturnSad_whenItsSad() {
        System.out.println("givenMsg_shouldReturnSad_whenItsSad");
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("I'm in SAD Mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMsg_shouldReturnHappy_whenItsInAnyMood() {
        System.out.println("givenMsg_shouldReturnHappy_whenItsInAnyMood");
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("I'm in Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }

}
