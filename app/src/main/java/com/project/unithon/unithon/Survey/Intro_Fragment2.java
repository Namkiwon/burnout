package com.project.unithon.unithon.Survey;


import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class Intro_Fragment2 extends Fragment {

    Button start_survey;
    public Intro_Fragment2()
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
        View view = inflater.inflate(R.layout.fragment_intro2,null);
        start_survey = (Button) view.findViewById(R.id.btn_startsurvey);
        start_survey.setOnClickListener(bListener);
        return view;
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_startsurvey:
                    Intent intent = new Intent(getActivity(),FirstSurveyActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
