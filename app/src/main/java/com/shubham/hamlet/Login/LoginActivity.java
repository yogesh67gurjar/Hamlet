package com.shubham.hamlet.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.shubham.hamlet.MainActivity;
import com.shubham.hamlet.R;
import com.shubham.hamlet.Splash.SplashActivity;
import com.shubham.hamlet.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onClick();
        // Hide the status bar
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
//        binding.bg.animate().translationY(-5000).setDuration(1000).setStartDelay(4500);
//        binding.parrot.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
//        binding.name.animate().translationY(5000).setDuration(1000).setStartDelay(4500);
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.splashtextanimation2);
        binding.firstLL.startAnimation(animation);
        binding.txtLogo.startAnimation(animation);
        binding.txtEmail.startAnimation(animation);
        binding.txtPassword.startAnimation(animation);
        binding.btnLogin.startAnimation(animation);
        binding.llOr.startAnimation(animation);
        binding.cardGoogle.startAnimation(animation);
        binding.cardFacebook.startAnimation(animation);

//        binding.bg.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bgrain));
//        binding.bg.start();
//
//        binding.bg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });

    }

    private void onClick() {
        binding.btnLogin.setOnClickListener(v -> {
            if (binding.txtEmail.getText().toString().trim().isEmpty()) {
                binding.txtEmail.setError("Enter Email");
                binding.txtEmail.requestFocus();
            } else if (binding.txtPassword.getText().toString().trim().isEmpty()) {
                binding.txtPassword.setError("Enter Password");
                binding.txtPassword.requestFocus();
            } else {
                email = binding.txtEmail.getText().toString();
                password = binding.txtPassword.getText().toString();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
        binding.txtNewUser.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            finish();
        });
        binding.btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Google", Toast.LENGTH_SHORT).show();
        });
        binding.btnFacebook.setOnClickListener(v -> {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
        });
    }
}