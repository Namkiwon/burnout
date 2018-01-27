package com.project.unithon.unithon.Fragment;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class ThirdFragment extends Fragment {
    public ThirdFragment()
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
        View view = inflater.inflate(R.layout.fragment_third,null);
        return view;
    }
}
