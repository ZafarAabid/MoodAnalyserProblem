package com.junit;

public class MoodAnalysisException extends Exception{
    ExceptionType type;
    public MoodAnalysisException(String mood)
    {
        super(mood);
    }
    public enum ExceptionType {
        ENTERED_NULL,ENTERED_EMPTY
    }

    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
}
