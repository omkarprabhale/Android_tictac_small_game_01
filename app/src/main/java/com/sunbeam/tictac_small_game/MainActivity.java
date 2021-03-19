package com.sunbeam.tictac_small_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

    private TextView winnerTv;
    private TextView player1Tv;
    private TextView player2Tv;
    private int count = 0;
    private Button playAgainBtn;
    private int activePlayer = 0;
    private int player1 = 0;
    private int player2 =1;
    private int filledPos[] ={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv0 = findViewById(R.id.tv0);
            tv1 = findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
            tv3 = findViewById(R.id.tv3);
            tv4 = findViewById(R.id.tv4);
            tv5 = findViewById(R.id.tv5);
            tv6 = findViewById(R.id.tv6);
            tv7 = findViewById(R.id.tv7);
            tv8 = findViewById(R.id.tv8);
            winnerTv = findViewById(R.id.winnerTv);
            player1Tv = findViewById(R.id.player1Tv);
            player2Tv = findViewById(R.id.player2Tv);
            playAgainBtn = findViewById(R.id.playAgainBtn);
            playAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshLayout();
                }
            });
            tv0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv0);

                }
            });
            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv1);

                }
            });
            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv2);

                }
            });
            tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv3);

                }
            });
            tv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv4);

                }
            });
            tv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv5);

                }
            });
            tv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv6);

                }
            });
            tv7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv7);

                }
            });
            tv8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startExecution(tv8);

                }
            });


        }

     }

    private void refreshLayout() {
        count =0;
        isGameActive = true;
        finish();
        startActivity(getIntent());
    }

    private void startExecution(TextView tv) {
        if(isGameActive) {
            count ++;
            TextView v = findViewById(tv.getId());
            int tag = Integer.parseInt(v.getTag().toString());
            filledPos[tag] = activePlayer;


            tv.setClickable(false);

                if (activePlayer == 0) {
                    tv.setText("X");
                    tv.setGravity(Gravity.CENTER);
                    player1Tv.setVisibility(View.INVISIBLE);
                    player2Tv.setVisibility(View.VISIBLE);
                    activePlayer = 1;
                } else {
                    tv.setText("O");
                    tv.setGravity(Gravity.CENTER);
                    player2Tv.setVisibility(View.INVISIBLE);
                    player1Tv.setVisibility(View.VISIBLE);
                    activePlayer = 0;
                }


            checkForwin();
                if(count >= 9 && isGameActive)
                {
                    playAgainBtn.setVisibility(View.VISIBLE);
                    winnerTv.setVisibility(View.VISIBLE);
                    winnerTv.setText(R.string.winnerNotdecided);
                }
        }
    }

    private void checkForwin() {
        int winningPos [][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        for(int i =0;i<8;i++)
        {

            int val0 = winningPos[i][0];
            int val1 = winningPos[i][1];
            int val2 = winningPos[i][2];


            if(filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]){
               if(filledPos [val0] != -1 && filledPos[val1] != -1 && filledPos[val2] != -1) {
                   winnerTv.setVisibility(View.VISIBLE);
                   if(filledPos[val0] == 0){
                       winnerTv.setText(R.string.winnerPlayer1);
                   }else{
                       winnerTv.setText(R.string.winnerPlayer2);
                   }
                   isGameActive = false;
                   playAgainBtn.setVisibility(View.VISIBLE);
               }

            }
        }

    }
}