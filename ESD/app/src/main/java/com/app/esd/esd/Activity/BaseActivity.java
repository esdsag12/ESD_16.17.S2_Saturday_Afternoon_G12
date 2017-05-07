package com.app.esd.esd.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.esd.esd.R;

/**
 * Created by ciqaz on 5/7/17.
 */

public class BaseActivity extends AppCompatActivity {
    Dialog progressDialog;
    protected void closeDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected void showProgressDialog(String tilte, String message) {
        if (progressDialog == null) {
            if (tilte.equals("")) {
                tilte = getString(R.string.txt_plzwait);
            }
            progressDialog = ProgressDialog.show(this,
                    tilte,
                    message, true, false);
        }
    }

    protected void handleProgressDialog() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isShowProgress()) {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    Toast.makeText(getApplicationContext(), "try again", Toast.LENGTH_SHORT).show();
                }
            }
        }, 15000);
    }
    protected boolean isShowProgress() {
        return progressDialog.isShowing();
    }
}
