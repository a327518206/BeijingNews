package com.example.beijingnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashAcitvity extends AppCompatActivity {

    private RelativeLayout rl_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);

        //渐变,缩放,旋转
        AlphaAnimation aa = new AlphaAnimation(0,1);
//        aa.setDuration(500);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(2000);

        rl_splash.setAnimation(set);
        rl_splash.setLayoutAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements Animation.AnimationListener {
        /**
         * 动画开始
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {
        }
        /**
         * 动画结束
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(SplashAcitvity.this, "播放完成", Toast.LENGTH_SHORT).show();
        }
        /**
         * 动画重复
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
