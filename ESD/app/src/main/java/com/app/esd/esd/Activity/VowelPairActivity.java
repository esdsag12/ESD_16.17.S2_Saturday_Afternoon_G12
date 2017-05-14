package com.app.esd.esd.Activity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.app.esd.esd.Adapter.Rv_VowelPair_Adapter;
import com.app.esd.esd.R;

public class VowelPairActivity extends AppCompatActivity {
    ImageView imgv_icon;
    Animator animator;
    RecyclerView rv_vowel;
    RecyclerView.LayoutManager rvLm;
    Rv_VowelPair_Adapter rv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vowel_pair);
        imgv_icon = (ImageView) findViewById(R.id.imgv_icon_vowelpair);
        rv_vowel = (RecyclerView) findViewById(R.id.rv_vowelpair);
        rvLm = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rv_vowel.setLayoutManager(rvLm);
        rv_adapter = new Rv_VowelPair_Adapter(this);
        rv_vowel.setAdapter(rv_adapter);
        rv_adapter.setOnItemClickListener(new Rv_VowelPair_Adapter.OnItemClickListener() {
            @Override
            public void ItemClick(Activity activity, int ID) {
                Intent intent_open = new Intent(activity, PracticeChooseWord.class);
                startActivity(intent_open);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        int cy = findViewById(R.id.ln_parent_vowelpair).getWidth() / 2,
//                cx = (imgv_icon.getBottom() + imgv_icon.getTop()) / 2;
//
//        float startRa = imgv_icon.getRight() - imgv_icon.getLeft(),
//                endRa = Math.max(findViewById(R.id.ln_parent_vowelpair).getWidth(),
//                        findViewById(R.id.ln_parent_vowelpair).getHeight());
//        animator = ViewAnimationUtils
//                .createCircularReveal(findViewById(R.id.ln_parent_vowelpair),
//                        cx, cy, startRa, endRa);
//        animator.setDuration(250);
//        animator.start();
    }
}
