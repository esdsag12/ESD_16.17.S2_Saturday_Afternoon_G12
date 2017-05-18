package com.app.esd.esd.Activity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.app.esd.esd.Adapter.Rv_ConsonantPair_Adapter;
import com.app.esd.esd.Adapter.Rv_VowelPair_Adapter;
import com.app.esd.esd.R;

public class VowelPairActivity extends AppCompatActivity {
    ImageView imgv_icon;
    Animator animator;
    RecyclerView rv_vowel, rv_conso;
    RecyclerView.LayoutManager rv_vowel_Lm, rv_conso_Lm;
    Rv_VowelPair_Adapter rv_vowel_adapter;
    Rv_ConsonantPair_Adapter rv_conso_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vowel_pair);
        imgv_icon = (ImageView) findViewById(R.id.imgv_icon_vowelpair);
        rv_vowel = (RecyclerView) findViewById(R.id.rv_vowelpair);
        rv_vowel_Lm = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rv_vowel.setLayoutManager(rv_vowel_Lm);
        rv_vowel_adapter = new Rv_VowelPair_Adapter(this);
        rv_vowel.setAdapter(rv_vowel_adapter);
        rv_vowel_adapter.setOnItemClickListener(new Rv_VowelPair_Adapter.OnItemClickListener() {
            @Override
            public void ItemClick(Activity activity, int ID, View itemView, String pair) {
                Intent intent_open = new Intent(activity, PracticeChooseWord.class);
                ActivityOptionsCompat option_text = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(activity,
                                itemView.findViewById(R.id.txtv_vowel_itemrv),
                                "vowelpair");
                intent_open.putExtra("pair", pair);
                intent_open.putExtra("id", ID);
                startActivity(intent_open, option_text.toBundle());
            }
        });
        rv_conso = (RecyclerView) findViewById(R.id.rv_consonantpair);
        rv_conso_Lm = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rv_conso.setLayoutManager(rv_conso_Lm);
        rv_conso_adapter = new Rv_ConsonantPair_Adapter(this);
        rv_conso.setAdapter(rv_conso_adapter);
        rv_conso_adapter.setOnItemClickListener(new Rv_ConsonantPair_Adapter.OnItemClickListener() {
            @Override
            public void ItemClick(Activity activity, int ID, View itemView, String pair) {
                Intent intent_open = new Intent(activity, PracticeChooseWord.class);
                ActivityOptionsCompat option_text = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(activity,
                                itemView.findViewById(R.id.txtv_vowel_itemrv),
                                "vowelpair");
                intent_open.putExtra("pair", pair);
                intent_open.putExtra("id", ID);
                startActivity(intent_open, option_text.toBundle());
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
