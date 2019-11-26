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
}
