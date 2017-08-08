package com.example.wean.weebo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wean.weebo.R;
import com.example.wean.weebo.adapter.WeiboAdapter;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.gson.User;
import com.example.wean.weebo.gson.Weibo;
import com.example.wean.weebo.utils.Image;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String access_token;
    private String uid;

    private RecyclerView recyclerView;
    private WeiboAdapter adapter;
    private List<List<Image>> imagesList;


    private TextView name;
    private TextView description;
    private TextView weibo_count;
    private TextView people_count;
    private TextView fans_count;
    private User user;

    private OnFragmentInteractionListener mListener;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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
            uid=getArguments().getString("uid");
            System.out.println("UserFragement接受到的acode：" + access_token);
        }
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        name= (TextView) view.findViewById(R.id.tv_name);
        description= (TextView) view.findViewById(R.id.description);
        weibo_count= (TextView) view.findViewById(R.id.weibo_count);
        people_count= (TextView) view.findViewById(R.id.people_count);
        fans_count= (TextView) view.findViewById(R.id.fans_count);
        recyclerView = (RecyclerView) view.findViewById(R.id.user_weibo);


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

    public void getUserInfo(){
        OkHttpClient client = new OkHttpClient();
        String url2="https://api.weibo.com/2/statuses/user_timeline.json?access_token="+access_token;
        access_token = "https://api.weibo.com/2/users/show.json?access_token=" + access_token+"&uid="+uid;
        Request request = new Request.Builder()
                .url(access_token)
                .build();

        Request request1=new Request.Builder()
                .url(url2)
                .build();
        Call call = client.newCall(request);
        Call call1=client.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    final String responesText = response.body().string();
                    Gson gson = new Gson();
                    User us = gson.fromJson(responesText, User.class);

                    @Override
                    public void run() {
                        System.out.println("weiboshu:"+us.getStatuses_count());
                        name.setText(us.getScreen_name());
                        description.setText(us.getDescription());
                        weibo_count.setText(us.getStatuses_count());
                        people_count.setText(us.getFriends_count());
                        fans_count.setText(us.getFollowers_count());
//                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                        recyclerView.setLayoutManager(layoutManager);
//                        List<Statuses> list = weibo.getStatuses();
//
//
//                        adapter = new WeiboAdapter(weibo.getStatuses(), imagesList);
//                        recyclerView.setAdapter(adapter);
//
                    }
                });
            }
        });
        call1.enqueue(new Callback() {
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


                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
//                        List<Statuses> list = weibo.getStatuses();


                        adapter = new WeiboAdapter(weibo.getStatuses(), imagesList,access_token);
                        recyclerView.setAdapter(adapter);

                    }
                });
            }
        });

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getUserInfo();
    }
}
