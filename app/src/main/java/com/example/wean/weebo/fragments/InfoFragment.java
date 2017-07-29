package com.example.wean.weebo.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wean.weebo.R;
import com.example.wean.weebo.adapter.WeiboAdapter;
import com.example.wean.weebo.gson.Pic_urls;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.gson.Weibo;
import com.example.wean.weebo.utils.Image;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int UPDATE_WEIBO = 1;
    private static final String TAG = "InfoFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String access_token;

    private OnFragmentInteractionListener mListener;
    private WeiboAdapter adapter;
    private List<Statuses> weibolist = new ArrayList<>();
    private RecyclerView recyclerView;
    private List<List<Image>> imagesList;
    private List<Pic_urls> itemList;

    private String[][] images = new String[][]{
            {"file:///android_asset/img2.jpg", "250", "250"}
            , {"http://img3.douban.com/view/photo/photo/public/p2249526036.jpg", "640", "960"}
            , {"file:///android_asset/img3.jpg", "250", "250"}
            , {"file:///android_asset/img4.jpg", "250", "250"}
            , {"file:///android_asset/img5.jpg", "250", "250"}
            , {"file:///android_asset/img6.jpg", "250", "250"}
            , {"file:///android_asset/img7.jpg", "250", "250"}
            , {"file:///android_asset/img8.jpg", "250", "250"}
            , {"file:///android_asset/img8.jpg", "250", "250"}
    };

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            access_token = getArguments().getString("access_token");
            System.out.println("Fragement接受到的acode：" + access_token);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void getWeibo() {
        OkHttpClient client = new OkHttpClient();
        access_token = "https://api.weibo.com/2/statuses/home_timeline.json?access_token="+access_token;
        Request request = new Request.Builder()
                .url(access_token)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    final String responesText = response.body().string();
                    Gson gson = new Gson();
                    Weibo weibo = gson.fromJson(responesText, Weibo.class);

                    @Override
                    public void run() {
                        Log.w(TAG, "run: response is "+responesText );

                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
//                        initData();
                        List<Statuses> list=weibo.getStatuses();


                        adapter = new WeiboAdapter(weibo.getStatuses(), imagesList);
                        recyclerView.setAdapter(adapter);
                        Log.w(TAG, "run: "+imagesList );
                    }
                });
            }
        });

    }


    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getWeibo();


    }


    private void initData() {
        imagesList=new ArrayList<>();
        //这里单独添加一条单条的测试数据，用来测试单张的时候横竖图片的效果
        ArrayList<Image> singleList=new ArrayList<>();
        singleList.add(new Image(images[8][0],Integer.parseInt(images[8][1]),Integer.parseInt(images[8][2])));
        imagesList.add(singleList);
        //从一到9生成9条朋友圈内容，分别是1~9张图片
        for(int i=0;i<9;i++){
            ArrayList<Image> itemList=new ArrayList<>();
            for(int j=0;j<=i;j++){
                itemList.add(new Image(images[j][0],Integer.parseInt(images[j][1]),Integer.parseInt(images[j][2])));
            }
            imagesList.add(itemList);
        }
    }
}
