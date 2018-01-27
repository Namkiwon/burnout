package com.project.unithon.unithon.MainFirstPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 23..
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView wisesaying;


    public ItemViewHolder(View itemView){
        super(itemView);
        wisesaying = (TextView) itemView.findViewById(R.id.wisesaying);
    }
}
