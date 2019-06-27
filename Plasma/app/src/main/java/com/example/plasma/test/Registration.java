package com.example.plasma.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.plasma.R;

public class Registration extends AppCompatActivity {
    public Button signupPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        signupPage = (Button) findViewById(R.id.signupPage);
        signupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewProfile();
            }
        });
    }
    public void openNewProfile() {
        Intent intent = new Intent(this, NewProfile.class);
        startActivity(intent);
    }
}
