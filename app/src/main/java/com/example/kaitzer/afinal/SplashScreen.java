package com.example.kaitzer.afinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.github.florent37.viewanimator.ViewAnimator;

public class SplashScreen extends AppCompatActivity {

    ImageView icon;
    public static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        icon = (ImageView) findViewById(R.id.IVicon);

        animateParallel();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
            }
        },SPLASH_TIME_OUT);
    }

    protected void onPause()
    {
        super.onPause();
        finish();
    }

    protected void animateParallel() {
        ViewAnimator.animate(icon)
                .dp().translationY(-1000, 0)
                .alpha(0, 1)
                .singleInterpolator(new OvershootInterpolator())

                .waitForHeight()
                .singleInterpolator(new AccelerateDecelerateInterpolator())
                .duration(2000)

                .andAnimate(icon)
                .rotation(0, 720)

                .duration(2500)

                .start();
    }
}
