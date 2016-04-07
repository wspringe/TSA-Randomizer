package com.example.wesley.onepointfourmillion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView l = (ImageView) findViewById(R.id.imageView1);
        final ImageView r = (ImageView) findViewById(R.id.imageView2);
        final Button clickaroo = (Button) findViewById(R.id.button);

        final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);
        l.setAnimation(fadeOut);
        r.setAnimation(fadeOut);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
             public void onAnimationEnd(Animation animation) {
                 l.setVisibility(View.GONE);
                 r.setVisibility(View.GONE);
                 clickaroo.setVisibility(View.VISIBLE);
             }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        clickaroo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int i = rand.nextInt(2);
                clickaroo.setVisibility(View.GONE);
                if (i == 0) {
                    l.setVisibility(View.VISIBLE);
                    l.startAnimation(fadeOut);
                } else {
                    r.setVisibility(View.VISIBLE);
                    r.startAnimation(fadeOut);
                }
            }
        });
    }
}
