package com.app.esd.esd.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.app.esd.esd.R;

public class PracticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice);
    }
}
