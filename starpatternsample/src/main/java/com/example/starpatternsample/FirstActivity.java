package com.example.starpatternsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        printPattern();
    }

    private void printPattern () {

        StringBuilder pattern = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            /*Case 1 : For 1 to 5 pattern*/
            for (int j = 1; j <= i; j++) {
                pattern.append("*");
            }
            /*Case 2 : For 5 to 1 pattern*/
//            for (int j = i; j<= 5; j++) {
//                pattern.append("*");
//            }
            pattern.append("\n");
        }
        Log.d("@modi","\n" + pattern);
    }
}
