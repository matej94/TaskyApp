package com.example.matej.tasky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {
    TextView tvtask;
    EditText ettask;
    Button addtaskButton;
    Spinner categorySpinner,prioritySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setUpUI();
    }
    private void setUpUI(){
        tvtask = (TextView) findViewById(R.id.tvtask);
        ettask = (EditText) findViewById(R.id.ettask);
        addtaskButton = (Button) findViewById(R.id.addtaskButton);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        prioritySpinner = (Spinner) findViewById(R.id.prioritySpinner);
    }
}
