package com.mikaela.redline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button rockBtn = (Button) findViewById(R.id.btn_rock);
//        Button paperBtn = (Button) findViewById(R.id.btn_paper);
//        Button scissorsBtn = (Button) findViewById(R.id.btn_scissors);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        playGame(btn.getText().toString().toLowerCase());
    }

    private void playGame(String playerChoice) {
        String computerChoice = "";

        switch ((new Random()).nextInt(3)) {
            case 0:
                computerChoice = "rock";
                break;
            case 1:
                computerChoice = "paper";
                break;
            case 2:
                computerChoice = "scissors";
                break;
        }

        String win = "You win, " + playerChoice + " defeats " + computerChoice + "!";
        String loss = "You lose... " + computerChoice + " defeats " + playerChoice + ".";
        String draw = "A draw! You both chose " + playerChoice  + ".";
        String result = "";

        if (computerChoice.equals(playerChoice)){
            result = draw;
        } else {
            if (playerChoice.equals("rock")){
                if (computerChoice.equals("paper")) {
                    result = loss;
                } else if (computerChoice.equals("scissors")) {
                    result = win;
                }
            } else if (playerChoice.equals("paper")){
                if (computerChoice.equals("scissors")) {
                    result = loss;
                } else if (computerChoice.equals("rock")) {
                    result = win;
                }
            } else if (playerChoice.equals("scissors")){
                if (computerChoice.equals("rock")) {
                    result = loss;
                } else if (computerChoice.equals("paper")) {
                    result = win;
                }
            }
        }

        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

        TextView topText = (TextView) findViewById(R.id.text_top);
        topText.setText("Make another choice to play again.");
    }
}
