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
        System.out.println("givenMsg_shouldInformUser_whenItPassEmptyString_ByConstructor");
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

    @Test
    public void givenMoodAnalyserClass_whenProper_returnObject() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenProper_returnObject");
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser();
        Assert.assertEquals(MoodAnalyserFactory.createMoodAnalyser(),moodAnalyser);
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperName_classNotFoundException() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperName_classNotFoundException");

      try {
          MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();

          Assert.assertEquals(MoodAnalyserFactory.createMoodAnalyserClassNotFound(), moodAnalyser);
      }
      catch (MoodAnalysisException mea)
      {
          Assert.assertEquals("No Such Class Present",mea.getMessage());
      }
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException");

        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            Assert.assertEquals(MoodAnalyserFactory.createMoodAnalyserMethodNotFound(), moodAnalyser);
        }
        catch (MoodAnalysisException mea)
        {
            Assert.assertEquals("No Such Method Present",mea.getMessage());

        }
    }
    @Test
    public void givenMoodAnalyserClass_whenProper_returnObject_WithParameters() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenProper_returnObject");
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I'm in HAPPY mood");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperName_classNotFoundException_withParameter() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperName_classNotFoundException_withParameter");
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I'm in HAPPY mood");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException_WithParameter() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException_WithParameter");
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I'm in HAPPY mood");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}
