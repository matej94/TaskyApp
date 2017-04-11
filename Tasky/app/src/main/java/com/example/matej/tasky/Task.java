package com.example.matej.tasky;

/**
 * Created by Matej on 11.4.2017..
 */

public class Task {
    private String mTitle;
    private int mPriority;
    public Task(String title,int priority) {

        mTitle = title;
        mPriority = priority;
    }
    public String getTitle() { return mTitle; }
    public int getPriority(){return mPriority;}

}
