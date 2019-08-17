
package com.example.plasma.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.plasma.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class Registration extends AppCompatActivity {
    EditText name, pass, blood_group, gender, number, email, address;
    Button button;

    ProgressBar progressBar;
    private FirebaseAuth auth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        auth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBarId);

        name = findViewById(R.id.nameID);
        pass = findViewById(R.id.signUpPasswordID);
        blood_group = findViewById(R.id.blood_groupID);
        gender = findViewById(R.id.genderID);
        number = findViewById(R.id.numberID);
        email = findViewById(R.id.signUpEmailID);
        address = findViewById(R.id.addressID);
    }

    public void btnInsert_Click(View view) {
        //user registration
        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful()) {
                            Toast.makeText(Registration.this, "Registration is successful", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Registration.this, "Registration is unsuccessful", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }

    @Override
    public void onBackPressed() {
         this.finish();
    }
}
