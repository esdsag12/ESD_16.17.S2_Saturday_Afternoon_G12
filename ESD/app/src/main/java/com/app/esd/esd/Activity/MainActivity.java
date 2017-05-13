package com.app.esd.esd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.R;

import java.util.Locale;

public class MainActivity extends BaseActivity implements OxfordPronuncationListener, View.OnClickListener {
    Button btnDich, btnKeyboard, btnPracticeRead;
    EditText edtText, edtSo;
    String text = "";
    int length = 0, totalLength = 0;
    private LinearLayout lnLearning, lnPracticing, lnTesting;
    public static TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        lnLearning = (LinearLayout) findViewById(R.id.lnLearning);
        lnLearning.setOnClickListener(this);
        lnPracticing = (LinearLayout) findViewById(R.id.lnpracticing);
        lnPracticing.setOnClickListener(this);
        lnTesting = (LinearLayout) findViewById(R.id.lntesting);
        lnTesting.setOnClickListener(this);

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
//            case R.id.btn_dich:
//                text = "";
//                String[] words = edtText.getText().toString().split(" ");
//                length = 0;
//                totalLength = words.length;
//                for (int i = 0; i < words.length; i++) {
//                    new OxfordPronunciationService(this).execute(words[i].trim());
//                }
//
//                break;
//            case R.id.btn_practice_read:
//                Intent i2 = new Intent(this, PracticeRead.class);
//                startActivity(i2);
//                break;
//            case R.id.btn_keyboard:
//                Intent i = new Intent(this, Keyboard.class);
//                startActivity(i);
//                break;
            case R.id.lnLearning:
                Intent intent_learning = new Intent(MainActivity.this, LearningActivity.class);
                ActivityOptionsCompat learningOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this,
                                        findViewById(R.id.imgv_learn_main),
                                        "icLearing");
                intent_learning.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_learning, learningOption.toBundle());
                break;
            case R.id.lnpracticing:
                Intent intent_practicing = new Intent(MainActivity.this, PracticeActivity.class);
                ActivityOptionsCompat practOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this,
                                        findViewById(R.id.imgv_pract_main),
                                        "icPract");
                intent_practicing.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_practicing, practOption.toBundle());
                break;
            case R.id.lntesting:
                Intent intent_testing = new Intent(MainActivity.this,
                        TestingActivity.class);
                intent_testing.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityOptionsCompat testOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this,
                                        findViewById(R.id.imgv_test_main),
                                        "icTest");
                startActivity(intent_testing, testOption.toBundle());
                break;
        }
    }
}
