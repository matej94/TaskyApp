package com.example.matej.tasky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {
    TextView tvtask;
    EditText ettask;
    Button addtaskButton;
    Spinner prioritySpinner;

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
        prioritySpinner = (Spinner) findViewById(R.id.prioritySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priority, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(adapter);
    }
}
