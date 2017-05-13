package com.app.esd.esd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.util.Locale;

public class MainActivity extends BaseActivity implements OxfordPronuncationListener, View.OnClickListener {
    Button btnDich, btnKeyboard,btnPracticeRead;
    EditText edtText, edtSo;
    String text = "";
    int length = 0, totalLength = 0;
    private LinearLayout lnLearning;
    public static TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDich = (Button) findViewById(R.id.btn_dich);
        edtText = (EditText) findViewById(R.id.edt_text);
        btnPracticeRead = (Button) findViewById(R.id.btn_practice_read);
        edtSo = (EditText) findViewById(R.id.edt_so);
        btnKeyboard = (Button) findViewById(R.id.btn_keyboard);
        btnKeyboard.setOnClickListener(this);
        btnPracticeRead.setOnClickListener(this);
        btnDich.setOnClickListener(this);
        lnLearning = (LinearLayout) findViewById(R.id.lnLearning);
        lnLearning.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }

    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        if (text == "") {
            text += oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
        } else {
            text += " " + oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
        }
        length++;
        if (length == totalLength) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dich:
                text = "";
                String[] words = edtText.getText().toString().split(" ");
                length = 0;
                totalLength = words.length;
                for (int i = 0; i < words.length; i++) {
                    new OxfordPronunciationService(this).execute(words[i].trim());
                }

                break;
            case R.id.btn_practice_read:
                Intent i2 = new Intent(this, PracticeRead.class);
                startActivity(i2);
                break;
            case R.id.btn_keyboard:
                Intent i = new Intent(this, Keyboard.class);
                startActivity(i);
                break;
            case R.id.lnLearning:
                Intent intent = new Intent(MainActivity.this,LearningActivity.class);
                startActivity(intent);
        }
    }
}
