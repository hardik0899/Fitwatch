package com.example.fitwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timerhere = findViewById(R.id.timer);

        // create optional animation
        btnstop.setAlpha(0);

        // load animations
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        // import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(view -> {
            // passing animation
            icanchor.startAnimation(roundingalone);
            btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
            btnstart.animate().alpha(0).setDuration(300).start();
            // start timer
            timerhere.setBase(SystemClock.elapsedRealtime());
            timerhere.start();
        });

        btnstop.setOnClickListener(view -> {
            // passing animation
            icanchor.clearAnimation();
            btnstop.animate().alpha(0).setDuration(300).start();
            btnstart.animate().alpha(1).setDuration(300).start();
            // stop timer
            timerhere.stop();
        });
    }
}