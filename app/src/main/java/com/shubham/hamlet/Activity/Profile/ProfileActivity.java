package com.shubham.hamlet.Activity.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    boolean genderBoy = false, genderGirl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cardBoy.setOnClickListener(v -> {
            if (binding.boyGender.isSelected() || !genderBoy) {
                binding.boyGender.setAnimation(R.raw.boy_selected);
                binding.boyGender.playAnimation();
                binding.cardBoy.setCardBackgroundColor(getResources().getColor(R.color.mediumblue));
                binding.cardGirl.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.girlGender.setAnimation(R.raw.girl_unselected);
                binding.girlGender.playAnimation();
                genderBoy = true;
                genderGirl = false;

            } else {
                binding.boyGender.setAnimation(R.raw.boy_unselected);
                binding.boyGender.playAnimation();
                binding.cardBoy.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.cardGirl.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.girlGender.setAnimation(R.raw.girl_unselected);
                binding.girlGender.playAnimation();
                genderBoy = false;
                genderGirl = false;

            }
        });

        binding.cardGirl.setOnClickListener(v -> {
            if (binding.girlGender.isSelected() || !genderGirl) {
                binding.boyGender.setAnimation(R.raw.boy_unselected);
                binding.boyGender.playAnimation();
                binding.cardBoy.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.cardGirl.setCardBackgroundColor(getResources().getColor(R.color.magenta));
                binding.girlGender.setAnimation(R.raw.girl_selected);
                binding.girlGender.playAnimation();
                genderGirl = true;
                genderBoy = false;
            } else {
                binding.boyGender.setAnimation(R.raw.boy_unselected);
                binding.boyGender.playAnimation();
                binding.girlGender.setAnimation(R.raw.girl_unselected);
                binding.cardBoy.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.cardGirl.setCardBackgroundColor(getResources().getColor(R.color.white));
                binding.girlGender.playAnimation();
                genderGirl = false;
                genderBoy = false;
            }
        });
    }
}