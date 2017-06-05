package com.app.esd.esd.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.support.v4.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.app.esd.esd.Adapter.PractVPAdapter;
import com.app.esd.esd.R;

public class PracticeActivity extends BaseActivity {
    ViewPager viewPager;
    View view_readpract, view_chooseword, view_keyboard;
    Button btn_read;
    ImageView imgv_icon;
    PractVPAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice);
        imgv_icon = (ImageView) findViewById(R.id.imgv_pract);
        imgv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewpager_pract);
        pagerAdapter = new PractVPAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding((int) dipToPixels(this, 32), 0, (int) dipToPixels(this, 32), 0);
        viewPager.setPageMargin((int) dipToPixels(this, 32));
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        pagerAdapter.setOnBtnItemClickListener(new PractVPAdapter.OnBtnItemClickListener() {
            @Override
            public void onClick(int position, ViewGroup viewGroup) {
                switch (position) {
                    case 0:
                        Intent open_keyboard = new Intent(PracticeActivity.this,
                                Keyboard.class);
                        startActivity(open_keyboard);
                        break;
                    case 1:
                        Intent open_listen = new Intent(PracticeActivity.this,
                                VowelPairActivity.class);
                        Pair<View, String> pair_listen_imgv =
                                new Pair<View, String>(
                                        viewGroup.findViewById(R.id.imgv_pager_listen),
                                        "imgvlisten"),
                                pair_listen_txtv =
                                        new Pair<View, String>(
                                                viewGroup.findViewById(R.id.tv_listen_pager),
                                                "txtvlisten");
                        ActivityOptionsCompat option_listen = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(PracticeActivity.this,
                                        pair_listen_imgv);
                        startActivity(open_listen, option_listen.toBundle());
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
