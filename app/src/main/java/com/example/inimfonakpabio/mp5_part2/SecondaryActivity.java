package com.example.inimfonakpabio.mp5_part2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SecondaryActivity extends AppCompatActivity {

    String question, answer;
    EditText Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Button BSubmit = (Button) findViewById(R.id.BSubmit);
        TextView questionText = (TextView) findViewById(R.id.questionText);
        Answer = (EditText) findViewById(R.id.Answer);

        Resources res = getResources();

        Random rand = new Random();
        int index = rand.nextInt(2);

        Intent intent = getIntent();
        switch (intent.getStringExtra("CATEGORY")) {
            case "Soccer Trivia":
                question = res.getStringArray(R.array.Soccer_Questions)[index];
                answer = res.getStringArray(R.array.Soccer_Answers)[index];
                questionText.setText(question);
                break;

            case "Math":
                question = res.getStringArray(R.array.Math_Questions)[index];
                answer = res.getStringArray(R.array.Math_Answers)[index];
                questionText.setText(question);
                break;

            case "History":
                question = res.getStringArray(R.array.History_Questions)[index];
                answer = res.getStringArray(R.array.History_Answers)[index];
                questionText.setText(question);
                break;

            default:
                break;
        }

    }

    public void Validate(View view) {
        Intent intent2 = new Intent();
        if(answer.equalsIgnoreCase(String.valueOf(Answer.getText()))) {
            intent2.putExtra("SCORE", 1);
        } else {
            intent2.putExtra("SCORE", 0);
        }
        setResult(RESULT_OK, intent2);
        finish();
    }
}
