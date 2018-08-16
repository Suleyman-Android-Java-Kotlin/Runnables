package com.developer.suleymanekici.runnables;

import android.os.Handler;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView textView;
   int number;
   Handler hander;
   Runnable run;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View view){
        textView = (TextView) findViewById(R.id.textView);
        number = 0;
        hander = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                textView.setText("Zaman: " + number);
                number++;
                textView.setText("Zaman: " + number);
                hander.postDelayed(this, 1000);

            }
        };
      hander.post(run);
    }

    public void  stop(View view) {
        hander.removeCallbacks(run);
        textView.setText("Zaman: 0");


    }
}
