package com.shubham.hamlet.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;
import com.shubham.hamlet.Adapter.HomeFragmentTabLayoutAdapter;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    HomeFragmentTabLayoutAdapter adapter;
    FragmentHomeBinding binding;
    private String[] titles={"Camera","Social","Message"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // fragment setup
        adapter = new HomeFragmentTabLayoutAdapter(getActivity());
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (((tab, position) -> tab.setText(titles[position])))).attach();
        binding.viewPager.setCurrentItem(1);
        return binding.getRoot();
    }
}