package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView title, score;
    int subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        title = findViewById(R.id.title);
        score = findViewById(R.id.score);
        subject = getIntent().getIntExtra("Subject", 0);
        if (subject == 1) {
            title.setText("In C++, you scored");
        } else if (subject == 2) {
            title.setText("In JAVA, you scored");
        } else if (subject == 3) {
            title.setText("In Python, you scored");
        }
        else if (subject == 4) {
            title.setText("In Android, you scored");
        }
        int scoreAchieved = getIntent().getIntExtra("Score", 0);
        score.setText(String.valueOf(scoreAchieved) + "/5");
    }
    public void retry(View view) {
        Intent intent = new Intent(this, Test.class);
        intent.putExtra("Subject", subject);
        startActivity(intent);
        finish();
    }
    public void home(View view) {
        Intent intent = new Intent(this, Subject.class);
        startActivity(intent);
        finish();
    }
}