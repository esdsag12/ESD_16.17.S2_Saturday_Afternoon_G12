package com.app.esd.esd.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class TestingLessionActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private static final char[] NUMBER_LIST = TickerUtils.getDefaultNumberList();
    private ImageView imgSpeak,imgnext;
    private TickerView ticker1;
    private  FlipProgressDialog dim;
    private TextView tv1, tv2,test,pro,stt;
    private MediaPlayer mediaPlayer;
    TextToSpeech tts;
    String message;
    List<Sentence> list;
    CountDownTimer countDownTimer;
    private boolean isSelected=false,isCorrect=false;
    int point =0;
    int pos=0;
    List<String> answers;
    private LinearLayout ln1, ln2;
    int type=0;
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
        answers =new ArrayList<>();
        answers.add("Từ chứa âm I");
        answers.add("Từ chứa âm iː");
        Intent intent=getIntent();
        type= intent.getIntExtra("C",1);
        if(type==1){
            addData1();
        }else{
            addData2();
        }


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
                pressNext();
            }
        });
    }
    public void addData1(){
        Sentence sentence=new Sentence("ship","ʃɪp",1, null,answers,0);
        Sentence sentence1=new Sentence("see","siː",1, null,answers,1);
        Sentence sentence2=new Sentence("sheep","ʃiːp",1, null,answers,1);
        Sentence sentence3=new Sentence("been","biːn",1, null,answers,1);
        Sentence sentence4=new Sentence("tin","tɪn",1, null,answers,0);
        Sentence sentence5=new Sentence("sit","sɪt",1, null,answers,0);
        Sentence sentence6=new Sentence("seat","siːt",1, null,answers,1);
        Sentence sentence7=new Sentence("it","ɪt",1, null,answers,0);
        Sentence sentence8=new Sentence("sing","sɪŋ",1, null,answers,0);
        Sentence sentence9=new Sentence("agree","əˈgriː",1, null,answers,1);
        list.add(sentence);
        list.add(sentence1);
        list.add(sentence2);
        list.add(sentence3);
        list.add(sentence4);
        list.add(sentence5);
        list.add(sentence6);
        list.add(sentence7);
        list.add(sentence8);
        list.add(sentence9);

    }
    public void addData2(){
        Sentence sentence=new Sentence("bit","bɪt",1, null,answers,0);
        Sentence sentence1=new Sentence("scene","siːn",1, null,answers,1);
        Sentence sentence2=new Sentence("meat","miːt",1, null,answers,1);
        Sentence sentence3=new Sentence("women","ˈwɪmɪn",1, null,answers,0);
        Sentence sentence4=new Sentence("England","ˈɪŋglənd",1, null,answers,0);
        Sentence sentence5=new Sentence("become","bɪˈkʌm",1, null,answers,0);
        Sentence sentence6=new Sentence("build","bɪld",1, null,answers,0);
        Sentence sentence7=new Sentence("chief","ʧiːf",1, null,answers,1);
        Sentence sentence8=new Sentence("free","friː",1, null,answers,1);
        Sentence sentence9=new Sentence("hit","hɪt",1, null,answers,0);
        list.add(sentence);
        list.add(sentence1);
        list.add(sentence2);
        list.add(sentence3);
        list.add(sentence4);
        list.add(sentence5);
        list.add(sentence6);
        list.add(sentence7);
        list.add(sentence8);
        list.add(sentence9);
    }
    public void readFromUrl(int num) {
        if (num < 45 && num > 0) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnErrorListener(this);
            try {
                mediaPlayer.setDataSource(getApplicationContext(), Uri.parse("https://noidung.tienganh123.com/file/baihoc/pronunciation/coban/" +
                        "bai" + num + "/u" + num + ".mp3" ));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(this);
        }
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

        test.setVisibility(View.INVISIBLE);
        pro.setVisibility(View.INVISIBLE);
        ln1.setBackgroundColor(getResources().getColor(R.color.white));
        ln2.setBackgroundColor(getResources().getColor(R.color.white));
        stt.setText(pos+1+"/"+list.size());
            test.setText(list.get(pos).getText().toString());
            pro.setText(list.get(pos).getPronunciation().toString());
            tv1.setText(list.get(pos).getAnswerList().get(0));
            tv2.setText(list.get(pos).getAnswerList().get(1));
    }
    public void pressNext(){
        if(pos+1<list.size()){
            pos++;
            onNext();
        }else{
            Intent i=new Intent(TestingLessionActivity.this,FinishActivity.class);
            i.putExtra("D",point);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
                        if (list.get(pos).getPosCorrect()==0) {
                            ln1.setBackgroundColor(getResources().getColor(R.color.correct));
                            //setNewData();
                            point++;
                            isCorrect=true;
                            try {
                                String mMp3Name = "correct";
                                Resources res = getResources();
                                int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                                mediaPlayer = MediaPlayer.create(TestingLessionActivity.this, resID);
                                mediaPlayer.start();

                            } catch (Exception e1) {

                            }

                        } else {
                            ln1.setBackgroundColor(getResources().getColor(R.color.error));
                            //clearError();
                            isCorrect=false;
                            animLL(ln2);
                            try {
                                String mMp3Name = "incorrect";
                                Resources res = getResources();
                                int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                                mediaPlayer = MediaPlayer.create(TestingLessionActivity.this, resID);
                                mediaPlayer.start();

                            } catch (Exception e1) {

                            }
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
                        if (list.get(pos).getPosCorrect()==1) {
                            ln2.setBackgroundColor(getResources().getColor(R.color.correct));
                            point++;
                            isCorrect = true;
                            try {
                                String mMp3Name = "correct";
                                Resources res = getResources();
                                int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                                mediaPlayer = MediaPlayer.create(TestingLessionActivity.this, resID);
                                mediaPlayer.start();

                            } catch (Exception e1) {

                            }
                        } else {
                            ln2.setBackgroundColor(getResources().getColor(R.color.error));
                            isCorrect = false;
                            animLL(ln1);
                            try {
                                String mMp3Name = "incorrect";
                                Resources res = getResources();
                                int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                                mediaPlayer = MediaPlayer.create(TestingLessionActivity.this, resID);
                                mediaPlayer.start();

                            } catch (Exception e1) {

                            }
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

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
    }
}
