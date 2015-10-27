package com.example.android.teniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player1Index = 0;
    int player2Index = 0;
    int player1Sets = 0;
    int player2Sets = 0;
    String[] scoreArray = {"0","15","30","40","+ 1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void pointForPlayer1(View v){
        String name  = getString(R.string.player1_name);
        if (player1Index <= 2){
            displayForPlayer1(scoreArray[++player1Index]);
        } else if (player1Index == 3){
            if (player2Index <= 2){
                ((TextView) findViewById(R.id.player_1_sets)).setText("Sets: " + ++player1Sets);
                Toast.makeText(getApplicationContext(), name + " has " + player1Sets + " sets.", Toast.LENGTH_SHORT).show();
                player1Index = 0;
                displayForPlayer1(scoreArray[0]);
                player2Index = 0;
                displayForPlayer2(scoreArray[0]);
            } else {
                if (player2Index == 4) {
                    displayForPlayer2(scoreArray[--player2Index]);
                    displayForPlayer1(scoreArray[++player1Index]);
                } else {
                    displayForPlayer1(scoreArray[++player1Index]);
                }
            }
        } else {
            ((TextView) findViewById(R.id.player_1_sets)).setText("Sets: " + ++player1Sets);
            Toast.makeText(getApplicationContext(), name + " has " + player1Sets + " sets.", Toast.LENGTH_SHORT).show();
            player1Index = 0;
            displayForPlayer1(scoreArray[0]);
            player2Index = 0;
            displayForPlayer2(scoreArray[0]);
        }
    }

    public void pointForPlayer2(View v){
        String name  = getString(R.string.player2_name);
        if (player2Index <= 2){
            displayForPlayer2(scoreArray[++player2Index]);
        } else if (player2Index == 3){
            if (player1Index <= 2){
                ((TextView) findViewById(R.id.player_2_sets)).setText("Sets: " + ++player2Sets);
                Toast.makeText(getApplicationContext(), name + " has " + player2Sets + " sets.", Toast.LENGTH_SHORT).show();
                player2Index = 0;
                displayForPlayer2(scoreArray[0]);
                player1Index = 0;
                displayForPlayer1(scoreArray[0]);
            } else {
                if (player1Index == 4){
                    displayForPlayer1(scoreArray[--player1Index]);
                    displayForPlayer2(scoreArray[++player2Index]);
                } else {
                    displayForPlayer2(scoreArray[++player2Index]);
                }
            }
        } else {
            ((TextView) findViewById(R.id.player_2_sets)).setText("Sets: " + ++player2Sets);
            Toast.makeText(getApplicationContext(), name + " has " + player2Sets + " sets.", Toast.LENGTH_SHORT).show();
            player2Index = 0;
            displayForPlayer2(scoreArray[0]);
            player1Index = 0;
            displayForPlayer1(scoreArray[0]);
        }
    }

    public void displayForPlayer1(String score){
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(score);
    }

    public void displayForPlayer2(String score){
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(score);
    }

    public void resetSet(View v){
        player1Index = 0;
        displayForPlayer1(scoreArray[0]);
        player2Index = 0;
        displayForPlayer2(scoreArray[0]);
    }

    public void resetScore(View v){
        player1Sets = 0;
        ((TextView) findViewById(R.id.player_1_sets)).setText("Sets: " + player1Sets);
        player2Sets = 0;
        ((TextView) findViewById(R.id.player_2_sets)).setText("Sets: " + player2Sets);
        player1Index = 0;
        displayForPlayer1(scoreArray[0]);
        player2Index = 0;
        displayForPlayer2(scoreArray[0]);
    }
}