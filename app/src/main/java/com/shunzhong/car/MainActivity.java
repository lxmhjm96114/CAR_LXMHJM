package com.shunzhong.car;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title, home_text,  trade_text, me_text;
    private ImageView  home_image,  trade_image, me_image;
    private ViewPager vp;
    private layout.HomeFragment HomeFragment;
    private layout.TradeFragment TradeFragment;
    private layout.MeFragment MeFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    String[] titles = new String[]{"首页", "交易", "我"};

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除工具栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initViews();


        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        home_text.setTextColor(Color.parseColor("#66CDAA"));

        //ViewPager的监听事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
                title.setText(titles[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        title = (TextView) findViewById(R.id.title);
        home_text = (TextView) findViewById(R.id.home_text);
        trade_text = (TextView) findViewById(R.id.trade_text);
        me_text = (TextView) findViewById(R.id.me_text);

        home_image = (ImageView) findViewById(R.id.home_image);
        trade_image = (ImageView) findViewById(R.id.trade_image);
        me_image = (ImageView) findViewById(R.id.me_image);

        home_text.setOnClickListener(this);
        trade_text.setOnClickListener(this);
        me_text.setOnClickListener(this);

        home_image.setOnClickListener(this);
        trade_image.setOnClickListener(this);
        me_image.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewPager);
        HomeFragment = new layout.HomeFragment();
        TradeFragment = new layout.TradeFragment();
        MeFragment = new layout.MeFragment();
        //给FragmentList添加数据
        mFragmentList.add(HomeFragment);
        mFragmentList.add(TradeFragment);
        mFragmentList.add(MeFragment);
    }


    /**
     * 点击底部image 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_image:
                vp.setCurrentItem(0, true);
                break;
            case R.id.trade_image:
                vp.setCurrentItem(1, true);
                break;
            case R.id.me_image:
                vp.setCurrentItem(2, true);
                break;
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            home_text.setTextColor(Color.parseColor("#66CDAA"));
            trade_text.setTextColor(Color.parseColor("#000000"));
            me_text.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            home_text.setTextColor(Color.parseColor("#000000"));
            trade_text.setTextColor(Color.parseColor("#66CDAA"));
            me_text.setTextColor(Color.parseColor("#000000"));
        } else if (position == 2) {
            trade_text.setTextColor(Color.parseColor("#000000"));
            home_text.setTextColor(Color.parseColor("#000000"));
            me_text.setTextColor(Color.parseColor("#66CDAA"));
        }
    }

}
