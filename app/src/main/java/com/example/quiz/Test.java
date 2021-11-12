package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class Test extends AppCompatActivity {
    TextView questionField;
    Button optionA, optionB, optionC, optionD;
    int subject, questionNo = 0, score = 0, selectedQuestion;
    String[] questionSet, optionSet;
    int[] answerSet;
    ArrayList<Integer> questionDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        questionField = findViewById(R.id.question);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        subject = getIntent().getIntExtra("Subject", 0);
        if (subject == 1) {
            testC();
        } else if (subject == 2) {
            testJAVA();
        } else if (subject == 3) {
            testPython();
        } else if (subject == 4) {
            testAndroid();
        }
    }
    private void endTest() {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("Subject", subject);
        intent.putExtra("Score", score);
        startActivity(intent);
        finish();
    }
    private void setQuestion() {
        boolean selected = false;
        while (!selected) {
            selectedQuestion = new Random().nextInt(5);
            if (!questionDone.contains(selectedQuestion)) {
                questionDone.add(selectedQuestion);
                selected = true;
            }
        }
        questionField.setText(questionSet[selectedQuestion]);
        String[] options = optionSet[selectedQuestion].split(";");
        optionA.setText(options[0]);
        optionB.setText(options[1]);
        optionC.setText(options[2]);
        optionD.setText(options[3]);
        optionA.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 0) {
                score += 1;
            }
            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });
        optionB.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 1) {
                score += 1;
            }
            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });
        optionC.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 2) {
                score += 1;
            }
            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });
        optionD.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 3) {
                score += 1;
            }
            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });
    }

    private void testC() {
        questionSet = new String[]{"Which of the following is the correct syntax to add the header file in the C++ program ?",
                "Which of the following is the correct identifier ?",
                "Which of the following is the address operator?",
                "Which of the following features must be supported by any programming language to become a pure object-oriented programming language ?",
                "Which of the following is the original creator of the C++ language?"};
        optionSet = new String[]{"#include<userdefined>;#include 'userdefined.h';<include>userdefined.h;Both A and B",
                "$var_name;VAR_123;varname@;None of the above",
                "@;#;&;%",
                "Encapsulation;Inheritance;Polymorphism;All of the above",
                "Dennis Ritchie; Ken Thompson; Bjarne Stroustrup; Brian Kernighan"};
        answerSet = new int[]{3, 1, 2, 3, 2};
        questionDone = new ArrayList<>();
        setQuestion();
    }

    private void testJAVA() {
        questionSet = new String[]{"Which of the following is not a Java features?",
                "_____ is used to find and fix bugs in the Java programs.",
                "What does the expression float a = 35 / 0 return?",
                "Which of the following is true about the anonymous inner class?",
                "Which of the following is an immediate subclass of the Panel class?"};
        optionSet = new String[]{"Dynamic;Architecture Neutral;Use of pointers;Object-oriented",
                "JVM;JRE;JDK;JDB",
                "0;Not a Number;Infinity;Run time exception",
                "It has only methods;Objects can't be created;It has a fixed class name;It has no class name",
                "Applet class;Window class;Frame class;Dialog class"};
        answerSet = new int[]{2, 3, 2, 3, 0};
        questionDone = new ArrayList<>();
        setQuestion();
    }

    private void testPython() {
        questionSet = new String[]{"Who developed the Python language?",
                "What is the maximum possible length of an identifier?",
                "In which year was the Python language developed?",
                "Which one of the following is the correct extension of the Python file?",
                "In which year was the Python 3.0 version developed?"};
        optionSet = new String[]{"Zim Den; Guido van Rossum; Niene Stom; Wick van Rossum",
                "16;32;64;None of these",
                "1995;1972;1981;1989",
                ".py;.python;.p; .pp",
                "2008; 2000; 2005; 2010"};
        answerSet = new int[]{1, 3, 3, 0, 0};
        questionDone = new ArrayList<>();
        setQuestion();
    }

    private void testAndroid() {
        questionSet = new String[]{"For which of the following Android is mainly developed?",
                "Android is based on which of the following language?",
                " Android is -",
                "Under which of the following Android is licensed?",
                "What does API stand for?"};
        optionSet = new String[]{"Servers;Desktops;Laptops;Mobile devices",
                "Java;C++;C;None of the above",
                "an operating system;a web browser;a web server;None of the above",
                "OSS;Sourceorge;Apache/MIT;None of the above",
                "Application Programming Interface;Android Programming Interface;Android Page Interface;Application Page Interface"};
        answerSet = new int[]{3, 0, 1, 2, 0};
        questionDone = new ArrayList<>();
        setQuestion();
 }
    }
