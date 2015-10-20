package com.afun.bottomslidelayout.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.afun.bottomslidelayout.R;

/**
 * Created by qingxi.wang on 2015/9/15.
 */
public class BottomSlideLayout extends FrameLayout {
    private View mSlideLayout;
    private Context mContext;
    private RelativeLayout layer;

    private Animation slideUp;
    private Animation slideDown;
    private Animation fadeIn;
    private boolean isOpen = false;
    private boolean autoSlideDownFlag = false;

    public BottomSlideLayout(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public BottomSlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public BottomSlideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private Animation.AnimationListener upAnimationListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            isOpen = true;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private Animation.AnimationListener downAnimationListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            isOpen = false;
            layer.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private Animation.AnimationListener fadeInListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
            mSlideLayout.setVisibility(View.VISIBLE);
            mSlideLayout.startAnimation(slideUp);
        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };


    private void init() {
        fadeIn = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
        fadeIn.setAnimationListener(fadeInListener);
        slideUp = AnimationUtils.loadAnimation(mContext, R.anim.bottom_slide_up);
        slideUp.setAnimationListener(upAnimationListener);
        slideDown = AnimationUtils.loadAnimation(mContext, R.anim.bottom_slide_down);
        slideDown.setAnimationListener(downAnimationListener);
    }

    private void addLayer() {
        //增加表面图层
        layer = new RelativeLayout(mContext);
        layer.setBackgroundColor(Color.parseColor("#55000000"));
        layer.setVisibility(View.GONE);
        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mSlideLayout.setVisibility(View.GONE);
        layer.addView(mSlideLayout, lp1);
        addView(layer);
    }

    public void setSlideLayout(View view) {
        mSlideLayout = view;
        addLayer();
    }

    public void slideUp() {
        if (!isOpen) {
            layer.setVisibility(View.VISIBLE);
            layer.startAnimation(fadeIn);
        }
    }

    public void setAutoSlideDown( boolean autoSlideDown) {
        this.autoSlideDownFlag = autoSlideDown;
        if (autoSlideDown) {
            layer.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    slideDown();
                }
            });

            mSlideLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    return;
                }
            });
        } else {
            layer.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }
    }

    public void slideDown() {
        if (isOpen) {
            mSlideLayout.setVisibility(View.GONE);
            mSlideLayout.startAnimation(slideDown);
        }
    }
}
