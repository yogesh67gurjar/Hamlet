package com.shubham.hamlet.Activity.Chating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.ActivityInsideChatBinding;

public class InsideChatActivity extends AppCompatActivity {
    ActivityInsideChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsideChatBinding.inflate(getLayoutInflater());

        binding.toolbar.setNavigationOnClickListener(v -> {
            finish();
        });

        setContentView(binding.getRoot());
    }
}