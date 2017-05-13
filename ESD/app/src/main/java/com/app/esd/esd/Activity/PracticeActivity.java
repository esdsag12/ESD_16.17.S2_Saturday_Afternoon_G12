package com.app.esd.esd.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.app.esd.esd.Adapter.PractVPAdapter;
import com.app.esd.esd.R;

public class PracticeActivity extends BaseActivity {
    ViewPager viewPager;
    View view_readpract, view_chooseword, view_keyboard;
    Button btn_read;
    PractVPAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice);
        viewPager = (ViewPager) findViewById(R.id.viewpager_pract);
        pagerAdapter = new PractVPAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding((int) dipToPixels(this, 32), 0, (int) dipToPixels(this, 32), 0);
        viewPager.setPageMargin((int) dipToPixels(this, 32));
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        pagerAdapter.setOnBtnItemClickListener(new PractVPAdapter.OnBtnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        Intent open_keyboard = new Intent(PracticeActivity.this,
                                Keyboard.class);
                        startActivity(open_keyboard);
                        break;
                    case 1:
                        Intent open_speak = new Intent(PracticeActivity.this,
                                PracticeRead.class);
                        startActivity(open_speak);
                        break;
                    case 2:
                        Intent open_listen = new Intent(PracticeActivity.this,
                                PracticeChooseWord.class);
                        startActivity(open_listen);
                        break;

                }
            }
        });
//        viewPager.setPageMargin(300);
//        viewPager.addView(, params);
//        viewPager.addView(view_keyboard, params);
    }

    public float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }
}
