package com.example.manufestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private Button add;
    private ListView listview;
    Context context;
    private DBHandler dbHandler;
    private List<ToDo> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        dbHandler = new DBHandler(context);
        add = findViewById(R.id.add10);
        listview = findViewById(R.id.listview);
        toDos = new ArrayList<>();
        context = this;

        toDos = dbHandler.getAllToDos();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,AddPromos.class));
            }
        });
    }
}