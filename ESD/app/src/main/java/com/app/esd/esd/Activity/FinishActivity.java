package com.app.esd.esd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.esd.esd.R;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class FinishActivity extends AppCompatActivity {
    private static final char[] NUMBER_LIST = TickerUtils.getDefaultNumberList();
    private ImageView imgv_icon;
    TickerView tickerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_finish);
        final Intent intent=getIntent();

       tickerView= (TickerView) findViewById(R.id.ticker1);
        tickerView.setCharacterList(NUMBER_LIST);
        tickerView.setText("0");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tickerView.setText( intent.getIntExtra("D",0)+"");
            }
        },200);
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
