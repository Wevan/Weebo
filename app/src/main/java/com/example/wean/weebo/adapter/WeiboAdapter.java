package com.example.wean.weebo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.Pic_urls;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.gson.User;
import com.example.wean.weebo.utils.EmotionUtils;
import com.example.wean.weebo.utils.Image;
import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;


/**
 * Created by Wean on 2017/7/21.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private Context context;
    private List<Statuses> statuses;
    private List<List<Image>> imagesList;

    private static final String AT = "@[\u4e00-\u9fa5\\w]+";// @人
    private static final String TOPIC = "#[\u4e00-\u9fa5\\w]+#";// ##话题
    private static final String EMOJI = "\\[[\u4e00-\u9fa5\\w]+\\]";// 表情
    private static final String URL = "http://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";// url

    private static final String REGEX="("+AT+")|"+"("+TOPIC+")|"+"("+EMOJI+")|"+"("+URL+")";

    private static String access_token;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView user_icon;
        TextView user_name;
        TextView weibo_time;
        TextView weibo_content;
        Button forward;
        Button comment;
        Button like;
        ImageButton more;
        NineGridlayout pic;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            user_icon = (ImageView) itemView.findViewById(R.id.user_image);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            weibo_time = (TextView) itemView.findViewById(R.id.time_weibo);
            weibo_content = (TextView) itemView.findViewById(R.id.weibo_content);
            forward = (Button) itemView.findViewById(R.id.resend);
            comment = (Button) itemView.findViewById(R.id.comment);
            like = (Button) itemView.findViewById(R.id.like);
            more = (ImageButton) itemView.findViewById(R.id.more_user);
            pic = (NineGridlayout) itemView.findViewById(R.id.iv_ngrid_layout);

        }
    }

    public WeiboAdapter(List<Statuses> mstatuses, List<List<Image>> datalist,String token) {
        access_token=token;
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
        //处理微博内容，@，##，emoji等
        SpannableString contents= SpannableString.valueOf(statuses1.getText().toString());
        contents=getWeiBoContent(context,contents,holder.weibo_content);
        holder.weibo_content.setText(contents);


        User user = statuses1.getUser();
        holder.user_name.setText(user.getScreen_name());
        holder.weibo_time.setText(statuses1.getCreated_at());
        holder.forward.setText(statuses1.getReposts_count());
        holder.comment.setText(statuses1.getComments_count());
        holder.like.setText(statuses1.getAttitudes_count());

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



    /**
     * 继承ClickableSpan复写updateDrawState方法，自定义所需样式
     * @author Rabbit_Lee
     *
     */
    public static class MyClickableSpan extends ClickableSpan {

        @Override
        public void onClick(View widget) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(Color.BLUE);
            ds.setUnderlineText(false);
        }

    }

    /**
     * 设置微博内容样式
     * @param context
     * @param source
     * @param textView
     * @return
     */
    public static SpannableString getWeiBoContent(final Context context, SpannableString source, TextView textView) {
        SpannableString spannableString = new SpannableString(source);

        //设置正则
        Pattern pattern = Pattern.compile(REGEX);
        //设置待测字符串
        Matcher matcher = pattern.matcher(spannableString);

        if (matcher.find()) {
            // 要实现文字的点击效果，这里需要做特殊处理
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            // 重置正则位置
            matcher.reset();
        }

        while (matcher.find()) {
            // 根据group的括号索引，可得出具体匹配哪个正则(0代表全部，1代表第一个括号)
            final String at = matcher.group(1);
            final String topic = matcher.group(2);
            String emoji = matcher.group(3);
            final String url = matcher.group(4);

            // 处理@符号
            if (at != null) {
                //获取匹配位置
                int start = matcher.start(1);
                int end = start + at.length();
                MyClickableSpan clickableSpan = new MyClickableSpan() {

                    @Override
                    public void onClick(View widget) {
                        //这里需要做跳转用户的实现，先用一个Toast代替
                        Toast.makeText(context, "点击了用户：" + at, Toast.LENGTH_LONG).show();
                    }
                };
                clickableSpan.updateDrawState(textView.getPaint());
                spannableString.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            // 处理话题##符号
            if (topic != null) {
                int start = matcher.start(2);
                int end = start + topic.length();
                MyClickableSpan clickableSpan = new MyClickableSpan() {

                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(context, "点击了话题：" + topic, Toast.LENGTH_LONG).show();
                    }
                };
                spannableString.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if (emoji != null) {

                int start = matcher.start(3);
                int end = start + emoji.length();
                EmotionUtils emotionUtils=new EmotionUtils();
                int ResId = emotionUtils.getImgByName(emoji);
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), ResId);
                if (bitmap != null) {
                    // 获取字符的大小
                    int size = (int) textView.getTextSize();
                    // 压缩Bitmap
                    bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
                    // 设置表情
                    ImageSpan imageSpan = new ImageSpan(context, bitmap);
                    spannableString.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


//                int start = matcher.start(3);
//                int end = start + emoji.length();
//                Bitmap bitmap = EmotionUtils.getImgByName(emoji);
//
//
//
//                if (bitmap != null) {
//                    // 获取字符的大小
//                    int size = (int) textView.getTextSize();
//                    // 压缩Bitmap
//                    bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
//                    // 设置表情
//                    ImageSpan imageSpan = new ImageSpan(context, bitmap);
//                    spannableString.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);}
                }
            }

            // 处理url地址
            if (url != null) {
                int start = matcher.start(4);
                int end = start + url.length();
                MyClickableSpan clickableSpan = new MyClickableSpan() {

                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(context, "点击了网址：" + url, Toast.LENGTH_LONG).show();
                    }
                };
                spannableString.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        return spannableString;
    }

}
