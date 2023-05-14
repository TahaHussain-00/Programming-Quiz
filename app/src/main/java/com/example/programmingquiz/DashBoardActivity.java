package com.example.programmingquiz;

import static com.example.programmingquiz.MainActivity.listofQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {
    CountDownTimer countDownTimer,myCountdownTimer;
   public int timerValue = 20;
    ProgressBar progressBar;
    TextView exitbtn;
    ImageView backbtn;
 TextView card_question,optiona,optionb,optionc,optiond;
 CardView cardOA,cardOB,cardOC,cardOD;
 int correctCount = 0,wrongCount=0;
 List<Modelclass> allQuestionList;
 Modelclass modelclass;
 LinearLayout nextbtn;
 int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        progressBar = findViewById(R.id.progress_bar);
        exitbtn = findViewById(R.id.ic_exit);
        backbtn = findViewById(R.id.ic_back);
        Hooks();
        allQuestionList = listofQ;
        Collections.shuffle(allQuestionList);
        modelclass = listofQ.get(index);
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));

        nextbtn.setClickable(false);
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dailog = new Dialog(DashBoardActivity.this);
                dailog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dailog.setContentView(R.layout.time_out_dailog);


                dailog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashBoardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                dailog.show();

            }
        }.start();
        setAllData();
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
               android.os.Process.killProcess(android.os.Process.myPid());
               System.exit(1);


            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private void setAllData() {
         card_question.setText(modelclass.getQuestion());

         optiona.setText(modelclass.getoA());
         optionb.setText(modelclass.getoB());
         optionc.setText(modelclass.getoC());
         optiond.setText(modelclass.getoD());
         timerValue =20;
         countDownTimer.cancel();
         countDownTimer.start();

    }

    private void Hooks() {
        card_question = findViewById(R.id.card_question);
        cardOA = findViewById(R.id.card_OA);
        cardOB = findViewById(R.id.card_OB);
        cardOC = findViewById(R.id.card_OC);
        cardOD = findViewById(R.id.card_OD);

        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optiona);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);
        nextbtn = findViewById(R.id.nextbtn_layout);
    }


    public void Correct(CardView cardView) {

        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
     nextbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             correctCount++;
             index++;
             modelclass = listofQ.get(index);
             resetColor();
             setAllData();
             enableButton();

         }
         });
     }



    public void wrong(CardView cardOA ){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.Red));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if(index<listofQ.size() -1){
                    index++;
                    modelclass = listofQ.get(index);
                    resetColor();
                    setAllData();
                    enableButton();



                }
                else {
                    GameWon();

            }
        }
        });

    }

    private void GameWon() {

        Intent intent = new Intent(DashBoardActivity.this,WonAcitivity.class);
        intent.putExtra("Correct",correctCount);
        intent.putExtra("Wrong",wrongCount);
        startActivity(intent);
    }

    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);

    }
    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);

    }
    public void resetColor(){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view) {
        disableButton();
        nextbtn.setClickable(true);

        if (modelclass.getoA().equals(modelclass.getAns())){
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listofQ.size()-1){
                Correct(cardOA);

            }
            else {
                GameWon();

            }
        }
        else{
            wrong(cardOA);


        }
        }

    public void OptionBClick(View view) {
        enableButton();
        disableButton();
        nextbtn.setClickable(true);

        if (modelclass.getoB().equals(modelclass.getAns())){
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listofQ.size()-1){
               Correct(cardOB);
            }
            else {
                GameWon();
            }
        }
        else{
            wrong(cardOB);

        }
    }

    public void OptionCClick(View view) {

        disableButton();
        nextbtn.setClickable(true);

        if (modelclass.getoC().equals(modelclass.getAns())){
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listofQ.size()-1){
                Correct(cardOC);
            }
            else {
                GameWon();
            }
        }
        else{
            wrong(cardOC);

        }
    }

    public void OptionDClick(View view) {
        disableButton();
        nextbtn.setClickable(true);
        if (modelclass.getoD().equals(modelclass.getAns())){
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listofQ.size()-1){

               Correct(cardOD);
            }
            else {
                GameWon();
            }
        }
        else{
            wrong(cardOD);

        }
    }
}


