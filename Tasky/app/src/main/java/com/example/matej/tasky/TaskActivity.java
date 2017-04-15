package com.example.matej.tasky;

import android.content.Intent;
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
    EditText etTitle,etDescription;
    Button addtaskButton;
    Spinner prioritySpinner;
    public static final String TITLE_KEY ="Naslov";
    public static final String DESCRIPTION_KEY ="Opis";
    public static final String PRIORITY_KEY = "Prioritet";
    public
    Intent explicitIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setUpUI();
    }
    private void setUpUI(){
        tvtask = (TextView) findViewById(R.id.tvtask);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);
        addtaskButton = (Button) findViewById(R.id.addtaskButton);
        prioritySpinner = (Spinner) findViewById(R.id.prioritySpinner);
        addtaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title, Description;
                int Priority;
                switch (prioritySpinner.getSelectedItemPosition()){
                    case 0:
                        Title = etTitle.getText().toString();
                        Description = etDescription.getText().toString();
                        Priority = R.color.low;
                        explicitIntent.putExtra(TITLE_KEY,Title);
                        explicitIntent.putExtra(DESCRIPTION_KEY,Description);
                        explicitIntent.putExtra(PRIORITY_KEY,Priority);
                        explicitIntent.setClass(getApplicationContext(), ListActivity.class);
                        startActivity(explicitIntent);
                        break;
                    case 1:
                        Title = etTitle.getText().toString();
                        Description = etDescription.getText().toString();
                        Priority = R.color.medium;
                        explicitIntent.putExtra(TITLE_KEY,Title);
                        explicitIntent.putExtra(DESCRIPTION_KEY,Description);
                        explicitIntent.putExtra(PRIORITY_KEY,Priority);
                        explicitIntent.setClass(getApplicationContext(), ListActivity.class);
                        startActivity(explicitIntent);
                        break;
                    case 2:
                        Title = etTitle.getText().toString();
                        Description = etDescription.getText().toString();
                        Priority = R.color.high;
                        explicitIntent.putExtra(TITLE_KEY,Title);
                        explicitIntent.putExtra(DESCRIPTION_KEY,Description);
                        explicitIntent.putExtra(PRIORITY_KEY,Priority);
                        explicitIntent.setClass(getApplicationContext(), ListActivity.class);
                        startActivity(explicitIntent);
                        break;
            }
            }
        });

       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priority, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(adapter);
    }
}
