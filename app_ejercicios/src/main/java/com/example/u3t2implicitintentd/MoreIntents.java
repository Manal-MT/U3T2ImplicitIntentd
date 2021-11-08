package com.example.u3t2implicitintentd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MoreIntents extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_intents);


        Button btnSend = (Button) findViewById(R.id.sendMailBtn);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si = new Intent(Intent.ACTION_SEND);
                si.setType("message/rfc822");
                si.putExtra(Intent.EXTRA_EMAIL, new String[]{"manal.mohamed@gmail.com"});
                si.putExtra(Intent.EXTRA_SUBJECT, "Welcome ");
                si.putExtra(Intent.EXTRA_TEXT, " Welcome");
                startActivity(Intent.createChooser(si, "Choose Mail App"));
            }
        });


       Button btnAlarm = (Button) findViewById(R.id.alarmBtn);
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm("Text of the Alarm", 10, 00);

            }
        });


        Button btnTimer =(Button) findViewById(R.id.timerBtn);
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer("Timer's Text", 50);
            }
        });
    }
        public void setAlarm(String msg, int hour, int min) {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, min);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }



    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }









    }














