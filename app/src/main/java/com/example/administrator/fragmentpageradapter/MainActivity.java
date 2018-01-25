package com.example.administrator.fragmentpageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MainAdapter adapter;

   //  private ArrayList<String> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_vp);



        SparseArray<Fragment> ments = new SparseArray<Fragment>();
        ments.put(0, new MainFlagment());
        ments.put(1, new MainFlagmenta());
        ments.put(2, new MainFlagmentb());
        ments.put(3, new MainFlagmentc());
        adapter = new MainAdapter(getSupportFragmentManager(), ments);

        viewPager.setAdapter(adapter);

     /*   FragmentManager suppmanager= getSupportFragmentManager();
        FragmentTransaction  transaction =suppmanager.beginTransaction();
        transaction.replace(R.layout.fragment_a,new MainFlagmenta());*/

       /* datas =new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            datas.add("content" + i);
        }
        RecyclerViewAdapter cycAdapter =new  RecyclerViewAdapter(MainActivity.this,datas);*/
       //recyclerView.setAdapter(cycAdapter);

     //   recyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
    }
}
