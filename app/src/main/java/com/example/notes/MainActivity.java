package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Notes> notes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerVievNotes);
        if (notes.isEmpty()) {
            notes.add(new Notes("Парихмахер", "Сделать Прическу", "Понедельник", 2));
            notes.add(new Notes("Баскетбол", "Сыграть за команду", "Вторник", 1));
            notes.add(new Notes("Магазин", "Купить продукты", "Среда", 1));
            notes.add(new Notes("Стоматолог", "Вылечить зубы", "Вторник", 3));
            notes.add(new Notes("Магазин", "Купить одежду", "Четверг", 2));
        }
        Adapter adapter = new Adapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);

    }

    public void CreateNewNote(View view) {
        Intent intent = new Intent(this , SecondActivity.class);
        startActivity(intent);
    }
}