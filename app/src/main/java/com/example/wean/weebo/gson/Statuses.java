package com.example.wean.weebo.gson;

import java.util.List;

/**
 * Created by Wean on 2017/7/7.
 */

public class Statuses {
    private String created_at;

    private long id;

    private String mid;

    private String idstr;

    private String text;

    private int source_allowclick;

    private int source_type;

    private String source;

    private boolean favorited;

    private boolean truncated;

    private String in_reply_to_status_id;

    private String in_reply_to_user_id;

    private String in_reply_to_screen_name;

    private List<Pic_urls> pic_urls;

    private Geo geo;

    private User user;

    private Retweeted_status retweeted_status;

    private List<Annotations> annotations;

    private int reposts_count;

    private int comments_count;

    private int attitudes_count;

    private boolean isLongText;

    private int mlevel;

    private Visible visible;

    private long biz_feature;

    private long hasActionTypeCard;

    private List<Darwin_tags> darwin_tags;

    private List<Hot_weibo_tags> hot_weibo_tags;

    private List<Text_tag_tips> text_tag_tips;

    private String rid;

    private int userType;

    private int positive_recom_flag;

    private String gif_ids;

    private int is_show_bulletin;

    private Comment_manage_info comment_manage_info;

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMid() {
        return this.mid;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getIdstr() {
        return this.idstr;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setSource_allowclick(int source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public int getSource_allowclick() {
        return this.source_allowclick;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public int getSource_type() {
        return this.source_type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean getFavorited() {
        return this.favorited;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public boolean getTruncated() {
        return this.truncated;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public String getIn_reply_to_status_id() {
        return this.in_reply_to_status_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_user_id() {
        return this.in_reply_to_user_id;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getIn_reply_to_screen_name() {
        return this.in_reply_to_screen_name;
    }

    public void setPic_urls(List<Pic_urls> pic_urls) {
        this.pic_urls = pic_urls;
    }

    public List<Pic_urls> getPic_urls() {
        return this.pic_urls;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setRetweeted_status(Retweeted_status retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public Retweeted_status getRetweeted_status() {
        return this.retweeted_status;
    }

    public void setAnnotations(List<Annotations> annotations) {
        this.annotations = annotations;
    }

    public List<Annotations> getAnnotations() {
        return this.annotations;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public String getReposts_count() {
        return String.valueOf(this.reposts_count);
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getComments_count() {
        return String.valueOf(this.comments_count);
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getAttitudes_count() {
        return String.valueOf(this.attitudes_count);
    }

    public void setIsLongText(boolean isLongText) {
        this.isLongText = isLongText;
    }

    public boolean getIsLongText() {
        return this.isLongText;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    public int getMlevel() {
        return this.mlevel;
    }

    public void setVisible(Visible visible) {
        this.visible = visible;
    }

    public Visible getVisible() {
        return this.visible;
    }

    public void setBiz_feature(long biz_feature) {
        this.biz_feature = biz_feature;
    }

    public long getBiz_feature() {
        return this.biz_feature;
    }

    public void setHasActionTypeCard(long hasActionTypeCard) {
        this.hasActionTypeCard = hasActionTypeCard;
    }

    public long getHasActionTypeCard() {
        return this.hasActionTypeCard;
    }

    public void setDarwin_tags(List<Darwin_tags> darwin_tags) {
        this.darwin_tags = darwin_tags;
    }

    public List<Darwin_tags> getDarwin_tags() {
        return this.darwin_tags;
    }

    public void setHot_weibo_tags(List<Hot_weibo_tags> hot_weibo_tags) {
        this.hot_weibo_tags = hot_weibo_tags;
    }

    public List<Hot_weibo_tags> getHot_weibo_tags() {
        return this.hot_weibo_tags;
    }

    public void setText_tag_tips(List<Text_tag_tips> text_tag_tips) {
        this.text_tag_tips = text_tag_tips;
    }

    public List<Text_tag_tips> getText_tag_tips() {
        return this.text_tag_tips;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRid() {
        return this.rid;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setPositive_recom_flag(int positive_recom_flag) {
        this.positive_recom_flag = positive_recom_flag;
    }

    public int getPositive_recom_flag() {
        return this.positive_recom_flag;
    }

    public void setGif_ids(String gif_ids) {
        this.gif_ids = gif_ids;
    }

    public String getGif_ids() {
        return this.gif_ids;
    }

    public void setIs_show_bulletin(int is_show_bulletin) {
        this.is_show_bulletin = is_show_bulletin;
    }

    public int getIs_show_bulletin() {
        return this.is_show_bulletin;
    }

    public void setComment_manage_info(Comment_manage_info comment_manage_info) {
        this.comment_manage_info = comment_manage_info;
    }

    public Comment_manage_info getComment_manage_info() {
        return this.comment_manage_info;
    }
}
