package com.app.esd.esd.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.esd.esd.Modals.Sentence;
import com.app.esd.esd.R;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class TestingLessionActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {
    private static final char[] NUMBER_LIST = TickerUtils.getDefaultNumberList();
    private ImageView imgSpeak,imgnext;
    private TickerView ticker1;
    private  FlipProgressDialog dim;
    private TextView tv1, tv2,test,pro,stt;
    TextToSpeech tts;
    String message;
    List<Sentence> list;
    CountDownTimer countDownTimer;
    private boolean isSelected=false,isCorrect=false;
    int point =0;
    int pos=0;
    private LinearLayout ln1, ln2;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice_listening_1);
        ticker1 = (TickerView) findViewById(R.id.ticker1);
        ticker1.setCharacterList(NUMBER_LIST);

        list=new ArrayList<>();
        Sentence sentence =new Sentence();
        sentence.setText("fuck");
        sentence.setPronunciation("asdasdsad");
        List<String> answers=new ArrayList<>();
        answers.add("a");
        answers.add("b");
        sentence.setAnswerList(answers);

        Sentence sentence1 =new Sentence();
        sentence1.setText("fuck");
        sentence1.setPronunciation("asdasdsad");
        List<String> answers1=new ArrayList<>();
        answers1.add("a");
        answers1.add("b");
        sentence1.setAnswerList(answers1);
        list.add(sentence1);
        list.add(sentence);

        tts=new TextToSpeech(this,this);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        imgSpeak= (ImageView) findViewById(R.id.imgSpeak);
        imgnext= (ImageView) findViewById(R.id.imgnext);
        ln1 = (LinearLayout) findViewById(R.id.ln1);
        ln2 = (LinearLayout) findViewById(R.id.ln2);
        stt= (TextView) findViewById(R.id.stt);
        ln1.setOnClickListener(this);
        ln2.setOnClickListener(this);
        test= (TextView) findViewById(R.id.test);
        pro= (TextView) findViewById(R.id.pro);
        onNext();

        imgSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSelected){
                    showDialog();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            speak(list.get(pos).getText(),message);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    speak("one more time",message);
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            speak(list.get(pos).getText(),message);
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    closeDialog();
                                                    new Handler().postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            countDown(5000);
                                                        }
                                                    },500);
                                                }
                                            },1000);
                                        }
                                    },2000);
                                }
                            },2000);
                        }
                    },500);
                }else{
                    speak(list.get(pos).getText(),message);
                }

            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNext();
            }
        });
    }
    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.ENGLISH);
        }
    }
    public void speak(String text, final String mMessage){
        HashMap<String, String> myHashAlarm = new HashMap<String, String>();
        myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, message);
        Bundle bundle=new Bundle();
        bundle.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,message);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, bundle, message);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, myHashAlarm);
        }



    }
    public void  onNext(){
        stopCountDown();
        imgnext.setBackgroundColor(getResources().getColor(R.color.transWhite));
        isSelected=false;
        isCorrect=false;
        ticker1.setVisibility(View.VISIBLE);
        ticker1.setText(5+"");
        ln1.setEnabled(true);
        ln2.setEnabled(true);
        test.setText(list.get(pos).getText().toString());
        pro.setText(list.get(pos).getPronunciation().toString());
        test.setVisibility(View.INVISIBLE);
        pro.setVisibility(View.INVISIBLE);
        ln1.setBackgroundColor(getResources().getColor(R.color.white));
        ln2.setBackgroundColor(getResources().getColor(R.color.white));
        tv1.setText(list.get(pos).getAnswerList().get(0));
        tv2.setText(list.get(pos).getAnswerList().get(1));
        stt.setText(pos+1+"/"+list.size());
        if(pos+1<list.size()){
            pos++;
        }else{
            Intent i=new Intent(TestingLessionActivity.this,FinishActivity.class);
            i.putExtra("D",point);
            startActivity(i);
        }
    }
    public void showAnswer(){
        test.setVisibility(View.VISIBLE);
        pro.setVisibility(View.VISIBLE);
        ticker1.setVisibility(View.INVISIBLE);
    }
    public void showDialog(){
        List<Integer> imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.ic_3);
        imageList.add(R.drawable.ic_2);

        dim = new FlipProgressDialog();
        dim.setImageList(imageList);
        dim.setOrientation("rotationY");
        dim.setCanceledOnTouchOutside(false);
        dim.setDimAmount(0.8f);
        dim.setBackgroundColor(Color.parseColor("#FFFFFF"));
        dim.show(getFragmentManager(),"");

    }
    public void closeDialog(){
        dim.dismiss();
    }
    public void countDown(int time){
         countDownTimer=new CountDownTimer(time,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ticker1.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                ticker1.setText(0+"");
                if(!isSelected){
                    if(list.get(pos).getPosCorrect()==1){
                        animLL(ln1);
                    }else{
                        animLL(ln2);
                    }
                }else{
                    showAnswer();
                }
                ln1.setEnabled(false);
                ln2.setEnabled(false);
            }
        };
        countDownTimer.start();
    }
    public void stopCountDown(){
        if(countDownTimer!=null )
        countDownTimer.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln1:
                isSelected=true;
                stopCountDown();
                ln1.setEnabled(false);
                ln2.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list.get(pos).getPosCorrect()==1) {
                            ln1.setBackgroundColor(getResources().getColor(R.color.correct));
                            //setNewData();
                            point++;
                            isCorrect=true;


                        } else {
                            ln1.setBackgroundColor(getResources().getColor(R.color.error));
                            //clearError();
                            isCorrect=false;
                            animLL(ln2);
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showAnswer();
                            }
                        },500);

                    }
                },500);

                break;
            case R.id.ln2:
                isSelected=true;
                stopCountDown();
                ln2.setEnabled(false);
                ln1.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list.get(pos).getPosCorrect()==2) {
                            ln2.setBackgroundColor(getResources().getColor(R.color.correct));
                            point++;
                            isCorrect = true;
                        } else {
                            ln2.setBackgroundColor(getResources().getColor(R.color.error));
                            isCorrect = false;
                            animLL(ln1);
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showAnswer();
                            }
                        }, 500);
                    }
                    },500);
                break;
        }
    }
    public void animLL(final LinearLayout ll){
        CountDownTimer countDownTimer=new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if((millisUntilFinished/1000)%2==0){
                    ll.setBackgroundColor(getResources().getColor(R.color.correct));
                }else{
                    ll.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onFinish() {
               // animNext();
            }
        };
        countDownTimer.start();
    }
    public void animNext(){
        CountDownTimer countDownTimer=new CountDownTimer(5000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if((millisUntilFinished/1000)%2==0){
                    imgnext.setBackgroundColor(getResources().getColor(R.color.correct));
                }else{
                    imgnext.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onFinish() {
                imgnext.setBackgroundColor(getResources().getColor(R.color.transWhite));
            }
        };
        countDownTimer.start();
    }
}
