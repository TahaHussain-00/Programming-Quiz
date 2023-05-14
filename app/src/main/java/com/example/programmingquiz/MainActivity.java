package com.example.programmingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<Modelclass> listofQ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listofQ = new ArrayList<>();

        listofQ.add(new Modelclass("Who is the father of C language?","Steve Jobs","James Gosling","Dennis Ritchie","Rasmus Lerdorf","Dennis Ritchie"));
        listofQ.add(new Modelclass("Which of the following is not a valid C variable name?","int number;","float rate;","int variable_count;","int $main;","int $main;"));
        listofQ.add(new Modelclass("All keywords in C are in","LowerCase letters"," UpperCase letters","CamelCase letters","None of the mentioned","LowerCase letters"));
        listofQ.add(new Modelclass("______language is not an object oriented programming language","visual basic","C",". C++","Java","C"));
        listofQ.add(new Modelclass("The step by step procedure for solving a problem…","algorithm","programming","planing","flowchart","algorithm"));
        listofQ.add(new Modelclass("Which programming paradigm emphasizes on writing code that is easy to read and maintain?","Procedural programming","Object-oriented programming"," Functional programming","Structured programming","Object-oriented programming"));
        listofQ.add(new Modelclass(" What is the term used for a block of code that is executed repeatedly until a certain condition is met?"," Function"," Loop"," Condition","Variable","Loop"));
        listofQ.add(new Modelclass("Which data structure is used for storing a collection of elements in a non-linear fashion?"," Array","Stack","Queue","Tree","Tree"));
        listofQ.add(new Modelclass("Which operator is used for exponentiation in most programming languages?","^","*","%","**","**"));
        listofQ.add(new Modelclass("Which programming language is used for developing Android apps?","Python","C#","Java","Swift","Java"));
        listofQ.add(new Modelclass("Which programming language is used for developing iOS apps?","Java","C#","Python","Swift","Swift"));
        listofQ.add(new Modelclass("Which of the following is not a relational operator in most programming languages?","=","==","!=","++","++"));
        listofQ.add(new Modelclass("Which data structure is used for implementing a Last-In-First-Out (LIFO) behavior?","Queue","Stack","Tree","LinkedList","Stack"));
        listofQ.add(new Modelclass("Which of the following is a type of database?","Relational database"," Object-oriented database","NoSQL database"," All of the above"," All of the above"));
        listofQ.add(new Modelclass(" Which of the following is a type of web development framework?","Django","React"," Angular"," All of the above"," All of the above"));
        new Handler().postDelayed(new Runnable(){
            @Override
             public void run()
            {
                    Intent intent = new Intent(MainActivity.this,DashBoardActivity.class);
                    startActivity(intent);
            }
        },1500);
    }
}