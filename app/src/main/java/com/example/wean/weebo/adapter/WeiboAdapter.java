package com.example.wean.weebo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
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
import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.content.ContentValues.TAG;


/**
 * Created by Wean on 2017/7/21.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private Context context;
    private List<Statuses> statuses;
    private List<List<Image>> imagesList;

    static class ViewHolder extends RecyclerView.ViewHolder {
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
            cardView = (CardView) itemView;
            user_icon = (ImageView) itemView.findViewById(R.id.user_image);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            weibo_time = (TextView) itemView.findViewById(R.id.time_weibo);
            weibo_content = (TextView) itemView.findViewById(R.id.weibo_content);
            forward = (ImageButton) itemView.findViewById(R.id.resend);
            comment = (ImageButton) itemView.findViewById(R.id.comment);
            like = (ImageButton) itemView.findViewById(R.id.like);
            more = (ImageButton) itemView.findViewById(R.id.more_user);
            pic = (NineGridlayout) itemView.findViewById(R.id.iv_ngrid_layout);
        }
    }

    public WeiboAdapter(List<Statuses> mstatuses, List<List<Image>> datalist) {
        statuses = mstatuses;
        imagesList = datalist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.weibo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Statuses statuses1 = statuses.get(position);
        Glide.with(context).load(statuses1.getUser().getAvatar_hd()).into(holder.user_icon);
        holder.weibo_content.setText(statuses1.getText().toString());
        User user = statuses1.getUser();
        holder.user_name.setText(user.getScreen_name());
        holder.weibo_time.setText(statuses1.getCreated_at());
        List<Pic_urls> piclist = statuses1.getPic_urls();
        System.out.println("Pic list:" + piclist.size());

        List<Image> templist = new ArrayList<>();
        for (int j = 0; j < piclist.size(); j++) {
            Image image = new Image(piclist.get(j).getThumbnail_pic(), 45, 45);
            templist.add(image);
        }

        if (templist.isEmpty()) {
            holder.pic.setVisibility(View.GONE);
        } else {
            holder.pic.setVisibility(View.VISIBLE);
            holder.pic.setAdapter(new Adapter(context, templist));
        }
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }


    class Adapter extends NineGridAdapter {

        public Adapter(Context context, List<Image> list) {
            super(context, list);
        }

        @Override
        public int getCount() {
            return (list == null) ? 0 : list.size();
        }

        @Override
        public String getUrl(int position) {
            return getItem(position) == null ? null : ((Image) getItem(position)).getUrl();
        }

        @Override
        public Object getItem(int position) {
            return (list == null) ? null : list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view) {
            ImageView iv = null;
            if (view != null && view instanceof ImageView) {
                iv = (ImageView) view;
            } else {
                iv = new ImageView(context);
            }
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setBackgroundColor(context.getResources().getColor((android.R.color.transparent)));
            String url = getUrl(i);
            Picasso.with(context).load(getUrl(i)).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(iv);
            if (!TextUtils.isEmpty(url)) {
                iv.setTag(url);
            }
            return iv;
        }
    }
}
