package com.junit;

import java.applet.Applet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
        public static MoodAnalyser createMoodAnalyser() throws MoodAnalysisException {
            try {
                Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser");
                Constructor<?> moodConstructor = moodAnalyseClass.getConstructor();
                Object moodObject = moodConstructor.newInstance();
                return (MoodAnalyser) moodObject;
            } catch (ClassNotFoundException e) {
                throw new MoodAnalysisException("No Such Class Present");
            } catch (NoSuchMethodException e) {
                throw new MoodAnalysisException("No Such Method Present");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }

    public static MoodAnalyser createMoodAnalyserClassNotFound() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser1");
            Constructor<?> moodConstructor = moodAnalyseClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Present");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Present");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyserMethodNotFound() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyseClass.getConstructor(Applet.class);
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Present");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Present");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyseClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Present");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Present");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyserClassNotFound(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser1");
            Constructor<?> moodConstructor = moodAnalyseClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Present");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Present");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyserMethodNotFound(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.junit.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyseClass.getConstructor(Applet.class);
            Object moodObject = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Present");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Present");
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
