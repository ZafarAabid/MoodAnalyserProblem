package com.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTests {

    @Test
    public void givenMsg_shouldReturnSad_whenItsSad_ByConstructor() throws MoodAnalysisException {
        System.out.println("givenMsg_shouldReturnSad_whenItsSad_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser("I'm in SAD Mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMsg_shouldReturnHappy_whenItsHappy_ByConstructor() throws MoodAnalysisException {
        System.out.println("givenMsg_shouldReturnSad_whenItsSad_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser("I'm in HAPPY Mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor() throws MoodAnalysisException {
        System.out.println("givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor");
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMsg_shouldInformUser_whenItPassNull_ByConstructor() throws MoodAnalysisException {
        System.out.println("givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor");
        try {
            ExpectedException expectedException= ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
             String mood = moodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException mae)
        {
            /* TEST WILL PASS EVEN WITHOUT ASSERT,ITS JUST TO VALIDATE THE EXCEPTION MESSAGE*/
           Assert.assertEquals("Mood cannot be Null",mae.getMessage());
        }
    }

    @Test
    public void givenMsg_shouldInformUser_whenItPassEmptyString_ByConstructor() throws MoodAnalysisException {
        System.out.println("givenMsg_shouldReturnHappy_whenItPassNull_ByConstructor");
        try {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException mae) {
            /* TEST WILL PASS EVEN WITHOUT ASSERT,ITS JUST TO VALIDATE THE EXCEPTION MESSAGE*/
            Assert.assertEquals("Mood cannot be Empty", mae.getMessage());
        }
    }




}
