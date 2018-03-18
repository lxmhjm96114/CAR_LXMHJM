package com.shunzhong.car;

/**
 * Created by hasee on 2018/3/13.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassifyActivity extends FragmentActivity implements View.OnClickListener {

    private String[] titles={"大客车","中巴车","小轿车","其他"};
    private ScrollView mScrollView;
    private FrameLayout mFrameLayout;
    private LinearLayout mLinearLayout;
    //装装ScrollView的item的TextView的数组
    private TextView[] textViewArray;
    //装ScrollView的item的数组
    private View[] views;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_classify);
        context=this;

        textViewArray=new TextView[titles.length];
        views=new View[titles.length];

        initView();
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }

        });

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Fragment1()).commit();
    }

    private void initView() {
        mScrollView= (ScrollView) findViewById(R.id.scrollview);
        addView();
        changeTextColor(0);

        mFrameLayout= (FrameLayout) findViewById(R.id.framelayout);

    }

    /**
     * 给ScrollView添加子View
     */
    private void addView() {
        LinearLayout mLinearLayout= (LinearLayout) findViewById(R.id.linearlayout);

        View view;
        for(int x=0;x<titles.length;x++){
            view = View.inflate(this, R.layout.item_scrollview, null);
            view.setId(x);
            view.setOnClickListener(this);
            TextView tv= (TextView) view.findViewById(R.id.textview);
            tv.setText(titles[x]);
            mLinearLayout.addView(view);

            textViewArray[x]=tv;
            views[x]=view;

        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,titles[(int)v.getId()],
        Toast.LENGTH_SHORT).show();
        changeTextColor((int) v.getId());
        changeTextLocation((int) v.getId());

        Fragment fragment=null;

        switch (v.getId()){
            case 0:
                fragment=new Fragment1();
                break;
            case 1:
                fragment=new Fragment2();
                break;
            case 2:
                fragment=new Fragment3();
                break;
            case 3:
                fragment=new Fragment4();
                break;
        }
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
        }
    }
    /**
     * 改变textView的颜色
     * @param id
     */
    private void changeTextColor(int id) {
        for (int i = 0; i < textViewArray.length; i++) {
            if(i!=id){
                textViewArray[i].setBackgroundResource(android.R.color.transparent);
                textViewArray[i].setTextColor(0xff000000);
            }else {
                textViewArray[id].setBackgroundResource(android.R.color.white);
                textViewArray[id].setTextColor(0xffff5d5e);
            }
        }

    }

    /**
     * 改变栏目位置
     */
    private void changeTextLocation(int index) {

        //views[clickPosition].getTop()针对其父视图的顶部相对位置
        int x = (views[index].getTop() - mScrollView.getHeight() / 2);
        mScrollView.smoothScrollTo(0, x);
    }


}
