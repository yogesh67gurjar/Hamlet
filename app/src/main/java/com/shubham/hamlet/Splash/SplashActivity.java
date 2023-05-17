package com.shubham.hamlet.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.shubham.hamlet.MainActivity;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    long l = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bg.animate().translationY(-5000).setDuration(1000).setStartDelay(4500);
        binding.parrot.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
        binding.name.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splashtextanimation2);
        binding.name.startAnimation(animation);
//        binding.lottie.startAnimation(animation);

        binding.lottie.animate().translationY(5000).setDuration(1000).setStartDelay(4500);


        new CountDownTimer(5560, 1000) {

            public void onTick(long millisUntilFinished) {
//                binding.splashLogo2.animate().alpha(0).setDuration(1500);
            }

            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }.start();

    }
}