package org.insideranken.christopher_hardy.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZodiacActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewZodiac;
    Button  buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewZodiac = findViewById(R.id.textViewZodiac);
        buttonHome = findViewById(R.id.buttonHome);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
            String monthString = intent.getStringExtra("MONTH");
            String dayString = intent.getStringExtra("DAY");
            String yearString = intent.getStringExtra("YEAR");

        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Sagittarius");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Capricorn");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Aquarius");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Pisces");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Aries");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Taurus");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Gemini");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Cancer");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Leo");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Virgo");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Libra");
        }
        if (monthString.equals("1"))
        {
            textViewZodiac.setText("Scorpio");
        }
}}
