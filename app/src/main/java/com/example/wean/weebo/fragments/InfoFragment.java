package com.example.wean.weebo.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wean.weebo.R;
import com.example.wean.weebo.activities.CommentActivity;
import com.example.wean.weebo.activities.MainActivity;
import com.example.wean.weebo.adapter.WeiboAdapter;
import com.example.wean.weebo.gson.Pic_urls;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.gson.Weibo;
import com.example.wean.weebo.utils.Image;
import com.google.gson.Gson;
import com.wingsofts.byeburgernavigationview.ByeBurgerBehavior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class InfoFragment extends Fragment implements MainActivity.MyOnTouchListener, GestureDetector.OnGestureListener {
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
    private BottomNavigationView navigationView;

    private GestureDetector detector;





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
        final GestureDetector mGestureDetector = new GestureDetector(
                getActivity(), this);
        MainActivity.MyOnTouchListener myOnTouchListener = new MainActivity.MyOnTouchListener() {
            @Override
            public boolean onTouch(MotionEvent ev) {
                boolean result = mGestureDetector.onTouchEvent(ev);
                return result;
            }

            @Override
            public void send(BottomNavigationView view) {

            }
        };

        ((MainActivity) getActivity())
                .registerMyOnTouchListener(myOnTouchListener);

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

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (e1.getY() - e2.getY() < -20) {
//                Toast.makeText(getContext(),"upupup",Toast.LENGTH_SHORT).show();
                return true;
            } else if (e1.getY() - e2.getY() > 20) {
//                Toast.makeText(getContext(),"隐藏操作",Toast.LENGTH_SHORT).show();
                navigationView.setEnabled(false);
                ByeBurgerBehavior.from(navigationView).hide();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean onTouch(MotionEvent ev) {
        return false;
    }

    @Override
    public void send(BottomNavigationView view) {
        navigationView=view;
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
        String acc="https://api.weibo.com/2/statuses/home_timeline.json?access_token=" + access_token;
        Request request = new Request.Builder()
                .url(acc)
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
                        Log.w(TAG, "run: response is " + responesText);

                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
//                        List<Statuses> list = weibo.getStatuses();


                        adapter = new WeiboAdapter(weibo.getStatuses(), imagesList,access_token);
                        recyclerView.setAdapter(adapter);
                        Log.w(TAG, "run: " + imagesList);
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
        MainActivity.Data data = new MainActivity.Data(this);//实例化data类
        data.sends();//启动发送

    }




}
