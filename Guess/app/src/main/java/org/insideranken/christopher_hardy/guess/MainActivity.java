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
    public static final int MAXNUMBER = 3;
    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private Button clear;

    public static final Random RANDOM = new Random();
    private int numberToFind, numberTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView) findViewById(R.id.start_msg);
        numberEnteredEt = (EditText) findViewById(R.id.numberEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        clear = (Button) findViewById(R.id.clear);
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
        numberTries++;

        if (n == numberToFind) {
            msgTv.setText(R.string.congrats);
        } else if (n > numberToFind) {
            msgTv.setText(R.string.tooHigh);
        } else if (n < numberToFind) {
            msgTv.setText(R.string.tooLow);
        }
    }

    private void newGame() {
        numberToFind = RANDOM.nextInt(MAXNUMBER) + 1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}