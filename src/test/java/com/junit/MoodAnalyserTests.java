package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTests {
    @Test
    public void givenMsg_shouldReturnSad_whenItsSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("im feeling SAD");
        Assert.assertEquals("SAD",mood);
    }
}
