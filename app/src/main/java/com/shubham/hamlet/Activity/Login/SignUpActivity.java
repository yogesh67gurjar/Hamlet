package com.shubham.hamlet.Activity.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth mAuth;
    String email, password;
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
        animation();

        binding.txtOldUser.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });
        binding.btnSignUp.setOnClickListener(v -> {
            email = binding.txtEmail.getText().toString();
            password = binding.txtPassword.getText().toString();

            if (binding.txtName.getText().toString().trim().isEmpty()) {
                binding.txtName.setError("Enter Full Name");
                binding.txtName.requestFocus();
            } else if (binding.txtNumber.getText().toString().isEmpty()) {
                binding.txtNumber.setError("Enter Phone Number");
                binding.txtNumber.requestFocus();
            } else if (binding.txtDOB.getText().toString().isEmpty()) {
                binding.txtDOB.setError("Enter date of birth");
                binding.txtDOB.requestFocus();
            } else if (binding.txtEmail.getText().toString().isEmpty()) {
                binding.txtEmail.setError("Enter Email Address");
                binding.txtEmail.requestFocus();
            } else if (binding.txtPassword.getText().toString().isEmpty()) {
                binding.txtPassword.setError("Enter Password");
                binding.txtPassword.requestFocus();
            } else {

                SignUp(email, password);

            }
        });
    }

    private void animation() {
        Animation animation = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.splashtextanimation2);
        binding.firstLL.startAnimation(animation);
        binding.txtLogo.startAnimation(animation);
        binding.txtEmail.startAnimation(animation);
        binding.txtPassword.startAnimation(animation);
        binding.btnSignUp.startAnimation(animation);
        binding.txtName.startAnimation(animation);
        binding.txtNumber.startAnimation(animation);
        binding.txtDOB.startAnimation(animation);

    }

    private void SignUp(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                    Toast.makeText(SignUpActivity.this, "Successful SignUp Please Login...", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(SignUpActivity.this, "Sorry We Can't Do This...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}