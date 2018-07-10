package com.example.primenumbersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        findViewById(R.id.btnPrime).setOnClickListener(this::CalculatePrime);

    }

    private void CalculatePrime(View view) {

        StringBuilder primeNumbers = new StringBuilder();
        int n = Integer.parseInt(String.valueOf(((EditText)findViewById(R.id.edtNumber)).getText()));

        for (int i = 0; i < n; i++) {
            int counter = 0;

            for (int j = i; j >= 1; j--) {
                if (i%j == 0) {
                    counter+=1;
                }
            }
            if (counter == 2) {
                primeNumbers.append(i).append("  ");
            }
        }
        ((TextView)findViewById(R.id.txtPrimeNumbers)).setText(primeNumbers.toString());
    }


}
