package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTests {

    @Test
    public void givenMsg_shouldReturnSad_whenItsSad_ByConstructor() {
        System.out.println("givenMsg_shouldReturnSad_whenItsSad_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser("I'm in SAD Mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMsg_shouldReturnHappy_whenItsHappy_ByConstructor() {
        System.out.println("givenMsg_shouldReturnSad_whenItsSad_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser("I'm in HAPPY Mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor() {
        System.out.println("givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }




}
