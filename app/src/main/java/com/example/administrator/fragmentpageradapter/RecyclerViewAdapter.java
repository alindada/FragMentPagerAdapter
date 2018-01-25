package com.example.administrator.fragmentpageradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/24.
 */

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.MyHolder> {
    private ArrayList<String> datas;
    private final Context context;

    public RecyclerViewAdapter(Context c, ArrayList<String> s) {
        this.context = c;
        this.datas = s;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(context, R.layout.item_recyclerview, null));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String data = datas.get(position);
        holder.textView.setText(data);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(int i, String s) {
        datas.add(i,s);
        notifyItemInserted(0);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.main_icon);
            textView = (TextView) v.findViewById(R.id.main_title);
            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(view,datas.get(getLayoutPosition()));
                    }
                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Log.i("showa","");
                    Integer posi=getLayoutPosition();
                    datas.remove(posi);
                    notifyItemRemoved(posi);
                    return  true;
                }
            });
        }
    }

    public  interface  OnItemClickListener{

        public  void  OnItemClick(View view, String data);
    }
    public  OnItemClickListener onItemClickListener;

    public  void  SetOnItemClickListener(OnItemClickListener listener){

        this.onItemClickListener=listener;
    }
}
