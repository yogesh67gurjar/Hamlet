package com.shubham.hamlet.BottomSheetFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.shubham.hamlet.Adapter.Comment.UserCommentViewAdapter;
import com.shubham.hamlet.R;
import com.shubham.hamlet.databinding.FragmentCommentBinding;

public class CommentFragment extends BottomSheetDialogFragment {


    FragmentCommentBinding binding;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCommentBinding.inflate(inflater, container, false);

        binding.rvComment.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvComment.setAdapter(new UserCommentViewAdapter(context));


        return binding.getRoot();
    }


}