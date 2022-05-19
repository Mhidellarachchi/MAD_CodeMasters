package com.example.manufestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText email, password;
    Button signin, button;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.reg);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = email.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity2.this, "Please enter all the creditais", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkemailpassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity2.this, "Sign in succesfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AddPromos.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "Invalid Credinatils", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);

            }
        });
    }
}