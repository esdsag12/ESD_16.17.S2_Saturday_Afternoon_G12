package com.app.esd.esd.Activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.esd.esd.R;

import java.io.IOException;

public class DetailVowelActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener{
    private TextView tvContent;
    private String vowel;
    private Toolbar toolbar;
    private ImageView imgSpeak,img;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vowel);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            vowel = extras.getString("vowel");
            id=extras.getInt("id");
        }
        init();
        setToolbar();
        setData(id);
        setEventClick();
    }

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvContent = (TextView) findViewById(R.id.tvContent);
        imgSpeak = (ImageView)findViewById(R.id.imgSpeak);
        img= (ImageView)findViewById(R.id.img);
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(vowel);
    }

    public void setEventClick()
    {
        imgSpeak.setOnClickListener(this);
    }

    public void setData(int i)
    {
        if(i==1)
        {
            tvContent.setText(getResources().getString(R.string.vowel1));
            img.setImageResource(R.drawable.vowel1);
        }
        else if (i==2)
        {
            tvContent.setText(getResources().getString(R.string.vowel2));
            img.setImageResource(R.drawable.vowel2);
        }
        else if (i==3)
        {
            tvContent.setText(getResources().getString(R.string.vowel3));
            img.setImageResource(R.drawable.vowel3);
        }
        else if (i==4)
        {
            tvContent.setText(getResources().getString(R.string.vowel4));
            img.setImageResource(R.drawable.vowel4);
        }
        else if (i==5)
        {
            tvContent.setText(getResources().getString(R.string.vowel5));
            img.setImageResource(R.drawable.vowel5);
        }
        else if (i==6)
        {
            tvContent.setText(getResources().getString(R.string.vowel6));
            img.setImageResource(R.drawable.vowel6);
        }
        else if (i==7)
        {
            tvContent.setText(getResources().getString(R.string.vowel7));
            img.setImageResource(R.drawable.vowel7);
        }
        else if (i==8)
        {
            tvContent.setText(getResources().getString(R.string.vowel8));
            img.setImageResource(R.drawable.vowel8);
        }
        else if (i==9)
        {
            tvContent.setText(getResources().getString(R.string.vowel9));
            img.setImageResource(R.drawable.vowel9);
        }
        else if (i==10)
        {
            tvContent.setText(getResources().getString(R.string.vowel10));
            img.setImageResource(R.drawable.vowel10);
        }
        else if (i==11)
        {
            tvContent.setText(getResources().getString(R.string.vowel11));
            img.setImageResource(R.drawable.vowel11);
        }
        else if (i==12)
        {
            tvContent.setText(getResources().getString(R.string.vowel12));
            img.setImageResource(R.drawable.vowel12);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void speakVowel(int i)
    {
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
        switch (v.getId()){
            case R.id.imgSpeak:
                speakVowel(id);
        }
    }
}
