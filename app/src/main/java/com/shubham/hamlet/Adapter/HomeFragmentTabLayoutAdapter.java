package com.shubham.hamlet.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.shubham.hamlet.Fragment.Home.Tablayout.CameraTab;
import com.shubham.hamlet.Fragment.Home.Tablayout.SocialTab;
import com.shubham.hamlet.Fragment.Home.Tablayout.MessageTab;

public class HomeFragmentTabLayoutAdapter extends FragmentStateAdapter {
    private String[] titles={"Camera","Social","Message"};
    public HomeFragmentTabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new CameraTab();
            case 1:
                return new SocialTab();
            case 2:
                return new MessageTab();
        }
        return new SocialTab();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
