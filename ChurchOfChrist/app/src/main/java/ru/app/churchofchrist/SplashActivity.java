package ru.app.churchofchrist;

import android.content.Intent;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView text = findViewById(R.id.text);
        TextView text2 = findViewById(R.id.text2);
        ImageView image = findViewById(R.id.imageView3);
        Typeface CF2 = Typeface.createFromAsset(getAssets(), "fonts/CODE Light.otf");
        Typeface CF = Typeface.createFromAsset(getAssets(), "fonts/CODE Bold.otf");
        text.setTypeface(CF);
        text2.setTypeface(CF2);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        image.startAnimation(anim);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.translate2);
        text.startAnimation(anim2);
        text2.startAnimation(anim2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);

    }
}
