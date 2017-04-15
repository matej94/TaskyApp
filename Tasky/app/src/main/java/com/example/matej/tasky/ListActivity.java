package com.example.matej.tasky;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.matej.tasky.TaskActivity.PRIORITY_KEY;

public class ListActivity extends AppCompatActivity {
    ListView lvTaskView;
    Button newtaskButton;
    String Title, Description;
    int Priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setUpUI();
    }
private void setUpUI() {
    lvTaskView = (ListView) findViewById(R.id.lvTaskList);
    final ArrayList<Task> tasks = this.loadTasks();
    final TaskAdapter taskAdapter = new TaskAdapter(tasks);
    this.lvTaskView.setAdapter(taskAdapter);
    lvTaskView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            TaskDBHelper.getInstance(getApplicationContext()).deleteTask((Task) taskAdapter.getItem(position));
            taskAdapter.delete(position);
            taskAdapter.notifyDataSetChanged();
            return true;
        }
    });
    newtaskButton = (Button) findViewById(R.id.newtaskButton);
    newtaskButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent explicitIntent = new Intent();
            explicitIntent.setClass(getApplicationContext(), TaskActivity.class);
            startActivity(explicitIntent);
        }
    });

    Intent Intent = getIntent();
    if(Intent.hasExtra(TaskActivity.TITLE_KEY)){
        Title = Intent.getStringExtra(TaskActivity.TITLE_KEY);
    }
    if(Intent.hasExtra(TaskActivity.DESCRIPTION_KEY)){
        Description = Intent.getStringExtra(TaskActivity.DESCRIPTION_KEY);
    }
    if(Intent.hasExtra(PRIORITY_KEY)){
        Priority = Intent.getIntExtra(PRIORITY_KEY,0);
    }

    Task task = new Task(Title, Description, Priority);
    TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
    TaskAdapter adapter = (TaskAdapter) lvTaskView.getAdapter();
    adapter.add(task);
}

    private ArrayList<Task> loadTasks() {
        return TaskDBHelper.getInstance(this).getAllTasks();
    }


}
