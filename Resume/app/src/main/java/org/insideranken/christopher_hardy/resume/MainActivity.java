package org.insideranken.christopher_hardy.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button buttonEducation;
    private Button buttonWorkEp;
    private Button buttonCallMe;
    private Button buttonEmailMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEducation = (Button) findViewById(R.id.buttonEducation);
        buttonWorkEp = (Button) findViewById(R.id.buttonWorkEp);
        buttonCallMe = (Button) findViewById(R.id.buttonCallMe);
        buttonEmailMe = (Button) findViewById(R.id.buttonEmailMe);

        buttonCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneNumber = Uri.parse("tel: 3143305736");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                startActivity(intent);
            }
        });

        buttonEmailMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Intent.ACTION_SEND));
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"chrishardy14@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Resume");
            }
        });

        buttonEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EducationActivity.class);
                startActivity(intent);
            }
        });

        buttonWorkEp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkEpActivity.class);
                startActivity(intent);
            }
        });
    }
}
