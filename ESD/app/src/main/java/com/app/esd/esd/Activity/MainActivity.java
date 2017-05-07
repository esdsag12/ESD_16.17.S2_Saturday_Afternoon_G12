package com.app.esd.esd.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.app.esd.esd.Modals.ServicesModals.OxfordPronunciationService;
import com.app.esd.esd.R;

import java.io.IOException;

public class MainActivity extends BaseActivity implements OxfordPronuncationListener, View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    Button btnDich, btnDoc, btnKeyboard;
    EditText edtText, edtSo;
    String text = "";
    int length = 0, totalLength = 0;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDich = (Button) findViewById(R.id.btn_dich);
        edtText = (EditText) findViewById(R.id.edt_text);
        btnDoc = (Button) findViewById(R.id.btn_doc);
        edtSo = (EditText) findViewById(R.id.edt_so);
        btnKeyboard = (Button) findViewById(R.id.btn_keyboard);
        btnKeyboard.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnDich.setOnClickListener(this);


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
            case R.id.btn_doc:
                if (Integer.parseInt(edtSo.getText().toString()) < 45 && Integer.parseInt(edtSo.getText().toString()) > 0) {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    try {
                        mediaPlayer.setDataSource(getApplicationContext(), Uri.parse("https://noidung.tienganh123.com/file/baihoc/pronunciation/coban/" +
                                "bai" + edtSo.getText().toString().trim() + "/u" + edtSo.getText().toString().trim() + ".mp3"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnCompletionListener(this);
                }
                break;
            case R.id.btn_keyboard:
                Intent i=new Intent(this,Keyboard.class);
                startActivity(i);
                break;

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
}
