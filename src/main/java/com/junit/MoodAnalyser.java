package com.junit;
public class MoodAnalyser {
    private String message;

    public MoodAnalyser() { }
    public MoodAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood(String message) {

        if(message.contains("SAD"))
            return "SAD";
        else
            return "HAPPY";
    }

    public String analyseMood() {

            return "SAD";
    }
}
