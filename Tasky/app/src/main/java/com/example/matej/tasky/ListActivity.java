package com.example.matej.tasky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    ListView lvTaskView;
    Button taskButton;
    TaskAdapter TaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setUpUI();
    }
private void setUpUI(){
    lvTaskView = (ListView) findViewById(R.id.lvTaskList);
    taskButton = (Button) findViewById(R.id.taskButton);
    taskButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent explicitIntent = new Intent();
            explicitIntent.setClass(getApplicationContext(), TaskActivity.class);
            startActivity(explicitIntent);
        }
    });

}
}
