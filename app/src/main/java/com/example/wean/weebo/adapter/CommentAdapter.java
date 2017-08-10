package com.example.wean.weebo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.Comments;


import java.util.List;

/**
 * Created by Wean on 2017/8/2.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private List<Comments> commentList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cname;
        TextView content;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            cname= (TextView) itemView.findViewById(R.id.c_name);
            content= (TextView) itemView.findViewById(R.id.comment);
            imageView= (ImageView) itemView.findViewById(R.id.com_adv);
        }
    }

    public CommentAdapter(List<Comments> mcommentList){
        commentList=mcommentList;
        System.out.println("评论数量"+commentList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        System.out.println("评论数量"+getItemCount());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comments comments=commentList.get(position);
        Glide.with(context).load(comments.getUser().getAvatar_hd()).into(holder.imageView);

        holder.cname.setText(comments.getUser().getScreen_name());
        holder.content.setText(comments.getText());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}
