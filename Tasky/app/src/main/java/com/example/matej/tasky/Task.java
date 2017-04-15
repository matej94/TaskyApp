package com.example.matej.tasky;

/**
 * Created by Matej on 11.4.2017..
 */

public class Task {
    private String mTitle;
    private String mDescription;
    private int mPriority;
    public Task(String title,String description,int priority) {

        mTitle = title;
        mDescription = description;
        mPriority = priority;
    }
    public String getTitle() { return mTitle; }
    public String getDescription(){return mDescription;}
    public int getPriority(){return mPriority;}

}
