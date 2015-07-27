/*
*  뷰페이저의 스와이핑을 막자!!
*  뷰페이저가 보유한 터치관련 메서드들을 오버라이딩하면 됨
* */
package kr.co.stylenetwork.smartboard;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}













