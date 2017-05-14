package com.app.esd.esd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.util.Log;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends BaseActivity implements OxfordPronuncationListener, View.OnClickListener {
    Button btnDich, btnKeyboard, btnPracticeRead;
    EditText edtText, edtSo;
    String text = "";
    int length = 0, totalLength = 0;
    private LinearLayout lnLearning, lnPracticing, lnTesting;
    public static TextToSpeech textToSpeech;
    private Date date, date2;

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
        date = new Date(System.currentTimeMillis());
        getDate();
    }

    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        if(null == oxfordObject){
            Toast.makeText(this, "Loi api, do st", Toast.LENGTH_SHORT).show();
        }else {
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
                Pair<View, String> pair_learnIC =
                        new Pair<>(findViewById(R.id.imgv_learn_main), "icLearing"),
                        pair_learnLn =
                                new Pair<>(findViewById(R.id.lnLearning), "lnLearning");
                ActivityOptionsCompat learningOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this, pair_learnIC, pair_learnLn);
                intent_learning.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_learning, learningOption.toBundle());
                break;
            case R.id.lnpracticing:
                Intent intent_practicing = new Intent(MainActivity.this, PracticeActivity.class);
                Pair<View, String> pair_practIC =
                        new Pair<>(findViewById(R.id.imgv_pract_main), "icPract"),
                        pair_practLn =
                                new Pair<>(findViewById(R.id.lnpracticing), "lnPract");
                ActivityOptionsCompat practOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this, pair_practIC, pair_practLn);
                intent_practicing.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_practicing, practOption.toBundle());
                break;
            case R.id.lntesting:
                Intent intent_testing = new Intent(MainActivity.this,
                        TestingActivity.class);
                intent_testing.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Pair<View, String> pair_testIC =
                        new Pair<>(findViewById(R.id.imgv_test_main), "icTest"),
                        pair_testLn =
                                new Pair<>(findViewById(R.id.lntesting), "lnTest");
                ActivityOptionsCompat testOption =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(this, pair_testIC, pair_testLn);
                startActivity(intent_testing, testOption.toBundle());
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        date2 = new Date(System.currentTimeMillis());
        long diff = date2.getTime() - date.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        Log.i("date",String.valueOf(diffHours)+" "+String.valueOf(diffMinutes)+" "+String.valueOf(diffSeconds));
    }
    public void getDate()
    {
        //Tạo đối tượng date sẽ lấy date hiện tại
        Date date = new Date();

        //Muốn xuất Ngày/Tháng/Năm , ví dụ 12/04/2013
        String strDateFormat = "dd/MM/yyyy";
        //tạo đối tượng SimpleDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        //gọi hàm format để lấy chuỗi ngày tháng năm đúng theo yêu cầu
        Log.i("today",sdf.format(date));
    }
}
