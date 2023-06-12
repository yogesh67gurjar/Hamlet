package com.shubham.hamlet.Adapter.Social;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.hamlet.BottomSheetFragment.CommentFragment;
import com.shubham.hamlet.R;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.MyViewHolder> {
    Context context;


    public SocialAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SocialAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_soical_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.MyViewHolder holder, int position) {
        holder.txtComment.setOnClickListener(v -> {
            CommentFragment commentFragment = new CommentFragment();

            FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
            FragmentTransaction ft =manager.beginTransaction();
//            commentFragment.setCancelable(false);
            commentFragment.show(ft, commentFragment.getTag());
        });
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView txtComment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtComment = itemView.findViewById(R.id.txtComment);
        }
    }
}
