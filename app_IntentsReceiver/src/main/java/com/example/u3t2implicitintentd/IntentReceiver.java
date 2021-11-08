package com.example.u3t2implicitintentd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class IntentReceiver extends AppCompatActivity {
   EditText share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_receiver);

        share = findViewById(R.id.texttoShare);
        // From where we inicialize the activity
        Intent intent = getIntent();
        String action= intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type!=null) {
            if (type.equals("text/plain")){
                Bundle bundle = intent.getExtras();
                String txt= bundle.getString(Intent.EXTRA_TEXT);
                share.setText(txt);

            }
        }



    }
}


