package com.example.inimfonakpabio.mp5_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String chosenTopic = "";
    public static final int REQUEST = 2468;
    int score = 0;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, SecondaryActivity.class);
        final ListView listview = (ListView) findViewById(R.id.listview);
        scoreText = (TextView) findViewById(R.id.scoreText);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chosenTopic = listview.getItemAtPosition(i).toString();

                switch (chosenTopic) {
                    case "Soccer Trivia":
                        intent.putExtra("CATEGORY", chosenTopic);
                        startActivityForResult(intent, REQUEST);
                        break;

                    case "Math":
                        intent.putExtra("CATEGORY", chosenTopic);
                        startActivityForResult(intent, REQUEST);
                        break;

                    case "History":
                        intent.putExtra("CATEGORY", chosenTopic);
                        startActivityForResult(intent, REQUEST);
                        break;

                    default:
                        break;
                }
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==REQUEST) {
            score = score + intent.getIntExtra("SCORE", -10);
            Log.d("NINI", "" + score);
            scoreText.setText(""+score);
        }
    }

    public void Reset(View view) {
        score = 0;
        scoreText.setText(""+score);
    }
}
