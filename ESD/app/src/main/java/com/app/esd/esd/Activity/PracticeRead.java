package com.app.esd.esd.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.app.esd.esd.Fragment.PracticeReadFragment;
import com.app.esd.esd.Modals.Sentence;
import com.app.esd.esd.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciqaz on 27/05/2017.
 */


public class PracticeRead extends AppCompatActivity {
    private ViewPager viewPager;
    private MyPageAdapter myPageAdapter;
    public static List<Sentence> sentences;
    private List<Fragment> fragments;
    private TextView txtStt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        sentences=new ArrayList<>();
        fragments=new ArrayList<>();
        Sentence sentence  =new Sentence();
        sentence.setText("Asdasd");
        sentence.setPronunciation("asdasdsad");
        sentence.setChoosed(true) ;

        Sentence sentence1  =new Sentence();
        sentence1.setText("Asdasd");
        sentence1.setPronunciation("asdasdsad");
        sentence1.setChoosed(false) ;

        Sentence sentence2  =new Sentence();
        sentence2.setText("Asdasd");
        sentence2.setPronunciation("asdasdsad");
        sentence2.setChoosed(false) ;
        sentences.add(sentence1);
        sentences.add(sentence2);
        sentences.add(sentence);

        viewPager= (ViewPager) findViewById(R.id.vp_list);
        txtStt= (TextView) findViewById(R.id.txt_stt);
        myPageAdapter=new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPageAdapter);

        for(int i=0;i<sentences.size();i++){
            fragments.add(PracticeReadFragment.newInstance(0));
        }
        myPageAdapter.addAll(fragments);
    }
}
class MyPageAdapter extends FragmentPagerAdapter{
    List<Fragment> list;
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
        list=new ArrayList<>();
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    public void addAll(List<Fragment> fragments){
        this.list.addAll(fragments);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}


