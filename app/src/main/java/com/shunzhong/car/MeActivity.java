package com.shunzhong.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hasee on 2018/3/11.
 */

public class MeActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_me);

        ImageView install = (ImageView) findViewById(R.id.install);
        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent ();
                it.setClass(getApplicationContext(),SettingsActivity.class);
                startActivity(it);
            }
        });
}}
