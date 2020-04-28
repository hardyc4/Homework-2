package org.insideranken.christopher_hardy.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    final String NIP = "NO INPUT PROVIDED";
    final int MINMONTH = 1;
    final int MAXMONTH = 12;
    final int MINDAY = 1;
    final int MAXDAY = 31;
    final int MINYEAR = 1890;
    final int MAXYEAR = 2020;

    String yourDate = "";
    String zodiacSign = "";
    int yourAge = 0;

    EditText editTextMonth;
    EditText editTextDay;
    EditText editTextYear;
    ImageButton buttonValidate;
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMonth = findViewById(R.id.editTextMonth);
        editTextDay = findViewById(R.id.editTextDay);
        editTextYear = findViewById(R.id.editTextYear);
        buttonValidate = findViewById(R.id.buttonValidate);
        buttonClear = findViewById(R.id.buttonClear);

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int m = Integer.parseInt(editTextMonth.getText().toString());
                if ((m < MINMONTH) || (m > MAXMONTH)) {
                    editTextMonth.setText(null);
                }
                int d = Integer.parseInt(editTextDay.getText().toString());
                if ((d < MINDAY) || (d > MAXDAY)) {
                    editTextDay.setText(null);
                }
                int y = Integer.parseInt(editTextYear.getText().toString());
                if ((y < MINYEAR) || (y > MAXYEAR)) {
                    editTextYear.setText(null);
                }

                yourDate = d + "/" + m + "/" + y;
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                Date dt1 = null;
                try {
                    dt1 = format1.parse(yourDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DateFormat format2 = new SimpleDateFormat("EEEE");
                String finalDay = format2.format(dt1);

                yourAge = 2020 - y;

                String monthStr = (editTextMonth.getText().toString());
                String dayStr = (editTextDay.getText().toString());
                String yearStr = (editTextYear.getText().toString());

                monthStr = (monthStr.length() == 0) ? NIP : monthStr;
                dayStr = (dayStr.length() == 0) ? NIP : dayStr;
                yearStr = (yearStr.length() == 0) ? NIP : yearStr;

                String result = "MONTH: " + monthStr + "\n";
                result += "DAY: " + dayStr + "\n";
                result += "YEAR: " + yearStr + "\n";
                result += "You Were Born On: " + finalDay + " " + yourDate + "\n";
                result += "So That Would Make You: " + yourAge + " Years Old!" + "\n";
                result += "So That Would Make You A: " + zodiacSign + "\n";

                Toast.makeText(MainActivity.this,
                        result, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), ZodiacActivity.class);
                String monthString = (editTextMonth.getText().toString());
                intent.putExtra("MONTH", monthString);
                String dayString = (editTextDay.getText().toString());
                intent.putExtra("DAY", dayString);
                String yearString = (editTextYear.getText().toString());
                intent.putExtra("YEAR", yearString);
                startActivity(intent);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextMonth.setText("");
                editTextDay.setText("");
                editTextYear.setText("");
            }
        });
    }
}
