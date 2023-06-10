package com.shubham.hamlet.Adapter.Message;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.hamlet.Activity.Chating.InsideChatActivity;
import com.shubham.hamlet.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    Context context;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_message_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyViewHolder holder, int position) {
        holder.clickOnChat.setOnClickListener(v -> {
            context.startActivity(new Intent(context, InsideChatActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clickOnChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            clickOnChat = itemView.findViewById(R.id.clickOnChat);
        }
    }
}
