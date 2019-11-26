package com.junit;
public class MoodAnalyser {
    private String message;

    public MoodAnalyser() { }
    public MoodAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() ==0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Invalid Mood");
            else if (message.contains("SAD"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException ne)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Invalid Mood");
        }
    }

}
