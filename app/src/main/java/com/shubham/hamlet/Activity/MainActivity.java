package com.shubham.hamlet.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.shubham.hamlet.Activity.Profile.ProfileActivity;
import com.shubham.hamlet.Fragment.Home.HomeFragment;
import com.shubham.hamlet.Fragment.Notification.NotificationFragment;
import com.shubham.hamlet.Fragment.Search.SearchFragment;
import com.shubham.hamlet.Fragment.Setting.SettingFragment;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String deviceToken;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //byDefault open fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        //clickListener
        setOnClickListener();
        //Drawer
        openDrawer();
        //Token
        getToken();
        //navigationBar
        binding.navigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
            } else if (item.getItemId() == R.id.search) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
            } else if (item.getItemId() == R.id.notification) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new NotificationFragment()).commit();
            } else if (item.getItemId() == R.id.setting) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingFragment()).commit();
            }
            return true;
        });


    }

    private void openDrawer() {

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar
                , 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        binding.drawernavigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.instagram) {
                Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show();
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
//                    binding.textView.setText("Home");
            }

            return true;
        });
    }

    private void setOnClickListener() {

        binding.floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        });

    }


    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                Toast.makeText(this, "Error generating device token", Toast.LENGTH_SHORT).show();
                return;
            }
            // Get new FCM registration token
            deviceToken = task.getResult();
            Log.d(TAG, "getToken: " + deviceToken);

        });
    }
}