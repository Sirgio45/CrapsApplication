package com.ebookfrenzy.crapsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final Random randomNumbers = new Random();

    private enum Status {CONTINUE, WON, LOST};

    private final static int SNAKE_EYES =2;
    private final static int TREY=3;
    private final static int SEVEN=7;
    private final static int YO_ELEVEN=11;
    private final static int BOX_CARS=12;
    private String playerWinnerMessage;

    TextView playerRolled ;
    TextView playerPointsText ;
    TextView playerWinner ;
    Button rollDice ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerRolled = (TextView)findViewById(R.id.playerRolledTextView);
        playerPointsText= (TextView)findViewById(R.id.playerPointTextView);
        playerWinner= (TextView)findViewById(R.id.playerWinsTextView);
        rollDice= (Button)findViewById(R.id.startButton);
        rollDice.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {


                playerRolled.setText("");


                int myPoint = 0;

                Status gameStatus;

                int sumOfDice = rollDice();

                switch (sumOfDice) {
                    case SEVEN:
                    case YO_ELEVEN:
                        gameStatus = Status.WON;
                        //playerWinnerMessage+= "player wins" + myPoint;
                        break;
                    case SNAKE_EYES:
                    case TREY:
                    case BOX_CARS:
                        gameStatus = Status.LOST;
                        break;
                    default:
                        gameStatus = Status.CONTINUE;
                        myPoint = sumOfDice;
                        playerPointsText.setText(String.format("Point is %d\n", myPoint));
                        break;
                }

                while (gameStatus == Status.CONTINUE) {
                    sumOfDice = rollDice();

                    if (sumOfDice == myPoint)
                        gameStatus = Status.WON;
                    else if (sumOfDice == SEVEN)
                        gameStatus = Status.LOST;


                }

                if (gameStatus == Status.WON)
                    playerWinner.setText("Player wins");
                else
                    playerWinner.setText("Player loses");
            }


        });
    }


        public int rollDice()
        {






            int die1 = 1+ randomNumbers.nextInt(6);
            int die2 = 2+ randomNumbers.nextInt(6);

            int sum = die1 + die2;

            playerRolled.append(String.format("Player rolled %d + %d = %d\n", die1, die2,sum));

            return sum;
        }






    }













