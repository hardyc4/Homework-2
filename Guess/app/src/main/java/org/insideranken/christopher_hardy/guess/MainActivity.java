package org.insideranken.christopher_hardy.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final int MAXNUMBER = 100;

    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private Button clear;
    private TextView textViewWinner;

    public static final Random RANDOM = new Random();
    private int numberToFind;
    public static int numberTries = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView) findViewById(R.id.start_msg);
        numberEnteredEt = (EditText) findViewById(R.id.numberEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        clear = (Button) findViewById(R.id.clear);
        textViewWinner = (TextView) findViewById(R.id.textViewWinner);
        validate.setOnClickListener(this);
        clear.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view == validate) {
            validate();
        }
        if (view == clear) {
            newGame();
        }
    }

    private void validate() {
        int n = Integer.parseInt(numberEnteredEt.getText().toString());

        if (n == numberToFind) {
            msgTv.setText(R.string.congrats);
            textViewWinner.setText(numberTries + R.string.tries); /* For some reason this breaks the program? */
        } else if (n > numberToFind) {
            msgTv.setText(R.string.tooHigh);
            numberTries++;
        } else if (n < numberToFind) {
            msgTv.setText(R.string.tooLow);
            numberTries++;
        }
    }

    private void newGame() {
        numberToFind = RANDOM.nextInt(MAXNUMBER) + 1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}