package com.example.matej.tasky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {
    TextView tvcategory;
    EditText etcategory;
    Button addcatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setUpUI();
    }
    private void setUpUI(){
        tvcategory = (TextView) findViewById(R.id.tvcategory);
        etcategory = (EditText) findViewById(R.id.etcategory);
        addcatButton = (Button) findViewById(R.id.addcatButton);

    }
}
