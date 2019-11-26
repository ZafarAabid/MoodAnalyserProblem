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
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Mood cannot be Empty");
            else if (message.contains("SAD"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException ne)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Mood cannot be Null");
        }
    }
    public boolean equals(Object thisObject)
    {
        if(thisObject instanceof MoodAnalyser)
            return true;
        return false;
    }

}
