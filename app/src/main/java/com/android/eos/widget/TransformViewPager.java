package com.android.eos.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static com.android.eos.utils.ConstantUtils.RESEARCH_BANNER_SCALE;

public class TransformViewPager extends ViewPager {
//    private static final float MIN_ALPHA = 0.8f;

    public TransformViewPager(Context context) {
        this(context, null);
    }

    public TransformViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this.setPageTransformer(false, new DepthPageTransformer());
//        this.setOffscreenPageLimit(2);  // 避免卡顿
//        this.setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
//            @Override
//            public void onChildViewAdded(View parent, View child) {
////                child.setScaleY(RESEARCH_BANNER_SCALE);
////                child.setAlpha(MIN_ALPHA);
//            }
//
//            @Override
//            public void onChildViewRemoved(View parent, View child) {
//
//            }
//        });
    }

    private float beforeX;
    private boolean isCanScroll = true;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isCanScroll) {
            return super.dispatchTouchEvent(ev);
        } else {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN://按下如果‘仅’作为‘上次坐标’，不妥，因为可能存在左滑，motionValue大于0的情况（来回滑，只要停止坐标在按下坐标的右边，左滑仍然能滑过去）
                    beforeX = ev.getX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float motionValue = ev.getX() - beforeX;

                    if (motionValue < -5) {//禁止左滑
                        if (null != mLeftSlideListener) {
                            mLeftSlideListener.leftSlide();
                        }
                        return true;
                    }
                    beforeX = ev.getX();//手指移动时，再把当前的坐标作为下一次的‘上次坐标’，解决上述问题

                    break;
                default:
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }

    }


    public boolean isScrollble() {
        return isCanScroll;
    }

    /**
     * 设置 是否可以滑动
     *
     * @param isCanScroll
     */
    public void setScrollble(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    /**
     * 禁止左滑后的左滑监听
     */
    public interface LeftSlideListener {
        void leftSlide();
    }

    private LeftSlideListener mLeftSlideListener;

    public void setLeftSlideListener(LeftSlideListener leftSlideListener) {
        this.mLeftSlideListener = leftSlideListener;
    }

    public class DepthPageTransformer implements PageTransformer {

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @SuppressLint("NewApi")
        public void transformPage(View view, float position) {

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setScaleY(RESEARCH_BANNER_SCALE);
//                view.setAlpha(MIN_ALPHA);
            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                float scaleFactor = RESEARCH_BANNER_SCALE + (1 - RESEARCH_BANNER_SCALE) * (1 - Math.abs(position));
//                float alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA)* (1 - Math.abs(position));
                view.setScaleY(scaleFactor);
//                view.setAlpha(alphaFactor);
            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                // Counteract the default slide transition

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = RESEARCH_BANNER_SCALE + (1 - RESEARCH_BANNER_SCALE) * (1 - Math.abs(position));
//                float alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA)* (1 - Math.abs(position));
                view.setScaleY(scaleFactor);
//                view.setAlpha(alphaFactor);
            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setScaleY(RESEARCH_BANNER_SCALE);
//                view.setAlpha(MIN_ALPHA);
            }
        }
    }

}
