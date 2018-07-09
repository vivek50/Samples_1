package com.example.speechtotextsample;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private SpeechRecognizer recognizer;
    private Intent recognizerIntent;

    private EditText edtInput() {
        return findViewById(R.id.edtInput);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialize();

        findViewById(R.id.btnSpeakStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recognizer.startListening(recognizerIntent);
                findViewById(R.id.btnSpeakStart).setVisibility(View.GONE);
                new CountDownTimer(50000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        findViewById(R.id.btnSpeakStart).setVisibility(View.VISIBLE);
                        recognizer.stopListening();
                    }
                }.start();
            }
        });
    }

    private void initialize() {

        recognizer = SpeechRecognizer.createSpeechRecognizer(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                .putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                .putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        recognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.d("@modi", "onBeginning");

            }

            @Override
            public void onRmsChanged(float rmsdB) {
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
            }

            @Override
            public void onEndOfSpeech() {
                findViewById(R.id.btnSpeakStart).setVisibility(View.VISIBLE);
                Log.d("@modi", "onEnd");
            }

            @Override
            public void onError(int error) {
                Log.d("@modi", "onError : " + error);
            }

            @Override
            public void onResults(Bundle results) {
                Log.d("@modi", "onResults : " + results);
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (matches != null) {
                    Log.d("@modi", matches.toString());
                    String input = edtInput().getText().toString() + " " + matches.get(0);
                    edtInput().setText(input);
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        recognizer.destroy();
    }
}
