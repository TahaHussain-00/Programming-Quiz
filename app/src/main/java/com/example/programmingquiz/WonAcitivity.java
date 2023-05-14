package com.example.programmingquiz;

import  androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Dialog;

import com.mikhaellopez.circularprogressbar.BuildConfig;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonAcitivity extends AppCompatActivity {
    CircularProgressBar circularProgressBar;
     TextView textView;
     int correct,wrong;
     LinearLayout btnshare;
     ImageView btnreset;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_acitivity);
        correct = getIntent().getIntExtra("Correct", 0);
        wrong = getIntent().getIntExtra("Wrong", 0);
        circularProgressBar = findViewById(R.id.circularProgressBar);
        textView = findViewById(R.id.Result_text);
        btnshare = findViewById(R.id.btn_share);
        btnreset = findViewById(R.id.ic_reset);
        circularProgressBar.setProgress(correct);
        textView.setText(correct+"/15");

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\n I got "+correct+" Out of 15 In Programming Quiz\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.BUILD_TYPE +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(WonAcitivity.this,MainActivity.class);
            startActivity(intent);
            }
        });



    }


}