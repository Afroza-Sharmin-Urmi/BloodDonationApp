package com.example.plasma.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.plasma.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity {
   public Button signup,login;
   EditText email,pass;
   private FirebaseAuth auth;
   ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        signup = (Button) findViewById(R.id.signup);
        progressBar=findViewById(R.id.progressbarId);

        login = (Button) findViewById(R.id.login);
        email=(EditText) findViewById(R.id.editTextEmailAddress);
        pass=(EditText) findViewById(R.id.editPassword);
        auth= FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String mEmail= email.getText().toString();
        String mPass= pass.getText().toString();
        progressBar.setVisibility(View.VISIBLE);
        auth.signInWithEmailAndPassword(mEmail,mPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful())
                        {
                             finish();
                            Intent intent= new Intent(getApplicationContext(),NewProfile.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(Activity2.this,"Login Unsuccessful",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void signUp(View view) {
        Intent signUp =new Intent(Activity2.this,Registration.class);
        startActivity(signUp);
    }
}

