package com.app.esd.esd.Activity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.esd.esd.Adapter.ExampleAdapter;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailVowelActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, OxfordPronuncationListener {
    private TextView tvContent;
    private String vowel;
    private ImageView imgSpeak, imgSpeakDialog, img;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int id;

    private String[] string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12,
            string13, string14, string15, string16, string17, string18, string19, string20,
            string21, string22, string23, string24, string25, string26, string27, string28,
            string29, string30, string31, string32, string33, string34, string35, string36,
            string37, string38, string39, string40, string41, string42, string43, string44;
    private List<String> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15,
            list16, list17, list18, list19, list20,
    list21, list22, list23, list24, list25,
    list26, list27, list28, list29, list30,
    list31, list32, list33, list34, list35,
    list36, list37, list38, list39, list40,
    list41, list42, list43, list44;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private String strExample;
    private TextToSpeech textToSpeech;
    private TextView tvExample, tvVowel, tvClose, tvResult;
    int length = 0, totalLength = 0;

    private ImageView imgMicro;
    private String[] text;
    private LinearLayout lnClose;
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private FloatingActionButton fabPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_vowel);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            vowel = extras.getString("vowel");
            id = extras.getInt("id");
        }
        init();
        setDataList();
        setData(id);
        setEventClick();
    }

    public void init() {
        tvContent = (TextView) findViewById(R.id.tvContent);
        imgSpeak = (ImageView) findViewById(R.id.imgSpeak);
        img = (ImageView) findViewById(R.id.img);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        fabPractice = (FloatingActionButton) findViewById(R.id.fabPractice);
    }


    public void setEventClick() {
        imgSpeak.setOnClickListener(this);
        fabPractice.setOnClickListener(this);
    }

    public void setData(int i) {
        if (i == 1) {
            tvContent.setText(getResources().getString(R.string.vowel1));
            img.setImageResource(R.drawable.vowel1);
            exampleAdapter = new ExampleAdapter(this, list1);
        } else if (i == 2) {
            tvContent.setText(getResources().getString(R.string.vowel2));
            img.setImageResource(R.drawable.vowel2);
            exampleAdapter = new ExampleAdapter(this, list2);
        } else if (i == 3) {
            tvContent.setText(getResources().getString(R.string.vowel3));
            img.setImageResource(R.drawable.vowel3);
            exampleAdapter = new ExampleAdapter(this, list3);
        } else if (i == 4) {
            tvContent.setText(getResources().getString(R.string.vowel4));
            img.setImageResource(R.drawable.vowel4);
            exampleAdapter = new ExampleAdapter(this, list4);
        } else if (i == 5) {
            tvContent.setText(getResources().getString(R.string.vowel5));
            img.setImageResource(R.drawable.vowel5);
            exampleAdapter = new ExampleAdapter(this, list5);
        } else if (i == 6) {
            tvContent.setText(getResources().getString(R.string.vowel6));
            img.setImageResource(R.drawable.vowel6);
            exampleAdapter = new ExampleAdapter(this, list6);
        } else if (i == 7) {
            tvContent.setText(getResources().getString(R.string.vowel7));
            img.setImageResource(R.drawable.vowel7);
            exampleAdapter = new ExampleAdapter(this, list7);
        } else if (i == 8) {
            tvContent.setText(getResources().getString(R.string.vowel8));
            img.setImageResource(R.drawable.vowel8);
            exampleAdapter = new ExampleAdapter(this, list8);
        } else if (i == 9) {
            tvContent.setText(getResources().getString(R.string.vowel9));
            img.setImageResource(R.drawable.vowel9);
            exampleAdapter = new ExampleAdapter(this, list9);
        } else if (i == 10) {
            tvContent.setText(getResources().getString(R.string.vowel10));
            img.setImageResource(R.drawable.vowel10);
            exampleAdapter = new ExampleAdapter(this, list10);
        } else if (i == 11) {
            tvContent.setText(getResources().getString(R.string.vowel11));
            img.setImageResource(R.drawable.vowel11);
            exampleAdapter = new ExampleAdapter(this, list11);
        } else if (i == 12) {
            tvContent.setText(getResources().getString(R.string.vowel12));
            img.setImageResource(R.drawable.vowel12);
            exampleAdapter = new ExampleAdapter(this, list12);
        } else if (i == 13) {
            tvContent.setText(getResources().getString(R.string.vowel13));
            img.setImageResource(R.drawable.vowel13);
            exampleAdapter = new ExampleAdapter(this, list13);
        } else if (i == 14) {
            tvContent.setText(getResources().getString(R.string.vowel14));
            img.setImageResource(R.drawable.vowel14);
            exampleAdapter = new ExampleAdapter(this, list14);
        } else if (i == 15) {
            tvContent.setText(getResources().getString(R.string.vowel15));
            img.setImageResource(R.drawable.vowel15);
            exampleAdapter = new ExampleAdapter(this, list15);
        } else if (i == 16) {
            tvContent.setText(getResources().getString(R.string.vowel16));
            img.setImageResource(R.drawable.vowel16);
            exampleAdapter = new ExampleAdapter(this, list16);
        } else if (i == 17) {
            tvContent.setText(getResources().getString(R.string.vowel17));
            img.setImageResource(R.drawable.vowel17);
            exampleAdapter = new ExampleAdapter(this, list17);
        } else if (i == 18) {
            tvContent.setText(getResources().getString(R.string.vowel18));
            img.setImageResource(R.drawable.vowel18);
            exampleAdapter = new ExampleAdapter(this, list18);
        } else if (i == 19) {
            tvContent.setText(getResources().getString(R.string.vowel19));
            img.setImageResource(R.drawable.vowel19);
            exampleAdapter = new ExampleAdapter(this, list19);
        } else if (i == 20) {
            tvContent.setText(getResources().getString(R.string.vowel20));
            img.setImageResource(R.drawable.vowel20);
            exampleAdapter = new ExampleAdapter(this, list20);
        }else if (i == 21) {
            tvContent.setText(getResources().getString(R.string.vowel21));
            img.setImageResource(R.drawable.vowel21);
            exampleAdapter = new ExampleAdapter(this, list21);
        }else if (i == 22) {
            tvContent.setText(getResources().getString(R.string.vowel22));
            img.setImageResource(R.drawable.vowel22);
            exampleAdapter = new ExampleAdapter(this, list22);
        }else if (i == 23) {
            tvContent.setText(getResources().getString(R.string.vowel23));
            img.setImageResource(R.drawable.vowel23);
            exampleAdapter = new ExampleAdapter(this, list23);
        }else if (i == 24) {
            tvContent.setText(getResources().getString(R.string.vowel24));
            img.setImageResource(R.drawable.vowel24);
            exampleAdapter = new ExampleAdapter(this, list24);
        }else if (i == 25) {
            tvContent.setText(getResources().getString(R.string.vowel25));
            img.setImageResource(R.drawable.vowel25);
            exampleAdapter = new ExampleAdapter(this, list25);
        }else if (i == 26) {
            tvContent.setText(getResources().getString(R.string.vowel26));
            img.setImageResource(R.drawable.vowel26);
            exampleAdapter = new ExampleAdapter(this, list26);
        }else if (i == 27) {
            tvContent.setText(getResources().getString(R.string.vowel27));
            img.setImageResource(R.drawable.vowel27);
            exampleAdapter = new ExampleAdapter(this, list27);
        }else if (i == 28) {
            tvContent.setText(getResources().getString(R.string.vowel28));
            img.setImageResource(R.drawable.vowel28);
            exampleAdapter = new ExampleAdapter(this, list28);
        }else if (i == 29) {
            tvContent.setText(getResources().getString(R.string.vowel29));
            img.setImageResource(R.drawable.vowel29);
            exampleAdapter = new ExampleAdapter(this, list29);
        }else if (i == 30) {
            tvContent.setText(getResources().getString(R.string.vowel30));
            img.setImageResource(R.drawable.vowel30);
            exampleAdapter = new ExampleAdapter(this, list30);
        }else if (i == 31) {
            tvContent.setText(getResources().getString(R.string.vowel31));
            img.setImageResource(R.drawable.vowel31);
            exampleAdapter = new ExampleAdapter(this, list31);
        }else if (i == 32) {
            tvContent.setText(getResources().getString(R.string.vowel32));
            img.setImageResource(R.drawable.vowel32);
            exampleAdapter = new ExampleAdapter(this, list32);
        }else if (i == 33) {
            tvContent.setText(getResources().getString(R.string.vowel33));
            img.setImageResource(R.drawable.vowel33);
            exampleAdapter = new ExampleAdapter(this, list33);
        }else if (i == 34) {
            tvContent.setText(getResources().getString(R.string.vowel34));
            img.setImageResource(R.drawable.vowel34);
            exampleAdapter = new ExampleAdapter(this, list34);
        }else if (i == 35) {
            tvContent.setText(getResources().getString(R.string.vowel35));
            img.setImageResource(R.drawable.vowel35);
            exampleAdapter = new ExampleAdapter(this, list35);
        }else if (i == 36) {
            tvContent.setText(getResources().getString(R.string.vowel36));
            img.setImageResource(R.drawable.vowel36);
            exampleAdapter = new ExampleAdapter(this, list36);
        }else if (i == 37) {
            tvContent.setText(getResources().getString(R.string.vowel37));
            img.setImageResource(R.drawable.vowel37);
            exampleAdapter = new ExampleAdapter(this, list37);
        }else if (i == 38) {
            tvContent.setText(getResources().getString(R.string.vowel38));
            img.setImageResource(R.drawable.vowel38);
            exampleAdapter = new ExampleAdapter(this, list38);
        }else if (i == 39) {
            tvContent.setText(getResources().getString(R.string.vowel39));
            img.setImageResource(R.drawable.vowel39);
            exampleAdapter = new ExampleAdapter(this, list39);
        }else if (i == 40) {
            tvContent.setText(getResources().getString(R.string.vowel40));
            img.setImageResource(R.drawable.vowel40);
            exampleAdapter = new ExampleAdapter(this, list40);
        }else if (i == 41) {
            tvContent.setText(getResources().getString(R.string.vowel41));
            img.setImageResource(R.drawable.vowel41);
            exampleAdapter = new ExampleAdapter(this, list41);
        }else if (i == 42) {
            tvContent.setText(getResources().getString(R.string.vowel42));
            img.setImageResource(R.drawable.vowel42);
            exampleAdapter = new ExampleAdapter(this, list42);
        }else if (i == 43) {
            tvContent.setText(getResources().getString(R.string.vowel43));
            img.setImageResource(R.drawable.vowel43);
            exampleAdapter = new ExampleAdapter(this, list43);
        }else if (i == 44) {
            tvContent.setText(getResources().getString(R.string.vowel44));
            img.setImageResource(R.drawable.vowel44);
            exampleAdapter = new ExampleAdapter(this, list44);
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
        string10 = new String[]{"room (n)", "pool (n)", "flute (n)", "glue (n)",
                "group (n)", "music (n)", "chew (v)", "move (v)", "suitable (adj)"};
        string9 = new String[]{"book (n)", "wool (n)", "woman (n)", "childhood (n)",
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

        string21 = new String[]{"pen (n)","pocket (n)","paper (n)","airport (n)","trip (n)","envelope (n)","put (v)","copy (v)","stop (v)","cheap (adj)"};
        string22 = new String[]{"boy (n)","bread (n)","bag (n)","book (n)","boots (n)","number (n)","club (n)","job (n)","remember (v)"};
        string23 = new String[]{"water (n)","bottle (n)","west (n)","complete (v)","missed (v)","tall (adj)","better (adj)","two (number)"};
        string24 = new String[]{"day (n)","middle (n)","ladder (n)","garden (n)","head (n)","dance (v)","drink (v)","deep (adj)","good (adj)"};
        string25 = new String[]{"calf (n)","king (n)","Christmas (n)","cook (v)","like (v)","make (v)","look (v)","think (v)"};
        string26 = new String[]{"gate (n)","dragon (n)","beggar (n)","leg (n)","fog (n)","give (v)","grow (v)","jog (v)"};
        string27 = new String[]{"sister (n)","Christmas (n)","grass (n)","face (n)","office (n)","scissors (n)","sit (v)","sleep (v)","yesterday (adv)"};
        string28 = new String[]{"size (n)","ozone (n)","prize (n)","noise (n)","rose (n)","doors (n)","surprise (n)","rise (v)","zero (number)"};
        string29 = new String[]{"mushroom (n)","Russia (n)","mission (n)","action (n)","emotion (n)","musician (n)","machine (n)","sugar (n)","she (pron)"};
        string30 = new String[]{"genre (n)","Asia (n)","decision (n)","occasion (n)","leisure (n)","equation (n)","garage (n)","massage (n)","usually (adv)"};
        string31 = new String[]{"cheese (n)","teacher (n)","March (n)","culture (n)","future (n)","picture (n)","kitchen (n)","watch (n)"};
        string32 = new String[]{"job (n)","gym (n)","age (n)","education (n)","fridge (n)","join (v)","enjoy (v)","giant (adj)","large (adj)"};
        string33 = new String[]{"face (n)","finger (n)","coffee (n)","staff (n)","photo (n)","orphan (n)","laugh (v)","cough (v)","fat (adj)"};
        string34 = new String[]{"vase (n)","vest (n)","violin (n)","lover (n)","advice (n)","glove (n)","drive (v)","seven (number)","five (number)"};
        string35 = new String[]{"wife (n)","weather (n)","world (n)","language (n)","sweet (adj)","white (adj)","why (adv)","what (pron)","one (number)"};
        string36 = new String[]{"year (n)","young (adj)","yesterday (adv)","you (pron)","yeah (exclamation)","your (determiner)","","","","",};
        string37 = new String[]{"hand (n)","house (n)","homework (n)","forehead (n)","behave (v)","who (pron)","whom (pron)","whose (pron)","behind (prep)"};
        string38 = new String[]{"thief (n)","throat (n)","author (n)","Kathy (n)","birthday (n)","mouth (n)","north (n)","teeth (n)","thin (adj)"};
        string39 = new String[]{"mother (n)","father (n)","feather (n)","bathe (v)","breathe (v)","smooth (adj)","they (pron)","this (pron)","these (pron)"};
        string40 = new String[]{"map (n)","mirror (n)","Monday (n)","film (n)","woman (n)","roommate (n)","mark (v)","smile (v)","slim (adj)"};
        string41 = new String[]{"nature (n)","nation (n)","knife (n)","month (n)","need (v)","know (v)","win (v)","learn (v)","sunny (adj)"};
        string42 = new String[]{"king (n)","ring (n)","monkey (n)","uncle (n)","morning (n)","think (v)","sing (v)","long (adj)","single (adj)"};
        string43 = new String[]{"leaf (n)","lamp (n)","wallet (n)","ball (n)","alarm (v)","believe (v)","sail (v)","fall (v)","silly (adj)"};
        string44 = new String[]{"road (n)","parents (n)","ferry (n)","read (v)","borrow (v)","write (v)","American (adj)","sorry (adj)","wrong (adj)"};

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


        list21 = Arrays.asList(string21);
        list22 = Arrays.asList(string22);
        list23 = Arrays.asList(string23);
        list24 = Arrays.asList(string24);
        list25 = Arrays.asList(string25);
        list26 = Arrays.asList(string26);
        list27 = Arrays.asList(string27);
        list28 = Arrays.asList(string28);
        list29 = Arrays.asList(string29);
        list30 = Arrays.asList(string30);

        list31 = Arrays.asList(string31);
        list32 = Arrays.asList(string32);
        list33 = Arrays.asList(string33);
        list34 = Arrays.asList(string34);
        list35 = Arrays.asList(string35);
        list36 = Arrays.asList(string36);
        list37 = Arrays.asList(string37);
        list38 = Arrays.asList(string38);
        list39 = Arrays.asList(string39);
        list40 = Arrays.asList(string40);

        list41 = Arrays.asList(string41);
        list42 = Arrays.asList(string42);
        list43 = Arrays.asList(string43);
        list44 = Arrays.asList(string44);

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
                break;
            case R.id.fabPractice:
                Intent intent = new Intent(DetailVowelActivity.this, PracticeChooseWord.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onOxfordPronuncationListenerSuccess(OxfordObject oxfordObject) {
        if(null == oxfordObject){
            Toast.makeText(this, "Loi api, do st", Toast.LENGTH_SHORT).show();
        }else{
            try {
                if (strExample == "") {
                    strExample += oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
                } else {
                    strExample += " " + oxfordObject.getResults()[0].getLexicalEntries()[0].getPronunciations()[0].getPhoneticSpelling();
                }
                showDialogFilter(text[0], strExample);
            }
            catch (Exception e){}
        }

    }

    public void speakExample(String example) {
        strExample = "";
        text = example.split(" ");
        new OxfordPronunciationService(this).execute(text[0].trim());
    }

    @Override
    protected void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    private void showDialogFilter(String example, String vowel) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_example);
       /*
       Init components
        */

        tvExample = (TextView) dialog.findViewById(R.id.tvExample);
        tvVowel = (TextView) dialog.findViewById(R.id.tvVowel);
        lnClose = (LinearLayout) dialog.findViewById(R.id.lnClose);
        tvResult = (TextView) dialog.findViewById(R.id.tvResult);
        imgMicro = (ImageView) dialog.findViewById(R.id.imgMicro);
        imgSpeakDialog = (ImageView) dialog.findViewById(R.id.imgSpeakDialog);

        tvExample.setText(example);
        tvVowel.setText("/" + vowel + "/");

        //format position dialog
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.TOP);
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();

        layoutParams.y = getPixelValue(this, 130);
        //layoutParams.x = convertDpToPixel((float) 130 / 1, ResortsActivity.this);
        dialog.getWindow().setAttributes(layoutParams);
        imgSpeakDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.textToSpeech.speak(text[0], TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        lnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        imgMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
        dialog.show();
    }

    public static int getPixelValue(Context context, int dimenId) {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dimenId,
                resources.getDisplayMetrics()
        );
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Phát âm");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Thiết bị không hỗ trợ",
                    Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQ_CODE_SPEECH_INPUT: {
                    if (data != null) {
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        String speak = result.get(0).substring(0, 1).toLowerCase() + result.get(0).substring(1);
                        if (tvExample.getText().toString().equals(speak)) {
                            tvResult.setText("Phát âm đúng: " + speak);
                            tvResult.setTextColor(getResources().getColor(R.color.correct));
                        } else {
                            tvResult.setText("Phát âm sai: " + speak);
                            tvResult.setTextColor(getResources().getColor(R.color.error));
                        }
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
