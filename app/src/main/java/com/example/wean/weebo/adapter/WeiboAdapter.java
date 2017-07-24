package com.example.wean.weebo.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.Statuses;

import java.util.List;

/**
 * Created by Wean on 2017/7/21.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private Context context;
    private List<Statuses> statuses;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView user_icon;
        TextView user_name;
        TextView weibo_time;
        TextView weibo_content;
        ImageButton forward;
        ImageButton comment;
        ImageButton like;
        ImageButton more;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            user_icon= (ImageView) itemView.findViewById(R.id.user_image);
            user_name= (TextView) itemView.findViewById(R.id.user_name);
            weibo_time= (TextView) itemView.findViewById(R.id.time_weibo);
            weibo_content= (TextView) itemView.findViewById(R.id.weibo_content);
            forward= (ImageButton) itemView.findViewById(R.id.resend);
            comment= (ImageButton) itemView.findViewById(R.id.comment);
            like= (ImageButton) itemView.findViewById(R.id.like);
            more= (ImageButton) itemView.findViewById(R.id.more_user);
        }
    }

    public WeiboAdapter(List<Statuses> mstatuses){
        statuses=mstatuses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.weibo_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Statuses statuses1=statuses.get(position);
        Glide.with(context).load(statuses1.getId()).into(holder.user_icon);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }
}
