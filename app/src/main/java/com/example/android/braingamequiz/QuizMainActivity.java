package com.example.android.braingamequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizMainActivity extends AppCompatActivity {

/** Initilization of submit button and correctanswer **/
    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private String getQuestionOneUserInput() {
        EditText mountainName = (EditText) findViewById(R.id.edit1_MountainName);
        String peakName = mountainName.getText().toString();
        return peakName;
    }

    private void checkQuestionOneAnswer(){
        String name = getQuestionOneUserInput();
        if (name.trim().equalsIgnoreCase("Mount Everest")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswer(){
        RadioButton radioButton1861 = (RadioButton)findViewById(R.id.radio1_1861);
        boolean isQuestionTwo1861Checked = radioButton1861.isChecked();
        if(isQuestionTwo1861Checked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionThreeAnswer(){
        CheckBox questionThreeSingapore = (CheckBox) findViewById(R.id.checkbox1_Singapore);
        CheckBox questionThreeHongKong = (CheckBox) findViewById(R.id.checkbox2_Hongkong);
        CheckBox questionThreeDenmark = (CheckBox) findViewById(R.id.checkbox3_Denmark);
        boolean isQuestionThreeSingaporeChecked = questionThreeSingapore.isChecked();
        boolean isQuestionThreeHongKongChecked = questionThreeHongKong.isChecked();
        boolean isQuestionThreeDenmarkChecked = questionThreeDenmark.isChecked();

        if (isQuestionThreeSingaporeChecked && isQuestionThreeHongKongChecked && !isQuestionThreeDenmarkChecked){
            correctAnswers += 1;
        }
    }

    private String getQuestionFourUserInput() {
        EditText referenceBook = (EditText) findViewById(R.id.edit4_ReferenceBook);
        String bookName = referenceBook.getText().toString();
        return bookName;
    }

    private void checkQuestionFourAnswer(){
        String name = getQuestionFourUserInput();
        if (name.trim().equalsIgnoreCase("Dictionary")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswer(){
        RadioButton radioButtonFive = (RadioButton)findViewById(R.id.radio2_KatharineHepburn);
        boolean isQuestionFiveChecked = radioButtonFive.isChecked();
        if(isQuestionFiveChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionSixAnswer(){
        CheckBox questionSixBlue = (CheckBox) findViewById(R.id.checkbox_Blue);
        CheckBox questionSixBlack = (CheckBox) findViewById(R.id.checkbox_Black);
        CheckBox questionSixYellow = (CheckBox) findViewById(R.id.checkbox_Yellow);
        boolean isQuestionSixBlueChecked = questionSixBlue.isChecked();
        boolean isQuestionSixBlackChecked = questionSixBlack.isChecked();
        boolean isQuestionSixYellowChecked = questionSixYellow.isChecked();

        if (isQuestionSixBlueChecked && isQuestionSixYellowChecked && !isQuestionSixBlackChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswer();
        checkQuestionTwoAnswer();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswer();
        checkQuestionFiveAnswer();
        checkQuestionSixAnswer();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(QuizMainActivity.this, "Total Correct Answers: " + correctAnswers + "/6",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}
