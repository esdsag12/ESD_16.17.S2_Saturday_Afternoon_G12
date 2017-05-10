package com.app.esd.esd.Activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.esd.esd.Adapter.ExampleAdapter;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DetailVowelActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener,OxfordPronuncationListener {
    private TextView tvContent;
    private String vowel;
    private Toolbar toolbar;
    private ImageView imgSpeak, img;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int id;

    private String[] string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12,
            string13, string14, string15, string16, string17, string18, string19, string20;
    private List<String> list1,list2,list3,list4,list5,list6,list7,list8,list9,list10,list11,list12,list13,list14,list15,
            list16,list17,list18,list19,list20;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private String strExample;
    private TextToSpeech textToSpeech;
    int length = 0, totalLength = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vowel);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            vowel = extras.getString("vowel");
            id = extras.getInt("id");
        }
        init();
        setToolbar();
        setDataList();
        setData(id);
        setEventClick();
    }

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvContent = (TextView) findViewById(R.id.tvContent);
        imgSpeak = (ImageView) findViewById(R.id.imgSpeak);
        img = (ImageView) findViewById(R.id.img);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(vowel);
    }

    public void setEventClick() {
        imgSpeak.setOnClickListener(this);
    }

    public void setData(int i) {
        if (i == 1) {
            tvContent.setText(getResources().getString(R.string.vowel1));
            img.setImageResource(R.drawable.vowel1);
            exampleAdapter = new ExampleAdapter(this,list1);
        } else if (i == 2) {
            tvContent.setText(getResources().getString(R.string.vowel2));
            img.setImageResource(R.drawable.vowel2);
            exampleAdapter = new ExampleAdapter(this,list2);
        } else if (i == 3) {
            tvContent.setText(getResources().getString(R.string.vowel3));
            img.setImageResource(R.drawable.vowel3);
            exampleAdapter = new ExampleAdapter(this,list3);
        } else if (i == 4) {
            tvContent.setText(getResources().getString(R.string.vowel4));
            img.setImageResource(R.drawable.vowel4);
            exampleAdapter = new ExampleAdapter(this,list4);
        } else if (i == 5) {
            tvContent.setText(getResources().getString(R.string.vowel5));
            img.setImageResource(R.drawable.vowel5);
            exampleAdapter = new ExampleAdapter(this,list5);
        } else if (i == 6) {
            tvContent.setText(getResources().getString(R.string.vowel6));
            img.setImageResource(R.drawable.vowel6);
            exampleAdapter = new ExampleAdapter(this,list6);
        } else if (i == 7) {
            tvContent.setText(getResources().getString(R.string.vowel7));
            img.setImageResource(R.drawable.vowel7);
            exampleAdapter = new ExampleAdapter(this,list7);
        } else if (i == 8) {
            tvContent.setText(getResources().getString(R.string.vowel8));
            img.setImageResource(R.drawable.vowel8);
            exampleAdapter = new ExampleAdapter(this,list8);
        } else if (i == 9) {
            tvContent.setText(getResources().getString(R.string.vowel9));
            img.setImageResource(R.drawable.vowel9);
            exampleAdapter = new ExampleAdapter(this,list9);
        } else if (i == 10) {
            tvContent.setText(getResources().getString(R.string.vowel10));
            img.setImageResource(R.drawable.vowel10);
            exampleAdapter = new ExampleAdapter(this,list10);
        } else if (i == 11) {
            tvContent.setText(getResources().getString(R.string.vowel11));
            img.setImageResource(R.drawable.vowel11);
            exampleAdapter = new ExampleAdapter(this,list11);
        } else if (i == 12) {
            tvContent.setText(getResources().getString(R.string.vowel12));
            img.setImageResource(R.drawable.vowel12);
            exampleAdapter = new ExampleAdapter(this,list12);
        } else if (i == 13) {
            tvContent.setText(getResources().getString(R.string.vowel13));
            img.setImageResource(R.drawable.vowel13);
            exampleAdapter = new ExampleAdapter(this,list13);
        } else if (i == 14) {
            tvContent.setText(getResources().getString(R.string.vowel14));
            img.setImageResource(R.drawable.vowel14);
            exampleAdapter = new ExampleAdapter(this,list14);
        } else if (i == 15) {
            tvContent.setText(getResources().getString(R.string.vowel15));
            img.setImageResource(R.drawable.vowel15);
            exampleAdapter = new ExampleAdapter(this,list15);
        } else if (i == 16) {
            tvContent.setText(getResources().getString(R.string.vowel16));
            img.setImageResource(R.drawable.vowel16);
            exampleAdapter = new ExampleAdapter(this,list16);
        } else if (i == 17) {
            tvContent.setText(getResources().getString(R.string.vowel17));
            img.setImageResource(R.drawable.vowel17);
            exampleAdapter = new ExampleAdapter(this,list17);
        } else if (i == 18) {
            tvContent.setText(getResources().getString(R.string.vowel18));
            img.setImageResource(R.drawable.vowel18);
            exampleAdapter = new ExampleAdapter(this,list18);
        } else if (i == 19) {
            tvContent.setText(getResources().getString(R.string.vowel19));
            img.setImageResource(R.drawable.vowel19);
            exampleAdapter = new ExampleAdapter(this,list19);
        } else if (i == 20) {
            tvContent.setText(getResources().getString(R.string.vowel20));
            img.setImageResource(R.drawable.vowel20);
            exampleAdapter = new ExampleAdapter(this,list20);
        }
        exampleAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(exampleAdapter);
    }

    public void setDataList() {
        string1 = new String[]{"sheep (n)", "bean (n)", "Vietnamese (n)", "see (v)",
                "eat (v)", "agree (v)", "complete (v)", "receive (v)", "believe (v)"};
        string2 = new String[]{"king (n)", "river (n)", "winter (n)", "prison (n)",
                "picnic (n)", "biscuit (n)", "physics (n)", "which (pron)", "sing (v)",
                "give (v)", "listen (v)"};
        string3 = new String[]{"end (n)", "west (n)", "neck (n)", "leg (n)",
                "America (n)", "fell (v)", "said (v)", "expect (v)", "heavy (adj)"};
        string4 = new String[]{"pan (n)", "map (n)", "bank (n)", "stamp (n)",
                "apple (n)", "captain (n)", "factory (n)", "manufacture (v)", "narrow (adj)"};
        string5 = new String[]{"sun (n)", "blood (n)", "number (n)", "summer (n)",
                "mother (n)", "cousin (n)", "country (n)", "come (v)", "touch (v)", "cover (v)"};
        string6 = new String[]{"car (n)", "bar (n)", "star (n)", "cart (n)",
                "father (n)", "start (v)", "carve (v)", "dark (adj)", "hard (adv)"};
        string7 = new String[]{"clock (n)", "cross (n)", "coffee (n)", "chocolate (n)",
                "bottle (n)", "hospital (n)", "wash (v)", "possible (adj)"};
        string8 = new String[]{"law (n)", "lawn (n)", "course (n)", "fault (n)",
                "walk (v)", "thought (v)", "taught (v)", "small (adj)", "important (adj)"};
        string9 = new String[]{"room (n)", "pool (n)", "flute (n)", "glue (n)",
                "group (n)", "music (n)", "chew (v)", "move (v)", "suitable (adj)"};
        string10 = new String[]{"book (n)", "wool (n)", "woman (n)", "childhood (n)",
                "neighbourhood", "good (adj)", "full (adj)", "would (modal)", "should (modal)"};
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
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void speakVowel(int i) {
        if (i < 45 && i > 0) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnErrorListener(this);
            try {
                mediaPlayer.setDataSource(getApplicationContext(), Uri.parse("https://noidung.tienganh123.com/file/baihoc/pronunciation/coban/" +
                        "bai" + String.valueOf(i) + "/u" + String.valueOf(i) + ".mp3"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgSpeak:
                speakVowel(id);
        }
    }

    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        if (strExample == "") {
            strExample += oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
        } else {
            strExample += " " + oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
        }
        Toast.makeText(this, strExample, Toast.LENGTH_SHORT).show();
    }

    public void speakExample(String example)
    {
        strExample = "";
        String[] text=example.split(" ");
        new OxfordPronunciationService(this).execute(text[0].trim());
        textToSpeech.speak(text[0], TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onPause() {
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}