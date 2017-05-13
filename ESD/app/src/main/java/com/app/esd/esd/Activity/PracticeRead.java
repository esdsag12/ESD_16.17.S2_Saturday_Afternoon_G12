package com.app.esd.esd.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.esd.esd.Const.AppConst;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.Sentence;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PracticeRead extends BaseActivity implements View.OnClickListener, OxfordPronuncationListener, TextToSpeech.OnInitListener {
    TextView txtTextTest, txtTextPronunTest, txtTextTestAnswer, txtTextPronunAnswer;
    ImageView btnListen, btnRead, btnNext;
    String textTest;
    private TextToSpeech textToSpeech;
    int pos, posListTest;
    int length, totalLength;
    List<Sentence> listTextTest;
    List<String> listTest;
    Sentence tempSentence;
    int type = 0;
    HashMap<String, String> map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_read);
        init();
        initData();
        pos = 0;
        posListTest = 0;
        showProgressDialog("please wait", "load data");
        getData(listTest.get(pos).toString());
        textToSpeech = new TextToSpeech(this, this);
        map = new HashMap<String, String>();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Practice Reading");

    }

    private void init() {
        listTextTest = new ArrayList<>();
        listTest = new ArrayList<>();
        txtTextTest = (TextView) findViewById(R.id.txt_text_check);
        txtTextTestAnswer = (TextView) findViewById(R.id.txt_text_answer);
        txtTextPronunTest = (TextView) findViewById(R.id.txt_text_pronun);
        txtTextPronunAnswer = (TextView) findViewById(R.id.txt_pronunciation_answer);
        btnListen = (ImageView) findViewById(R.id.btn_listen);
        btnNext = (ImageView) findViewById(R.id.btn_next);
        btnRead = (ImageView) findViewById(R.id.btn_read);
        btnRead.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnListen.setOnClickListener(this);


    }

    public void initData() {
        listTest.add(new String("i love you"));
        listTest.add(new String("sit down please"));
        listTest.add(new String("i don't know how to do this"));
        listTest.add(new String("sheet shit ship sheep"));
        listTest.add(new String("what will we do"));
    }

    private void getData(String text) {
        tempSentence = new Sentence();
        textTest = AppConst.TEXT_EMTY;
        String[] words = text.trim().split(" ");
        length = 0;
        tempSentence.setText(text);
        totalLength = words.length;
        for (int i = 0; i < words.length; i++) {
            new OxfordPronunciationService(this).execute(words[i].trim());
        }
    }


    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        if (null != oxfordObject) {
            if (AppConst.TEXT_EMTY.equals(textTest)) {
                textTest += oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
            } else {
                textTest += AppConst.TEXT_SPACE + oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
            }

            length++;
            if (length == totalLength) {
                tempSentence.setPronunciation(textTest);
                if (type == 0) {
                    listTextTest.add(tempSentence);
                    pos++;
                    if (pos < listTest.size()) {
                        getData(listTest.get(pos).toString());
                    } else {
                        closeDialog();
                        txtTextTest.setText(listTextTest.get(posListTest).getText());
                        txtTextPronunTest.setText(listTextTest.get(posListTest).getPronunciation());
                    }
                } else {
                    closeDialog();

                    //txtTextPronunAnswer.setText(tempSentence.getPronunciation());
                    setCorrectAnswer(tempSentence.getText(), listTextTest.get(posListTest).getText(), tempSentence.getPronunciation(), listTextTest.get(posListTest).getPronunciation());

//                    if (tempSentence.getPronunciation().trim().equals(listTextTest.get(posListTest).getPronunciation())) {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            txtTextPronunAnswer.setTextColor(getColor(R.color.correct));
//                            txtTextTestAnswer.setTextColor(getColor(R.color.correct));
//                        } else {
//                            txtTextPronunAnswer.setTextColor(getResources().getColor(R.color.correct));
//                            txtTextTestAnswer.setTextColor(getResources().getColor(R.color.correct));
//                        }
//                        Snackbar.make(getWindow().getDecorView(), "Good Job!", Snackbar.LENGTH_SHORT);
//                    } else {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            txtTextPronunAnswer.setTextColor(getColor(R.color.error));
//                            txtTextTestAnswer.setTextColor(getColor(R.color.error));
//                        } else {
//                            txtTextPronunAnswer.setTextColor(getResources().getColor(R.color.error));
//                            txtTextTestAnswer.setTextColor(getResources().getColor(R.color.error));
//                        }
//                        Snackbar.make(getWindow().getDecorView(), "Try again", Snackbar.LENGTH_SHORT);
//
//                    }

                }


            }
        } else {
            Toast.makeText(this, "Api loi, co the do tu nhap vao", Toast.LENGTH_SHORT).show();
        }
    }

    public void setCorrectAnswer(String text, String correctText, String pronun, String correctPronun) {
        String[] listWord = text.split(" ");
        String[] listWordCorrect = correctText.split(" ");
        String[] listPronun = pronun.split(" ");
        String[] listPronunCorrect = correctPronun.split(" ");
        //String finalPronunciation="<font COLOR=\'RED\'><b>" + "android-coding" + "</b></font>" + "<font COLOR=\'#00FF00\'><i>" + ".blogspot" + "</i></font>" + ".com";
        String correctColorStart = "<font COLOR=\'GREEN\'><b>";
        String finalPronunciation = "";
        String finalString = "";
        String colorEnd = "</b></font>";
        String unCorrectColorStart = "<font COLOR=\'RED\'><b>";
        String lackColorStart = "<font COLOR=\'YELLOW\'><b>";
        String overColorStart = "<font COLOR=\'BLUE\'><b>";
        int isWrongAll=-1;
        if (listPronun.length > listPronunCorrect.length) {
            for (int i = 0; i < listPronunCorrect.length; i++) {
                if (listPronun[i].trim().equals(listPronunCorrect[i])) {
                    if (finalPronunciation == "") {
                        finalPronunciation += correctColorStart + listPronun[i] + colorEnd;
                        finalString += correctColorStart + listWord[i] + colorEnd;
                    } else {
                        finalPronunciation += " " + correctColorStart + listPronun[i] + colorEnd;
                        finalString += " " + correctColorStart + listWord[i] + colorEnd;
                    }
                } else {
                    if (finalPronunciation == "") {
                        finalPronunciation += unCorrectColorStart + listPronun[i] + colorEnd;
                        finalString += unCorrectColorStart + listWord[i] + colorEnd;
                    } else {
                        finalPronunciation += " " + unCorrectColorStart + listPronun[i] + colorEnd;
                        finalString += " " + unCorrectColorStart + listWord[i] + colorEnd;
                    }
                    isWrongAll++;
                }
                if(isWrongAll==listPronunCorrect.length-1){
                    for (int j = i+1; j < listWord.length; j++) {
                        finalPronunciation += " " + unCorrectColorStart + listPronun[j] + colorEnd;
                        finalString += " " + unCorrectColorStart + listWord[j] + colorEnd;
                    }
                }else{
                    if (i == listPronunCorrect.length - 1) {
                        for (int j = i+1; j < listWord.length; j++) {
                            finalPronunciation += " " + overColorStart + listPronun[j] + colorEnd;
                            finalString += " " + overColorStart + listWord[j] + colorEnd;
                        }
                    }
                }

            }
        } else {
            for (int i = 0; i < listPronun.length; i++) {
                if (listPronun[i].trim().equals(listPronunCorrect[i])) {
                    if (finalPronunciation == "") {
                        finalPronunciation += correctColorStart + listPronun[i] + colorEnd;
                        finalString += correctColorStart + listWord[i] + colorEnd;
                    } else {
                        finalPronunciation += " " + correctColorStart + listPronun[i] + colorEnd;
                        finalString +=" "+ correctColorStart + listWord[i] + colorEnd;
                    }
                } else {
                    if (finalPronunciation == "") {
                        finalPronunciation += unCorrectColorStart + listPronun[i] + colorEnd;
                        finalString += unCorrectColorStart + listWord[i] + colorEnd;
                    } else {
                        finalPronunciation += " " + unCorrectColorStart + listPronun[i] + colorEnd;
                        finalString +=" "+ unCorrectColorStart + listWord[i] + colorEnd;
                    }
                    isWrongAll++;
                }
                if(isWrongAll==listPronun.length-1){
                    for (int j = i+1; j < listPronunCorrect.length; j++) {
                        finalPronunciation += " " + unCorrectColorStart + listPronunCorrect[j] + colorEnd;
                        finalString += " " + unCorrectColorStart + listWordCorrect[j] + colorEnd;
                    }
                }else {
                    if (i == listPronun.length - 1 && listPronun.length < listPronunCorrect.length) {
                        for (int j = i + 1; j < listPronunCorrect.length; j++) {
                            finalPronunciation += " " + lackColorStart + listPronunCorrect[j] + colorEnd;
                            finalString += " " + lackColorStart + listWordCorrect[j] + colorEnd;
                        }
                    }
                }


            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtTextPronunAnswer.setText(Html.fromHtml(finalPronunciation, 1));
            txtTextTestAnswer.setText(Html.fromHtml(finalString, 1));
        } else {
            txtTextPronunAnswer.setText(Html.fromHtml(finalPronunciation));
            txtTextTestAnswer.setText(Html.fromHtml(finalString));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                Log.i("CuongNV", res.get(0).toString());
                type = 1;
                showProgressDialog("please wait", "load data");
                if (res.get(0).contains("*")) {
                } else {
                    getData(res.get(0));
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read:
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say some thing");
                try {
                    startActivityForResult(i, 100);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(PracticeRead.this, "Not support", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_listen:
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
                textToSpeech.speak(txtTextTest.getText().toString(), TextToSpeech.QUEUE_FLUSH, map);
                break;
            case R.id.btn_next:
                posListTest++;
                if (posListTest < listTextTest.size()) {
                    txtTextTest.setText(listTextTest.get(posListTest).getText());
                    txtTextPronunTest.setText(listTextTest.get(posListTest).getPronunciation());

                } else {
                    posListTest = 0;
                }
                txtTextTestAnswer.setText(AppConst.TEXT_EMTY);
                txtTextPronunAnswer.setText(AppConst.TEXT_EMTY);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    txtTextPronunAnswer.setTextColor(getColor(R.color.black));
                    txtTextTestAnswer.setTextColor(getColor(R.color.black));
                } else {
                    txtTextPronunAnswer.setTextColor(getResources().getColor(R.color.black));
                    txtTextTestAnswer.setTextColor(getResources().getColor(R.color.black));
                }
                break;
        }
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.7f);
        }
    }
}
