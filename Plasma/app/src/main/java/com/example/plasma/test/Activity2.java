package com.example.plasma.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.plasma.R;

public class Activity2 extends AppCompatActivity {
   public Button signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        signup = (Button) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistration();
            }
        });
    }
    public void openRegistration(){
        Intent intent=new Intent(this,Registration.class);
        startActivity(intent);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openLogin(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}

