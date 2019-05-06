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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.test.myapplication.objects.Result;

import java.util.ArrayList;
import java.util.Locale;

public class Challengen extends AppCompatActivity {

    TextView tvQuestion;
    Button btnSpeak;
    SpeechRecognizer mSpeechRecognizer;
    Intent mSpeechRecognizerIntent;
    TextView tvSpoken;
    TextView tvThongBao;
    Button btnSend;
    TextView tvDiem;
    String email;
    String idTopic;
    String cauhoi;
    double diem;
    int flag=-1;
    int id;
    Result rs;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengen);
        Intent intent = getIntent();
        tvQuestion=findViewById(R.id.tv_Challengen);
        btnSpeak=findViewById(R.id.btnSpeak);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setVisibility(View.INVISIBLE);
        tvDiem=findViewById(R.id.tvDiem);
        tvDiem.setVisibility(View.INVISIBLE);

        tvSpoken=findViewById(R.id.tvSpoken);
        tvThongBao=findViewById(R.id.textView4);
        tvQuestion.setMovementMethod(new ScrollingMovementMethod());
        cauhoi= intent.getStringExtra("topic_text");
        email=intent.getStringExtra("email");
        idTopic=intent.getStringExtra("topic_name");
        flag=intent.getIntExtra("flag",-1);
        id=intent.getIntExtra("id",-1);
        Bundle bd=intent.getExtras();
        rs=(Result) bd.getSerializable("result");
        tvQuestion.setText(cauhoi);

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
                    if(matches.get(0).length()>0){
                        tvThongBao.setVisibility(View.VISIBLE);
                        btnSend.setVisibility(View.VISIBLE);
                        tvSpoken.setText(matches.get(0));
                        tvDiem.setVisibility(View.VISIBLE);
                        diem=chamDiem(cauhoi,matches.get(0));
                        tvDiem.setText(String.format("%.2f",chamDiem(cauhoi,matches.get(0))));
                        if(flag==1){
                            Toast.makeText(Challengen.this, (String.format("%.2f",chamDiem(cauhoi,matches.get(0)))), Toast.LENGTH_SHORT).show();
                            //them EnemyPoint
                            rs.setPointEnemy(diem);
                            mDatabase = FirebaseDatabase.getInstance().getReference("Result");
                            mDatabase.child(rs.getId()).setValue(rs);
                            btnSend.setVisibility(View.INVISIBLE);
                        }
                    }
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
    public double chamDiem(String banMau,String phanThi){
        banMau=banMau.toLowerCase();
        String[] splited1 = banMau.split("\\s+");
        String[] splited2 = phanThi.split("\\s+");
        double dem =0;
        if(splited1.length<=splited2.length) {
            for (int i = 0; i < splited1.length; i++) {
                if (splited1[i].equals(splited2[i])) {
                    dem++;
                }
            }
        }
        else {
            for (int i = 0; i < splited2.length; i++) {
                if (splited1[i].equals(splited2[i])) {
                    dem++;
                }
            }
        }

        if(banMau.length()>0){
            double diem=dem*10/splited1.length;
            return diem;
        }
        return 0;
    }
    public void SendChallenge (View view){
        //Tao 1 cái Reulst
        Result result= new Result();
        if(email.equals("hung@gmail.com")){
            result.setIdUser("hung@gmail.com");
            result.setIdEnemy("quan@gmail.com");
            result.setIdTopic(idTopic);
            result.setPointUser(diem);
            result.setTextResult(cauhoi);
        }
        else {
            result.setIdUser("quan@gmail.com");
            result.setIdEnemy("hung@gmail.com");
            result.setIdTopic(idTopic);
            result.setPointUser(diem);
            result.setTextResult(cauhoi);
        }
        mDatabase = FirebaseDatabase.getInstance().getReference("Result");
        String key= mDatabase.push().getKey();
        result.setId(key);
        mDatabase.child(key).setValue(result);
    }
}
