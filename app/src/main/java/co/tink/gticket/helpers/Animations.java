package co.tink.gticket.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import co.tink.gticket.R;
import co.tink.gticket.activities.ActivityMain;

public class Animations {

    public static Animation fade_in() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(300);
        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeIn);
        return animation;
    }

    public static Animation fade_out() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new DecelerateInterpolator());
        fadeOut.setDuration(300);
        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeOut);
        return animation;
    }

    public static Animation blink() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        animation.setStartOffset(20);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        return animation;
    }

    public static void visible(View view, boolean visible) {
        if (visible) {
            view.setVisibility(View.VISIBLE);
            view.setAnimation(fade_in());
        } else {
            view.setAnimation(fade_out());
            view.setVisibility(View.GONE);
        }
    }

    public static void expand(Context context, final View v, boolean expand) {
        ValueAnimator slideAnimator;
        int min = context.getResources().getDimensionPixelSize(R.dimen.nav_header_height);
        int max = context.getResources().getDimensionPixelSize(R.dimen.nav_header_height);

        if (expand) {
            slideAnimator = ValueAnimator.ofInt(min, max).setDuration(500);
        } else {
            slideAnimator = ValueAnimator.ofInt(max, min).setDuration(500);
        }

        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                v.getLayoutParams().height = value.intValue();
                v.requestLayout();
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(slideAnimator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    public static void shrink(Context context, final View v, boolean shrink) {
        ValueAnimator animator;
//        int min = context.getResources().getDimensionPixelSize(R.dimen.add_set_margin_left);
//        int max = context.getResources().getDimensionPixelSize(R.dimen.circle_image_dim);

        DisplayMetrics dm = new DisplayMetrics();
        ((ActivityMain)context).getWindowManager().getDefaultDisplay().getMetrics(dm);

        int min = context.getResources().getDimensionPixelSize(R.dimen.nav_header_height);
        int max = dm.widthPixels;

        if (shrink) {
            animator = ValueAnimator.ofInt(max, min).setDuration(500);
        } else {
            animator = ValueAnimator.ofInt(min, max).setDuration(500);
        }

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                v.getLayoutParams().height = value.intValue();
                v.getLayoutParams().width = value.intValue();
                v.requestLayout();
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    public static void moveViewToScreenCenter(Activity activity, final View view) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int originalPos[] = new int[2];
        view.getLocationOnScreen(originalPos);

//        int xDelta = -(dm.widthPixels - view.getMeasuredWidth() - originalPos[0]) / 2;
//        int yDelta = -(dm.heightPixels - view.getMeasuredHeight() - originalPos[1]) / 2;
        int xDelta = -originalPos[0];
        int yDelta = -originalPos[1] +view.getMeasuredHeight();

        AnimationSet animSet = new AnimationSet(true);
        animSet.setFillAfter(true);
        animSet.setDuration(1000);
        animSet.setInterpolator(new DecelerateInterpolator());
        TranslateAnimation translate = new TranslateAnimation(0, xDelta, 0, yDelta);
        animSet.addAnimation(translate);
//        ScaleAnimation scale = new ScaleAnimation(1f, 0.4f, 1f, 0.4f, ScaleAnimation.RELATIVE_TO_PARENT, .5f, ScaleAnimation.RELATIVE_TO_PARENT, .5f);
//        animSet.addAnimation(scale);
//
//        translate.setRepeatCount(1);
//        translate.setRepeatMode(Animation.REVERSE);
//        scale.setRepeatCount(1);
//        scale.setRepeatMode(Animation.REVERSE);

        view.startAnimation(animSet);
    }

    public void circular_reveal(View view) {
        view.setVisibility(View.VISIBLE);
        int x = (view.getLeft() + view.getRight()) / 2;
        int y = (view.getTop() + view.getBottom()) / 2;

        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(view, x, y, 0, finalRadius);
        anim.setDuration(500);

        anim.start();
    }

    public void circular_hide(final View view) {
//
        int x = (view.getLeft() + view.getRight()) / 2;
        int y = (view.getTop() + view.getBottom()) / 2;

        int initialRadius = view.getWidth();

        Animator anim = ViewAnimationUtils.createCircularReveal(view, x, y, initialRadius, 0);
        anim.setDuration(500);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.GONE);
            }
        });
        anim.start();
    }

}
