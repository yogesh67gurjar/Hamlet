package com.shubham.hamlet.Adapter.Comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.hamlet.R;

import java.util.concurrent.atomic.AtomicBoolean;

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
        AtomicBoolean likeComment = new AtomicBoolean(false);
        holder.btnCommentLike.setOnClickListener(v -> {

            if (!likeComment.get()){
                holder.btnCommentLike.setImageResource(R.drawable.ic_fill_comment_like);
                likeComment.set(true);
            }else {
                holder.btnCommentLike.setImageResource(R.drawable.ic_comment_like);
                likeComment.set(false);
            }

        });

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton btnCommentLike;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCommentLike = itemView.findViewById(R.id.btnCommentLike);
        }
    }
}
