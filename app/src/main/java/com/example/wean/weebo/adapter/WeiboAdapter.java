package com.example.wean.weebo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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
import com.example.wean.weebo.gson.Pic_urls;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.gson.User;
import com.example.wean.weebo.utils.Image;
import com.example.wean.weebo.utils.ImageAapter;
import com.w4lle.library.NineGridlayout;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Wean on 2017/7/21.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private Context context;
    private List<Statuses> statuses;
    private  List<List<Image>> imagesList;

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
        NineGridlayout pic;

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
            pic= (NineGridlayout) itemView.findViewById(R.id.iv_ngrid_layout);
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
        Glide.with(context).load(R.drawable.adv).into(holder.user_icon);
        holder.weibo_content.setText(statuses1.getText().toString());
        User user=statuses1.getUser();
        holder.user_name.setText(user.getScreen_name());
        holder.weibo_time.setText(statuses1.getCreated_at());
        List<Pic_urls> list=statuses1.getPic_urls();
        List<Image> itemList=new List<Image>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Image> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(Image image) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Image> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Image> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Image get(int index) {
                return null;
            }

            @Override
            public Image set(int index, Image element) {
                return null;
            }

            @Override
            public void add(int index, Image element) {

            }

            @Override
            public Image remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Image> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Image> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Image> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (list.size()!=0){
            for (int i = 0; i <list.size() ; i++) {
                Image image=new Image(list.get(i).getThumbnail_pic(),45,45);
                itemList.add(image);
            }
            imagesList.add(itemList);
        }

        holder.pic.setAdapter(new ImageAapter(context,imagesList));
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }
}
