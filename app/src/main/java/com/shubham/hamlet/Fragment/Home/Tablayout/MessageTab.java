package com.shubham.hamlet.Fragment.Home.Tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shubham.hamlet.Adapter.Message.MessageAdapter;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.FragmentMessageTabBinding;

public class MessageTab extends Fragment {

    FragmentMessageTabBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMessageTabBinding.inflate(inflater, container, false);


        binding.RvMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.RvMessage.setAdapter(new MessageAdapter(getContext()));

        return binding.getRoot();
    }
}