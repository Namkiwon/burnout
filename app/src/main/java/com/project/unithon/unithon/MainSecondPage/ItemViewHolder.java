package com.project.unithon.unithon.MainSecondPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.unithon.unithon.R;


/**
 * Created by namgiwon on 2018. 1. 23..
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView a;
    public TextView b;
    public TextView c;
    public LinearLayout ll;


    public ItemViewHolder(View itemView){
        super(itemView);
        a = (TextView) itemView.findViewById(R.id.a);
        b = (TextView) itemView.findViewById(R.id.b);
        c = (TextView) itemView.findViewById(R.id.c);
        ll = (LinearLayout) itemView.findViewById(R.id.contnets);
    }
}
