package com.example.android.braingamequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

    }
    
    //Learned First time about Intent //
    //** On cliclicking start button its open the new quiz page **//
    private void startQuiz(){
        Intent intent = new Intent(StartingScreenActivity.this,QuizMainActivity.class);
        startActivity(intent);
    }
}
