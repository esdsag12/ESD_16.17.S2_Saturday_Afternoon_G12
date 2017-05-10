package com.app.esd.esd.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.esd.esd.R;

public class PracticeChooseWord extends AppCompatActivity implements View.OnClickListener{
    private TextView tv1,tv2,tv3,tv4;
    private ImageView imgSpeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_choose_word);
        init();
        setEventClick();
    }
    public void init()
    {
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        imgSpeak = (ImageView) findViewById(R.id.imgSpeak);
    }
    public void setEventClick()
    {
        imgSpeak.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgSpeak:
        }
    }
}
