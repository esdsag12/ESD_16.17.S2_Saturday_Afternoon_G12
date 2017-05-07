package com.app.esd.esd.Activity;

import android.app.Dialog;
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

public class MainActivity extends BaseActivity implements OxfordPronuncationListener, View.OnClickListener {
    Button btnDich;
    EditText edtText;
    String text = "";
    int length = 0, totalLength = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDich = (Button) findViewById(R.id.btn_dich);
        edtText = (EditText) findViewById(R.id.edt_text);
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
        }
    }
}
