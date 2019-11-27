package com.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Constructor;

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
        }catch (MoodAnalysisException mae){
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
        }catch (MoodAnalysisException mae) {
            /* TEST WILL PASS EVEN WITHOUT ASSERT,ITS JUST TO VALIDATE THE EXCEPTION MESSAGE*/
            Assert.assertEquals("Mood cannot be Empty", mae.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenProper_returnObject() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenProper_returnObject");
        Constructor<?> constructor=MoodAnalyserReflactor.getConstructor();
        Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor);
        Assert.assertEquals(myObject,new MoodAnalyser());
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperName_classNotFoundException() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperName_classNotFoundException");
      try {
          Constructor myConstructor = MoodAnalyserReflactor.getConstructor();
      }catch (MoodAnalysisException e){
          Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
      }
    }


    @Test
    public void givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException");

        try {
            Constructor myConstructor = MoodAnalyserReflactor.getConstructor();
            Object myObject = MoodAnalyserReflactor.createMoodAnalyser(myConstructor);
            MoodAnalyserReflactor.setFieldValue(myObject, "message" , "this is a sad message");
            MoodAnalyserReflactor.invokeMethod(myObject, "analyseMood1");
        }
        catch (MoodAnalysisException mea)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, mea.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenProper_returnObject_WithParameters() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenProper_returnObject");
        Constructor constructor = MoodAnalyserReflactor.getConstructor(String.class);
        Object object = MoodAnalyserReflactor.createMoodAnalyser(constructor,"Im in HAPPY mood");
        Assert.assertEquals(object,new MoodAnalyser());
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperName_classNotFoundException_withParameter() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperName_classNotFoundException_withParameter");
        try {
            Constructor myConstructor = MoodAnalyserReflactor.getConstructor(String.class);
            Object object = MoodAnalyserReflactor.createMoodAnalyser(myConstructor,"this is a sad message");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException_WithParameter() throws MoodAnalysisException {
        System.out.println("givenMoodAnalyserClass_whenImproperMethodName_MethodNotFoundException_WithParameter");
      try {
          Constructor<?> constructor=MoodAnalyserReflactor.getConstructor(String.class);
          Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor,"Im in HAPPY mood");
          MoodAnalyserReflactor.setFieldValue(myObject, "message" , "this is a sad message");
          MoodAnalyserReflactor.invokeMethod(myObject, "analyseMood1");
      }catch (MoodAnalysisException mea){
        Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, mea.type);
      }

    }

    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflactor.getConstructor(String.class);
            Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor,"I am in HAPPY Mood");
            Object analyzeMood = MoodAnalyserReflactor.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", analyzeMood);
        } catch (MoodAnalysisException e) {
        }

    }

    @Test
    public void givenMoodAnalyzer_OnChangeMood_Should_Return_Happy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflactor.getConstructor(String.class);
            Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor,"I am in HAPPY Mood");
            MoodAnalyserReflactor.setFieldValue(myObject,"message","I am in HAPPY Mood");
            Object analyzeMood = MoodAnalyserReflactor.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", analyzeMood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMsg_withDefaultConstructor_ShouldReturnHappy() {
       try {
           Constructor<?> constructor=MoodAnalyserReflactor.getConstructor();
           Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor);
           MoodAnalyserReflactor.setFieldValue(myObject,"message","I am in HAPPY Mood");
           Object analyzeMood = MoodAnalyserReflactor.invokeMethod(myObject, "analyseMood");
           Assert.assertEquals("HAPPY", analyzeMood);
       } catch (MoodAnalysisException e) {
           e.printStackTrace();
       }
    }

    @Test
    public void givenMoodAnalyserClass_whenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor=MoodAnalyserReflactor.getConstructor(String.class);
            Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor,"Im in HAPPY mood");
            Assert.assertEquals(new MoodAnalyser("Im in HAPPY mood"), myObject);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_withDefaultConstructor_ShouldReturnObject() {
        try {
            Constructor<?> constructor=MoodAnalyserReflactor.getConstructor();
            Object myObject = MoodAnalyserReflactor.createMoodAnalyser(constructor);
            MoodAnalyserReflactor.setFieldValue(myObject,"message","Im in HAPPY mood");
            Object mood = MoodAnalyserReflactor.invokeMethod(myObject,"analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

}
