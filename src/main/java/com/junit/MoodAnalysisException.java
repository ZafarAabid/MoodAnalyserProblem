package com.junit;

public class MoodAnalysisException extends Exception{
    ExceptionType type;
    public MoodAnalysisException(String mood)
    {
        super(mood);
    }


    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_ACCESS
    }

    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
    public MoodAnalysisException(ExceptionType cause, ReflectiveOperationException e) {
        super(String.valueOf(cause));
        this.type=type;

    }

    public MoodAnalysisException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
