package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Channel_Name_Activity;
import com.fluntoo.zenberry.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Channel_ChannelName_Adapter extends RecyclerView.Adapter<Channel_ChannelName_Adapter.myview> {
    List<Channel_ChannelName> items = new ArrayList<>();
    Context context;

    public Channel_ChannelName_Adapter(List<Channel_ChannelName> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_channel_channelname, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        Channel_ChannelName item = items.get(position);
        holder.title.setText(item.getChannelName());
        holder.subtv.setText(item.getSubscribers().toString() + " subcriber");
        Glide.with(context).
                load(item.getChannelProfileimagepath())
                .into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String channeldyanmicid = item.getChanneldynamicId();
                Intent intent1 = new Intent(context, Channel_Name_Activity.class);
                intent1.putExtra("channeldyanmicid", channeldyanmicid);
//                intent1.getIntExtra("rah", sid);
                context.startActivity(intent1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, subtv;

        public myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.channel_channel_img1);
            title = itemView.findViewById(R.id.channel_channelname1);
            subtv = itemView.findViewById(R.id.channel_subscribertv1);
        }
    }
}
