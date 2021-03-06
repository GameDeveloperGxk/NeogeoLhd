/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.arcade.activity.simulator;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.view.Window;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

public class BaseActivity extends AppCompatActivity {
    static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL = 0x1;
    protected boolean mPermissionExternal;
    
    public BaseActivity() {
        mPermissionExternal = false;
    }
    
    protected void onCreate(Bundle p1) {
        super.onCreate(p1);
        getSupportActionBar().hide();
        checkPermission();
    }
    
    protected void onResume() {
        super.onResume();
    }
    
    protected void onPause() {
        super.onPause();
    }
    
    protected void onDestroy() {
        super.onDestroy();
    }
    
    protected void hideNavigationBar() {
        Window localWindow1 = 0x1506;
        getWindow().getDecorView().setSystemUiVisibility(localWindow1);
        getWindow().addFlags(0x8000000);
    }
    
    private void checkPermission() {
        if(ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") = {
                ActivityCompat.requestPermissions(this, ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE")"android.permission.WRITE_EXTERNAL_STORAGE"}, 0x1);
                return;
            }
            mPermissionExternal = true;
        }
        
        public void onRequestPermissionsResult(int p1, String[] p2, int[] p3) {
            switch(p1) {
                case 1:
                {
                    if(p3[0x0] == 0) {
                        mPermissionExternal = true;
                        return;
                    }
                    mPermissionExternal = false;
                    finish();
                    break;
                }
            }
        }
    }
    