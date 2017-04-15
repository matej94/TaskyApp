package com.example.matej.tasky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Matej on 13.4.2017..
 */

public class TaskDBHelper extends SQLiteOpenHelper {
    // Singleton
    private static TaskDBHelper mTaskDBHelper = null;
    public TaskDBHelper (Context context){
        super(context.getApplicationContext(),Schema.DATABASE_NAME,null,Schema.SCHEMA_VERSION);
    }
    public static synchronized TaskDBHelper getInstance(Context context){
        if(mTaskDBHelper == null){
            mTaskDBHelper = new TaskDBHelper(context);
        }
        return mTaskDBHelper;
    }
    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_TABLE_MY_TASKS); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MY_TASKS);
        this.onCreate(db);
    }
    //SQL statements
    static final String CREATE_TABLE_MY_TASKS = "CREATE TABLE " + Schema.TABLE_MY_TASKS +
            " (" + Schema.TITLE + " TEXT," + Schema.DESCRIPTION + " TEXT," + Schema.PRIORITY + " INTEGER);";
    static final String DROP_TABLE_MY_TASKS = "DROP TABLE IF EXISTS " + Schema.TABLE_MY_TASKS;
    static final String SELECT_ALL_TASKS = "SELECT " + Schema.TITLE + "," + Schema.DESCRIPTION + ","
            + Schema.PRIORITY + " FROM " + Schema.TABLE_MY_TASKS;
    // CRUD should be performed on another thread
    public void insertTask(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.TITLE, task.getTitle());
        contentValues.put(Schema.DESCRIPTION, task.getDescription());
        contentValues.put(Schema.PRIORITY, task.getPriority());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_MY_TASKS, Schema.TITLE,contentValues);
        writeableDatabase.close();
    }
    public ArrayList<Task> getAllTasks(){
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writeableDatabase.rawQuery(SELECT_ALL_TASKS,null);
        ArrayList<Task> tasks = new ArrayList<>();
        if(taskCursor.moveToFirst()){
            do{
                String title = taskCursor.getString(0);
                String description = taskCursor.getString(1);
                int priority = taskCursor.getInt(2);
                tasks.add(new Task(title,description,priority));
            }while(taskCursor.moveToNext());
        }
        taskCursor.close();
        writeableDatabase.close();
        return tasks;
    }
    public void deleteTask(Task task){
        String Title= task.getTitle();
        String[] arg = new String[]{String.valueOf(Title)};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Schema.TABLE_MY_TASKS, Schema.TITLE + "=?", arg);
        db.close();
    }
    public static class Schema{
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "tasks.db";
        //A table to store owned books:
        static final String TABLE_MY_TASKS = "my_tasks";
        static final String TITLE = "Naslov";
        static final String DESCRIPTION = "Opis";
        static final String PRIORITY = "Prioritet";

    }
}
