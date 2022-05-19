package com.example.manufestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPromos extends AppCompatActivity {
    private  EditText catagory,period,price,count;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promos2);

        Button add = findViewById(R.id.add);
        findViewById(R.id.cancel);
        catagory = findViewById(R.id.category);
        period = findViewById(R.id.period);
        price = findViewById(R.id.price);
        count = findViewById(R.id.quantity);
        Context context = this;

        dbHandler = new DBHandler(context);

        add.setOnClickListener(view -> {
            String adminCatagory = catagory.getText().toString();
            String adminPeriod = period.getText().toString();
            String adminPrice = price.getText().toString();
            String adminCount = count.getText().toString();
            long started = System.currentTimeMillis();

            ToDo toDo = new ToDo(adminCatagory,adminPeriod,adminPrice,adminCount,started);
            dbHandler.AddPromos(toDo);


        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);

            }
        });





    }
}














