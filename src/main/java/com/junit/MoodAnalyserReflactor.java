package com.junit;

import java.applet.Applet;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflactor {
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

    public static Object invokeMethod(Object moodAnalyzerObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyzerObject.getClass().getMethod(methodName).invoke(moodAnalyzerObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,
                    "Define proper method!......");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "May be Issue with Data Entered", e);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS,"Not Accessible!",e);
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,
                    "Define Proper Field Name!......");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS,
                    "May be Issue with Access", e);
        }

    }
}
