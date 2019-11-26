package com.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
        public static MoodAnalyser createMoodAnalyser() {
            try {
                Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser");
                Constructor<?> moodConstructor = moodAnalyseClass.getConstructor();
                Object moodObject = moodConstructor.newInstance();
                return (MoodAnalyser) moodObject;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
}
