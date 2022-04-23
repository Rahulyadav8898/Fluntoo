package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.GetComments;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter <CommentAdapter.myviewholder>{
    List<GetComments> items=new ArrayList<>();
    Context context;

    public CommentAdapter(List<GetComments> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_comment, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        GetComments item=items.get(position);
        holder.username.setText(item.getCommentsUserName());
        holder.comment_tv.setText(item.getUserComment());
        holder.time_tv.setText(item.getUserCommentDate().toString());
        Glide.with(context)
                .load(item.getCommentsUserProfile())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView username,comment_tv,time_tv;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.usernamecomment);
            comment_tv=itemView.findViewById(R.id.comment_tv);
            time_tv=itemView.findViewById(R.id.time);
            img=itemView.findViewById(R.id.imgcomment);

        }
    }
}
