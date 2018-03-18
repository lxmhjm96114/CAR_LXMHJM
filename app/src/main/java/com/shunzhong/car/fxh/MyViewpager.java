package com.shunzhong.car.fxh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by hasee on 2018/3/18.
 */

public class MyViewpager extends ViewPager {
    public MyViewpager(@NonNull Context context) {
        super(context);
    }

    public MyViewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int y = (int) ev.getRawY();
        int x = (int) ev.getRawX();
        int mLastMotionY = 0, mLastMotionX = 0;
        boolean resume = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 发生down事件时,记录y坐标
                mLastMotionY = y;
                mLastMotionX = x;
                resume = false;
                break;
            case MotionEvent.ACTION_MOVE:
                // deltaY > 0 是向下运动,< 0是向上运动
                int deltaY = y - mLastMotionY;
                int deleaX = x - mLastMotionX;

                if (Math.abs(deleaX) > Math.abs(deltaY)) {
                    resume = true;
                } else {
                    //当前正处于滑动
                    resume = false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return resume;
    }
}