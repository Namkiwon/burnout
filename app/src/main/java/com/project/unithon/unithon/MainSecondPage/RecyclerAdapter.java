package com.project.unithon.unithon.MainSecondPage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.project.unithon.unithon.R;

import java.util.ArrayList;


/**
 * Created by namgiwon on 2018. 1. 23..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder>{
    ArrayList<ListviewVO> items;
    Context context;
    public RecyclerAdapter(Context context ,ArrayList<ListviewVO> items){
        this.context = context;
        this.items = items;
    }

    public void add(ListviewVO item) {
        this.items.add(item);
        notifyItemInserted(items.size()-1);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.think_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ListviewVO item = items.get(position);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

}
