package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class FirstSurveyActivity extends AppCompatActivity{
    private Button next;
    SharedMemory sharedMemory;
    private Spinner spinner_sex;
    private Spinner spinner_age;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstsurvey);
        getSupportActionBar().setTitle("Survey");

        sharedMemory = SharedMemory.getinstance();
        next = (Button) findViewById(R.id.firstsurvey_next);
        next.setOnClickListener(bListener);

        spinner_age = (Spinner) findViewById(R.id.spinner_age);
        spinner_sex = (Spinner) findViewById(R.id.spinner_sex);

    }


    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.firstsurvey_next:
                    Intent SecondSurveyIntent = new Intent(FirstSurveyActivity.this,SecondSurveyActivity.class);
                    sharedMemory.getUserinfo().setAge(spinner_age.getSelectedItem().toString());
                    sharedMemory.getUserinfo().setSex(spinner_sex.getSelectedItem().toString());
                    startActivity(SecondSurveyIntent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        }
    };
}
