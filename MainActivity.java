package com.example.umpirebuddy_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countBall = 0;
    private int countStrike = 0;
    private int counterTotalStrike = 0;
    TextView BallView;
    TextView StrikeView;
    TextView StrikeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BallView = (TextView)findViewById(R.id.BallView);
        StrikeView = (TextView)findViewById(R.id.StrikeView);
        StrikeTotal = (TextView)findViewById(R.id.StrikeTotal);
    }

    public void ballClicked(View view) {
        countBall++;
        if(countBall < 4){
            BallView.setText("Ball: "+countBall);

        }else{
            BallView.setText("Walk!!");
        }
    }

    public void strikeClicked(View view) {
        countStrike++;
        if (countStrike < 3){
            StrikeView.setText("Strike: "+countStrike);
        }else{
            StrikeView.setText("Out!!");
            counterTotalStrike++;
            StrikeTotal.setText("Total outs: " + String.valueOf(counterTotalStrike));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                countBall = 0;
                countStrike = 0;
                BallView.setText("Ball: " + String.valueOf(countBall));
                StrikeView.setText("Strike: " + String.valueOf(countStrike));

                return true;
            case R.id.item2:
                Intent myintent = new Intent(MainActivity.this,
                        About.class);
                startActivity(myintent);
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
