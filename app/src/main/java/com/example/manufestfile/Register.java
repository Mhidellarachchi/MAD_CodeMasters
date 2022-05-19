package com.example.manufestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;


public class Register extends AppCompatActivity {

    EditText  firstname, lastname,  phoneno, email, password, confirmpassword;
    Button register, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phoneno = (EditText)  findViewById(R.id.phone);
        firstname = (EditText) findViewById(R.id.FirstName);
        lastname = (EditText) findViewById(R.id.LastName);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
        confirmpassword = (EditText) findViewById(R.id.ConfirmPassword);
        register = (Button) findViewById(R.id.butreg);
        signin = (Button) findViewById(R.id.signin);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = confirmpassword.getText().toString();




                if (user.equals("") || pass.equals("") || cpass.equals(""))
                    Toast.makeText(Register.this, "Please enter the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(cpass)) {
                        Boolean checkuser = DB.checkemail(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Register.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),AddPromos.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Registsration failed", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(Register.this, "Usedr already exists", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(Register.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}