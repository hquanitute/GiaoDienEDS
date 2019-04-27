package com.test.myapplication;

import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class Challengen extends AppCompatActivity {

    TextView tvQuestion;
    Button btnSpeak;
    SpeechRecognizer mSpeechRecognizer;
    Intent mSpeechRecognizerIntent;
    TextView tvSpoken;
    TextView tvThongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengen);
        Intent intent = getIntent();
        tvQuestion=findViewById(R.id.tv_Challengen);
        btnSpeak=findViewById(R.id.btnSpeak);

        tvSpoken=findViewById(R.id.tvSpoken);
        tvThongBao=findViewById(R.id.textView4);
        tvQuestion.setMovementMethod(new ScrollingMovementMethod());
        String question= intent.getStringExtra("topic_text");
        tvQuestion.setText(question);

        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if(matches!= null){
                    tvThongBao.setVisibility(View.VISIBLE);
                    tvSpoken.setText(matches.get(0));
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });


        // Them sự kiện cho button thu âm
        btnSpeak.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvSpoken.setVisibility(View.VISIBLE);
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        tvSpoken.setText("");
                        tvSpoken.setHint("Dang nghe ...");
                        mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                        break;
                    case MotionEvent.ACTION_UP:
                        mSpeechRecognizer.stopListening();
                        tvSpoken.setHint("nhap vao");
                        break;
                }
                return false;
            }
        });
    }
}
