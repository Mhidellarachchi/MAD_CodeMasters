package com.example.manufestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditPromos extends AppCompatActivity {
    private EditText catagory,period,price,count;
    private Button edit;
    private ImageView pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pro);
        catagory = findViewById(R.id.Editcategory);
        period = findViewById(R.id.Editperiod);
        price = findViewById(R.id.Editprice);
        count = findViewById(R.id.Editquantity);
        pizza = findViewById(R.id.Editpizza);
    }
}