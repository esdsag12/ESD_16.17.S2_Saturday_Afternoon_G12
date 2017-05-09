package com.app.esd.esd.Activity;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.esd.esd.Const.AppConst;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Keyboard extends BaseActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, OxfordPronuncationListener {
    private TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30,
            btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40,
            btn41, btn42, btn43, btn44, btnDel, btnEnter, txtText,btnReload;
    private EditText edtText;
    private String tempText = "", totalText = "", apiWord = "";
    private List<String> listText;
    private int pos = 0, num = 0;
    private MediaPlayer mediaPlayer;
    String[] listWord = {"love", "smooth", "load", "horse", "bean", "near"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initButton();

        getApiWord(pos);
    }

    private void getApiWord(int pos) {
        showProgressDialog("wait", "loading....");
        handleProgressDialog();
        txtText.setText(listWord[pos]);
        new OxfordPronunciationService(this).execute(txtText.getText().toString().trim());
    }

    public void initButton() {
        listText = new ArrayList<>();
        setContentView(R.layout.activity_keyboard);
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
        btnReload=(TextView) findViewById(R.id.buttonReload);
        btnReload.setOnClickListener(this);
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
            case R.id.buttonReload:
                num=-1;
                getApiWord(pos);
                break;
        }
        if (num < 45&&num>0) {
            tempText = AppConst.listSymbol[num - 1].trim();
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
        if(num>0) {
            edtText.setText(totalText);
            if (totalText.length() > 0) {
                edtText.setSelection(totalText.length());
            }
        }
        if (num == 46) {
            if (!TextUtils.isEmpty(apiWord)) {
                if (!TextUtils.isEmpty(totalText)) {
                    if (totalText.trim().equals(apiWord.trim())) {
                        Toast.makeText(this, "Good job!!!", Toast.LENGTH_SHORT).show();
                        if (pos == listWord.length - 1) {
                            pos = 0;
                        } else {
                            pos++;
                        }
                        getApiWord(pos);
                        edtText.setText("");
                        listText.clear();
                        totalText="";
                        tempText="";
                    } else {
                        Toast.makeText(this, "Try again!!!! :(", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Input invalid :(", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Api Error :(", Toast.LENGTH_SHORT).show();
            }
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
                        "bai" + num + "/u" + num + ".mp3" + "123123123123123123123123"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(this);
        }
    }

    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        apiWord = oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
        closeDialog();
    }
}
