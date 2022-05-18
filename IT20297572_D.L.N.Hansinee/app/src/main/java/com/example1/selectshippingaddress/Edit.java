package com.example1.selectshippingaddress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {

    private EditText title,des,phone;
    private Button edit;
    private DbHandler dbHandler;
    private Context context;
    private Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        context = this;
        dbHandler = new DbHandler(context);

        title = findViewById(R.id.editToDoTextTitle);
        phone = findViewById(R.id.editToDoText2);
        des = findViewById(R.id.editToDoText1);
        edit = findViewById(R.id.buttonEdit);

        final String id = getIntent().getStringExtra("id");
        ToDo todo = dbHandler.getSingleToDo(Integer.parseInt(id));

        title.setText(todo.getTitle());
        phone.setText(todo.getPhone());
        des.setText(todo.getDescription());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString();
                String phoneText = phone.getText().toString();
                String decText = des.getText().toString();
                updateDate = System.currentTimeMillis();

                ToDo toDo = new ToDo(Integer.parseInt(id),titleText,phoneText,decText,updateDate,0);
                int state = dbHandler.updateSingleToDo(toDo);
                System.out.println(state);
                startActivity(new Intent(context,MainActivity.class));
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Delivery To Your Door");
    }
}