package com.shubham.hamlet.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.shubham.hamlet.R;
import com.shubham.hamlet.Splash.SplashActivity;
import com.shubham.hamlet.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hide the status bar
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
//        binding.bg.animate().translationY(-5000).setDuration(1000).setStartDelay(4500);
//        binding.parrot.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
//        binding.name.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.splashtextanimation2);
//        binding.card1.startAnimation(animation);
        binding.parrot.startAnimation(animation);
        binding.number.startAnimation(animation);
        binding.btnLogin.startAnimation(animation);
        binding.bg.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bgrain));
        binding.bg.start();

        binding.bg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }
}