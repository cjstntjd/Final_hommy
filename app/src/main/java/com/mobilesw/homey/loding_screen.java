package com.mobilesw.homey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class loding_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding_screen);
        ImageView imageView = (ImageView)findViewById(R.id.loding_logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        imageView.setAnimation(animation);

        startLoading();
    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },4000);


    }


}
