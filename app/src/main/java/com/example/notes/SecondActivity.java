package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDesription;
    private Spinner spinnerDay;
    private RadioGroup radioGroupPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextTitle = findViewById(R.id.editTextTextPersonName);
        editTextDesription = findViewById(R.id.editTextTextMultiLine);
        spinnerDay = findViewById(R.id.spinner);
        radioGroupPriority = findViewById(R.id.radioGroup);
    }

    public void Create(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDesription.getText().toString().trim();
        String days = spinnerDay.getSelectedItem().toString();
        int radioButtonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radio = findViewById(radioButtonId);
        int priority = Integer.parseInt(radio.getText().toString());
        Notes notes = new Notes(title , description , days , priority);
        MainActivity.notes.add(notes);
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}