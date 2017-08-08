package com.example.wean.weebo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.wean.weebo.Inter.Constants;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.EmotionList;
import com.example.wean.weebo.gson.Emotions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Wean on 2017/8/6.
 */

public class EmotionUtils {


    public static Map<String, Integer> emojiMap;
    static {
        emojiMap = new HashMap<String, Integer>();
        emojiMap.put("[坏笑]", R.drawable.pcmoren_huaixiao_org);
        emojiMap.put("[舔屏]", R.drawable.pcmoren_tian_org);
        emojiMap.put("[污]", R.drawable.pcmoren_wu_org);
        emojiMap.put("[允悲]", R.drawable.moren_yunbei_org);
        emojiMap.put("[笑而不语]", R.drawable.moren_xiaoerbuyu_org);

        emojiMap.put("[费解]", R.drawable.moren_feijie_org);

        emojiMap.put("[憧憬]", R.drawable.moren_chongjing_org);

        emojiMap.put("[并不简单]", R.drawable.moren_bbjdnew_org);

        emojiMap.put("[微笑]", R.drawable.huanglianwx_org);

        emojiMap.put("[嘻嘻]", R.drawable.tootha_org);

        emojiMap.put("[哈哈]", R.drawable.haha_org);

        emojiMap.put("[可爱]", R.drawable.tza_org);

        emojiMap.put("[可怜]", R.drawable.kl_org);

        emojiMap.put("[挖鼻]", R.drawable.wabi_org);

        emojiMap.put("[吃惊]", R.drawable.cj_org);

        emojiMap.put("[害羞]", R.drawable.shamea_org);

        emojiMap.put("[挤眼]", R.drawable.zy_org);

        emojiMap.put("[闭嘴]", R.drawable.bz_org);

        emojiMap.put("[鄙视]", R.drawable.bs2_org);

        emojiMap.put("[爱你]", R.drawable.lovea_org);

        emojiMap.put("[泪]", R.drawable.sada_org);

        emojiMap.put("[偷笑]", R.drawable.heia_org);

        emojiMap.put("[亲亲]", R.drawable.qq_org);

        emojiMap.put("[生病]", R.drawable.sb_org);

        emojiMap.put("[太开心]", R.drawable.mb_org);

        emojiMap.put("[白眼]", R.drawable.landeln_org);

        emojiMap.put("[右哼哼]", R.drawable.yhh_org);

        emojiMap.put("[左哼哼]", R.drawable.zhh_org);

        emojiMap.put("[嘘]", R.drawable.x_org);

//        emojiMap.put("[衰]", R.drawable.cry);

        emojiMap.put("[委屈]", R.drawable.wq_org);

        emojiMap.put("[吐]", R.drawable.t_org);

        emojiMap.put("[哈欠]", R.drawable.haqianv2_org);

        emojiMap.put("[抱抱_旧]", R.drawable.bba_org);

        emojiMap.put("[怒]", R.drawable.angrya_org);

        emojiMap.put("[疑问]", R.drawable.yw_org);

        emojiMap.put("[馋嘴]", R.drawable.cza_org);

        emojiMap.put("[拜拜]", R.drawable.y88_org);

        emojiMap.put("[思考]", R.drawable.sk_org);

        emojiMap.put("[汗]", R.drawable.sweata_org);

        emojiMap.put("[困]", R.drawable.kunv2_org);

        emojiMap.put("[睡]", R.drawable.huangliansj_org);

        emojiMap.put("[钱]", R.drawable.money_org);

        emojiMap.put("[失望]", R.drawable.sw_org);

        emojiMap.put("[酷]", R.drawable.cool_org);

        emojiMap.put("[色]", R.drawable.huanglianse_org);

        emojiMap.put("[哼]", R.drawable.hatea_org);

        emojiMap.put("[鼓掌]", R.drawable.gza_org);

        emojiMap.put("[晕]", R.drawable.dizzya_org);

        emojiMap.put("[悲伤]", R.drawable.bs_org);

        emojiMap.put("[抓狂]", R.drawable.crazya_org);

        emojiMap.put("[黑线]", R.drawable.h_org);

        emojiMap.put("[阴险]", R.drawable.yx_org);

        emojiMap.put("[怒骂]", R.drawable.numav2_org);

        emojiMap.put("[互粉]", R.drawable.hufen_org);

        emojiMap.put("[心]", R.drawable.hearta_org);

//        emojiMap.put("[伤心]", R.drawable.unheart);
//
//        emojiMap.put("[猪头]", R.drawable.pig);

        emojiMap.put("[熊猫]", R.drawable.panda_org);

        emojiMap.put("[兔子]", R.drawable.rabbit_org);

        emojiMap.put("[ok]", R.drawable.ok_org);

        emojiMap.put("[耶]", R.drawable.ye_org);

        emojiMap.put("[good]", R.drawable.good_org);

        emojiMap.put("[NO]", R.drawable.buyao_org);

        emojiMap.put("[赞]", R.drawable.z2_org);

        emojiMap.put("[来]", R.drawable.come_org);

        emojiMap.put("[弱]", R.drawable.sad_org);

        emojiMap.put("[草泥马]", R.drawable.shenshou_org);

        emojiMap.put("[神马]", R.drawable.horse2_org);

        emojiMap.put("[囧]", R.drawable.j_org);

        emojiMap.put("[浮云]", R.drawable.fuyun_org);

        emojiMap.put("[给力]", R.drawable.geiliv2_org);

        emojiMap.put("[围观]", R.drawable.wg_org);

        emojiMap.put("[威武]", R.drawable.vw_org);

        emojiMap.put("[话筒]", R.drawable.huatongv2_org);

        emojiMap.put("[蜡烛]", R.drawable.lazhuv2_org);



        emojiMap.put("[广告]", R.drawable.ad_new0902_org);

        emojiMap.put("[doge]", R.drawable.doge_org);

        emojiMap.put("[喵喵]", R.drawable.mm_org);

        emojiMap.put("[二哈]", R.drawable.moren_hashiqi_org);

        emojiMap.put("[小黄人坏笑]", R.drawable.xiaohuangren_huaixiao_org);

        emojiMap.put("[小黄人剪刀手]", R.drawable.xiaohuangren_jiandaoshou_org);

        emojiMap.put("[小黄人高兴]", R.drawable.xiaohuangren_gaoxing_org);

        emojiMap.put("[哆啦A梦无奈]", R.drawable.dora_wunai_org);

        emojiMap.put("[哆啦A梦开心]", R.drawable.dora_kaixin_org);

        emojiMap.put("[笑cry]", R.drawable.xiaoku_org);

        emojiMap.put("[摊手]", R.drawable.pcmoren_tanshou_org);

        emojiMap.put("[抱抱]", R.drawable.pcmoren_baobao_org);

        emojiMap.put("[红包飞]", R.drawable.hongbao1_org);

        emojiMap.put("[发红包]", R.drawable.fahongbao_org);

//        emojiMap.put("[冰川时代希德奶奶]", R.drawable.bhsj5_nainai_org);
//
//        emojiMap.put("[快银]", R.drawable.xman_kuaiyin_org);
//
//        emojiMap.put("[暴风女]", R.drawable.xman_baofengnv_org);
//
//        emojiMap.put("[芒果流口水]", R.drawable.mango_07_org);
//
//        emojiMap.put("[芒果点赞]", R.drawable.mango_12_org);
//
//        emojiMap.put("[芒果大笑]", R.drawable.mango_02_org);
//
//        emojiMap.put("[芒果得意]", R.drawable.mango_03_org);
//
//        emojiMap.put("[芒果萌萌哒]", R.drawable.mango_11_org);
//
//        emojiMap.put("[羊年大吉]", R.drawable.yangniandj_org);
//
//        emojiMap.put("[老妈我爱你]", R.drawable.mothersday_org);
//
//        emojiMap.put("[母亲节]", R.drawable.carnation_org);
//
//        emojiMap.put("[肥皂]", R.drawable.soap_org);
//
//        emojiMap.put("[有钱]", R.drawable.youqian_org);
//
//        emojiMap.put("[地球一小时]", R.drawable.earth1r_org);
//
//        emojiMap.put("[国旗]", R.drawable.flag_org);
//
//        emojiMap.put("[许愿]", R.drawable.lxhxuyuan_org);
//
//        emojiMap.put("[炸鸡和啤酒]", R.drawable.zhaji_org);
//
//        emojiMap.put("[雪]", R.drawable.snow_org);
//
//        emojiMap.put("[马上有对象]", R.drawable.mashangyouduixiang_org);
//
//        emojiMap.put("[马到成功旧]", R.drawable.madaochenggong_org);
//
//        emojiMap.put("[青啤鸿运当头]", R.drawable.hongyun_org);
//
//        emojiMap.put("[让红包飞]", R.drawable.hongbaofei2014_org);
//
//        emojiMap.put("[ali做鬼脸]", R.drawable.alizuoguiliannew_org);
//
//        emojiMap.put("[ali哇]", R.drawable.aliwanew_org);
//
//        emojiMap.put("[xkl转圈]", R.drawable.xklzhuanquan_org);
//
//        emojiMap.put("[酷库熊顽皮]", R.drawable.kxwanpi_org);
//
//        emojiMap.put("[bm可爱]", R.drawable.bmkeai_org);
//
//        emojiMap.put("[BOBO爱你]", R.drawable.boaini_org);
//
//        emojiMap.put("[转发]", R.drawable.lxhzhuanfa_org);
//
//        emojiMap.put("[得意地笑]", R.drawable.lxhdeyidixiao_org);
//
//        emojiMap.put("[ppb鼓掌]", R.drawable.ppbguzhang_org);
//
//        emojiMap.put("[din推撞]", R.drawable.dintuizhuang_org);
//
//        emojiMap.put("[moc转发]", R.drawable.moczhuanfa_org);

        emojiMap.put("[lt切克闹]", R.drawable.ltqiekenao_org);

        emojiMap.put("[江南style]", R.drawable.gangnamstyle_org);

        emojiMap.put("[笑哈哈]", R.drawable.lxhwahaha_org);

        emojiMap.put("[挤眼]", R.drawable.zy_org);

        emojiMap.put("[亲亲]", R.drawable.qq_org);

        emojiMap.put("[太开心]", R.drawable.mb_org);

        emojiMap.put("[生病]", R.drawable.sb_org);

        emojiMap.put("[书呆子]", R.drawable.sdz_org);

        emojiMap.put("[失望]", R.drawable.sw_org);

        emojiMap.put("[可怜]", R.drawable.kl_org);

        emojiMap.put("[黑线]", R.drawable.h_org);

        emojiMap.put("[吐]", R.drawable.t_org);

        emojiMap.put("[委屈]", R.drawable.wq_org);

        emojiMap.put("[思考]", R.drawable.sk_org);


        emojiMap.put("[嘘]", R.drawable.x_org);

        emojiMap.put("[右哼哼]", R.drawable.yhh_org);

        emojiMap.put("[左哼哼]", R.drawable.zhh_org);

        emojiMap.put("[疑问]", R.drawable.yw_org);

        emojiMap.put("[阴险]", R.drawable.yx_org);

        emojiMap.put("[顶]", R.drawable.d_org);

        emojiMap.put("[钱]", R.drawable.money_org);

        emojiMap.put("[悲伤]", R.drawable.bs_org);

        emojiMap.put("[鄙视]", R.drawable.bs2_org);

        emojiMap.put("[吃惊]", R.drawable.cj_org);

        emojiMap.put("[闭嘴]", R.drawable.bz_org);

        emojiMap.put("[愤怒]", R.drawable.fn_org);

        emojiMap.put("[感冒]", R.drawable.gm_org);

        emojiMap.put("[酷]", R.drawable.cool_org);

        emojiMap.put("[来]", R.drawable.come_org);

        emojiMap.put("[good]", R.drawable.good_org);

        emojiMap.put("[haha]", R.drawable.ha_org);

        emojiMap.put("[ok]", R.drawable.ok_org);

        emojiMap.put("[拳头]", R.drawable.o_org);

        emojiMap.put("[弱]", R.drawable.sad_org);

        emojiMap.put("[握手]", R.drawable.ws_org);

        emojiMap.put("[赞]", R.drawable.z2_org);

        emojiMap.put("[耶]", R.drawable.ye_org);

        emojiMap.put("[最差]", R.drawable.bad_org);

        emojiMap.put("[NO]", R.drawable.buyao_org);

        emojiMap.put("[怒骂]", R.drawable.numav2_org);

        emojiMap.put("[困]", R.drawable.kunv2_org);

        emojiMap.put("[哈欠]", R.drawable.haqianv2_org);

        emojiMap.put("[微笑]", R.drawable.huanglianwx_org);

        emojiMap.put("[白眼]", R.drawable.landeln_org);

        emojiMap.put("[睡]", R.drawable.huangliansj_org);

        emojiMap.put("[色]", R.drawable.huanglianse_org);

        emojiMap.put("[挖鼻]", R.drawable.wabi_org);

        emojiMap.put("[傻眼]", R.drawable.shayan_org);

        emojiMap.put("[打脸]", R.drawable.dalian_org);

        emojiMap.put("[作揖]", R.drawable.zuoyi_org);

        emojiMap.put("[笑cry]", R.drawable.xiaoku_org);

        emojiMap.put("[可爱]", R.drawable.tza_org);

        emojiMap.put("[嘻嘻]", R.drawable.tootha_org);

        emojiMap.put("[汗]", R.drawable.sweata_org);

        emojiMap.put("[害羞]", R.drawable.shamea_org);

        emojiMap.put("[泪]", R.drawable.sada_org);

        emojiMap.put("[爱你]", R.drawable.lovea_org);

        emojiMap.put("[偷笑]", R.drawable.heia_org);

        emojiMap.put("[心]", R.drawable.hearta_org);

        emojiMap.put("[哼]", R.drawable.hatea_org);

        emojiMap.put("[鼓掌]", R.drawable.gza_org);

        emojiMap.put("[晕]", R.drawable.dizzya_org);

        emojiMap.put("[馋嘴]", R.drawable.cza_org);

        emojiMap.put("[抓狂]", R.drawable.crazya_org);

        emojiMap.put("[抱抱_旧]", R.drawable.bba_org);

        emojiMap.put("[怒]", R.drawable.angrya_org);

        emojiMap.put("[右抱抱]", R.drawable.right_org);

        emojiMap.put("[左抱抱]", R.drawable.left_org);

        emojiMap.put("[哆啦A梦花心]", R.drawable.dorahaose_org);

        emojiMap.put("[哆啦A梦害怕]", R.drawable.dorahaipa_org);

        emojiMap.put("[哆啦A梦吃惊]", R.drawable.dorachijing_org);

        emojiMap.put("[哆啦A梦汗]", R.drawable.dorahan_org);

        emojiMap.put("[哆啦A梦微笑]", R.drawable.jqmweixiao_org);

        emojiMap.put("[伴我同行]", R.drawable.jqmbwtxing_org);

        emojiMap.put("[静香微笑]", R.drawable.jiqimaojingxiang_org);

        emojiMap.put("[大雄微笑]", R.drawable.jiqimaodaxiong_org);

        emojiMap.put("[胖虎微笑]", R.drawable.jiqimaopanghu_org);

        emojiMap.put("[小夫微笑]", R.drawable.jiqimaoxiaofu_org);

        emojiMap.put("[哆啦A梦无奈]", R.drawable.dora_wunai_org);

        emojiMap.put("[哆啦A梦笑]", R.drawable.dora_xiao_org);

        emojiMap.put("[哆啦A梦亲亲]", R.drawable.dora_qinqin_org);

        emojiMap.put("[哆啦A梦美味]", R.drawable.dora_meiwei_org);

        emojiMap.put("[哆啦A梦开心]", R.drawable.dora_kaixin_org);

        emojiMap.put("[小黄人无奈]", R.drawable.xiaohuangren_wunai_org);

        emojiMap.put("[小黄人委屈]", R.drawable.xiaohuangren_weiqu_org);

        emojiMap.put("[小黄人惊讶]", R.drawable.xiaohuangren_jingya_org);

        emojiMap.put("[小黄人剪刀手]", R.drawable.xiaohuangren_jiandaoshou_org);

        emojiMap.put("[小黄人坏笑]", R.drawable.xiaohuangren_huaixiao_org);

        emojiMap.put("[小黄人高兴]", R.drawable.xiaohuangren_gaoxing_org);

        emojiMap.put("[小黄人得意]", R.drawable.xiaohuangren_deyi_org);

        emojiMap.put("[小黄人不屑]", R.drawable.xiaohuangren_buxie_org);

        emojiMap.put("[小黄人白眼]", R.drawable.xiaohuangren_baiyan_org);

//        emojiMap.put("[bm做操]", R.drawable.bmzuocao_org);
//
//        emojiMap.put("[bm抓狂]", R.drawable.bmzhuakuang_org);
//
//        emojiMap.put("[bm中枪]", R.drawable.bmzhongqiang_org);
//
//        emojiMap.put("[bm震惊]", R.drawable.bmzhenjing_org);
//
//        emojiMap.put("[bm赞]", R.drawable.bmzan_org);
//
//        emojiMap.put("[bm喜悦]", R.drawable.bmxiyue_org);
//
//        emojiMap.put("[bm醒悟]", R.drawable.bmxingwu_org);
//
//        emojiMap.put("[bm兴奋]", R.drawable.bmxingfen_org);
//
//        emojiMap.put("[bm血泪]", R.drawable.bmxielei_org);
//
//        emojiMap.put("[bm挖鼻孔]", R.drawable.bmwabikong_org);
//
//        emojiMap.put("[bm吐舌头]", R.drawable.bmtushetou_org);
//
//        emojiMap.put("[bm吐槽]", R.drawable.bmtucao_org);
//
//        emojiMap.put("[bm投诉]", R.drawable.bmtousu_org);
//
//        emojiMap.put("[bm跳绳]", R.drawable.bmtiaosheng_org);
//
//        emojiMap.put("[bm调皮]", R.drawable.bmtiaopi_org);
//
//        emojiMap.put("[bm讨论]", R.drawable.bmtaolun_org);
//
//        emojiMap.put("[bm抬腿]", R.drawable.bmtaitui_org);
//
//        emojiMap.put("[bm思考]", R.drawable.bmsikao_org);
//
//        emojiMap.put("[bm生气]", R.drawable.bmshengqi_org);
//
//        emojiMap.put("[bm亲吻]", R.drawable.bmqinwen_org);
//
//        emojiMap.put("[bm庆幸]", R.drawable.bmqingxing_org);
//
//        emojiMap.put("[bm内涵]", R.drawable.bmneihan_org);
//
//        emojiMap.put("[bm忙碌]", R.drawable.bmmanglu_org);
//
//        emojiMap.put("[bm乱入]", R.drawable.bmluanru_org);
//
//        emojiMap.put("[bm卖萌]", R.drawable.bmluanmeng_org);
//
//        emojiMap.put("[bm流泪]", R.drawable.bmliulei_org);
//
//        emojiMap.put("[bm流口水]", R.drawable.bmliukoushui_org);
//
//        emojiMap.put("[bm流鼻涕]", R.drawable.bmliubiti_org);
//
//        emojiMap.put("[bm路过]", R.drawable.bmliguo_org);
//
//        emojiMap.put("[bm咧嘴]", R.drawable.bmliezui_org);
//
//        emojiMap.put("[bm啦啦队]", R.drawable.bmlaladui_org);
//
//        emojiMap.put("[bm哭诉]", R.drawable.bmkusu_org);
//
//        emojiMap.put("[bm哭泣]", R.drawable.bmkuqi_org);
//
//        emojiMap.put("[bm苦逼]", R.drawable.bmkubi_org);
//
//        emojiMap.put("[bm口哨]", R.drawable.bmkoushao_org);
//
//        emojiMap.put("[bm可爱]", R.drawable.bmkeai_org);
//
//        emojiMap.put("[bm紧张]", R.drawable.bmjinzhang_org);
//
//        emojiMap.put("[bm惊讶]", R.drawable.bmjingya_org);
//
//        emojiMap.put("[bm惊吓]", R.drawable.bmjingxia_org);
//
//        emojiMap.put("[bm焦虑]", R.drawable.bmjiaolv_org);
//
//        emojiMap.put("[bm会心笑]", R.drawable.bmhuixinxiao_org);
//
//        emojiMap.put("[bm坏笑]", R.drawable.bmhuaixiao_org);
//
//        emojiMap.put("[bm花痴]", R.drawable.bmhuachi_org);
//
//        emojiMap.put("[bm厚脸皮]", R.drawable.bmhoulianpi_org);
//
//        emojiMap.put("[bm好吧]", R.drawable.bmhaoba_org);
//
//        emojiMap.put("[bm害怕]", R.drawable.bmhaipa_org);
//
//        emojiMap.put("[bm鬼脸]", R.drawable.bmguilian_org);
//
//        emojiMap.put("[bm孤独]", R.drawable.bmgudu_org);
//
//        emojiMap.put("[bm高兴]", R.drawable.bmgaoxing_org);
//
//        emojiMap.put("[bm搞怪]", R.drawable.bmgaoguai_org);
//
//        emojiMap.put("[bm干笑]", R.drawable.bmganxiao_org);
//
//        emojiMap.put("[bm感动]", R.drawable.bmgandong_org);
//
//        emojiMap.put("[bm愤懑]", R.drawable.bmfenmen_org);
//
//        emojiMap.put("[bm反对]", R.drawable.bmfandui_org);
//
//        emojiMap.put("[bm踱步]", R.drawable.bmduobu_org);
//
//        emojiMap.put("[bm顶]", R.drawable.bmding_org);
//
//        emojiMap.put("[bm得意]", R.drawable.bmdeyi_org);
//
//        emojiMap.put("[bm得瑟]", R.drawable.bmdese_org);
//
//        emojiMap.put("[bm大笑]", R.drawable.bmdaxiao_org);
//
//        emojiMap.put("[bm大哭]", R.drawable.bmdaku_org);
//
//        emojiMap.put("[bm大叫]", R.drawable.bmdajiao_org);
//
//        emojiMap.put("[bm吃惊]", R.drawable.bmchijing_org);
//
//        emojiMap.put("[bm馋]", R.drawable.bmchan_org);
//
//        emojiMap.put("[bm彩色]", R.drawable.bmcaise_org);
//
//        emojiMap.put("[bm缤纷]", R.drawable.bmbinfen_org);
//
//        emojiMap.put("[bm变身]", R.drawable.bmbianshen_org);
//
//        emojiMap.put("[bm悲催]", R.drawable.bmbeicui_org);
//
//        emojiMap.put("[bm暴怒]", R.drawable.bmbaonu_org);
//
//        emojiMap.put("[bm熬夜]", R.drawable.bmaoye_org);
//
//        emojiMap.put("[bm暗爽]", R.drawable.bmanshuang_org);
//
//        emojiMap.put("[xkl拜年]", R.drawable.xklbainian_org);
//
//        emojiMap.put("[xkl恭喜]", R.drawable.xklgongxi_org);
//
//        emojiMap.put("[xkl发财]", R.drawable.xklfacai_org);
//
//        emojiMap.put("[xkl鞭炮]", R.drawable.xklbianpao_org);
//
//        emojiMap.put("[xkl下雪]", R.drawable.xklxiaxue_org);
//
//        emojiMap.put("[xkl撒花]", R.drawable.xklsahua_org);
//
//        emojiMap.put("[xkl扔糖豆]", R.drawable.xklrengtangdou_org);
//
//        emojiMap.put("[xkl扭]", R.drawable.xklniu_org);
//
//        emojiMap.put("[xkl你拍一]", R.drawable.xklnipaiyi_org);
//
//        emojiMap.put("[xkl打岔]", R.drawable.xkldacha_org);
//
//        emojiMap.put("[dada搬糖豆]", R.drawable.xklbanyun2_org);
//
//        emojiMap.put("[xkl搬糖豆]", R.drawable.xklbanyun1_org);
//
//        emojiMap.put("[dada转圈]", R.drawable.dadazhuanquan_org);
//
//        emojiMap.put("[dada秧歌]", R.drawable.dadayangge_org);
//
//        emojiMap.put("[dada提灯笼]", R.drawable.dadadenglong_org);
//
//        emojiMap.put("[xkl追]", R.drawable.xklzhui_org);
//
//        emojiMap.put("[xkl拥抱]", R.drawable.xklyongbao_org);
//
//        emojiMap.put("[xkl亲亲]", R.drawable.xklqinqin_org);
//
//        emojiMap.put("[xkl困]", R.drawable.xklkun_org);
//
//        emojiMap.put("[xkl达达喜欢]", R.drawable.xkldadaxihuan_org);
//
//        emojiMap.put("[xkl达达吐舌头]", R.drawable.xkldadatushetou_org);
//
//        emojiMap.put("[xkl达达坏笑]", R.drawable.xkldadahuaixiao_org);
//
//        emojiMap.put("[xkl达达黑暗]", R.drawable.xkldadaheian_org);
//
//        emojiMap.put("[xkl吃西瓜]", R.drawable.xklchixigua_org);
//
//        emojiMap.put("[kxl晕]", R.drawable.kxlyun_org);
//
//        emojiMap.put("[xkl抓狂]", R.drawable.xklzhuakuang_org);
//
//        emojiMap.put("[xkl眨眼]", R.drawable.xklzhayan_org);
//
//        emojiMap.put("[xkl摇尾巴]", R.drawable.xklyaoweiba_org);
//
//        emojiMap.put("[xkl偷看]", R.drawable.xkltoukan_org);
//
//        emojiMap.put("[xkl糖豆]", R.drawable.xkltangdou_org);
//
//        emojiMap.put("[xkl囧]", R.drawable.xkljiong_org);
//
//        emojiMap.put("[xkl抚摸]", R.drawable.xklfumo_org);
//
//        emojiMap.put("[xkl奔跑]", R.drawable.xklbenpao_org);
//
//        emojiMap.put("[xkl被抓]", R.drawable.xklbeizhua_org);
//
//        emojiMap.put("[xkl被电]", R.drawable.xklbeidian_org);
//
//        emojiMap.put("[xkl怒火]", R.drawable.xlknuhuo_org);
//
//        emojiMap.put("[xkl转圈]", R.drawable.xklzhuanquan_org);
//
//        emojiMap.put("[xkl喜]", R.drawable.xklxi_org);
//
//        emojiMap.put("[xkl委屈]", R.drawable.xklweiqu_org);
//
//        emojiMap.put("[xkl石化]", R.drawable.xklshihua_org);
//
//        emojiMap.put("[xkl期待]", R.drawable.xklqidai_org);
//
//        emojiMap.put("[xkl捏脸]", R.drawable.xklnielian_org);
//
//        emojiMap.put("[xkl路过]", R.drawable.xklluguo_org);
//
//        emojiMap.put("[xkl哈哈哈]", R.drawable.xklhahaha_org);
//
//        emojiMap.put("[xkl顶]", R.drawable.xklding_org);
//
//        emojiMap.put("[lt火车票]", R.drawable.lttickets_org);
//
//        emojiMap.put("[lt五一]", R.drawable.ltwuyi_org);

        emojiMap.put("[lt新年好]", R.drawable.ltxinnianhao_org);

        emojiMap.put("[lt火车]", R.drawable.lttrain_org);

        emojiMap.put("[lt红包]", R.drawable.lthongbao_org);

        emojiMap.put("[lt摇滚]", R.drawable.ltrock_org);

        emojiMap.put("[lt万圣节]", R.drawable.lthalloween_org);

        emojiMap.put("[lt赞]", R.drawable.ltgood_org);

        emojiMap.put("[lt江南style]", R.drawable.ltgangnamstyle_org);

        emojiMap.put("[lt吃东西]", R.drawable.lteating_org);

        emojiMap.put("[lt最右]", R.drawable.ltzuiyou_org);

        emojiMap.put("[lt切克闹]", R.drawable.ltqiekenao_org);

        emojiMap.put("[lt犯困]", R.drawable.ltfankun_org);

        emojiMap.put("[lt戳瞎]", R.drawable.ltchuoxia_org);

        emojiMap.put("[lt鼻血]", R.drawable.ltbixue_org);

        emojiMap.put("[lt阴险]", R.drawable.ltyinxian_org);

        emojiMap.put("[lt摇摆]", R.drawable.ltyaobai_org);

        emojiMap.put("[lt羞]", R.drawable.ltxiu_org);

        emojiMap.put("[lt闪瞎]", R.drawable.ltshanxia_org);

        emojiMap.put("[lt拍手]", R.drawable.ltpaishou_org);

        emojiMap.put("[lt蛋疼]", R.drawable.ltdanteng_org);

        emojiMap.put("[lt撒花]", R.drawable.ltsahua_org);

        emojiMap.put("[lt母亲节]", R.drawable.ltmuqinjie_org);

        emojiMap.put("[lt挖鼻]", R.drawable.ltwabi_org);

        emojiMap.put("[lt哈欠]", R.drawable.lehaqian_org);

        emojiMap.put("[lt泪目]", R.drawable.ltleimu_org);

        emojiMap.put("[lt雷]", R.drawable.ltlei_org);

        emojiMap.put("[lt中枪]", R.drawable.ltzhongqiang_org);

        emojiMap.put("[lt耳朵]", R.drawable.lterduo_org);

        emojiMap.put("[lt顶]", R.drawable.ltding_org);

        emojiMap.put("[lt潜水]", R.drawable.ltqianshui_org);

        emojiMap.put("[lt拍桌大笑]", R.drawable.ltpaizhuodaxiao_org);

        emojiMap.put("[lt黑线]", R.drawable.ltheixian_org);

        emojiMap.put("[lt喷血]", R.drawable.ltpenxue_org);

        emojiMap.put("[lt巨汗]", R.drawable.ltjuhan_org);

        emojiMap.put("[lt疑惑]", R.drawable.ltyihuo_org);

        emojiMap.put("[lt浮云]", R.drawable.ltfuyun_org);

        emojiMap.put("[lt笑话]", R.drawable.ltxiaohua_org);

        emojiMap.put("[lt喷]", R.drawable.ltpen_org);

        emojiMap.put("[lt雪]", R.drawable.ltxue_org);

        emojiMap.put("[lt转发]", R.drawable.ltzhuanfa_org);

        emojiMap.put("[lt偷窥]", R.drawable.lttoukui_org);

        emojiMap.put("[lt惊吓]", R.drawable.ltjingxia_org);

        emojiMap.put("[lt囧]", R.drawable.ltjiong_org);

        emojiMap.put("[lt灰飞烟灭]", R.drawable.lthuifeiyanmie_org);

        emojiMap.put("[lt冰封]", R.drawable.ltbengfeng_org);

        emojiMap.put("[lt吐]", R.drawable.lttu_org);

        emojiMap.put("[lt吹泡泡]", R.drawable.ltchuipaopao_org);

        emojiMap.put("[lt吓]", R.drawable.ltxia_org);

        emojiMap.put("[芒果点赞]", R.drawable.mango_12_org);

        emojiMap.put("[芒果萌萌哒]", R.drawable.mango_11_org);

        emojiMap.put("[芒果舔屏]", R.drawable.mango_10_org);

        emojiMap.put("[芒果帅炸了]", R.drawable.mango_09_org);

        emojiMap.put("[芒果魔性]", R.drawable.mango_08_org);

        emojiMap.put("[芒果流口水]", R.drawable.mango_07_org);

        emojiMap.put("[芒果可怜]", R.drawable.mango_06_org);

        emojiMap.put("[芒果惊讶]", R.drawable.mango_05_org);

        emojiMap.put("[芒果红包脸]", R.drawable.mango_04_org);

        emojiMap.put("[芒果得意]", R.drawable.mango_03_org);

        emojiMap.put("[芒果大笑]", R.drawable.mango_02_org);

        emojiMap.put("[芒果霸屏]", R.drawable.mango_01_org);

        emojiMap.put("[粉丝俱乐部]", R.drawable.fansclub_org);

        emojiMap.put("[应援]", R.drawable.fansyingyuan_org);

        emojiMap.put("[TF]", R.drawable.tffans_org);

        emojiMap.put("[凯]", R.drawable.tfkai_org);

        emojiMap.put("[源]", R.drawable.tfyuan_org);

        emojiMap.put("[千]", R.drawable.tfqian_org);

        emojiMap.put("[t]", R.drawable.newt_org);

        emojiMap.put("[f]", R.drawable.newf_org);

        emojiMap.put("[b]", R.drawable.weibob_org);

        emojiMap.put("[o]", R.drawable.weiboo_org);

        emojiMap.put("[y]", R.drawable.newy_org);

        emojiMap.put("[s]", R.drawable.news_org);

        emojiMap.put("[din看看]", R.drawable.dinkankan_org);

        emojiMap.put("[din说话]", R.drawable.dinshuohua_org);

        emojiMap.put("[din癫当圣诞礼物]", R.drawable.dindongshengdanliwu_org);

        emojiMap.put("[din阿赞招财猫]", R.drawable.dinjenzhaocaimao_org);

        emojiMap.put("[din阿赞福到]", R.drawable.dinjenfudao_org);

        emojiMap.put("[din癫当招财猫]", R.drawable.dindongzhaocaimao_org);

        emojiMap.put("[din癫当xmas]", R.drawable.dindongxmas_org);

        emojiMap.put("[din癫当圣诞树]", R.drawable.dindongshengdanshu_org);

        emojiMap.put("[din癫当阿赞圣诞奔]", R.drawable.dindongjenshengdanben_org);

        emojiMap.put("[din癫当阿赞炮竹]", R.drawable.dindongjenpaozhu_org);

        emojiMap.put("[din癫当阿赞礼物盒]", R.drawable.dindongjenliwuhe_org);

        emojiMap.put("[din癫当阿赞礼物]", R.drawable.dindongjenliwu_org);

        emojiMap.put("[din癫当阿赞变身]", R.drawable.dindongjenbianshen_org);

        emojiMap.put("[din癫当红包]", R.drawable.dindonghongbao_org);

        emojiMap.put("[din癫当财神]", R.drawable.dindongcaishen_org);

        emojiMap.put("[din转转]", R.drawable.dinzhuanzhuan_org);

        emojiMap.put("[din撞墙]", R.drawable.dinzhuangqiang_org);

        emojiMap.put("[din抓狂]", R.drawable.dinzhuakuang_org);

        emojiMap.put("[din赞好]", R.drawable.dinzanhao_org);

        emojiMap.put("[din信息]", R.drawable.dinxinxi_org);

        emojiMap.put("[din兴奋]", R.drawable.dinxingfen_org);

        emojiMap.put("[din推撞]", R.drawable.dintuizhuang_org);

        emojiMap.put("[din天哦]", R.drawable.dintiano_org);

        emojiMap.put("[din弹弹]", R.drawable.dintantan_org);

        emojiMap.put("[din睡觉]", R.drawable.dinshuijiao_org);

        emojiMap.put("[din帅]", R.drawable.dinshuai_org);

        emojiMap.put("[din闪避]", R.drawable.dinshanbi_org);

        emojiMap.put("[din亲亲]", R.drawable.dinqinqin_org);

        emojiMap.put("[din拍手]", R.drawable.dinpaishou_org);

        emojiMap.put("[din怒]", R.drawable.dinnu_org);

        emojiMap.put("[din摸头]", R.drawable.dinmotou_org);

        emojiMap.put("[din流血]", R.drawable.dinliuxue_org);

        emojiMap.put("[din厉害]", R.drawable.dinlihai_org);

        emojiMap.put("[din脸红]", R.drawable.dinlianhong_org);

        emojiMap.put("[din泪]", R.drawable.dinlei_org);

        emojiMap.put("[din贱香]", R.drawable.dinjianxiang_org);

        emojiMap.put("[din挥手]", R.drawable.dinhuishou_org);

        emojiMap.put("[din化妆]", R.drawable.dinhuazhuang_org);

        emojiMap.put("[din喝]", R.drawable.dinhe_org);

        emojiMap.put("[din汗]", R.drawable.dinhan_org);

        emojiMap.put("[din害羞]", R.drawable.dinhaixiu_org);

        emojiMap.put("[din鬼脸]", R.drawable.dinguilian_org);

        emojiMap.put("[din挂了]", R.drawable.dinguale_org);

        emojiMap.put("[din分身1]", R.drawable.dinfenshenb_org);

        emojiMap.put("[din分身2]", R.drawable.dinfenshena_org);

        emojiMap.put("[din癫当]", R.drawable.dindiandang_org);

        emojiMap.put("[din戴熊]", R.drawable.dindaixiong_org);

        emojiMap.put("[din吃]", R.drawable.dinchi_org);

        emojiMap.put("[din变身]", R.drawable.dinbianshen_org);

        emojiMap.put("[din变脸]", R.drawable.dinbianlian_org);

        emojiMap.put("[din白旗]", R.drawable.dinbaiqi_org);

        emojiMap.put("[din爱你]", R.drawable.dinaini_org);

        emojiMap.put("[ali微博益起来]", R.drawable.aligongyi_org);

        emojiMap.put("[ali皇冠]", R.drawable.newalidese_org);

        emojiMap.put("[ali做鬼脸]", R.drawable.alizuoguiliannew_org);

        emojiMap.put("[ali追]", R.drawable.alizhuinew_org);

        emojiMap.put("[ali转圈哭]", R.drawable.alizhuanquankunew_org);

        emojiMap.put("[ali转]", R.drawable.alizhuannew_org);

        emojiMap.put("[ali郁闷]", R.drawable.aliyumengnew_org);

        emojiMap.put("[ali元宝]", R.drawable.aliyuanbaonew_org);

        emojiMap.put("[ali摇晃]", R.drawable.aliyaohuangnew_org);

        emojiMap.put("[ali嘘嘘嘘]", R.drawable.alixuxunew_org);

        emojiMap.put("[ali羞]", R.drawable.alixiunew_org);

        emojiMap.put("[ali笑死了]", R.drawable.alixiaosilenew_org);

        emojiMap.put("[ali笑]", R.drawable.alixiaonew_org);

        emojiMap.put("[ali掀桌子]", R.drawable.alixianzhuozinew_org);

        emojiMap.put("[ali鲜花]", R.drawable.alixianhuanew_org);

        emojiMap.put("[ali想]", R.drawable.alixiangnew_org);

        emojiMap.put("[ali吓]", R.drawable.alixianew_org);

        emojiMap.put("[ali哇]", R.drawable.aliwanew_org);

        emojiMap.put("[ali吐血]", R.drawable.alituxuenew_org);

        emojiMap.put("[ali偷看]", R.drawable.alitoukannew_org);

        emojiMap.put("[ali送礼物]", R.drawable.alisongliwunew_org);

        emojiMap.put("[ali睡]", R.drawable.alishuinew_org);

        emojiMap.put("[ali甩手]", R.drawable.alishuaishounew_org);

        emojiMap.put("[ali摔]", R.drawable.alishuainew_org);

        emojiMap.put("[ali撒钱]", R.drawable.alisaqiannew_org);

        emojiMap.put("[ali揪]", R.drawable.aliqiunew_org);

        emojiMap.put("[ali亲一个]", R.drawable.aliqinyigenew_org);

        emojiMap.put("[ali欠揍]", R.drawable.aliqianzounew_org);

        emojiMap.put("[ali扑]", R.drawable.alipunew_org);

        emojiMap.put("[ali扑倒]", R.drawable.alipudaonew_org);

        emojiMap.put("[ali飘]", R.drawable.alipiaonew_org);

        emojiMap.put("[ali飘过]", R.drawable.alipiaoguonew_org);

        emojiMap.put("[ali喷嚏]", R.drawable.alipengtinew_org);

        emojiMap.put("[ali拍拍手]", R.drawable.alipaipaishounew_org);

        emojiMap.put("[ali你]", R.drawable.alininew_org);

        emojiMap.put("[ali挠墙]", R.drawable.alinaoqiangnew_org);

        emojiMap.put("[ali摸摸头]", R.drawable.alimomotounew_org);

        emojiMap.put("[ali溜]", R.drawable.aliliunew_org);

        emojiMap.put("[ali赖皮]", R.drawable.alilaipinew_org);

        emojiMap.put("[ali来吧]", R.drawable.alilaibanew_org);

        emojiMap.put("[ali囧]", R.drawable.alijiongnew_org);

        emojiMap.put("[ali惊]", R.drawable.alijingnew_org);

        emojiMap.put("[ali加油]", R.drawable.alijiayounew_org);

        emojiMap.put("[ali僵尸跳]", R.drawable.alijiangshitiaonew_org);

        emojiMap.put("[ali呼啦圈]", R.drawable.alihulaquannew_org);

        emojiMap.put("[ali画圈圈]", R.drawable.alihuaquanquannew_org);

        emojiMap.put("[ali欢呼]", R.drawable.alihuanhunew_org);

        emojiMap.put("[ali坏笑]", R.drawable.alihuaixiaonew_org);

        emojiMap.put("[ali跪求]", R.drawable.aliguiqiunew_org);

        emojiMap.put("[ali风筝]", R.drawable.alifengzhengnew_org);

        emojiMap.put("[ali飞]", R.drawable.alifeinew_org);

        emojiMap.put("[ali翻白眼]", R.drawable.alifanbaiyannew_org);

        emojiMap.put("[ali顶起]", R.drawable.alidingqinew_org);

        emojiMap.put("[ali点头]", R.drawable.alidiantounew_org);

        emojiMap.put("[ali得瑟]", R.drawable.alidesenew_org);

        emojiMap.put("[ali打篮球]", R.drawable.alidalanqiunew_org);

        emojiMap.put("[ali打滚]", R.drawable.alidagunnew_org);

        emojiMap.put("[ali大吃]", R.drawable.alidachinew_org);

        emojiMap.put("[ali踩]", R.drawable.alicainew_org);

        emojiMap.put("[ali不耐烦]", R.drawable.alibunaifannew_org);

        emojiMap.put("[ali不吗]", R.drawable.alibumanew_org);

        emojiMap.put("[alibiechaonew]", R.drawable.alibiechaonew_org);

        emojiMap.put("[ali鞭炮]", R.drawable.alibianpaonew_org);

        emojiMap.put("[ali抱一抱]", R.drawable.alibaoyibaonew_org);

        emojiMap.put("[ali拜年]", R.drawable.alibainiannew_org);

        emojiMap.put("[ali88]", R.drawable.ali88new_org);

        emojiMap.put("[ali狂笑]", R.drawable.zk_org);

        emojiMap.put("[ali冤]", R.drawable.wq2_org);

        emojiMap.put("[ali蜷]", R.drawable.q2_org);

        emojiMap.put("[ali美好]", R.drawable.mh_org);

        emojiMap.put("[ali乐和]", R.drawable.m2_org);

        emojiMap.put("[ali揪耳朵]", R.drawable.j3_org);

        emojiMap.put("[ali晃]", R.drawable.h2_org);

        emojiMap.put("[aliigh]", R.drawable.f_org);

        emojiMap.put("[ali蹭]", R.drawable.c_org);

        emojiMap.put("[ali抱枕]", R.drawable.bz3_org);

        emojiMap.put("[ali不公平]", R.drawable.bgp_org);

        emojiMap.put("[BOBO害羞]", R.drawable.bohaixiu_org);

        emojiMap.put("[BOBO哈哈]", R.drawable.bohaha_org);

        emojiMap.put("[BOBO吃面]", R.drawable.bochimian_org);

        emojiMap.put("[BOBO擦泪]", R.drawable.bocalei_org);

        emojiMap.put("[bobuyaoa]", R.drawable.bobuyaoa_org);

        emojiMap.put("[BOBO变身]", R.drawable.bobianshen_org);

        emojiMap.put("[BOBO崩溃]", R.drawable.bobengkui_org);

        emojiMap.put("[BOBO拜]", R.drawable.bobai_org);

        emojiMap.put("[BOBO爱你]", R.drawable.boaini_org);

        emojiMap.put("[TOTO打我啊]", R.drawable.todawoa_org);

        emojiMap.put("[toto拜年]", R.drawable.longniantoto_org);

        emojiMap.put("[bobo拜年]", R.drawable.bobolongnian_org);

        emojiMap.put("[toto无聊]", R.drawable.totowuliao_org);

        emojiMap.put("[toto我最摇滚]", R.drawable.totowozuiyaogun_org);

        emojiMap.put("[toto数落]", R.drawable.totoshuluo_org);

        emojiMap.put("[toto睡觉]", R.drawable.totoshuijiao_org);

        emojiMap.put("[toto甩头发]", R.drawable.totoshuaitoufa_org);

        emojiMap.put("[toto飘过]", R.drawable.totopiaoguo_org);

        emojiMap.put("[toto狂汗]", R.drawable.totokuanghan_org);

        emojiMap.put("[toto好累]", R.drawable.totohaolei_org);

        emojiMap.put("[bobo抓狂]", R.drawable.bobozhuakuang_org);

        emojiMap.put("[bobo疑问]", R.drawable.boboyiwen_org);

        emojiMap.put("[bobo抛媚眼]", R.drawable.bobopaomeiyan_org);

        emojiMap.put("[bobo膜拜]", R.drawable.bobomobai_org);

        emojiMap.put("[bobo纠结]", R.drawable.bobojiujie_org);

        emojiMap.put("[bobo不要啊]", R.drawable.bobobuyaoa_org);

        emojiMap.put("[bobo不理你]", R.drawable.bobobulini_org);

        emojiMap.put("[有爱]", R.drawable.totoyouai_org);

        emojiMap.put("[TOTOYES]", R.drawable.totoyes_org);

        emojiMap.put("[我爱听]", R.drawable.tototingge_org);

        emojiMap.put("[怒火]", R.drawable.totonu_org);

        emojiMap.put("[擂鼓]", R.drawable.totoleigu_org);

        emojiMap.put("[讥笑]", R.drawable.totojixiao_org);

        emojiMap.put("[抛钱]", R.drawable.totoheixianpaoqian_org);

        emojiMap.put("[变花]", R.drawable.boboxianhua_org);

        emojiMap.put("[飙泪]", R.drawable.boboweiqu_org);

        emojiMap.put("[藏猫猫]", R.drawable.bobotoukan_org);

        emojiMap.put("[淘气]", R.drawable.bobotiaopi_org);

        emojiMap.put("[生闷气]", R.drawable.boboshengmenqi_org);

        emojiMap.put("[忍]", R.drawable.boboren_org);

        emojiMap.put("[泡泡糖]", R.drawable.bobopaopaotang_org);

        emojiMap.put("[BOBO赞]", R.drawable.bobook_org);

        emojiMap.put("[Hi]", R.drawable.bobohi_org);

        emojiMap.put("[BOBO么么哒]", R.drawable.bobofeiwen_org);

        emojiMap.put("[我爱西瓜]", R.drawable.bobochixigua_org);

        emojiMap.put("[吓一跳]", R.drawable.bobochijing_org);

        emojiMap.put("[吃饭]", R.drawable.bobochifan_org);

        emojiMap.put("[doge]", R.drawable.doge_org);

        emojiMap.put("[喵喵]", R.drawable.mm_org);

        emojiMap.put("[二哈]", R.drawable.moren_hashiqi_org);

        emojiMap.put("[织]", R.drawable.zz2_org);

        emojiMap.put("[兔子]", R.drawable.rabbit_org);

        emojiMap.put("[神马]", R.drawable.horse2_org);

        emojiMap.put("[浮云]", R.drawable.fuyun_org);

        emojiMap.put("[给力]", R.drawable.geiliv2_org);

        emojiMap.put("[萌]", R.drawable.kawayi_org);

        emojiMap.put("[熊猫]", R.drawable.panda_org);

        emojiMap.put("[互粉]", R.drawable.hufen_org);

        emojiMap.put("[围观]", R.drawable.wg_org);

        emojiMap.put("[扔鸡蛋]", R.drawable.rjd_org);

        emojiMap.put("[奥特曼]", R.drawable.otm_org);

        emojiMap.put("[威武]", R.drawable.vw_org);

        emojiMap.put("[热吻]", R.drawable.rw_org);

        emojiMap.put("[囧]", R.drawable.j_org);

        emojiMap.put("[orz]", R.drawable.orz1_org);

        emojiMap.put("[宅]", R.drawable.z_org);

        emojiMap.put("[帅]", R.drawable.s2_org);


        emojiMap.put("[实习]", R.drawable.sx_org);

        emojiMap.put("[骷髅]", R.drawable.kl2_org);

        emojiMap.put("[便便]", R.drawable.s_org);

        emojiMap.put("[跳舞花]", R.drawable.twh_org);

        emojiMap.put("[礼花]", R.drawable.bingo_org);

        emojiMap.put("[打针]", R.drawable.zt_org);

        emojiMap.put("[闪]", R.drawable.y03_org);

        emojiMap.put("[啦啦]", R.drawable.y04_org);

        emojiMap.put("[吼吼]", R.drawable.y05_org);

        emojiMap.put("[庆祝]", R.drawable.y06_org);

        emojiMap.put("[嘿]", R.drawable.y01_org);

        emojiMap.put("[团]", R.drawable.tuan_org);

        emojiMap.put("[圆]", R.drawable.yuan_org);

        emojiMap.put("[男孩儿]", R.drawable.kissboy_org);

        emojiMap.put("[女孩儿]", R.drawable.kissgirl_org);

        emojiMap.put("[炸鸡啤酒]", R.drawable.zhajibeer_org);

        emojiMap.put("[做鬼脸]", R.drawable.guilian_org);

        emojiMap.put("[22]", R.drawable.twot_org);

        emojiMap.put("[00]", R.drawable.zero_org);

        emojiMap.put("[2]", R.drawable.two_org);

        emojiMap.put("[3]", R.drawable.three_org);

        emojiMap.put("[6]", R.drawable.six_org);

        emojiMap.put("[7]", R.drawable.seven_org);

        emojiMap.put("[1]", R.drawable.one_org);

        emojiMap.put("[9]", R.drawable.nine_org);

        emojiMap.put("[4]", R.drawable.four_org);

        emojiMap.put("[5]", R.drawable.five_org);

        emojiMap.put("[8]", R.drawable.eight_org);

        emojiMap.put("[z]", R.drawable.newz_org);

        emojiMap.put("[y]", R.drawable.newy_org);

        emojiMap.put("[x]", R.drawable.newx_org);

        emojiMap.put("[v]", R.drawable.newv_org);

        emojiMap.put("[u]", R.drawable.newu_org);

        emojiMap.put("[t]", R.drawable.newt_org);

        emojiMap.put("[s]", R.drawable.news_org);

        emojiMap.put("[r]", R.drawable.newr_org);

        emojiMap.put("[q]", R.drawable.newq_org);

        emojiMap.put("[p]", R.drawable.newp_org);

        emojiMap.put("[n]", R.drawable.newn_org);

        emojiMap.put("[l]", R.drawable.newl_org);

        emojiMap.put("[k]", R.drawable.newk_org);

        emojiMap.put("[j]", R.drawable.newj_org);

        emojiMap.put("[h]", R.drawable.newh_org);

        emojiMap.put("[g]", R.drawable.newg_org);

        emojiMap.put("[d]", R.drawable.newd_org);

        emojiMap.put("[a]", R.drawable.newa_org);

        emojiMap.put("[w]", R.drawable.weibow_org);

        emojiMap.put("[点]", R.drawable.weibop_org);

        emojiMap.put("[o]", R.drawable.weiboo_org);

        emojiMap.put("[m]", R.drawable.weibom_org);

        emojiMap.put("[i]", R.drawable.weiboi_org);

        emojiMap.put("[e]", R.drawable.weiboe_org);

        emojiMap.put("[c]", R.drawable.weiboc_org);

        emojiMap.put("[b]", R.drawable.weibob_org);

        emojiMap.put("[鸭梨]", R.drawable.pear_org);

        emojiMap.put("[省略号]", R.drawable.shengluehao_org);

        emojiMap.put("[kiss]", R.drawable.kiss2_org);

        emojiMap.put("[雪人]", R.drawable.xx2_org);

        emojiMap.put("[小丑]", R.drawable.xc_org);

        emojiMap.put("[问号]", R.drawable.wh_org);

        emojiMap.put("[叹号]", R.drawable.th_org);

        emojiMap.put("[句号]", R.drawable.jh_org);

        emojiMap.put("[c帅]", R.drawable.cshuai_org);

        emojiMap.put("[c窃喜]", R.drawable.cqiexi_org);

        emojiMap.put("[c迷糊]", R.drawable.cmihu_org);

        emojiMap.put("[c面瘫]", R.drawable.cmiantan_org);

        emojiMap.put("[c囧]", R.drawable.cjiong_org);

        emojiMap.put("[c汗]", R.drawable.chan_org);

        emojiMap.put("[c高明]", R.drawable.cgaoming_org);

        emojiMap.put("[c大笑]", R.drawable.cdaxiao_org);

        emojiMap.put("[c变脸]", R.drawable.cbianlian_org);

        emojiMap.put("[c左右看]", R.drawable.xcjzuoyoukan_org);

        emojiMap.put("[c坏笑]", R.drawable.xcjhuaixiao_org);

        emojiMap.put("[c看热闹]", R.drawable.xcjkanrenao_org);

        emojiMap.put("[c开心]", R.drawable.xcjkaixin_org);

        emojiMap.put("[c关注]", R.drawable.xcjguanzhu_org);

        emojiMap.put("[c娇羞]", R.drawable.xcjjiaoxiu_org);

        emojiMap.put("[c无语]", R.drawable.xcjwuyu_org);

        emojiMap.put("[c疑惑]", R.drawable.xcjyihuo_org);

        emojiMap.put("[c正经]", R.drawable.xcjzhengjing_org);

        emojiMap.put("[c无聊]", R.drawable.xcjwuliao_org);

        emojiMap.put("[c挖鼻孔]", R.drawable.xcjwabikong_org);

        emojiMap.put("[c期待]", R.drawable.xcjqidai_org);

        emojiMap.put("[c摇头看]", R.drawable.xcjyaotoukan_org);

        emojiMap.put("[c亲亲]", R.drawable.xcjqinqin_org);

        emojiMap.put("[c羞涩]", R.drawable.xcjxiushe_org);

        emojiMap.put("[c悲催]", R.drawable.xcjbeicui_org);

        emojiMap.put("[c得瑟]", R.drawable.xcjdese_org);

        emojiMap.put("[c冷眼]", R.drawable.xcjlengyan_org);

        emojiMap.put("[c惊讶]", R.drawable.xcjjingya_org);

        emojiMap.put("[c委屈]", R.drawable.xcjweiqu_org);

        emojiMap.put("[c甩舌头]", R.drawable.xcjshuaishetou_org);

        emojiMap.put("[c摇头萌]", R.drawable.xcjyaotoumeng_org);

        emojiMap.put("[c抓狂]", R.drawable.xcjzhuakuang_org);

        emojiMap.put("[c发火]", R.drawable.xcjfahuo_org);

        emojiMap.put("[c卖萌]", R.drawable.xcjmaimeng_org);

        emojiMap.put("[c伤心]", R.drawable.xcjshangxin_org);

        emojiMap.put("[c捂脸]", R.drawable.xcjwulian_org);

        emojiMap.put("[c震惊哭]", R.drawable.xcjzhenjingku_org);

        emojiMap.put("[c摇摆]", R.drawable.xcjyaobai_org);

        emojiMap.put("[c得意笑]", R.drawable.xcjdeyixiao_org);

        emojiMap.put("[c烦躁]", R.drawable.xcjfanzao_org);

        emojiMap.put("[c得意]", R.drawable.xcjdeyi_org);

        emojiMap.put("[c脸红]", R.drawable.xcjlianhong_org);

        emojiMap.put("[lxhx喵]", R.drawable.lxhxmiao_org);

        emojiMap.put("[lxhx喵喵]", R.drawable.lxhxmiao2_org);

        emojiMap.put("[lxhx奔跑]", R.drawable.lxhxbenpao_org);

        emojiMap.put("[lxhx走]", R.drawable.lxhxzou_org);

        emojiMap.put("[lxhx蠕过]", R.drawable.lxhxruguo_org);

        emojiMap.put("[lxhx蹭]", R.drawable.lxhxceng_org);

        emojiMap.put("[lxhx狂欢]", R.drawable.lxhxkuanghuan_org);

        emojiMap.put("[lxhx奋斗]", R.drawable.lxhxfendou_org);

        emojiMap.put("[lxhx笑]", R.drawable.lxhxxiao_org);

        emojiMap.put("[lxhx懒腰]", R.drawable.lxhxlanyao_org);

        emojiMap.put("[lxhx得意]", R.drawable.lxhxdeyi_org);

        emojiMap.put("[lxhx右边]", R.drawable.lxhxyou_org);

        emojiMap.put("[lxhx转头]", R.drawable.lxhxzhuantou_org);

        emojiMap.put("[lxhx跳跃]", R.drawable.lxhxtiaoyue_org);

        emojiMap.put("[lxhx转体]", R.drawable.lxhxzhuanti_org);

        emojiMap.put("[lxhx撒欢]", R.drawable.lxhxsahuan_org);

        emojiMap.put("[lxhx挠]", R.drawable.lxhxnao_org);

        emojiMap.put("[lxhx挠皇]", R.drawable.lxhxnaohuang_org);

        emojiMap.put("[lxhx逗转圈]", R.drawable.lxhxdouzhuanquan_org);

        emojiMap.put("[lxhx划]", R.drawable.lxhxhua_org);

        emojiMap.put("[lxhx得瑟]", R.drawable.lxhxdese_org);

        emojiMap.put("[lxhx喷嚏]", R.drawable.lxhxpenti2_org);

        emojiMap.put("[lxhx打喷嚏]", R.drawable.lxhxpenti_org);

        emojiMap.put("[lxhx哭]", R.drawable.lxhxku_org);

        emojiMap.put("[lxhx扫灰]", R.drawable.lxhxsaohui_org);

        emojiMap.put("[lxhx听歌]", R.drawable.lxhxtingge_org);

        emojiMap.put("[lxhx狂吃]", R.drawable.lxhxkuangchi_org);

        emojiMap.put("[lxhx画圈]", R.drawable.lxhxhuaquan_org);

        emojiMap.put("[lxhx掀桌]", R.drawable.lxhxxianzhuo_org);

        emojiMap.put("[lxhx刷牙]", R.drawable.lxhxshuaya_org);

        emojiMap.put("[lxhx抱枕]", R.drawable.lxhxbaozhen_org);

        emojiMap.put("[lxhx都不给]", R.drawable.lxhxdoubugei_org);

        emojiMap.put("[lxhx逗左右]", R.drawable.lxhxdouzuoyou_org);

        emojiMap.put("[lxhx变化]", R.drawable.lxhxbianhua_org);

        emojiMap.put("[lxhx打地鼠]", R.drawable.lxhxdadishu_org);

        emojiMap.put("[lxhx西瓜]", R.drawable.lxhxxigua_org);

        emojiMap.put("[lxhx咻]", R.drawable.lxhxxiu1_org);

        emojiMap.put("[lxhx咻2]", R.drawable.lxhxxiu2_org);

        emojiMap.put("[lxhx咻3]", R.drawable.lxhxxiu3_org);

        emojiMap.put("[lxhx咻4]", R.drawable.lxhxxiu4_org);

        emojiMap.put("[lxhx咻5]", R.drawable.lxhxxiu5_org);

        emojiMap.put("[lxhx咻6]", R.drawable.lxhxxiu6_org);

        emojiMap.put("[lxhx咻7]", R.drawable.lxhxxiu7_org);

        emojiMap.put("[lxhx咻8]", R.drawable.lxhxxiu8_org);

        emojiMap.put("[lxhx滚过]", R.drawable.lxhxgunguo_org);

        emojiMap.put("[lxhx躺中枪]", R.drawable.lxhxtangzhongqiang_org);

        emojiMap.put("[lxhx讨厌]", R.drawable.lxhxtaoyan_org);

        emojiMap.put("[lxhx逗上下]", R.drawable.lxhxdoushangxia_org);

        emojiMap.put("[lxhx吐血]", R.drawable.lxhxtuxue_org);

        emojiMap.put("[lxhx病了]", R.drawable.lxhxbingle_org);

        emojiMap.put("[lxhx泪目]", R.drawable.lxhxleimu_org);

        emojiMap.put("[lxhx无语]", R.drawable.lxhxwuyu_org);

        emojiMap.put("[lxhx问号]", R.drawable.lxhxwenhao_org);

        emojiMap.put("[lxhx侧目]", R.drawable.lxhxcemu_org);

        emojiMap.put("[lxhx惊]", R.drawable.lxhxjing_org);

        emojiMap.put("[lxhx吐]", R.drawable.lxhxtu_org);

        emojiMap.put("[lxhx失落]", R.drawable.lxhxshiluo_org);

        emojiMap.put("[lxhx汗]", R.drawable.lxhxhan_org);

        emojiMap.put("[lxhx暴汗]", R.drawable.lxhxhan1_org);

        emojiMap.put("[lxhx狠]", R.drawable.lxhxhen_org);

        emojiMap.put("[lxhx怨念]", R.drawable.lxhxyuannian_org);

        emojiMap.put("[lxhx睡觉]", R.drawable.lxhxshuijiao_org);

        emojiMap.put("[lxhx求表扬]", R.drawable.lxhxqiubiaoyang_org);

        emojiMap.put("[lxhx啄地]", R.drawable.lxhxzhuodi_org);

        emojiMap.put("[lxhx无聊]", R.drawable.lxhxwuliao_org);

        emojiMap.put("[lxhx顺毛]", R.drawable.lxhxshunmao_org);

        emojiMap.put("[lxhx喝奶]", R.drawable.lxhxhenai_org);

        emojiMap.put("[lxhx不爽]", R.drawable.lxhxbushuang_org);

        emojiMap.put("[lxhx老大]", R.drawable.lxhxlaoda_org);

        emojiMap.put("[lxhx生日快乐]", R.drawable.lxhxshengrikuaile_org);

        emojiMap.put("[mtjj拜年]", R.drawable.longnianmtjj_org);

        emojiMap.put("[芒果点赞]", R.drawable.mango_12_org);

        emojiMap.put("[雾]", R.drawable.w_org);

        emojiMap.put("[台风]", R.drawable.tf_org);

        emojiMap.put("[沙尘暴]", R.drawable.sc_org);

        emojiMap.put("[晴转多云]", R.drawable.qzdy_org);

        emojiMap.put("[流星]", R.drawable.lx_org);

        emojiMap.put("[龙卷风]", R.drawable.ljf_org);

        emojiMap.put("[洪水]", R.drawable.hs2_org);

        emojiMap.put("[风]", R.drawable.gf_org);

        emojiMap.put("[多云转晴]", R.drawable.dyzq_org);

        emojiMap.put("[彩虹]", R.drawable.ch_org);

        emojiMap.put("[冰雹]", R.drawable.bb2_org);

        emojiMap.put("[微风]", R.drawable.wind_org);

        emojiMap.put("[阳光]", R.drawable.sunny_org);

        emojiMap.put("[雪]", R.drawable.snow_org);

        emojiMap.put("[闪电]", R.drawable.sh_org);

        emojiMap.put("[阴天]", R.drawable.dark_org);

        emojiMap.put("[真心英雄陈学冬]", R.drawable.zxyxchenxuedong_org);

        emojiMap.put("[真心英雄张杰]", R.drawable.zxyxwanzi_org);

        emojiMap.put("[糖宝惊呆了]", R.drawable.hqgtangbao_org);

        emojiMap.put("[夏天公主]", R.drawable.bbqnxiatian_org);

        emojiMap.put("[萌娃大竣]", R.drawable.bbqnmengwadajun_org);

        emojiMap.put("[真心英雄佟大为]", R.drawable.zxyxtongdawei_org);

        emojiMap.put("[痴情轩轩]", R.drawable.bbqnxuanxuan_org);

        emojiMap.put("[康康保佑]", R.drawable.bbqnkkbaoyou_org);

        emojiMap.put("[诺一粗来嗨]", R.drawable.bbqnchulaihai_org);

        emojiMap.put("[小骨最萌了]", R.drawable.huaqianguxiaogu_org);

        emojiMap.put("[最美杀阡陌]", R.drawable.huaqiangusqm_org);

        emojiMap.put("[尊上么么哒]", R.drawable.hqgzunshangv1_org);

        emojiMap.put("[七夕快乐]", R.drawable.qixi2015_org);

        emojiMap.put("[看跌]", R.drawable.kandiev2_org);

        emojiMap.put("[看涨]", R.drawable.kanzhangv2_org);

        emojiMap.put("[支持红方]", R.drawable.htzchongfang_org);

        emojiMap.put("[国旗]", R.drawable.flag_org);

        emojiMap.put("[支持蓝方]", R.drawable.htzclanfang_org);

        emojiMap.put("[国庆65周年]", R.drawable.gqzn_org);

        emojiMap.put("[圣诞铃铛]", R.drawable.chrisbell_org);

        emojiMap.put("[鞭炮]", R.drawable.bianpao_org);

        emojiMap.put("[红包飞]", R.drawable.hongbao1_org);

        emojiMap.put("[围脖]", R.drawable.weijin_org);

        emojiMap.put("[温暖帽子]", R.drawable.wennuanmaozi_org);

        emojiMap.put("[手套]", R.drawable.shoutao_org);

        emojiMap.put("[红包]", R.drawable.hongbao_org);

        emojiMap.put("[喜]", R.drawable.xi_org);

        emojiMap.put("[礼物]", R.drawable.liwu_org);

        emojiMap.put("[钻戒]", R.drawable.r_org);

        emojiMap.put("[钻石]", R.drawable.diamond_org);

        emojiMap.put("[大巴]", R.drawable.dynamicbus_org);

        emojiMap.put("[飞机]", R.drawable.travel_org);

        emojiMap.put("[自行车]", R.drawable.zxc_org);

        emojiMap.put("[汽车]", R.drawable.jc_org);

        emojiMap.put("[手机]", R.drawable.sj2_org);

        emojiMap.put("[照相机]", R.drawable.camera_org);

        emojiMap.put("[药]", R.drawable.y_org);

        emojiMap.put("[电脑]", R.drawable.dn_org);

        emojiMap.put("[手纸]", R.drawable.sz_org);


        emojiMap.put("[圣诞树]", R.drawable.christree_org);

        emojiMap.put("[圣诞帽]", R.drawable.chrishat_org);

        emojiMap.put("[圣诞老人]", R.drawable.chrisfather_org);

        emojiMap.put("[圣诞袜]", R.drawable.chrisocks_org);

        emojiMap.put("[牛郎]", R.drawable.qixi2016_niulang2_org);

        emojiMap.put("[织女]", R.drawable.qixi2016_zhinv2_org);

        emojiMap.put("[星星]", R.drawable.allstar_dp_org);

        emojiMap.put("[半星]", R.drawable.halfstar_dp_org);

        emojiMap.put("[空星]", R.drawable.blankstar_dp_org);

        emojiMap.put("[发红包啦]", R.drawable.hb_fahongbao2016_org);

        emojiMap.put("[抢到啦]", R.drawable.hb_qiangdao2016_org);

        emojiMap.put("[火华社长美男子]", R.drawable.bbqnshezhang_org);

        emojiMap.put("[小公主珊珊]", R.drawable.bbqnxiaogongzhushanshan_org);

        emojiMap.put("[弟弟皓皓]", R.drawable.bbqndidihaohao_org);

        emojiMap.put("[可爱霓娜]", R.drawable.bbqnnina_org);

        emojiMap.put("[你的宫铃]", R.drawable.ndgl_org);

        emojiMap.put("[父亲节]", R.drawable.fuqinjie2015_org);

        emojiMap.put("[话筒]", R.drawable.huatongv2_org);

        emojiMap.put("[马到成功]", R.drawable.mdcg_org);

        emojiMap.put("[浪]", R.drawable.lang_org);

        emojiMap.put("[织女2]", R.drawable.zv_org);

        emojiMap.put("[牛郎2]", R.drawable.nl_org);

        emojiMap.put("[我爱世界杯]", R.drawable.wasjb_org);

        emojiMap.put("[康乃馨]", R.drawable.muqinjie_org);

        emojiMap.put("[老妈我爱你]", R.drawable.mothersday_org);

        emojiMap.put("[母亲节]", R.drawable.carnation_org);

        emojiMap.put("[随手拍]", R.drawable.suishoupai2014_org);

        emojiMap.put("[青啤鸿运当头]", R.drawable.hongyun_org);

        emojiMap.put("[鸿运当头]", R.drawable.hongyun_org);

        emojiMap.put("[让红包飞]", R.drawable.hongbaofei2014_org);

        emojiMap.put("[Lavida生活]", R.drawable.lavida_org);

        emojiMap.put("[劲能样]", R.drawable.jingnengyang_org);

        emojiMap.put("[微博益起来]", R.drawable.yiqilai_org);

        emojiMap.put("[玩去啦]", R.drawable.weitrip_org);

        emojiMap.put("[bh彪悍]", R.drawable.lenovebiaoan_org);

        emojiMap.put("[offthewall]", R.drawable.newvans_org);

        emojiMap.put("[助力山东]", R.drawable.goshandong_org);

        emojiMap.put("[助力广东]", R.drawable.goguangdong_org);

        emojiMap.put("[K兵加油]", R.drawable.konca_org);

        emojiMap.put("[起亚律动]", R.drawable.kiago_org);

        emojiMap.put("[草泥马]", R.drawable.shenshou_org);

        emojiMap.put("[微博三周年]", R.drawable.weibo3yr_org);

        emojiMap.put("[皇小冠]", R.drawable.weibovip_org);

        emojiMap.put("[达人一周年]", R.drawable.darenanniversary_org);

        emojiMap.put("[伦敦奥火]", R.drawable.lundunaohuo_org);

        emojiMap.put("[神龙]", R.drawable.longniao_org);

        emojiMap.put("[龙蛋]", R.drawable.longdan_org);

        emojiMap.put("[驯鹿]", R.drawable.xunlu_org);

        emojiMap.put("[上海志愿者]", R.drawable.shfabu_org);

        emojiMap.put("[红丝带]", R.drawable.red_band_org);

        emojiMap.put("[绿丝带]", R.drawable.green_band_org);

        emojiMap.put("[音乐盒]", R.drawable.yinyuehe_org);

        emojiMap.put("[首发]", R.drawable.shoufa_org);

        emojiMap.put("[微博蛋糕]", R.drawable.weibo2zhounian_org);

        emojiMap.put("[图片]", R.drawable.tupianimage_org);

        emojiMap.put("[植树节]", R.drawable.zhishujie_org);

        emojiMap.put("[粉蛋糕]", R.drawable.nycake_org);

        emojiMap.put("[糖果]", R.drawable.candy_org);

        emojiMap.put("[万圣节]", R.drawable.nanguatou2_org);

        emojiMap.put("[粉红丝带]", R.drawable.pink_org);

        emojiMap.put("[火炬]", R.drawable.hj_org);

        emojiMap.put("[酒壶]", R.drawable.wine_org);

        emojiMap.put("[月饼]", R.drawable.mooncake3_org);

        emojiMap.put("[满月]", R.drawable.moon1_org);

        emojiMap.put("[黑板]", R.drawable.blackboard_org);

        emojiMap.put("[巧克力]", R.drawable.qkl_org);

        emojiMap.put("[脚印]", R.drawable.jy_org);

        emojiMap.put("[酒]", R.drawable.j2_org);

        emojiMap.put("[狗]", R.drawable.g_org);

        emojiMap.put("[工作]", R.drawable.gz3_org);

        emojiMap.put("[档案]", R.drawable.gz2_org);

        emojiMap.put("[叶子]", R.drawable.green_org);

        emojiMap.put("[钢琴]", R.drawable.gq_org);

        emojiMap.put("[印迹]", R.drawable.foot_org);

        emojiMap.put("[钟]", R.drawable.clock_org);

        emojiMap.put("[茶]", R.drawable.cha_org);


        emojiMap.put("[雨伞]", R.drawable.umb_org);

        emojiMap.put("[电视机]", R.drawable.tv_org);

        emojiMap.put("[电话]", R.drawable.tel_org);


        emojiMap.put("[星]", R.drawable.star_org);


        emojiMap.put("[音乐]", R.drawable.music_org);

        emojiMap.put("[电影]", R.drawable.movie_org);

        emojiMap.put("[唱歌]", R.drawable.ktv_org);

//        emojiMap.put("[冰棍]", R.drawable.ice);

        emojiMap.put("[房子]", R.drawable.house_org);

        emojiMap.put("[帽子]", R.drawable.hat_org);

//        emojiMap.put("[足球]", R.drawable.football);

        emojiMap.put("[鲜花]", R.drawable.flower_org);

//        emojiMap.put("[花]", R.drawable.flower);
//
//        emojiMap.put("[风扇]", R.drawable.fan);
//
//        emojiMap.put("[干杯]", R.drawable.cheer);

        emojiMap.put("[咖啡]", R.drawable.cafe_org);

        emojiMap.put("[j微博益起来]", R.drawable.xyjgongyi_org);

        emojiMap.put("[j疯了]", R.drawable.xyjfengle_org);

        emojiMap.put("[j撒娇]", R.drawable.xyjsajiao_org);

        emojiMap.put("[j吐血]", R.drawable.xyjtuxue_org);

        emojiMap.put("[j浪笑]", R.drawable.xyjlangxiao_org);

        emojiMap.put("[j作揖]", R.drawable.xyjzuoyi_org);

        emojiMap.put("[j哎呀]", R.drawable.xyjaiya_org);

        emojiMap.put("[j挂了]", R.drawable.xyjguale_org);

        emojiMap.put("[j扭秧歌]", R.drawable.xyjniuyangge_org);

        emojiMap.put("[j媚眼]", R.drawable.xyjmeiyan_org);

        emojiMap.put("[j来嘛]", R.drawable.xyjlaima_org);

        emojiMap.put("[j蹭]", R.drawable.xyjceng_org);

        emojiMap.put("[xyj年年有鱼]", R.drawable.longnianxyjyu_org);

        emojiMap.put("[xyj红包]", R.drawable.longnianxyjhb_org);

        emojiMap.put("[xyj拜年]", R.drawable.longnianxyjbai_org);

        emojiMap.put("[抓沙发]", R.drawable.chn_zhuashafa_org);

        emojiMap.put("[震撼]", R.drawable.chn_zhenhan_org);

        emojiMap.put("[晕晕]", R.drawable.chn_yun_org);

        emojiMap.put("[瞎眼]", R.drawable.chn_xiayan_org);

        emojiMap.put("[为难]", R.drawable.chn_weinan_org);

        emojiMap.put("[舔_旧]", R.drawable.chn_tian_org);

        emojiMap.put("[流汗]", R.drawable.chn_liuhan_org);

        emojiMap.put("[冷]", R.drawable.chn_leng_org);

        emojiMap.put("[老大]", R.drawable.chn_laoda_org);

        emojiMap.put("[瞌睡]", R.drawable.chn_keshui_org);

        emojiMap.put("[可怜的]", R.drawable.chn_kelian_org);

        emojiMap.put("[咖啡咖啡]", R.drawable.chn_kafei_org);

        emojiMap.put("[坏笑_旧]", R.drawable.chn_huaixiao_org);

        emojiMap.put("[顶啊]", R.drawable.chn_ding_org);

        emojiMap.put("[好得意]", R.drawable.chn_deyi_org);

        emojiMap.put("[冲啊]", R.drawable.chn_chonga_org);

        emojiMap.put("[吃西瓜]", R.drawable.chn_chixigua_org);

        emojiMap.put("[不要啊]", R.drawable.chn_buyaoya_org);

        emojiMap.put("[飙泪中]", R.drawable.chn_biaolei_org);

        emojiMap.put("[爱你哦]", R.drawable.chn_aini_org);

        emojiMap.put("[moc生日快乐]", R.drawable.mocshengrikuaile_org);

        emojiMap.put("[moc自重]", R.drawable.moczizhong_org);

        emojiMap.put("[moc转头]", R.drawable.moczhuangtou_org);

        emojiMap.put("[moc装酷]", R.drawable.moczhuangku_org);

        emojiMap.put("[moc转发]", R.drawable.moczhuanfa_org);

        emojiMap.put("[moc中箭]", R.drawable.moczhongjian_org);

        emojiMap.put("[moc晕]", R.drawable.mocyun_org);

        emojiMap.put("[moc羞]", R.drawable.mocxiu_org);

        emojiMap.put("[moc围观]", R.drawable.mocweiguan_org);

        emojiMap.put("[moc晚安]", R.drawable.mocwanan_org);

        emojiMap.put("[moc弹跳]", R.drawable.moctantiao_org);

        emojiMap.put("[moc石化]", R.drawable.mocshihua_org);

        emojiMap.put("[moc生气]", R.drawable.mocshengqi_org);

        emojiMap.put("[moc亲亲女]", R.drawable.mocqinqinzuo_org);

        emojiMap.put("[moc亲亲男]", R.drawable.mocqinqinyou_org);

        emojiMap.put("[moc亲吻]", R.drawable.mocqinqinwen_org);

        emojiMap.put("[moc强吻]", R.drawable.mocqiangwen_org);

        emojiMap.put("[moc拍照]", R.drawable.mocpaizhao_org);

        emojiMap.put("[moc呕吐]", R.drawable.mocoutu_org);

        emojiMap.put("[moc冒出]", R.drawable.mocmaochu_org);

        emojiMap.put("[moc路过]", R.drawable.mocluguo_org);

        emojiMap.put("[moc看清楚]", R.drawable.mockanqingchu_org);

        emojiMap.put("[moc结冰]", R.drawable.mocjiebing_org);

        emojiMap.put("[moc挤]", R.drawable.mocji_org);

        emojiMap.put("[moc鬼脸]", R.drawable.mocguilian_org);

        emojiMap.put("[moc尴尬]", R.drawable.mocganga_org);

        emojiMap.put("[moc浮云]", R.drawable.mocfuyun_org);

        emojiMap.put("[moc顶]", R.drawable.mocding_org);

        emojiMap.put("[moc大哭]", R.drawable.mocdaku_org);

        emojiMap.put("[moc大口吃]", R.drawable.mocdakouchi_org);

        emojiMap.put("[moc打击]", R.drawable.mocdaji_org);

        emojiMap.put("[moc呲牙笑]", R.drawable.mocciyaxiao_org);

        emojiMap.put("[moc扯脸]", R.drawable.mocchelian_org);

        emojiMap.put("[g思考]", R.drawable.guibao1sikao_org);

        emojiMap.put("[g震惊]", R.drawable.guibao2zhenjing_org);

        emojiMap.put("[g狂笑]", R.drawable.guibao3kuangxiao_org);

        emojiMap.put("[g脸红]", R.drawable.guibao4lianhong_org);

        emojiMap.put("[g发愣]", R.drawable.guibao5faleng_org);

        emojiMap.put("[g话痨]", R.drawable.guibao6hualao_org);

        emojiMap.put("[g吹发]", R.drawable.guibao7chuifa_org);

        emojiMap.put("[g爆哭]", R.drawable.guibao8baoku_org);

        emojiMap.put("[g伤心]", R.drawable.guibao9shangxin_org);

        emojiMap.put("[g得瑟]", R.drawable.guibao10dese_org);

        emojiMap.put("[g魅眼]", R.drawable.guibao11meiyan_org);

        emojiMap.put("[g无辜]", R.drawable.guibao12wugu_org);

        emojiMap.put("[g挑眉]", R.drawable.guibao13tiaomei_org);

        emojiMap.put("[g墨镜1]", R.drawable.guibao14mojing_org);

        emojiMap.put("[g墨镜2]", R.drawable.guibao16mojing_org);

        emojiMap.put("[g变脸]", R.drawable.guibao17bianlian_org);

        emojiMap.put("[g扇笑]", R.drawable.guibao18shanxiao_org);

        emojiMap.put("[g扣鼻]", R.drawable.guibao19koubi_org);

        emojiMap.put("[g扣鼻2]", R.drawable.guibao20koubi_org);

        emojiMap.put("[g瀑汗]", R.drawable.guibao21baohan_org);

        emojiMap.put("[g汗滴]", R.drawable.guibao22handi_org);

        emojiMap.put("[g咀嚼]", R.drawable.guibao23jujue_org);

        emojiMap.put("[g阴影]", R.drawable.guibao24yinying_org);

        emojiMap.put("[g鼻血]", R.drawable.guibao25bixue_org);

        emojiMap.put("[g呕吐]", R.drawable.guibao26outu_org);

        emojiMap.put("[g噴血]", R.drawable.guibao27penxue_org);

        emojiMap.put("[g泪滴]", R.drawable.guibao28leidi_org);

        emojiMap.put("[g惊讶1]", R.drawable.guibao29jingya_org);

        emojiMap.put("[g头晕]", R.drawable.guibao30touyun_org);

        emojiMap.put("[g闪牙1]", R.drawable.guibao31shanya_org);

        emojiMap.put("[g闪牙2]", R.drawable.guibao32shanya_org);

        emojiMap.put("[g巨汗]", R.drawable.guibao33juhan_org);

        emojiMap.put("[g鼓掌]", R.drawable.guibao34guzhang_org);

        emojiMap.put("[g招呼]", R.drawable.guibao35zhaohu_org);

        emojiMap.put("[g鼓掌2]", R.drawable.guibao36guzhang_org);

        emojiMap.put("[g无所谓]", R.drawable.guibao37wusuowei_org);

        emojiMap.put("[g雷击]", R.drawable.guibao38leiji_org);

        emojiMap.put("[g邪笑]", R.drawable.guibao39xiexiao_org);

        emojiMap.put("[g裸奔1]", R.drawable.guibao40luoben_org);

        emojiMap.put("[g裸奔2]", R.drawable.guibao41luoben_org);

        emojiMap.put("[g裸奔3]", R.drawable.guibao42luoben_org);

        emojiMap.put("[g举刀]", R.drawable.guibao43judao_org);

        emojiMap.put("[g喝茶]", R.drawable.guibao44hecha_org);

        emojiMap.put("[g摇手]", R.drawable.guibao45yaoshou_org);

        emojiMap.put("[g病了]", R.drawable.guibao46bingle_org);

        emojiMap.put("[g冻上]", R.drawable.guibao47dongshang_org);

        emojiMap.put("[g好冷]", R.drawable.guibao48haoleng_org);

        emojiMap.put("[g委屈]", R.drawable.guibao49weiqu_org);

        emojiMap.put("[g发飘]", R.drawable.guibao50fapiao_org);

        emojiMap.put("[g卖萌]", R.drawable.guibao51maimeng_org);

        emojiMap.put("[g唱歌]", R.drawable.guibao52changge_org);

        emojiMap.put("[g吃糖]", R.drawable.guibao53chitang_org);

        emojiMap.put("[g桂宝]", R.drawable.guibao54guibao_org);

        emojiMap.put("[g汪汪]", R.drawable.guibao55wangwang_org);

        emojiMap.put("[g吐舌]", R.drawable.guibao56tushe_org);

        emojiMap.put("[g骨头]", R.drawable.guibao57gutou_org);

        emojiMap.put("[g口水]", R.drawable.guibao58koushui_org);

        emojiMap.put("[g惊讶2]", R.drawable.guibao59jingya_org);

        emojiMap.put("[g爆哭2]", R.drawable.guibao60baoku_org);

        emojiMap.put("[g激动]", R.drawable.guibao60jidong_org);

        emojiMap.put("[lm招财猫]", R.drawable.lmmzhaocaimao0_org);

        emojiMap.put("[lm贼笑]", R.drawable.lmmzeixiao0_org);

        emojiMap.put("[lm严肃]", R.drawable.lmmyansu0_org);

        emojiMap.put("[lm小地主]", R.drawable.lmmxiaodizhu0_org);

        emojiMap.put("[lm无奈]", R.drawable.lmmwunai0_org);

        emojiMap.put("[lm挖鼻屎]", R.drawable.lmmwabisi0_org);

        emojiMap.put("[lm天然呆]", R.drawable.lmmtianrandai0_org);

        emojiMap.put("[lm生病了]", R.drawable.lmmshengbingle0_org);

        emojiMap.put("[lm扑克脸]", R.drawable.lmmpukelian0_org);

        emojiMap.put("[lm瀑布汗]", R.drawable.lmmpubuhan0_org);

        emojiMap.put("[lm磨牙]", R.drawable.lmmmoya0_org);

        emojiMap.put("[lm没听见]", R.drawable.lmmmeitingjian0_org);

        emojiMap.put("[lm没事吧]", R.drawable.lmmmeishiba0_org);

        emojiMap.put("[lm茫然]", R.drawable.lmmmangran0_org);

        emojiMap.put("[lm泪流满面]", R.drawable.lmmleiliumanmian0_org);

        emojiMap.put("[lm囧汗]", R.drawable.lmmjionghan0_org);

        emojiMap.put("[lm惊恐]", R.drawable.lmmjingkong0_org);

        emojiMap.put("[lm惊呆]", R.drawable.lmmjingdai0_org);

        emojiMap.put("[lm警察]", R.drawable.lmmjingcha0_org);

        emojiMap.put("[lm混乱中]", R.drawable.lmmhunluan0_org);

        emojiMap.put("[lm花痴]", R.drawable.lmmhuachi0_org);

        emojiMap.put("[lm喝水]", R.drawable.lmmheshui0_org);

        emojiMap.put("[lm嘿嘿]", R.drawable.lmmheihei0_org);

        emojiMap.put("[lm哈哈哈]", R.drawable.lmmhahaha0_org);

        emojiMap.put("[lm干笑]", R.drawable.lmmganxiao0_org);

        emojiMap.put("[lm疯了]", R.drawable.lmmfengle0_org);

        emojiMap.put("[lm恶心]", R.drawable.lmmexin0_org);

        emojiMap.put("[lm嘟嘟嘴]", R.drawable.lmmduduzui0_org);

        emojiMap.put("[lm滴蜡]", R.drawable.lmmdila0_org);

        emojiMap.put("[lm点头]", R.drawable.lmmdiantou0_org);

        emojiMap.put("[lm大怒]", R.drawable.lmmdanu0_org);

        emojiMap.put("[lm大惊失色]", R.drawable.lmmdajingshise0_org);

        emojiMap.put("[lm呆笑]", R.drawable.lmmdaixiao0_org);

        emojiMap.put("[lm搭错线]", R.drawable.lmmdacuoxian0_org);

        emojiMap.put("[lm大便]", R.drawable.lmmdabian0_org);

        emojiMap.put("[lm不]", R.drawable.lmmbu0_org);

        emojiMap.put("[lm鼻涕虫]", R.drawable.lmmbitichong0_org);

        emojiMap.put("[lm暴雨汗]", R.drawable.lmmbaoyuhan0_org);

        emojiMap.put("[lm啊呜啊呜]", R.drawable.lmmawuawu0_org);

        emojiMap.put("[lm爱爱爱]", R.drawable.lmmaiaiai0_org);

        emojiMap.put("[mk拜年]", R.drawable.longnianmk_org);

        emojiMap.put("[真淡定]", R.drawable.cat_zhendanding_org);

        emojiMap.put("[运气中]", R.drawable.cat_yunqizhong_org);

        emojiMap.put("[嗯]", R.drawable.cat_yi_org);

        emojiMap.put("[一头竖线]", R.drawable.cat_yitoushuxian_org);

        emojiMap.put("[星星眼儿]", R.drawable.cat_xingxingyan_org);

        emojiMap.put("[笑眯眯]", R.drawable.cat_xiaomimi_org);

        emojiMap.put("[小地主]", R.drawable.cat_xiaodizhu_org);

        emojiMap.put("[我错了]", R.drawable.cat_wocuole_org);

        emojiMap.put("[喂]", R.drawable.cat_wei_org);

        emojiMap.put("[伸舌头]", R.drawable.cat_tushetou_org);

        emojiMap.put("[天然呆]", R.drawable.cat_tianrandai_org);

        emojiMap.put("[陶醉了]", R.drawable.cat_taozuile_org);

        emojiMap.put("[生气了]", R.drawable.cat_shengqile_org);

        emojiMap.put("[生病鸟]", R.drawable.cat_shengbingle_org);

        emojiMap.put("[忍不了]", R.drawable.cat_renbuliao_org);

        emojiMap.put("[扑克脸]", R.drawable.cat_pukelian_org);

        emojiMap.put("[瀑布汗]", R.drawable.cat_pubuhan_org);

        emojiMap.put("[你没事吧]", R.drawable.cat_nimeishiba_org);

        emojiMap.put("[内牛满面]", R.drawable.cat_neiniumanmian_org);

        emojiMap.put("[没听见]", R.drawable.cat_meitingjian_org);

        emojiMap.put("[哭死啦]", R.drawable.cat_kusila_org);

        emojiMap.put("[囧汗]", R.drawable.cat_jionghan_org);

        emojiMap.put("[惊恐中]", R.drawable.cat_jingkongzhong_org);

        emojiMap.put("[混乱中]", R.drawable.cat_hunluanzhong_org);

        emojiMap.put("[花痴闪闪]", R.drawable.cat_huachishanshan_org);

        emojiMap.put("[嘿嘿嘿]", R.drawable.cat_heiheihei_org);

        emojiMap.put("[哈哈哈哈]", R.drawable.cat_hahaha_org);

        emojiMap.put("[干笑中]", R.drawable.cat_ganxiaozhong_org);

        emojiMap.put("[恶心死]", R.drawable.cat_exinsi_org);

        emojiMap.put("[嘟嘟嘴]", R.drawable.cat_duduzui_org);

        emojiMap.put("[大怒]", R.drawable.cat_danu_org);

        emojiMap.put("[大惊失色]", R.drawable.cat_dajingshise_org);

        emojiMap.put("[呆呆]", R.drawable.cat_daidai_org);

        emojiMap.put("[搭错线]", R.drawable.cat_dacuoxian_org);

        emojiMap.put("[鼻涕虫]", R.drawable.cat_bitichong_org);

        emojiMap.put("[暴雨汗]", R.drawable.cat_baoyuhan_org);

        emojiMap.put("[啊呜啊呜]", R.drawable.cat_awuawu_org);

        emojiMap.put("[哇]", R.drawable.cat_ai_org);

        emojiMap.put("[爱爱爱]", R.drawable.cat_aiaiai_org);

        emojiMap.put("[bed蹬腿]", R.drawable.brddengtui_org);

        emojiMap.put("[bed弹跳]", R.drawable.brdtantiao_org);

        emojiMap.put("[bed扯]", R.drawable.brdche_org);

        emojiMap.put("[bed凌乱]", R.drawable.brdlingluan_org);

        emojiMap.put("[bed奔跑]", R.drawable.brdbenpao_org);

        emojiMap.put("[bed仰卧起坐]", R.drawable.brdyangwoqizuo_org);

        emojiMap.put("[bed出浴]", R.drawable.brdchuyu_org);

        emojiMap.put("[bed练腰]", R.drawable.brdlianyao_org);

        emojiMap.put("[bed皮]", R.drawable.brdpi_org);

        emojiMap.put("[bed挠痒]", R.drawable.brdnaoyang_org);

        emojiMap.put("[bed啦啦啦]", R.drawable.brdlalala_org);

        emojiMap.put("[bed举哑铃]", R.drawable.brdjuyaling_org);

        emojiMap.put("[bed飘忽]", R.drawable.brdpiaohu_org);

        emojiMap.put("[bed拍手]", R.drawable.brdpaishou_org);

        emojiMap.put("[bed嘿哈]", R.drawable.brdheiha_org);

        emojiMap.put("[bed踏步]", R.drawable.brdtabu_org);

        emojiMap.put("[bed揉眼]", R.drawable.brdrouyan_org);

        emojiMap.put("[bed转圈]", R.drawable.brdzhuanquan_org);

        emojiMap.put("[bed飞吻]", R.drawable.brdfeiwen_org);

        emojiMap.put("[bed跳]", R.drawable.brdtiao_org);

        emojiMap.put("[bed巴掌]", R.drawable.brdbazhang_org);

        emojiMap.put("[bed撒娇]", R.drawable.brdsajiao_org);

        emojiMap.put("[bed拍脸]", R.drawable.brdpailian_org);

        emojiMap.put("[bed好饱]", R.drawable.brdhaobao_org);

        emojiMap.put("[bed跑]", R.drawable.brdpao_org);

        emojiMap.put("[bed兴奋]", R.drawable.brdxingfen_org);

        emojiMap.put("[brd新]", R.drawable.brdxinlongnian_org);

        emojiMap.put("[brd年]", R.drawable.brdnianlongnian_org);

        emojiMap.put("[brd拜年]", R.drawable.brdlongnian_org);

        emojiMap.put("[brd谨]", R.drawable.brdjinlongnian_org);

        emojiMap.put("[brd贺]", R.drawable.brdhelongnian_org);

        emojiMap.put("[ppb生日快乐]", R.drawable.ppbshengrikuaile_org);

        emojiMap.put("[ppb愚人节]", R.drawable.ppbfool_org);

        emojiMap.put("[ppb圣诞圣衣]", R.drawable.ppbshengyi_org);

        emojiMap.put("[ppb叮叮当]", R.drawable.ppbddd_org);

        emojiMap.put("[ppb早安]", R.drawable.ppbzaoan_org);

        emojiMap.put("[ppb洗澡]", R.drawable.ppbxizao_org);

        emojiMap.put("[ppb脱光]", R.drawable.ppbtuoguang_org);

        emojiMap.put("[ppb喷血]", R.drawable.ppbpengxue_org);

        emojiMap.put("[ppb捏捏]", R.drawable.ppbnienie_org);

        emojiMap.put("[ppb裸走]", R.drawable.ppbluozou_org);

        emojiMap.put("[ppb裸舞]", R.drawable.ppbluowu_org);

        emojiMap.put("[ppb路过]", R.drawable.ppbluguo_org);

        emojiMap.put("[ppb激动]", R.drawable.ppbjidong_org);

        emojiMap.put("[ppb奸笑]", R.drawable.ppbjianxiao_org);

        emojiMap.put("[ppb鼓掌]", R.drawable.ppbguzhang_org);

        emojiMap.put("[ppbbibi]", R.drawable.ppbbibi_org);

        emojiMap.put("[ppb靠]", R.drawable.ppbkao_org);

        emojiMap.put("[ppb发狂]", R.drawable.ppbfakuang_org);

        emojiMap.put("[ppb困]", R.drawable.ppbkun_org);

        emojiMap.put("[ppb啊哈哈]", R.drawable.ppbahaha_org);

        emojiMap.put("[ppb僵尸]", R.drawable.ppbjiangshi_org);

        emojiMap.put("[ppb甩嘴]", R.drawable.ppbshuaizui_org);

        emojiMap.put("[ppb囧]", R.drawable.ppbjiong_org);

        emojiMap.put("[ppb去死]", R.drawable.ppbqusi_org);

        emojiMap.put("[ppb晴天霹雳]", R.drawable.ppbqingtianpili_org);

        emojiMap.put("[ppb啊]", R.drawable.ppba_org);

        emojiMap.put("[ppb大哭]", R.drawable.ppbdaku_org);

        emojiMap.put("[ppb我砍]", R.drawable.ppbwokan_org);

        emojiMap.put("[ppb扫射]", R.drawable.ppbsaoshe_org);

        emojiMap.put("[ppb杀啊]", R.drawable.ppbshaa_org);

        emojiMap.put("[ppb啊呜]", R.drawable.ppbawu_org);

        emojiMap.put("[ppb蝙蝠侠]", R.drawable.ppbbianfuxia_org);

        emojiMap.put("[ppb滚]", R.drawable.ppbgun_org);

        emojiMap.put("[ppb欢迎欢迎]", R.drawable.ppbhuanying_org);

        emojiMap.put("[ppb狂吃]", R.drawable.ppbkuangchi_org);

        emojiMap.put("[ppb讨厌]", R.drawable.ppbtaoyan_org);

        emojiMap.put("[ppb爱你哟]", R.drawable.ppbainiyo_org);

        emojiMap.put("[ppb卖萌]", R.drawable.ppbmaimeng_org);

        emojiMap.put("[哎呦熊做面膜]", R.drawable.ayxzuomianmo_org);

        emojiMap.put("[哎呦熊咒骂]", R.drawable.ayxzma_org);

        emojiMap.put("[哎呦熊震惊]", R.drawable.ayxzhenjing_org);

        emojiMap.put("[哎呦熊yes]", R.drawable.ayxyes_org);

        emojiMap.put("[哎呦熊掩面]", R.drawable.ayxyanmian_org);

        emojiMap.put("[哎呦熊乌鸦]", R.drawable.ayxwuya_org);

        emojiMap.put("[哎呦熊无奈]", R.drawable.ayxwunai_org);

        emojiMap.put("[哎呦熊晚安]", R.drawable.ayxwanan_org);

        emojiMap.put("[哎呦熊生日快乐]", R.drawable.ayxshengrikuaile_org);

        emojiMap.put("[哎呦熊撒欢]", R.drawable.ayxsahuan_org);

        emojiMap.put("[哎呦熊no]", R.drawable.ayxno_org);

        emojiMap.put("[哎呦熊路过]", R.drawable.ayxluguo_org);

        emojiMap.put("[哎呦熊流汗]", R.drawable.ayxliuhan_org);

        emojiMap.put("[哎呦熊流鼻血]", R.drawable.ayxliubixue_org);

        emojiMap.put("[哎呦熊雷死]", R.drawable.ayxleisi_org);

        emojiMap.put("[哎呦熊泪奔]", R.drawable.ayxleiben_org);

        emojiMap.put("[哎呦熊哭泣]", R.drawable.ayxkuqi_org);

        emojiMap.put("[哎呦熊开心]", R.drawable.ayxkaixin_org);

        emojiMap.put("[哎呦熊开饭咯]", R.drawable.ayxkaifanluo_org);

        emojiMap.put("[哎呦熊纠结]", R.drawable.ayxjiujie_org);

        emojiMap.put("[哎呦熊害羞]", R.drawable.ayxhaixiu_org);

        emojiMap.put("[哎呦熊鼓掌]", R.drawable.ayxguzhang_org);

        emojiMap.put("[哎呦熊感动]", R.drawable.ayxgandong_org);

        emojiMap.put("[哎呦熊浮云]", R.drawable.ayxfuyun_org);

        emojiMap.put("[哎呦熊飞吻]", R.drawable.ayxfeiwen_org);

        emojiMap.put("[哎呦熊打招呼]", R.drawable.ayxdazhaohu_org);

        emojiMap.put("[哎呦熊补妆]", R.drawable.ayxbuzhuang_org);

        emojiMap.put("[哎呦熊崩溃]", R.drawable.ayxbenkui_org);

        emojiMap.put("[km问号]", R.drawable.km1wenhao_org);

        emojiMap.put("[km爱你]", R.drawable.km1aini_org);

        emojiMap.put("[km白块旋转]", R.drawable.km1baikuaixuanzhuan_org);

        emojiMap.put("[km黑块旋转]", R.drawable.km1heikuaixuanzhuan_org);

        emojiMap.put("[km花痴]", R.drawable.km1huachi_org);

        emojiMap.put("[km可爱]", R.drawable.km1keai_org);

        emojiMap.put("[km切]", R.drawable.km1qie_org);

        emojiMap.put("[km亲亲]", R.drawable.km1qinqin_org);

        emojiMap.put("[km亲亲白块]", R.drawable.km1qinqinbaikuai_org);

        emojiMap.put("[km亲亲黑块]", R.drawable.km1qinqinheikuai_org);

        emojiMap.put("[km挖鼻屎]", R.drawable.km1wabishi_org);

        emojiMap.put("[km哇哇哭]", R.drawable.km1wawaku_org);

        emojiMap.put("[km围观]", R.drawable.km1weiguan_org);

        emojiMap.put("[km委屈]", R.drawable.km1weiqu_org);

        emojiMap.put("[km羞]", R.drawable.km1xiu_org);


        emojiMap.put("[km侦探]", R.drawable.kmzhentan_org);

        emojiMap.put("[km嘻嘻]", R.drawable.kmxixi_org);

        emojiMap.put("[km呜呜1]", R.drawable.kmwuwu1_org);

        emojiMap.put("[km冷笑]", R.drawable.kmlengxiao_org);

        emojiMap.put("[km邮件]", R.drawable.kmyoujian_org);

        emojiMap.put("[km闹钟]", R.drawable.kmnaozhong_org);

        emojiMap.put("[km哼]", R.drawable.kmheng_org);

        emojiMap.put("[km无语]", R.drawable.kmwuyu_org);

        emojiMap.put("[km黑块不淡定]", R.drawable.kmheikuaibudanding_org);

        emojiMap.put("[km害怕]", R.drawable.kmhaipa_org);

        emojiMap.put("[km呜呜88]", R.drawable.kmwuwu88_org);

        emojiMap.put("[km透亮]", R.drawable.kmtouliang_org);

        emojiMap.put("[km唔]", R.drawable.kmwu_org);

        emojiMap.put("[km侠盗]", R.drawable.kmxiadao_org);

        emojiMap.put("[km醉]", R.drawable.kmzui_org);

        emojiMap.put("[km丽莎2]", R.drawable.kmlisha2_org);

        emojiMap.put("[km酷2]", R.drawable.kmku2_org);

        emojiMap.put("[km憨]", R.drawable.kmhan_org);

        emojiMap.put("[km中毒]", R.drawable.kmzhongdu_org);

        emojiMap.put("[km电视]", R.drawable.kmdianshi_org);

        emojiMap.put("[km困]", R.drawable.kmkun_org);

        emojiMap.put("[km高兴]", R.drawable.kmgaoxing_org);

        emojiMap.put("[km幺鸡猫]", R.drawable.kmyaojimao_org);

        emojiMap.put("[km黑化笑]", R.drawable.kmhaihuaxiao_org);

        emojiMap.put("[km花猫]", R.drawable.kmhuamao_org);

        emojiMap.put("[km好吃]", R.drawable.kmhaochi_org);


        emojiMap.put("[km黑化唠叨]", R.drawable.kmheihualaodao_org);

        emojiMap.put("[km好吃惊]", R.drawable.kmhaochijing_org);

        emojiMap.put("[km唠叨]", R.drawable.kmlaodao_org);

        emojiMap.put("[km眼镜]", R.drawable.kmyanjing_org);

        emojiMap.put("[km闪]", R.drawable.kmshan_org);


        emojiMap.put("[km不淡定]", R.drawable.kmbudanding_org);

        emojiMap.put("[km鼻血1]", R.drawable.kmbixue1_org);

        emojiMap.put("[km好饿]", R.drawable.kmhaoe_org);

        emojiMap.put("[km上传]", R.drawable.kmshangchuan_org);

        emojiMap.put("[km黑化]", R.drawable.kmheihua_org);

        emojiMap.put("[km鼻血]", R.drawable.kmbixue_org);

        emojiMap.put("[km酷]", R.drawable.kmku_org);

        emojiMap.put("[km愁]", R.drawable.kmchou_org);

        emojiMap.put("[km相机]", R.drawable.kmxiangji_org);

        emojiMap.put("[km喜]", R.drawable.kmxi_org);

        emojiMap.put("[km得意]", R.drawable.kmdeyi_org);

        emojiMap.put("[km怒]", R.drawable.kmnu_org);

        emojiMap.put("[km生气]", R.drawable.kmshengqi_org);


        emojiMap.put("[km呜血泪]", R.drawable.km1wuxuelei_org);


        emojiMap.put("[km馋]", R.drawable.kmchan_org);

        emojiMap.put("[km下载]", R.drawable.kmxiazai_org);


        emojiMap.put("[km情书]", R.drawable.kmqingshu_org);

        emojiMap.put("[km骷髅]", R.drawable.kmkulou_org);

        emojiMap.put("[km丽莎]", R.drawable.kmlisha_org);

        emojiMap.put("[km禁]", R.drawable.kmjin_org);

        emojiMap.put("[km晕]", R.drawable.kmyun_org);

        emojiMap.put("[km热]", R.drawable.kmre_org);

        emojiMap.put("[km冷]", R.drawable.kmleng_org);

        emojiMap.put("[km猫]", R.drawable.kmmao_org);

        emojiMap.put("[km拜年]", R.drawable.longniankm_org);

        emojiMap.put("[bofu吐舌头]", R.drawable.bofutushetou_org);

        emojiMap.put("[bofu拜年]", R.drawable.bofulongnian_org);

        emojiMap.put("[bofu淫笑]", R.drawable.bofuyinxiao_org);

        emojiMap.put("[bofu压力山大]", R.drawable.bofuyalishanda_org);

        emojiMap.put("[bofu心灰意冷]", R.drawable.bofuxinhuiyileng_org);

        emojiMap.put("[bofu心动]", R.drawable.bofuxindong_org);

        emojiMap.put("[bofu咸蛋超人]", R.drawable.bofuxiandanchaoren_org);

        emojiMap.put("[bofu食神]", R.drawable.bofushishen_org);

        emojiMap.put("[bofu票子快来]", R.drawable.bofupiaozikuailai_org);

        emojiMap.put("[bofu怒]", R.drawable.bofunu_org);

        emojiMap.put("[bofu扭]", R.drawable.bofuniu_org);

        emojiMap.put("[bofu梦遗]", R.drawable.bofumengyi_org);

        emojiMap.put("[bofu累]", R.drawable.bofulei_org);

        emojiMap.put("[bofu啃西瓜]", R.drawable.bofukenxigua_org);

        emojiMap.put("[bofu给力]", R.drawable.bofugeili_org);

        emojiMap.put("[bofu发愤图强]", R.drawable.bofufafentuqiang_org);

        emojiMap.put("[bofu抖骚]", R.drawable.bofudousao_org);

        emojiMap.put("[bofu得瑟]", R.drawable.bofudese_org);

        emojiMap.put("[bofu打飞机]", R.drawable.bofudafeiji_org);

        emojiMap.put("[bofu变脸]", R.drawable.bofubianlian_org);

        emojiMap.put("[bofu蹦极]", R.drawable.bofubengji_org);

        emojiMap.put("[bofu暴躁]", R.drawable.bofubaozao_org);

        emojiMap.put("[萌萌星星眼]", R.drawable.mmxingxingyan_org);

        emojiMap.put("[萌萌打滚]", R.drawable.mmdagun_org);

        emojiMap.put("[萌萌甩帽]", R.drawable.mmshuaimaozi_org);

        emojiMap.put("[萌萌摔瓶]", R.drawable.mmshuaipingzi_org);

        emojiMap.put("[萌萌扭屁股]", R.drawable.mmniupigu_org);

        emojiMap.put("[萌萌惊讶]", R.drawable.mmjidujingya_org);

        emojiMap.put("[萌萌懒得理]", R.drawable.mmlandeli_org);

        emojiMap.put("[萌萌偷乐]", R.drawable.mmwuzuile_org);

        emojiMap.put("[萌萌鄙视]", R.drawable.mmbishini_org);

        emojiMap.put("[萌萌哈欠]", R.drawable.mmdagehaqian_org);

        emojiMap.put("[萌萌石化]", R.drawable.mmshihua_org);

        emojiMap.put("[萌萌敲鼓]", R.drawable.mmqiaodagu_org);

        emojiMap.put("[萌萌叹气]", R.drawable.mmtankouqi_org);

        emojiMap.put("[萌萌捶地笑]", R.drawable.mmchuidixiao_org);

        emojiMap.put("[萌萌捂脸]", R.drawable.mmwulian_org);

        emojiMap.put("[萌萌流汗]", R.drawable.mmkuangliuhan_org);

        emojiMap.put("[萌萌抠鼻]", R.drawable.mmkoubizi_org);

        emojiMap.put("[萌萌泪奔]", R.drawable.mmleiben_org);

        emojiMap.put("[萌萌献花]", R.drawable.mmxianduohua_org);

        emojiMap.put("[欢欢]", R.drawable.liaobuqi_org);

        emojiMap.put("[乐乐]", R.drawable.guanbuzhao_org);


        emojiMap.put("[爱]", R.drawable.ai_org);


        emojiMap.put("[gbz真穿越]", R.drawable.gbzzhenchuanyue_org);

        emojiMap.put("[gbz再睡会]", R.drawable.gbzzaishuihui_org);

        emojiMap.put("[gbz呜呜]", R.drawable.gbzwuwu_org);

        emojiMap.put("[gbz委屈]", R.drawable.gbzweiqu_org);

        emojiMap.put("[gbz晚安了]", R.drawable.gbzwananle_org);

        emojiMap.put("[gbz祈福]", R.drawable.gbzqifu_org);

        emojiMap.put("[gbz祈福了]", R.drawable.gbzqifule_org);

        emojiMap.put("[gbz窃笑]", R.drawable.gbzqiexiao_org);

        emojiMap.put("[gbz起床啦]", R.drawable.gbzqichuangla_org);

        emojiMap.put("[gbz困]", R.drawable.gbzkun_org);

        emojiMap.put("[gbz加班]", R.drawable.gbzjiaban_org);

        emojiMap.put("[gbz加班中]", R.drawable.gbzjiabanzhong_org);

        emojiMap.put("[gbz饿]", R.drawable.gbze_org);

        emojiMap.put("[gbz饿晕]", R.drawable.gbzeyun_org);

        emojiMap.put("[gbz得意]", R.drawable.gbzdeyi_org);

        emojiMap.put("[gbz大笑]", R.drawable.gbzdaxiao_org);

        emojiMap.put("[gbz穿越了]", R.drawable.gbzchuanyuele_org);

        emojiMap.put("[有点困]", R.drawable.youdiankun_org);

        emojiMap.put("[yes]", R.drawable.yes_org);

        emojiMap.put("[咽回去了]", R.drawable.yanhuiqule_org);

        emojiMap.put("[鸭梨很大]", R.drawable.yalihenda_org);

        emojiMap.put("[羞羞]", R.drawable.xiuxiu_org);

        emojiMap.put("[喜欢你]", R.drawable.xihuang_org);

        emojiMap.put("[小便屁]", R.drawable.xiaobianpi_org);

        emojiMap.put("[无奈]", R.drawable.wunai22_org);

        emojiMap.put("[兔兔]", R.drawable.tutu_org);

        emojiMap.put("[吐舌头]", R.drawable.tushetou_org);

        emojiMap.put("[头晕]", R.drawable.touyun_org);

        emojiMap.put("[听音乐]", R.drawable.tingyinyue_org);

        emojiMap.put("[睡大觉]", R.drawable.shuijiao_org);

        emojiMap.put("[闪闪紫]", R.drawable.shanshanzi_org);

        emojiMap.put("[闪闪绿]", R.drawable.shanshanlu_org);

        emojiMap.put("[闪闪灰]", R.drawable.shanshanhui_org);

        emojiMap.put("[闪闪红]", R.drawable.shanshanhong_org);

        emojiMap.put("[闪闪粉]", R.drawable.shanshanfen_org);

        emojiMap.put("[咆哮]", R.drawable.paoxiao_org);

        emojiMap.put("[摸头]", R.drawable.motou_org);

        emojiMap.put("[真美好]", R.drawable.meihao_org);

        emojiMap.put("[脸红自爆]", R.drawable.lianhongzibao_org);

        emojiMap.put("[哭泣女]", R.drawable.kuqinv_org);

        emojiMap.put("[哭泣男]", R.drawable.kuqinan_org);

        emojiMap.put("[空]", R.drawable.kong_org);

        emojiMap.put("[尽情玩]", R.drawable.jinqingwan_org);

        emojiMap.put("[惊喜]", R.drawable.jingxi_org);

        emojiMap.put("[惊呆]", R.drawable.jingdai_org);

        emojiMap.put("[胡萝卜]", R.drawable.huluobo_org);

        emojiMap.put("[欢腾去爱]", R.drawable.huangtengquai_org);

        emojiMap.put("[感冒了]", R.drawable.ganmao_org);

        emojiMap.put("[怒了]", R.drawable.fennu_org);

        emojiMap.put("[我要奋斗]", R.drawable.fendou123_org);

        emojiMap.put("[发芽]", R.drawable.faya_org);

        emojiMap.put("[春暖花开]", R.drawable.chunnuanhuakai_org);

        emojiMap.put("[抽烟]", R.drawable.chouyan_org);

        emojiMap.put("[昂]", R.drawable.ang_org);

        emojiMap.put("[啊]", R.drawable.aa_org);

        emojiMap.put("[自插双目]", R.drawable.zichashuangmu_org);

        emojiMap.put("[咦]", R.drawable.yiwen_org);

        emojiMap.put("[嘘嘘]", R.drawable.xu_org);

        emojiMap.put("[我吃]", R.drawable.wochiwode_org);

        emojiMap.put("[喵呜]", R.drawable.weiqu_org);

        emojiMap.put("[v5]", R.drawable.v5_org);

        emojiMap.put("[调戏]", R.drawable.tiaoxi_org);

        emojiMap.put("[打牙]", R.drawable.taihaoxiaole_org);

        emojiMap.put("[手贱]", R.drawable.shoujian_org);

        emojiMap.put("[gbz色]", R.drawable.se_org);

        emojiMap.put("[喷]", R.drawable.pen_org);

        emojiMap.put("[你懂的]", R.drawable.nidongde_org);

        emojiMap.put("[喵]", R.drawable.miaomiao_org);

        emojiMap.put("[美味]", R.drawable.meiwei_org);

        emojiMap.put("[惊恐]", R.drawable.jingkong_org);

        emojiMap.put("[感动]", R.drawable.gandong_org);

        emojiMap.put("[放开]", R.drawable.fangkai_org);

        emojiMap.put("[痴呆]", R.drawable.chidai_org);

        emojiMap.put("[扯脸]", R.drawable.chelian_org);

        emojiMap.put("[不知所措]", R.drawable.buzhisuocuo_org);

        emojiMap.put("[翻白眼]", R.drawable.baiyan_org);

        emojiMap.put("[cc疯掉]", R.drawable.ccfengdiao_org);

        emojiMap.put("[cc吃货]", R.drawable.ccchihuo_org);

        emojiMap.put("[cc疑问]", R.drawable.ccyiwen_org);

        emojiMap.put("[cc老爷]", R.drawable.cclaoye_org);

        emojiMap.put("[cc开心]", R.drawable.cckaixin_org);

        emojiMap.put("[cc怕怕]", R.drawable.ccpapa_org);


        emojiMap.put("[cc鼻血]", R.drawable.ccbixue_org);

        emojiMap.put("[cc没有]", R.drawable.ccmeiyou_org);

        emojiMap.put("[cc晕菜]", R.drawable.ccyuncai_org);

        emojiMap.put("[cc媚眼]", R.drawable.ccmeiyan_org);

        emojiMap.put("[cc鄙视]", R.drawable.ccbishi_org);

        emojiMap.put("[cc委屈]", R.drawable.ccweiqu_org);

        emojiMap.put("[cc革命]", R.drawable.ccgeming_org);

        emojiMap.put("[cc撞墙]", R.drawable.cczhuangqiang_org);

        emojiMap.put("[cc穿越]", R.drawable.ccchuanyue_org);

        emojiMap.put("[cc嘿嘿]", R.drawable.ccheihei_org);

        emojiMap.put("[cc不行]", R.drawable.ccbuxing_org);

        emojiMap.put("[cc大哭]", R.drawable.ccdaku_org);

        emojiMap.put("[cc耍赖]", R.drawable.ccshualai_org);

        emojiMap.put("[cc激动]", R.drawable.ccjidong_org);

        emojiMap.put("[cc哭泣]", R.drawable.cckuqi_org);

        emojiMap.put("[cc亲亲]", R.drawable.ccqinqin_org);

        emojiMap.put("[cc心虚]", R.drawable.ccxinxu_org);

        emojiMap.put("[cc舞动]", R.drawable.ccwudong_org);

        emojiMap.put("[cc数钱]", R.drawable.ccshuqian_org);

        emojiMap.put("[cc抱抱]", R.drawable.ccbaobao_org);

        emojiMap.put("[cc睡觉]", R.drawable.ccshuijiao_org);

        emojiMap.put("[cc僵尸]", R.drawable.ccjiangshi_org);

        emojiMap.put("[cc我踩]", R.drawable.ccwocai_org);

        emojiMap.put("[cc运动]", R.drawable.ccyundong_org);

        emojiMap.put("[cc恭喜]", R.drawable.ccgongxi_org);

        emojiMap.put("[cc歌唱]", R.drawable.ccgechang_org);

        emojiMap.put("[cc无语]", R.drawable.ccwuyu_org);

        emojiMap.put("[cc郁闷]", R.drawable.ccyumen_org);

        emojiMap.put("[cc思考]", R.drawable.ccsikao_org);

        emojiMap.put("[cc惊讶]", R.drawable.ccjingya_org);

        emojiMap.put("[cc得瑟]", R.drawable.ccdese_org);

        emojiMap.put("[cc不嘛]", R.drawable.ccbuma_org);

        emojiMap.put("[cc生气]", R.drawable.ccshengqi_org);

        emojiMap.put("[cc乞讨]", R.drawable.ccqitao_org);

        emojiMap.put("[cc呼啦]", R.drawable.cchula_org);

        emojiMap.put("[cc偷乐]", R.drawable.cctoule_org);

        emojiMap.put("[cc无奈]", R.drawable.ccwunai_org);

        emojiMap.put("[cc蒙面]", R.drawable.ccmengmian_org);

        emojiMap.put("[cc色色]", R.drawable.ccsese_org);

        emojiMap.put("[cc哈哈]", R.drawable.cchaha_org);

        emojiMap.put("[nono微博益起来]", R.drawable.npgongyi_org);

        emojiMap.put("[nono生日快乐]", R.drawable.nonoshengrikuaile_org);

        emojiMap.put("[nono得瑟]", R.drawable.nonodese_org);

        emojiMap.put("[nono卖帅]", R.drawable.nonomaishuai_org);

        emojiMap.put("[nono摇手指]", R.drawable.nonoyaoshouzhi_org);

        emojiMap.put("[nono来呀来呀]", R.drawable.nonolaiyalaiya_org);

        emojiMap.put("[nono哭]", R.drawable.nonoku_org);

        emojiMap.put("[nono挑逗]", R.drawable.nonotiaodou_org);

        emojiMap.put("[nono娇羞]", R.drawable.nonojiuxiu_org);

        emojiMap.put("[nono生病]", R.drawable.nonoshengbing_org);

        emojiMap.put("[nono开心]", R.drawable.nonokaixin_org);

        emojiMap.put("[nono看不见我]", R.drawable.nonokanbujianwo_org);

        emojiMap.put("[nono眨眼]", R.drawable.nonozhayan_org);

        emojiMap.put("[nono大礼包]", R.drawable.nonodalibao_org);

        emojiMap.put("[nono水汪汪]", R.drawable.nonoshuiwangwang_org);

        emojiMap.put("[nonokiss]", R.drawable.nonokiss_org);

        emojiMap.put("[nono圣诞节]", R.drawable.nonoshengdanjie_org);

        emojiMap.put("[nono跳舞]", R.drawable.nonotiaowu_org);

        emojiMap.put("[nono害羞]", R.drawable.nonohaixiu_org);

        emojiMap.put("[nono无语]", R.drawable.nonowuyu_org);

        emojiMap.put("[nono放屁]", R.drawable.nonofangpi_org);

        emojiMap.put("[nono晕]", R.drawable.nonoyun_org);

        emojiMap.put("[nono悠哉跑]", R.drawable.nonoyouzaipao_org);

        emojiMap.put("[nono打哈欠]", R.drawable.nonodahaqian_org);

        emojiMap.put("[nono扭]", R.drawable.nononiu_org);

        emojiMap.put("[nonomua]", R.drawable.nonomua_org);

        emojiMap.put("[nono尴尬]", R.drawable.nonoganga_org);

        emojiMap.put("[nono跑步]", R.drawable.nonopaobu_org);

        emojiMap.put("[nono转圈圈]", R.drawable.nonozhuanquanquan_org);

        emojiMap.put("[nono心心眼]", R.drawable.nonoxinxinyan_org);

        emojiMap.put("[nono睡觉]", R.drawable.nonoshuijiao_org);

        emojiMap.put("[nono星星眼]", R.drawable.nonoxingxingyan_org);

        emojiMap.put("[nono抛小球]", R.drawable.nonopaoxiaoqiu_org);

        emojiMap.put("[nono拜年]", R.drawable.longnianpanda_org);

        emojiMap.put("[dino求人]", R.drawable.dinoqiuren_org);

        emojiMap.put("[dino泪奔]", R.drawable.dinoleiben_org);

        emojiMap.put("[dino害羞]", R.drawable.dinohaixiu_org);

        emojiMap.put("[dino等人]", R.drawable.dinodengren_org);

        emojiMap.put("[dino囧]", R.drawable.dinojiong_org);

        emojiMap.put("[dino抠鼻]", R.drawable.dinokoubi_org);

        emojiMap.put("[dino心碎]", R.drawable.dinoxinsui_org);

        emojiMap.put("[dino撒花]", R.drawable.dinosahua_org);

        emojiMap.put("[dino电筒]", R.drawable.dinodiantong_org);

        emojiMap.put("[dino热]", R.drawable.dinore_org);

        emojiMap.put("[dino坏笑]", R.drawable.dinohuaixiao_org);

        emojiMap.put("[dino礼物]", R.drawable.dinoliwu_org);

        emojiMap.put("[dino晕倒]", R.drawable.dinoyundao_org);

        emojiMap.put("[dino诡异]", R.drawable.dinoguiyi_org);

        emojiMap.put("[dino瞌睡]", R.drawable.dinokeshui_org);

        emojiMap.put("[dino安慰]", R.drawable.dinoanwei_org);

        emojiMap.put("[dino再见]", R.drawable.dinozaijian_org);

        emojiMap.put("[dino甜筒]", R.drawable.dinotiantong_org);

        emojiMap.put("[dino不屑]", R.drawable.dinobuxie_org);

        emojiMap.put("[dino早安]", R.drawable.dinozaoan_org);

        emojiMap.put("[dino高兴]", R.drawable.dinogaoxing_org);

        emojiMap.put("[dino投降]", R.drawable.dinotouxiang_org);

        emojiMap.put("[dino鬼脸]", R.drawable.dinoguilian_org);

        emojiMap.put("[dino吃饭]", R.drawable.dinochifan_org);

        emojiMap.put("[dino失望]", R.drawable.dinoshiwang_org);

        emojiMap.put("[dino数钱]", R.drawable.dinoshuqian_org);

        emojiMap.put("[dino打你]", R.drawable.dinodani_org);

        emojiMap.put("[dino狂叫]", R.drawable.dinokuangjiao_org);

        emojiMap.put("[dino吐血]", R.drawable.dinotuxue_org);

        emojiMap.put("[dino委屈]", R.drawable.dinoweiqu_org);

        emojiMap.put("[dino划圈]", R.drawable.dinohuaquan_org);

        emojiMap.put("[dino发怒]", R.drawable.dinofanu_org);

        emojiMap.put("[dino吃惊]", R.drawable.dinochijing_org);

        emojiMap.put("[dino喝酒]", R.drawable.dinohejiu_org);

        emojiMap.put("[dino咬手帕]", R.drawable.dinoyaoshoupa_org);

        emojiMap.put("[dino臭美]", R.drawable.dinochoumei_org);

        emojiMap.put("[dino困惑]", R.drawable.dinokunhuo_org);

        emojiMap.put("[dino许愿]", R.drawable.dinoxuyuan_org);

        emojiMap.put("[dino打滚]", R.drawable.dinodagun_org);

        emojiMap.put("[yz我倒]", R.drawable.yzwodao_org);

        emojiMap.put("[yz撞玻璃]", R.drawable.yzzhuangboli_org);

        emojiMap.put("[yz淋浴]", R.drawable.yzlinyu_org);

        emojiMap.put("[yz纳尼]", R.drawable.yznani_org);

        emojiMap.put("[yz欢呼]", R.drawable.yzhuanhu_org);

        emojiMap.put("[yz拍桌子]", R.drawable.yzpaizhuozi_org);

        emojiMap.put("[yz光棍]", R.drawable.yzguanglun_org);

        emojiMap.put("[yz哇哇叫]", R.drawable.yzwawajiao_org);

        emojiMap.put("[yz求你了]", R.drawable.yzqiunile_org);

        emojiMap.put("[yz翻滚]", R.drawable.yzfangun_org);

        emojiMap.put("[yz偷着笑]", R.drawable.yztouzhexiao_org);

        emojiMap.put("[yzye]", R.drawable.yzye_org);

        emojiMap.put("[yz投降]", R.drawable.yztouxiang_org);

        emojiMap.put("[yz抽风]", R.drawable.yzchoufeng_org);

        emojiMap.put("[yzoye]", R.drawable.yzoye_org);

        emojiMap.put("[yz撒花]", R.drawable.yzsahua_org);

        emojiMap.put("[yz抱枕头]", R.drawable.yzbaozhentou_org);

        emojiMap.put("[yz甩手绢]", R.drawable.yzshuaishoujuan_org);

        emojiMap.put("[yz右边亮了]", R.drawable.yzyoubianliangle_org);

        emojiMap.put("[yz人呢]", R.drawable.yzrenne_org);

        emojiMap.put("[yz傻兮兮]", R.drawable.yzshaxixi_org);

        emojiMap.put("[yz砸]", R.drawable.yzza_org);

        emojiMap.put("[yz招财猫]", R.drawable.yzzhaocaimao_org);

        emojiMap.put("[yz扇扇子]", R.drawable.yzshanshanzi_org);

        emojiMap.put("[yz不呢]", R.drawable.yzbune_org);

        emojiMap.put("[yz拍屁股]", R.drawable.yzpaipigu_org);

        emojiMap.put("[yz委屈哭]", R.drawable.yzweiquku_org);

        emojiMap.put("[yz听歌]", R.drawable.yztingge_org);

        emojiMap.put("[yz吃瓜]", R.drawable.yzchigua_org);

        emojiMap.put("[yz好哇]", R.drawable.yzhaowa_org);

        emojiMap.put("[yz来看看]", R.drawable.yzlaikankan_org);

        emojiMap.put("[yz焦糖舞]", R.drawable.yzjiaotangwu_org);

        emojiMap.put("[yz放屁]", R.drawable.yzfangpi_org);

        emojiMap.put("[yz吃苹果]", R.drawable.yzchipingguo_org);

        emojiMap.put("[yz太好了]", R.drawable.yztaihaole_org);

        emojiMap.put("[yz好紧张]", R.drawable.yzhaojinzhang_org);

        emojiMap.put("[猥琐]", R.drawable.weisuo_org);

        emojiMap.put("[挑眉]", R.drawable.tiaomei_org);

        emojiMap.put("[挑逗]", R.drawable.tiaodou_org);

        emojiMap.put("[亲耳朵]", R.drawable.qinerduo_org);

        emojiMap.put("[媚眼]", R.drawable.meiyan_org);

        emojiMap.put("[冒个泡]", R.drawable.maogepao_org);

        emojiMap.put("[囧耳朵]", R.drawable.jiongerduo_org);

        emojiMap.put("[鬼脸]", R.drawable.guilian_org);

        emojiMap.put("[放电]", R.drawable.fangdian_org);

        emojiMap.put("[悲剧]", R.drawable.beiju_org);

        emojiMap.put("[抚摸]", R.drawable.touch_org);

        emojiMap.put("[大汗]", R.drawable.sweat_org);

        emojiMap.put("[大惊]", R.drawable.suprise_org);

        emojiMap.put("[惊哭]", R.drawable.supcry_org);

        emojiMap.put("[星星眼]", R.drawable.stareyes_org);

        emojiMap.put("[好困]", R.drawable.sleepy_org);

        emojiMap.put("[呕吐]", R.drawable.sick_org);

        emojiMap.put("[加我一个]", R.drawable.plus1_org);

        emojiMap.put("[痞痞兔耶]", R.drawable.pipioye_org);

        emojiMap.put("[mua]", R.drawable.muamua_org);

        emojiMap.put("[面抽]", R.drawable.mianchou_org);

        emojiMap.put("[大笑]", R.drawable.laugh_org);

        emojiMap.put("[揉]", R.drawable.knead_org);

        emojiMap.put("[痞痞兔囧]", R.drawable.jiong_org);

        emojiMap.put("[哈尼兔耶]", R.drawable.honeyoye_org);

        emojiMap.put("[开心]", R.drawable.happy_org);

        emojiMap.put("[咬手帕]", R.drawable.handkerchief_org);

        emojiMap.put("[去]", R.drawable.go_org);

        emojiMap.put("[晕死了]", R.drawable.dizzy_org);

        emojiMap.put("[大哭]", R.drawable.cry_org);

        emojiMap.put("[扇子遮面]", R.drawable.coverface_org);

        emojiMap.put("[怒气]", R.drawable.angery_org);


        emojiMap.put("[白羊]", R.drawable.byz2_org);

        emojiMap.put("[射手]", R.drawable.ssz2_org);

        emojiMap.put("[双鱼]", R.drawable.syz2_org);

        emojiMap.put("[双子]", R.drawable.szz2_org);

        emojiMap.put("[天秤]", R.drawable.tpz2_org);

        emojiMap.put("[天蝎]", R.drawable.txz2_org);

        emojiMap.put("[水瓶]", R.drawable.spz2_org);

        emojiMap.put("[处女]", R.drawable.cnz2_org);

        emojiMap.put("[金牛]", R.drawable.jnz2_org);

        emojiMap.put("[巨蟹]", R.drawable.jxz2_org);

        emojiMap.put("[狮子]", R.drawable.leo2_org);

        emojiMap.put("[摩羯]", R.drawable.mjz2_org);

        emojiMap.put("[天蝎座]", R.drawable.txz_org);

        emojiMap.put("[天秤座]", R.drawable.tpz_org);

        emojiMap.put("[双子座]", R.drawable.szz_org);

        emojiMap.put("[双鱼座]", R.drawable.syz_org);

        emojiMap.put("[射手座]", R.drawable.ssz_org);

        emojiMap.put("[水瓶座]", R.drawable.spz_org);

        emojiMap.put("[摩羯座]", R.drawable.mjz_org);

        emojiMap.put("[狮子座]", R.drawable.leo_org);

        emojiMap.put("[巨蟹座]", R.drawable.jxz_org);

        emojiMap.put("[金牛座]", R.drawable.jnz_org);

        emojiMap.put("[处女座]", R.drawable.cnz_org);

        emojiMap.put("[白羊座]", R.drawable.byz_org);

        emojiMap.put("[爱心传递]", R.drawable.aixincd_org);

        emojiMap.put("[zxh得瑟]", R.drawable.zxhdese_org);

        emojiMap.put("[微微笑]", R.drawable.xiaoheweixiao_org);

        emojiMap.put("[特委屈]", R.drawable.xiaoheweiqu_org);

        emojiMap.put("[我吐]", R.drawable.xiaohetua_org);

        emojiMap.put("[很生气]", R.drawable.xiaoheshengqi_org);

        emojiMap.put("[流鼻涕]", R.drawable.xiaoheliubiti_org);

        emojiMap.put("[默默哭泣]", R.drawable.xiaohekuqi_org);

        emojiMap.put("[小盒汗]", R.drawable.xiaohehan_org);

        emojiMap.put("[发呆中]", R.drawable.xiaohefadai_org);

        emojiMap.put("[不理你]", R.drawable.xiaohebulini_org);

        emojiMap.put("[强烈鄙视]", R.drawable.xiaohebishi_org);

        emojiMap.put("[烦躁]", R.drawable.fanzao_org);

        emojiMap.put("[呲牙]", R.drawable.ciya_org);

        emojiMap.put("[有钱]", R.drawable.youqian_org);

        emojiMap.put("[微笑旧]", R.drawable.weixiao_org);

        emojiMap.put("[帅爆]", R.drawable.shuaibao_org);

        emojiMap.put("[生气]", R.drawable.shengqi_org);

        emojiMap.put("[生病了]", R.drawable.shengbing_org);

        emojiMap.put("[色眯眯]", R.drawable.semimi_org);

        emojiMap.put("[疲劳]", R.drawable.pilao_org);

        emojiMap.put("[瞄]", R.drawable.miao_org);

        emojiMap.put("[哭]", R.drawable.ku_org);

        emojiMap.put("[好可怜]", R.drawable.kelian_org);

        emojiMap.put("[紧张]", R.drawable.jinzhang_org);

        emojiMap.put("[惊讶]", R.drawable.jingya_org);

        emojiMap.put("[激动]", R.drawable.jidong_org);

        emojiMap.put("[见钱]", R.drawable.jianqian_org);

        emojiMap.put("[汗了]", R.drawable.han_org);

        emojiMap.put("[奋斗]", R.drawable.fendou_org);

        emojiMap.put("[小人得志]", R.drawable.xrdz_org);

        emojiMap.put("[哇哈哈]", R.drawable.whh_org);

        emojiMap.put("[叹气]", R.drawable.tq_org);

        emojiMap.put("[冻结]", R.drawable.sjdj_org);

        emojiMap.put("[切]", R.drawable.q_org);

        emojiMap.put("[悠嘻猴拍照]", R.drawable.pz_org);

        emojiMap.put("[怕怕]", R.drawable.pp_org);

        emojiMap.put("[怒吼]", R.drawable.nh_org);

        emojiMap.put("[膜拜]", R.drawable.mb2_org);

        emojiMap.put("[路过]", R.drawable.lg_org);

        emojiMap.put("[泪奔]", R.drawable.lb_org);

        emojiMap.put("[脸变色]", R.drawable.lbs_org);

        emojiMap.put("[亲]", R.drawable.kiss_org);

        emojiMap.put("[恐怖]", R.drawable.kb_org);

        emojiMap.put("[交给我吧]", R.drawable.jgwb_org);

        emojiMap.put("[欢欣鼓舞]", R.drawable.hxgw_org);

        emojiMap.put("[高兴]", R.drawable.gx3_org);

        emojiMap.put("[尴尬]", R.drawable.gg_org);

        emojiMap.put("[发嗲]", R.drawable.fd_org);

        emojiMap.put("[犯错]", R.drawable.fc_org);

        emojiMap.put("[得意]", R.drawable.dy_org);

        emojiMap.put("[吵闹]", R.drawable.cn_org);

        emojiMap.put("[冲锋]", R.drawable.cf_org);

        emojiMap.put("[抽耳光]", R.drawable.ceg_org);

        emojiMap.put("[差得远呢]", R.drawable.cdyn_org);

        emojiMap.put("[被砸]", R.drawable.bz2_org);

        emojiMap.put("[拜托]", R.drawable.bt_org);

        emojiMap.put("[必胜]", R.drawable.bs3_org);

        emojiMap.put("[不关我事]", R.drawable.bgws_org);

        emojiMap.put("[上火]", R.drawable.bf_org);

        emojiMap.put("[不倒翁]", R.drawable.bdw_org);

        emojiMap.put("[不错哦]", R.drawable.bco_org);

        emojiMap.put("[yeah]", R.drawable.yeah_org);

        emojiMap.put("[喜欢]", R.drawable.xh_org);

        emojiMap.put("[心动]", R.drawable.xd_org);

        emojiMap.put("[无聊]", R.drawable.wl_org);

        emojiMap.put("[手舞足蹈]", R.drawable.gx_org);

        emojiMap.put("[搞笑]", R.drawable.gx2_org);

        emojiMap.put("[痛哭]", R.drawable.gd_org);

        emojiMap.put("[爆发]", R.drawable.fn2_org);

        emojiMap.put("[发奋]", R.drawable.d2_org);

        emojiMap.put("[不屑]", R.drawable.bx_org);

        emojiMap.put("[dx拜年]", R.drawable.longniandx_org);

        emojiMap.put("[dx炸弹]", R.drawable.daxiongzhadan_org);

        emojiMap.put("[dx洗澡]", R.drawable.daxiongxizao_org);

        emojiMap.put("[dx握爪]", R.drawable.daxiongwozhua_org);

        emojiMap.put("[dx数落]", R.drawable.daxiongshuluo_org);

        emojiMap.put("[dx刷牙]", R.drawable.daxiongshuaya_org);

        emojiMap.put("[dx傻]", R.drawable.daxiongsha_org);

        emojiMap.put("[dx晒]", R.drawable.daxiongshai_org);

        emojiMap.put("[dx抛媚眼]", R.drawable.daxiongpaomeiyan_org);

        emojiMap.put("[dx拍拍手]", R.drawable.daxiongpaipaishou_org);

        emojiMap.put("[dx耶]", R.drawable.daxiongoye_org);

        emojiMap.put("[dx扭]", R.drawable.daxiongniu_org);

        emojiMap.put("[dx没有]", R.drawable.daxiongmeiyou_org);

        emojiMap.put("[dx卖萌]", R.drawable.daxiongmaimeng_org);

        emojiMap.put("[dx脸红]", R.drawable.daxionglianhong_org);

        emojiMap.put("[dx泪奔]", R.drawable.daxiongleibenxiong_org);

        emojiMap.put("[dx加油]", R.drawable.daxiongjiayouxiong_org);

        emojiMap.put("[dx脚踏车]", R.drawable.daxiongjiaotache_org);

        emojiMap.put("[dx花心]", R.drawable.daxionghuaxin_org);

        emojiMap.put("[dx欢乐]", R.drawable.daxionghuanle_org);

        emojiMap.put("[dx滑板]", R.drawable.daxionghuaban_org);

        emojiMap.put("[dx倒]", R.drawable.daxiongdao_org);

        emojiMap.put("[dx超人]", R.drawable.daxiongchaoren_org);

        emojiMap.put("[dx饱]", R.drawable.daxiongbao_org);

        emojiMap.put("[dx哎]", R.drawable.daxiongai_org);

        emojiMap.put("[笑哈哈]", R.drawable.lxhwahaha_org);

        emojiMap.put("[转发]", R.drawable.lxhzhuanfa_org);

        emojiMap.put("[得意地笑]", R.drawable.lxhdeyidixiao_org);

        emojiMap.put("[噢耶]", R.drawable.lxhxixi_org);

        emojiMap.put("[偷乐]", R.drawable.lxhtouxiao_org);

        emojiMap.put("[泪流满面]", R.drawable.lxhtongku_org);

        emojiMap.put("[巨汗]", R.drawable.lxhjuhan_org);

        emojiMap.put("[抠鼻屎]", R.drawable.lxhkoubishi_org);

        emojiMap.put("[求关注]", R.drawable.lxhqiuguanzhu_org);

        emojiMap.put("[真V5]", R.drawable.lxhv5_org);

        emojiMap.put("[群体围观]", R.drawable.lxhweiguan_org);

        emojiMap.put("[hold住]", R.drawable.lxhholdzhu_org);

        emojiMap.put("[羞嗒嗒]", R.drawable.lxhxiudada_org);

        emojiMap.put("[非常汗]", R.drawable.lxhpubuhan_org);

        emojiMap.put("[许愿]", R.drawable.lxhxuyuan_org);

        emojiMap.put("[崩溃]", R.drawable.lxhzhuakuang_org);

        emojiMap.put("[好囧]", R.drawable.lxhhaojiong_org);

        emojiMap.put("[震惊]", R.drawable.lxhchijing_org);

        emojiMap.put("[别烦我]", R.drawable.lxhbiefanwo_org);

        emojiMap.put("[不好意思]", R.drawable.lxhbuhaoyisi_org);

        emojiMap.put("[纠结]", R.drawable.lxhjiujie_org);

        emojiMap.put("[拍手]", R.drawable.lxhguzhang_org);

        emojiMap.put("[给劲]", R.drawable.lxhgeili_org);

        emojiMap.put("[好喜欢]", R.drawable.lxhlike_org);

        emojiMap.put("[好爱哦]", R.drawable.lxhainio_org);

        emojiMap.put("[路过这儿]", R.drawable.lxhluguo_org);

        emojiMap.put("[悲催]", R.drawable.lxhbeicui_org);

        emojiMap.put("[不想上班]", R.drawable.lxhbuxiangshangban_org);

        emojiMap.put("[躁狂症]", R.drawable.lxhzaokuangzheng_org);

        emojiMap.put("[甩甩手]", R.drawable.lxhshuaishuaishou_org);

        emojiMap.put("[瞧瞧]", R.drawable.lxhqiaoqiao_org);

        emojiMap.put("[同意]", R.drawable.lxhtongyi_org);

        emojiMap.put("[喝多了]", R.drawable.lxhheduole_org);

        emojiMap.put("[啦啦啦啦]", R.drawable.lxhlalalala_org);

        emojiMap.put("[杰克逊]", R.drawable.lxhjiekexun_org);

        emojiMap.put("[雷锋]", R.drawable.lxhleifeng_org);

        emojiMap.put("[带感]", R.drawable.lxhdaigan_org);

        emojiMap.put("[亲一口]", R.drawable.lxhqinyikou_org);

        emojiMap.put("[飞个吻]", R.drawable.lxhblowakiss_org);

        emojiMap.put("[加油啊]", R.drawable.lxhjiayou_org);

        emojiMap.put("[七夕]", R.drawable.lxhqixi_org);

        emojiMap.put("[困死了]", R.drawable.lxhkunsile_org);

        emojiMap.put("[有鸭梨]", R.drawable.lxhyouyali_org);

        emojiMap.put("[右边亮了]", R.drawable.lxhliangle_org);

        emojiMap.put("[撒花]", R.drawable.lxhfangjiala_org);

        emojiMap.put("[好棒]", R.drawable.lxhhaobang_org);

        emojiMap.put("[想一想]", R.drawable.lxhxiangyixiang_org);

        emojiMap.put("[下班]", R.drawable.lxhxiaban_org);

        emojiMap.put("[最右]", R.drawable.lxhzuiyou_org);

        emojiMap.put("[丘比特]", R.drawable.lxhqiubite_org);

        emojiMap.put("[中箭]", R.drawable.lxhzhongjian_org);

        emojiMap.put("[互相膜拜]", R.drawable.lxhhuxiangmobai_org);

        emojiMap.put("[膜拜了]", R.drawable.lxhmobai_org);

        emojiMap.put("[放电抛媚]", R.drawable.lxhfangdianpaomei_org);

        emojiMap.put("[霹雳]", R.drawable.lxhshandian_org);

        emojiMap.put("[被电]", R.drawable.lxhbeidian_org);

        emojiMap.put("[拍砖]", R.drawable.lxhpaizhuan_org);

        emojiMap.put("[互相拍砖]", R.drawable.lxhhuxiangpaizhuan_org);

        emojiMap.put("[采访]", R.drawable.lxhcaifang_org);

        emojiMap.put("[发表言论]", R.drawable.lxhfabiaoyanlun_org);

        emojiMap.put("[江南style]", R.drawable.gangnamstyle_org);

        emojiMap.put("[牛]", R.drawable.lxhniu_org);

        emojiMap.put("[玫瑰]", R.drawable.lxhrose_org);

        emojiMap.put("[赞啊]", R.drawable.lxhzan_org);

        emojiMap.put("[推荐]", R.drawable.lxhtuijian_org);

        emojiMap.put("[放假啦]", R.drawable.lxhfangjiale_org);

        emojiMap.put("[萌翻]", R.drawable.lxhmengfan_org);

        emojiMap.put("[吃货]", R.drawable.lxhgreedy_org);

        emojiMap.put("[大南瓜]", R.drawable.lxhpumpkin_org);

        emojiMap.put("[立志青年]", R.drawable.lxhlizhiqingnian_org);

        emojiMap.put("[得瑟]", R.drawable.lxhdese_org);

        emojiMap.put("[月儿圆]", R.drawable.lxhyueeryuan_org);

        emojiMap.put("[微博三岁啦]", R.drawable.lxhweibo3yr_org);

        emojiMap.put("[复活节]", R.drawable.lxhfuhuojie_org);

        emojiMap.put("[愚人节]", R.drawable.lxhyurenjie_org);

        emojiMap.put("[收藏]", R.drawable.lxhshoucang_org);

        emojiMap.put("[喜得金牌]", R.drawable.lxhhappygold_org);

        emojiMap.put("[夺冠感动]", R.drawable.lxhduoguan_org);

        emojiMap.put("[冠军诞生]", R.drawable.lxhguanjun_org);

        emojiMap.put("[传火炬]", R.drawable.lxhchuanhuoju_org);

        emojiMap.put("[奥运金牌_旧]", R.drawable.lxhgold_org);

        emojiMap.put("[奥运银牌_旧]", R.drawable.lxhbronze_org);

        emojiMap.put("[奥运铜牌_旧]", R.drawable.lxhsilver_org);

        emojiMap.put("[德国加油]", R.drawable.germany_org);

        emojiMap.put("[西班牙队加油]", R.drawable.spain_org);

        emojiMap.put("[葡萄牙队加油]", R.drawable.portugal_org);

        emojiMap.put("[意大利队加油]", R.drawable.italy_org);

        emojiMap.put("[耍花灯]", R.drawable.lxhshuahuadeng_org);

        emojiMap.put("[元宵快乐]", R.drawable.lxhyuanxiaohappy_org);

        emojiMap.put("[吃元宵]", R.drawable.lxhchitangyuan_org);

        emojiMap.put("[金元宝]", R.drawable.lxhjinyuanbao_org);

        emojiMap.put("[红包拿来]", R.drawable.lxhhongbaonalai_org);

        emojiMap.put("[福到啦]", R.drawable.lxhfudaola_org);

        emojiMap.put("[放鞭炮]", R.drawable.lxhbianpao_org);

        emojiMap.put("[大红灯笼]", R.drawable.lxhdahongdenglong_org);

        emojiMap.put("[拜年了]", R.drawable.lxhbainianle_org);

        emojiMap.put("[龙啸]", R.drawable.lxhlongxiao_org);

        emojiMap.put("[光棍节]", R.drawable.lxh1111_org);

        emojiMap.put("[带着微博去旅行]", R.drawable.eventtravel_org);

        emojiMap.put("[爱红包]", R.drawable.aihongbao_org);

        emojiMap.put("[拍照]", R.drawable.lxhpz_org);

        emojiMap.put("[发红包]", R.drawable.fahongbao_org);

        emojiMap.put("[冰桶挑战]", R.drawable.bttz_org);

        emojiMap.put("[欢乐购车季]", R.drawable.hlgcj_org);

        emojiMap.put("[去旅行]", R.drawable.qlx_org);

        emojiMap.put("[肥皂]", R.drawable.soap_org);

        emojiMap.put("[马上拜年]", R.drawable.mashangbainian_org);

        emojiMap.put("[求红包]", R.drawable.lxhhongbao2014_org);

        emojiMap.put("[微公益爱心]", R.drawable.lxhgongyi_org);

        emojiMap.put("[会员一周年]", R.drawable.vipanniversary_org);

        emojiMap.put("[蛇年快乐]", R.drawable.lxhshenian_org);

        emojiMap.put("[过年啦]", R.drawable.lxhguonianla_org);

        emojiMap.put("[圆蛋快乐]", R.drawable.lxhyuandan_org);

        emojiMap.put("[发礼物]", R.drawable.lxh_santa_org);

        emojiMap.put("[要礼物]", R.drawable.lxh_gift_org);

        emojiMap.put("[平安果]", R.drawable.lxh_apple_org);

        emojiMap.put("[吓到了]", R.drawable.lxhscare_org);

        emojiMap.put("[走你]", R.drawable.zouni_org);

        emojiMap.put("[吐血]", R.drawable.lxhtuxue_org);

        emojiMap.put("[好激动]", R.drawable.lxhjidong_org);

        emojiMap.put("[没人疼]", R.drawable.lxhlonely_org);

        emojiMap.put("[招财]", R.drawable.lxhzhaocai_org);

        emojiMap.put("[挤火车]", R.drawable.lxhjihuoche_org);

        emojiMap.put("[赶火车]", R.drawable.lxhganhuoche_org);
    }


    public static int getImgByName(String imgName) {
        Integer integer = emojiMap.get(imgName);
        System.out.println("get到了吗"+integer);
        return integer == null ? -1 : integer;
    }

//    public static List<Emotions> getEmotionsList(String access_token) {
//        OkHttpClient client = new OkHttpClient();
//        access_token = "https://api.weibo.com/2/emotions.json?access_token=" + access_token;
//        System.out.println("有没1" + access_token);
//        Request request = new Request.Builder()
//                .url(access_token)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("表情返回失败");
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                final String responesText = response.body().string();
//                test=responesText;
//                Gson gson = new Gson();
//                EmotionList list = gson.fromJson(responesText, EmotionList.class);
//                System.out.println("到这里了"+list.toString());
//                emotionsList= list.getEmotions();
//            }
//        });
//        return emotionsList;
//    }
//
//
//    public static Bitmap getImgByName(String imgName, String access_token) {
//        getEmotionsList(access_token);
//        System.out.println("测试"+test);
//        Bitmap emoji = null;
//        System.out.println("名字是" + imgName + "," + emotionsList.size());
//        for (Emotions em :
//                emotionsList) {
//            if (em.getPhrase().equals(imgName)) {
//
//                try {
//                    URL url = new URL(em.getUrl());
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setDoInput(true);
//                    connection.connect();
//                    InputStream input = connection.getInputStream();
//                    emoji = BitmapFactory.decodeStream(input);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//        return emoji == null ? null : emoji;
//    }
}
