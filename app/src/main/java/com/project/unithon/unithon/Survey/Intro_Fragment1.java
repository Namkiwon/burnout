package com.project.unithon.unithon.Survey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class Intro_Fragment1 extends Fragment {
    public Intro_Fragment1()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_intro1,null);
        return view;
    }
}
