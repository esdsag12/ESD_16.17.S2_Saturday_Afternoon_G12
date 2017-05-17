package com.app.esd.esd.Activity;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.esd.esd.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class PracticeChooseWord extends BaseActivity implements View.OnClickListener {
    private TextView tv1, tv2, tv_result, tv4;
    private ImageView imgSpeak;
    private String[] string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12,
            string13, string14, string15, string16, string17, string18, string19, string20;
    private List<String> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15,
            list16, list17, list18, list19, list20;
    private Random random;
    private TextToSpeech textToSpeech;
    private String strExample;
    private String[] text;
    private LinearLayout ln1, ln2, ln3, ln4;
    private int id;
    HashMap<String, String> map;
    private int stt;
    private int score;
    TextView txtv_next, txtv_back, txtv_pair;
    String pair = "";
    CardView cardv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice_listening);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("id");
        }
        pair = extras.getString("pair");
        init();
        setDataList();
        setData(id);
        setEventClick();
    }

    public void init() {
        txtv_pair = (TextView) findViewById(R.id.txtv_listening);
        txtv_pair.setText(pair);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv_result = (TextView) findViewById(R.id.tv_result);
        txtv_next = (TextView) findViewById(R.id.txtv_next);
        txtv_back = (TextView) findViewById(R.id.txtv_back);
        ln1 = (LinearLayout) findViewById(R.id.ln1);
        ln2 = (LinearLayout) findViewById(R.id.ln2);
        ln4 = (LinearLayout) findViewById(R.id.ln4);
        imgSpeak = (ImageView) findViewById(R.id.imgSpeak);
        map = new HashMap<String, String>();
        stt = 0;
        score = 0;
        cardv_result = (CardView) findViewById(R.id.cardv_listen);
    }

    public void setEventClick() {
        imgSpeak.setOnClickListener(this);
        ln1.setOnClickListener(this);
        ln2.setOnClickListener(this);
        txtv_next.setOnClickListener(this);
        txtv_back.setOnClickListener(this);
    }

    private void animCR() {
        int cx = (cardv_result.getLeft() + cardv_result.getRight()) / 2;
        int cy = (cardv_result.getTop() + cardv_result.getBottom()) / 2;
        float end = Math.max(cardv_result.getWidth(), cardv_result.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(cardv_result, cx, cy, 0, end);
        cardv_result.setVisibility(View.VISIBLE);
        ln4.setVisibility(View.VISIBLE);
        if(id==0)
        {
            txtv_back.setVisibility(View.INVISIBLE);
        }
        else if (id >0)
        {
            txtv_back.setVisibility(View.VISIBLE);
            txtv_next.setVisibility(View.VISIBLE);
        }
        animator.start();
    }

    public void setDataList() {
        string1 = new String[]{"eat", "seat", "teen", "sheep", "been"};
        string2 = new String[]{"it", "sit", "tin", "ship", "bin"};
        string3 = new String[]{"men", "pen", "met", "beg","set"};
        string4 = new String[]{"man", "pan", "mat", "bag","sat"};
        string5 = new String[]{"come", "cup", "hut", "cut", "bun"};
        string6 = new String[]{"calm", "carp", "heart", "cart", "barn"};
        string7 = new String[]{"pot", "don", "cot", "shot","spot"};
        string8 = new String[]{"port", "dawn", "caught", "short","sport"};
        string9 = new String[]{"foot", "full", "wood", "look", "stood"};
        string10 = new String[]{"food", "fool", "wooed", "luke", "stewed"};
        string11 = new String[]{"term (n)", "firm (n)", "bird (n)", "word (n)",
                "burglar (n)", "journey (n)", "learn (v)", "dirty (adj)", "thirty (number)"};
        string12 = new String[]{"woman (n)", "mother (n)", "accept (v)", "answer (v)",
                "complete (v)", "suggest (v)", "handsome (adj)", "anxious (adj)", "responsible (adj)"};
        string13 = new String[]{"aim (n)", "gate (n)", "lake (n)", "tail (n)", "clay (n)", "weight (n)",
                "break (v)", "escape (v)", "anyway (adv)"};
        string14 = new String[]{"side (n)", "price (n)", "night (n)", "sky (n)", "July (n)", "die (v)",
                "deny (v)", "white (adj)", "ripe (adj)"};
        string15 = new String[]{"toy (n)", "oil (n)", "choice (n)", "appoinment (n)", "spoil (v)", "annoy (v)",
                "enjoy (v)", "noisy (adj)"};
        string16 = new String[]{"house (n)", "flower (n)", "power (n)", "council (n)", "pronounce (v)", "loud (adj)",
                "brown (adj)", "now (adv)"};
        string17 = new String[]{"home (n)", "coat (n)", "road (n)", "toe (n)", "window (n)", "potato (n)",
                "propose (v)", "slow (adj)"};
        string18 = new String[]{"deer (n)", "spear (n)", "idea (n)", "steer (v)",
                "near (prep)"};
        string19 = new String[]{"square (n)", "area (n)", "share (v)", "tear (v)",
                "scarce (adj)", "there (adv)", "barely (adv)", "upstairs (adv)"};
        string20 = new String[]{"tournament (n)", "assure (v)", "sure (adj)", "poor (adj)", "surely (adv)"};

        list1 = Arrays.asList(string1);
        list2 = Arrays.asList(string2);
        list3 = Arrays.asList(string3);
        list4 = Arrays.asList(string4);
        list5 = Arrays.asList(string5);
        list6 = Arrays.asList(string6);
        list7 = Arrays.asList(string7);
        list8 = Arrays.asList(string8);
        list9 = Arrays.asList(string9);
        list10 = Arrays.asList(string10);
        list11 = Arrays.asList(string11);
        list12 = Arrays.asList(string12);
        list13 = Arrays.asList(string13);
        list14 = Arrays.asList(string14);
        list15 = Arrays.asList(string15);
        list16 = Arrays.asList(string16);
        list17 = Arrays.asList(string17);
        list18 = Arrays.asList(string18);
        list19 = Arrays.asList(string19);
        list20 = Arrays.asList(string20);

        random = new Random();

    }

    public void setData(int i) {
        if (i == 0) {
            if (stt < string1.length) {
                if (rand(0, 1) == 1) {
                    text = string1[stt].split(" ");
                } else {
                    text = string2[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string1[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string2[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string2[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string1[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv1.setText("");
                tv2.setText("");
                tv_result.setText(String.valueOf(score) + "/" + string1.length);
                animCR();
                score = 0;
            }
        } else if (i == 1) {
            if (stt < string3.length) {
                if (rand(3, 4) == 3) {
                    text = string3[stt].split(" ");
                } else {
                    text = string4[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string3[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string4[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string4[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string3[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string3.length);
                animCR();
                score = 0;
            }
        } else if (i == 3) {
            if (stt < string5.length) {
                if (rand(5, 6) == 5) {
                    text = string5[stt].split(" ");
                } else {
                    text = string6[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string5[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string6[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string6[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string5[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string5.length);
                animCR();
                score = 0;
            }
        } else if (i==4 ) {
            if (stt < string1.length) {
                if (rand(7, 8) == 7) {
                    text = string7[stt].split(" ");
                } else {
                    text = string8[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string7[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string8[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string8[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string7[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string1.length);
                animCR();
                score = 0;
            }
        } else if (i == 2) {
            if (stt < string9.length) {
                if (rand(9, 10) == 9) {
                    text = string9[stt].split(" ");
                } else {
                    text = string10[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string9[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string10[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string10[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string9[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string9.length);
                animCR();
                score = 0;
            }
        } else if (i == 11 || i == 12) {
            if (stt < string11.length) {
                if (i == 11) {
                    text = string11[stt].split(" ");
                } else {
                    text = string12[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string11[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string12[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string12[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string11[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string11.length);
                animCR();
                score = 0;
            }
        } else if (i == 13 || i == 14) {
            if (stt < string13.length) {
                if (i == 13) {
                    text = string13[stt].split(" ");
                } else {
                    text = string14[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string13[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string14[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string14[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string13[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string13.length);
                animCR();
                score = 0;
            }
        } else if (i == 15 || i == 16) {
            if (stt < string15.length) {
                if (i == 15) {
                    text = string15[stt].split(" ");
                } else {
                    text = string16[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string15[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string16[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string16[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string15[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string15.length);
                animCR();
                score = 0;
            }
        } else if (i == 17 || i == 18) {
            if (stt < string1.length) {
                if (i == 1) {
                    text = string1[stt].split(" ");
                } else {
                    text = string2[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string1[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string2[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string2[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string1[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string1.length);
                animCR();
                score = 0;
            }
        } else if (i == 19 || i == 20) {
            if (stt < string1.length) {
                if (i == 1) {
                    text = string1[stt].split(" ");
                } else {
                    text = string2[stt].split(" ");
                }
                strExample = text[0];
                if (rand(0, 1) == 0) {
                    text = string1[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string2[stt].split(" ");
                    tv2.setText(text[0]);
                } else {
                    text = string2[stt].split(" ");
                    tv1.setText(text[0]);
                    text = string1[stt].split(" ");
                    tv2.setText(text[0]);
                }
            } else {
                tv_result.setText(String.valueOf(score) + "/" + string1.length);
                animCR();
                score = 0;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgSpeak:
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
                MainActivity.textToSpeech.speak(strExample, TextToSpeech.QUEUE_FLUSH, map);
                break;
            case R.id.ln1:
                if (tv1.getText().toString().equals(strExample)) {
                    ln1.setBackgroundColor(getResources().getColor(R.color.correct));
                    setNewData();
                } else {
                    ln1.setBackgroundColor(getResources().getColor(R.color.error));
                    clearError();
                }
                break;
            case R.id.ln2:
                if (tv2.getText().toString().equals(strExample)) {
                    ln2.setBackgroundColor(getResources().getColor(R.color.correct));
                    setNewData();
                } else {
                    ln2.setBackgroundColor(getResources().getColor(R.color.error));
                    clearError();
                }
                break;
            case R.id.ln3:
                if (tv_result.getText().toString().equals(strExample)) {
                    ln3.setBackgroundColor(getResources().getColor(R.color.correct));
                    setNewData();
                } else {
                    ln3.setBackgroundColor(getResources().getColor(R.color.error));
                    clearError();

                }
                break;
            case R.id.ln4:
                if (tv4.getText().toString().equals(strExample)) {
                    ln4.setBackgroundColor(getResources().getColor(R.color.correct));
                    setNewData();
                } else {
                    ln4.setBackgroundColor(getResources().getColor(R.color.error));
                    clearError();
                }
                break;
            case R.id.txtv_next:
                break;
            case R.id.txtv_back:
                break;

        }
    }

    public void setNewData() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handlerSetNewData.sendEmptyMessage(0);
            }
        });
        thread.start();
    }

    private Handler handlerSetNewData = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            stt++;
            score++;
            setData(id);
            ln1.setBackgroundColor(getResources().getColor(R.color.white));
            ln2.setBackgroundColor(getResources().getColor(R.color.white));
        }
    };

    public void clearError() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handlerClearError.sendEmptyMessage(0);
            }
        });
        thread.start();
    }

    private Handler handlerClearError = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            stt++;
            setData(id);
            ln1.setBackgroundColor(getResources().getColor(R.color.white));
            ln2.setBackgroundColor(getResources().getColor(R.color.white));
        }
    };

    @Override
    protected void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
