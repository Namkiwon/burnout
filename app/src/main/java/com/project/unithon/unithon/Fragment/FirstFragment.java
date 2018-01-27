package com.project.unithon.unithon.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class FirstFragment extends Fragment {
    SharedMemory sharedMemory;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        sharedMemory = SharedMemory.getinstance();
        View view = inflater.inflate(R.layout.fragment_first,null);

        TextView token = (TextView) view.findViewById(R.id.token);
        token.setText(sharedMemory.getUserinfo().getToken());
        return view;
    }



}
