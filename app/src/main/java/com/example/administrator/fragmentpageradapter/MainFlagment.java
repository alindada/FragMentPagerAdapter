package com.example.administrator.fragmentpageradapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/24.
 */

public class MainFlagment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private RecyclerView recyclerView;
    private Button test_add;
    private ArrayList<String> datas;
    private  RecyclerViewAdapter cycAdapter;
    public static MainFlagment getMainFlagment(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("test", "gotest");
        MainFlagment flagment = new MainFlagment();
        flagment.setArguments(bundle);
        return flagment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.tv_title);
        recyclerView = (RecyclerView) view.findViewById(R.id.main_rlv);
        test_add = (Button) view.findViewById(R.id.test_add);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ///  Bundle bundle =getArguments();
        //  String title= bundle.getString("test");
        //  textView.setText(title);
        datas = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            datas.add("content" + i);
        }

        cycAdapter = new RecyclerViewAdapter(this.getActivity(), datas);
        recyclerView.setAdapter(cycAdapter);
        recyclerView.scrollToPosition(0);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        test_add .setOnClickListener(this);

        cycAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, String data) {
                Toast.makeText(getActivity(),data,Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Integer aaa= view.getId();
        switch (view.getId()){
            case  R.id.test_add:
                cycAdapter.addData(0,"new content");
                recyclerView.scrollToPosition(0);
                Toast.makeText(getActivity(),"add",Toast.LENGTH_SHORT);
                Log.d("show","add");
                break;
            case R.id.test_del:
                FragmentManager suppmanager= getActivity(). getSupportFragmentManager();
                FragmentTransaction transaction =suppmanager.beginTransaction();
                transaction.replace(R.id.main_frame,new MainFlagmenta());
                break;

        }
    }
}
