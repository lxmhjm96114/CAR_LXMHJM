package com.shunzhong.car;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hasee on 2018/3/11.
 */

public class LianxiActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);

       Button back_button = (Button) findViewById(R.id.back_button);
       back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                       public void onClick(View v){
                   finish();
               }

       });
    }}

