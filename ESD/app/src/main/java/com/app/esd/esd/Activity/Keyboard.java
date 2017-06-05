package com.app.esd.esd.Activity;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.esd.esd.Const.AppConst;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.Sentence;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class
Keyboard extends BaseActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, TextToSpeech.OnInitListener {
    private TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30,
            btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40,
            btn41, btn42, btn43, btn44, btnDel, btnEnter, txtText, txtTextPronun,txtStt;
    private ImageView imgRead, imgNext, imgPrev;
    private TextToSpeech textToSpeech;
    private EditText edtText;
    private List<String> listText;
    private String tempText = "", totalText = "", apiWord = "";
    private int pos = 0, num = 0;
    private MediaPlayer mediaPlayer;
    private List<Sentence> sentences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listText=new ArrayList<>();
        sentences=new ArrayList<>();
        addData2();
        addData();
        initButton();
        textToSpeech = new TextToSpeech(this, this);
        pos=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtText.setTextColor(getApplicationContext().getColor(R.color.white));
        }else{
            txtText.setTextColor(getResources().getColor(R.color.white));
        }
        txtText.setText(sentences.get(pos).getText());
        txtStt.setText(pos+1+"/"+sentences.size());
    }
    public void addData2(){
        List answers =new ArrayList<>();
        answers.add("Từ chứa âm iː");
        answers.add("Từ chứa âm I");
        Sentence sentence=new Sentence("ship","ʃɪp",1, null,answers,0);
        Sentence sentence1=new Sentence("see","siː",1, null,answers,1);
        Sentence sentence2=new Sentence("sheep","ʃ'iːp",1, null,answers,1);
        Sentence sentence3=new Sentence("been","biːn",1, null,answers,1);
        Sentence sentence4=new Sentence("tin","tɪn",1, null,answers,0);
        Sentence sentence5=new Sentence("sit","sɪt",1, null,answers,0);
        Sentence sentence6=new Sentence("seat","siːt",1, null,answers,1);
        Sentence sentence7=new Sentence("it","ɪt",1, null,answers,0);
        Sentence sentence8=new Sentence("sing","sɪŋ",1, null,answers,0);
        Sentence sentence9=new Sentence("agree","əˈgriː",1, null,answers,1);
        sentences.add(sentence);
        sentences.add(sentence1);
        sentences.add(sentence2);
        sentences.add(sentence3);
        sentences.add(sentence4);
        sentences.add(sentence5);
        sentences.add(sentence6);
        sentences.add(sentence7);
        sentences.add(sentence8);
        sentences.add(sentence9);
    }
    public void addData(){
        List answers =new ArrayList<>();
        answers.add("Từ chứa âm iː");
        answers.add("Từ chứa âm I");
        Sentence sentence=new Sentence("bit","bɪt",1, null,answers,0);
        Sentence sentence1=new Sentence("scene","siːn",1, null,answers,1);
        Sentence sentence2=new Sentence("meat","miːt",1, null,answers,1);
        Sentence sentence3=new Sentence("women","ˈwɪmɪn",1, null,answers,0);
        Sentence sentence4=new Sentence("England","ˈɪŋglənd",1, null,answers,0);
        Sentence sentence5=new Sentence("become","bɪˈkʌm",1, null,answers,0);
        Sentence sentence6=new Sentence("build","bɪld",1, null,answers,0);
        Sentence sentence7=new Sentence("chief","ʧiːf",1, null,answers,1);
        Sentence sentence8=new Sentence("transcription","trænsˈkrɪpʃən",1, null,answers,1);
        Sentence sentence9=new Sentence("hit","hɪt",1, null,answers,0);
        sentences.add(sentence);
        sentences.add(sentence1);
        sentences.add(sentence2);
        sentences.add(sentence3);
        sentences.add(sentence4);
        sentences.add(sentence5);
        sentences.add(sentence6);
        sentences.add(sentence7);
        sentences.add(sentence8);
        sentences.add(sentence9);
    }

    public void initButton() {


        setContentView(R.layout.activity_keyboard);
        txtStt= (TextView) findViewById(R.id.txt_stt);
        txtTextPronun = (TextView) findViewById(R.id.txt_text_pronun);
        imgRead = (ImageView) findViewById(R.id.buttonRead);
        imgNext = (ImageView) findViewById(R.id.buttonNext);
        imgPrev = (ImageView) findViewById(R.id.buttonPrev);
        btn1 = (TextView) findViewById(R.id.button1);
        btn2 = (TextView) findViewById(R.id.button2);
        btn3 = (TextView) findViewById(R.id.button3);
        btn4 = (TextView) findViewById(R.id.button4);
        btn5 = (TextView) findViewById(R.id.button5);
        btn6 = (TextView) findViewById(R.id.button6);
        btn7 = (TextView) findViewById(R.id.button7);
        btn8 = (TextView) findViewById(R.id.button8);
        btn9 = (TextView) findViewById(R.id.button9);
        btn10 = (TextView) findViewById(R.id.button10);
        btn11 = (TextView) findViewById(R.id.button11);
        btn12 = (TextView) findViewById(R.id.button12);
        btn13 = (TextView) findViewById(R.id.button13);
        btn14 = (TextView) findViewById(R.id.button14);
        btn15 = (TextView) findViewById(R.id.button15);
        btn16 = (TextView) findViewById(R.id.button16);
        btn17 = (TextView) findViewById(R.id.button17);
        btn18 = (TextView) findViewById(R.id.button18);
        btn19 = (TextView) findViewById(R.id.button19);
        btn20 = (TextView) findViewById(R.id.button20);
        btn21 = (TextView) findViewById(R.id.button21);
        btn22 = (TextView) findViewById(R.id.button22);
        btn23 = (TextView) findViewById(R.id.button23);
        btn24 = (TextView) findViewById(R.id.button24);
        btn25 = (TextView) findViewById(R.id.button25);
        btn26 = (TextView) findViewById(R.id.button26);
        btn27 = (TextView) findViewById(R.id.button27);
        btn28 = (TextView) findViewById(R.id.button28);
        btn29 = (TextView) findViewById(R.id.button29);
        btn30 = (TextView) findViewById(R.id.button30);
        btn31 = (TextView) findViewById(R.id.button31);
        btn32 = (TextView) findViewById(R.id.button32);
        btn33 = (TextView) findViewById(R.id.button33);
        btn34 = (TextView) findViewById(R.id.button34);
        btn35 = (TextView) findViewById(R.id.button35);
        btn36 = (TextView) findViewById(R.id.button36);
        btn37 = (TextView) findViewById(R.id.button37);
        btn38 = (TextView) findViewById(R.id.button38);
        btn39 = (TextView) findViewById(R.id.button39);
        btn40 = (TextView) findViewById(R.id.button40);
        btn41 = (TextView) findViewById(R.id.button41);
        btn42 = (TextView) findViewById(R.id.button42);
        btn43 = (TextView) findViewById(R.id.button43);
        btn44 = (TextView) findViewById(R.id.button44);
        btnDel = (TextView) findViewById(R.id.buttonDel);
        btnEnter = (TextView) findViewById(R.id.buttonEnter);
        txtText = (TextView) findViewById(R.id.txt_text);
        edtText = (EditText) findViewById(R.id.edt_text);
        edtText.setInputType(InputType.TYPE_NULL);
        imgRead.setOnClickListener(this);
        imgNext.setOnClickListener(this);
        imgPrev.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
        btn34.setOnClickListener(this);
        btn35.setOnClickListener(this);
        btn36.setOnClickListener(this);
        btn37.setOnClickListener(this);
        btn38.setOnClickListener(this);
        btn39.setOnClickListener(this);
        btn40.setOnClickListener(this);
        btn41.setOnClickListener(this);
        btn42.setOnClickListener(this);
        btn43.setOnClickListener(this);
        btn44.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                num = 1;
                break;
            case R.id.button2:
                num = 2;
                break;
            case R.id.button3:
                num = 3;
                break;
            case R.id.button4:
                num = 4;
                break;
            case R.id.button5:
                num = 5;
                break;
            case R.id.button6:
                num = 6;
                break;
            case R.id.button7:
                num = 7;
                break;
            case R.id.button8:
                num = 8;
                break;
            case R.id.button9:
                num = 9;

                break;
            case R.id.button10:
                num = 10;
                break;
            case R.id.button11:
                num = 11;
                break;
            case R.id.button12:
                num = 12;
                break;
            case R.id.button13:
                num = 13;
                break;
            case R.id.button14:
                num = 14;
                break;
            case R.id.button15:
                num = 15;
                break;
            case R.id.button16:
                num = 16;
                break;
            case R.id.button17:
                num = 17;
                break;
            case R.id.button18:
                num = 18;
                break;
            case R.id.button19:
                num = 19;
                break;
            case R.id.button20:
                num = 20;
                break;
            case R.id.button21:
                num = 21;
                break;
            case R.id.button22:
                num = 22;
                break;
            case R.id.button23:
                num = 23;
                break;
            case R.id.button24:
                num = 24;
                break;
            case R.id.button25:
                num = 25;
                break;
            case R.id.button26:
                num = 26;
                break;
            case R.id.button27:
                num = 27;
                break;
            case R.id.button28:
                num = 28;
                break;
            case R.id.button29:
                num = 29;
                break;
            case R.id.button30:
                num = 30;
                break;
            case R.id.button31:
                num = 31;
                break;
            case R.id.button32:
                num = 32;
                break;
            case R.id.button33:
                num = 33;
                break;
            case R.id.button34:
                num = 34;
                break;
            case R.id.button35:
                num = 35;
                break;
            case R.id.button36:
                num = 36;
                break;
            case R.id.button37:
                num = 37;
                break;
            case R.id.button38:
                num = 38;
                break;
            case R.id.button39:
                num = 39;
                break;
            case R.id.button40:
                num = 40;
                break;
            case R.id.button41:
                num = 41;
                break;
            case R.id.button42:
                num = 42;
                break;
            case R.id.button43:
                num = 43;
                break;
            case R.id.button44:
                num = 44;
                break;
            case R.id.buttonDel:
                num = 45;
                break;
            case R.id.buttonEnter:
                num = 46;
                break;
            case R.id.buttonRead:
                speak(sentences.get(pos).getText());
                break;
            case R.id.buttonNext:
                num=-1;
                tempText = "";
                totalText = "";
                edtText.setText("");
                if (pos + 1 < sentences.size()) {
                    pos++;
                } else {
                    pos = 0;
                }
                txtText.setText(sentences.get(pos).getText());
                txtTextPronun.setText("");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    txtText.setTextColor(getApplicationContext().getColor(R.color.white));
                }else{
                    txtText.setTextColor(getResources().getColor(R.color.white));
                }
                txtStt.setText(pos+1+"/"+sentences.size());
                break;
            case R.id.buttonPrev:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    txtText.setTextColor(getApplicationContext().getColor(R.color.white));
                }else{
                    txtText.setTextColor(getResources().getColor(R.color.white));
                }
                num=-1;
                tempText = "";
                totalText = "";
                edtText.setText("");
                if (pos - 1 >= 0) {
                    pos--;
                } else {
                    pos = sentences.size() - 1;
                }
                txtText.setText(sentences.get(pos).getText());
                txtTextPronun.setText("");
                txtStt.setText(pos+1+"/"+sentences.size());
                break;
        }
        if (num < 45 && num > 0) {
            tempText = AppConst.LIST_SYMBOL[num - 1].trim();
            try {
                String mMp3Name = "u" + num;
                Resources res = getResources();
                int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(Keyboard.this, resID);
                mediaPlayer.start();

            } catch (Exception e1) {
                readFromUrl(num);
            }

            totalText += tempText;
            listText.add(tempText);
        }
        if (num == 45) {
            if (listText.size() > 0) {
                if (totalText.length() >= listText.get(listText.size() - 1).length()) {
                    totalText = totalText.substring(0, totalText.length() - listText.get(listText.size() - 1).length());
                    listText.remove(listText.get(listText.size() - 1));
                }
            }
        }
        if (num > 0) {
            edtText.setText(totalText);
            if (totalText.length() > 0) {
                edtText.setSelection(totalText.length());
            }
        }
        if (num == 46) {
            if (!TextUtils.isEmpty(totalText)) {
                if (totalText.trim().equals(sentences.get(pos).getPronunciation().replace("ˈ",""))) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        txtText.setTextColor(getApplicationContext().getColor(R.color.correct));
                    }else{
                        txtText.setTextColor(getResources().getColor(R.color.correct));
                    }
                    try {
                        String mMp3Name = "correct";
                        Resources res = getResources();
                        int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                        mediaPlayer = MediaPlayer.create(Keyboard.this, resID);
                        mediaPlayer.start();

                    } catch (Exception e1) {

                    }

                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        txtText.setTextColor(getApplicationContext().getColor(R.color.error));
                    }else{
                        txtText.setTextColor(getResources().getColor(R.color.error));
                    }
                    try {
                        String mMp3Name ="incorrect";
                        Resources res = getResources();
                        int resID = res.getIdentifier(mMp3Name, "raw", getPackageName());
                        mediaPlayer = MediaPlayer.create(Keyboard.this, resID);
                        mediaPlayer.start();
                    } catch (Exception e1) {
                    }
                }
            }
            txtTextPronun.setText(sentences.get(pos).getPronunciation());
        }

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
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.ENGLISH);
        }
    }

    public void speak(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);

    }
}
