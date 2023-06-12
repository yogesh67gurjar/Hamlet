package com.shubham.hamlet.Adapter.Comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.hamlet.Adapter.Message.MessageAdapter;
import com.shubham.hamlet.R;

public class UserCommentViewAdapter extends RecyclerView.Adapter<UserCommentViewAdapter.MyViewHolder> {
    Context context;

    public UserCommentViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserCommentViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_commentview_layout, parent, false);
        return new UserCommentViewAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserCommentViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
