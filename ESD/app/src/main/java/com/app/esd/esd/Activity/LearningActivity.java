package com.app.esd.esd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;

import com.app.esd.esd.Adapter.VowelAdapter;
import com.app.esd.esd.Model.Vowel;
import com.app.esd.esd.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LearningActivity extends AppCompatActivity {

    private static final String TAG = "LearningActivity";
    private ExpandableListView eplVowel;
    private HashMap<String, List<Vowel>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        eplVowel = (ExpandableListView) findViewById(R.id.eplVowel);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        eplVowel.setIndicatorBounds(width - dp2px(50), width - dp2px(10));

        //prepare data

        //data for header group
        final List<String> listHeader = new ArrayList<>();
        listHeader.add("Nguyên âm dài");
        listHeader.add("Nguyên âm ngắn");
        listHeader.add("Nguyên âm đôi");
        listHeader.add("Phụ âm");

        //data for child
        mData = new HashMap<>();
        List<Vowel> listShortVowel = new ArrayList<>();
        listShortVowel.add(new Vowel(2,"/ɪ/"));
        listShortVowel.add(new Vowel(3,"/e/"));
        listShortVowel.add(new Vowel(4,"/æ/"));
        listShortVowel.add(new Vowel(5,"/ʌ/"));
        listShortVowel.add(new Vowel(7,"/ɒ/"));
        listShortVowel.add(new Vowel(9,"/ʊ/"));
        listShortVowel.add(new Vowel(12,"/ə/"));



        List<Vowel> listLongVowel = new ArrayList<>();
        listLongVowel.add(new Vowel(1,"/i:/"));
        listLongVowel.add(new Vowel(6,"/ɑ:/"));
        listLongVowel.add(new Vowel(8,"/ɔ:/"));
        listLongVowel.add(new Vowel(10,"/u:/"));
        listLongVowel.add(new Vowel(11,"/ɜ:/"));




        List<Vowel> listDiphthong = new ArrayList<>();
        listDiphthong.add(new Vowel(13,"/eɪ/"));
        listDiphthong.add(new Vowel(14,"/aɪ/"));
        listDiphthong.add(new Vowel(15,"/ɔɪ/"));
        listDiphthong.add(new Vowel(16,"/aʊ/"));
        listDiphthong.add(new Vowel(17,"/əʊ/"));
        listDiphthong.add(new Vowel(18,"/ɪə/"));
        listDiphthong.add(new Vowel(19,"/eə/"));
        listDiphthong.add(new Vowel(20,"/ʊə/"));



        List<Vowel> listConsonants = new ArrayList<>();
        listConsonants.add(new Vowel(21,"/p/"));
        listConsonants.add(new Vowel(22,"/b/"));
        listConsonants.add(new Vowel(23,"/t/"));
        listConsonants.add(new Vowel(24,"/d/"));
        listConsonants.add(new Vowel(25,"/k/"));
        listConsonants.add(new Vowel(26,"/g/"));
        listConsonants.add(new Vowel(27,"/s/"));
        listConsonants.add(new Vowel(28,"/z/"));
        listConsonants.add(new Vowel(29,"/ʃ/"));
        listConsonants.add(new Vowel(30,"/ʒ/"));
        listConsonants.add(new Vowel(31,"/tʃ/"));
        listConsonants.add(new Vowel(32,"/dʒ/"));
        listConsonants.add(new Vowel(33,"/f/"));
        listConsonants.add(new Vowel(34,"/v/"));
        listConsonants.add(new Vowel(35,"/w/"));
        listConsonants.add(new Vowel(36,"/j/"));
        listConsonants.add(new Vowel(37,"/h/"));
        listConsonants.add(new Vowel(38,"/θ/"));
        listConsonants.add(new Vowel(39,"/ð/"));
        listConsonants.add(new Vowel(40,"/m/"));
        listConsonants.add(new Vowel(41,"/n/"));
        listConsonants.add(new Vowel(42,"/ŋ/"));
        listConsonants.add(new Vowel(43,"/l/"));
        listConsonants.add(new Vowel(44,"/r/"));

        mData.put(listHeader.get(0), listLongVowel);
        mData.put(listHeader.get(1), listShortVowel);
        mData.put(listHeader.get(2), listDiphthong);
        mData.put(listHeader.get(3), listConsonants);

        //setup adapter for ExpandableListView
        VowelAdapter adapter = new VowelAdapter(this, listHeader, mData);
        eplVowel.setAdapter(adapter);

        eplVowel.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(LearningActivity.this, DetailVowelActivity.class);
                intent.putExtra("id",mData.get(listHeader.get(groupPosition)).get(childPosition).getId());
                intent.putExtra("vowel",mData.get(listHeader.get(groupPosition)).get(childPosition).getVowel());
                startActivity(intent);
                return true;
            }
        });
    }

    public int dp2px(float dp) {
        // Get the screen's density scale
        final float density = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * density + 0.5f);
    }
}
