package com.example1.selectshippingaddress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    private EditText title, desc,phone;
    private Button add;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.editTextTitle);
        phone = findViewById(R.id.phone);
        desc = findViewById(R.id.editTextDescription);
        add = findViewById(R.id.buttonAdd);
        context = this;

        dbHandler = new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userTitle = title.getText().toString();
                String userDesc = desc.getText().toString();
                String userPhone = phone.getText().toString();
                long started = System.currentTimeMillis();

                ToDo toDo = new ToDo(userTitle,userDesc,userPhone,started,0);
                dbHandler.addToDo(toDo);

                startActivity(new Intent(context,MainActivity.class));
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Delivery To Your Door");
    }
}