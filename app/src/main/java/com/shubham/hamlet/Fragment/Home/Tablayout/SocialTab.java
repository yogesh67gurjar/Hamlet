package com.shubham.hamlet.Fragment.Home.Tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shubham.hamlet.Adapter.Social.SocialAdapter;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.FragmentMaintabBinding;
import com.shubham.hamlet.databinding.FragmentMessageTabBinding;

public class SocialTab extends Fragment {

    FragmentMaintabBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMaintabBinding.inflate(inflater, container, false);

        binding.RvSocial.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.RvSocial.setAdapter(new SocialAdapter(getContext()));


        return binding.getRoot();
    }
}