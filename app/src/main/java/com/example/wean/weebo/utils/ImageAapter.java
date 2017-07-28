package com.example.wean.weebo.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.wean.weebo.gson.Pic_urls;
import com.squareup.picasso.Picasso;


import java.util.List;

import com.example.wean.weebo.R;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;


/**
 * Created by Wean on 2017/7/27.
 */

public class ImageAapter extends BaseAdapter {
    private Context context;
    private List<List<Image>> datalist;
    private NineGridAdapter adapter;

    public ImageAapter(Context context, List<List<Image>> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        List<Image> itemList = datalist.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.weibo_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.ivMore = (NineGridlayout) convertView.findViewById(R.id.iv_ngrid_layout);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (itemList.isEmpty() || itemList.isEmpty()) {
            viewHolder.ivMore.setVisibility(View.GONE);
        } else {
            viewHolder.ivMore.setVisibility(View.VISIBLE);
            handlerOneImage(viewHolder, itemList);
        }

        return convertView;
    }

    private void handlerOneImage(ViewHolder viewHolder, List<Image> image) {
        adapter = new Adapter(context, image);
        viewHolder.ivMore.setAdapter(adapter);
        viewHolder.ivMore.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
            @Override
            public void onItemClick(View view, int position) {
                //do some thing
                L.d("onItemClick : " + position);
            }
        });
    }


    class ViewHolder {
        public NineGridlayout ivMore;
    }

    class Adapter extends NineGridAdapter {

        public Adapter(Context context, List list) {
            super(context, list);
        }

        @Override
        public int getCount() {
            return (list == null) ? 0 : list.size();
        }

        @Override
        public String getUrl(int position) {
            return getItem(position) == null ? null : ((Image)getItem(position)).getUrl();
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

