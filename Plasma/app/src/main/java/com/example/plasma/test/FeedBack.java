package com.example.plasma.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plasma.R;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        final EditText name= findViewById(R.id.fName);
        final EditText feedback= findViewById(R.id.fFeedback);
        Button button= findViewById(R.id.fButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, "xyz@gmail.com");
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
                i.putExtra(Intent.EXTRA_TEXT,"Name:"+name.getText()+"\nMessage:"+feedback.getText());
                try {
                    startActivity(Intent.createChooser(i,"Please select Email"));
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(FeedBack.this,"There are no email clients.",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
