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
    ;
    SharedMemory sharedMemory;
    private Button btn_sex_man;
    private Button btn_sex_woman;
    private Button btn_age_10;
    private Button btn_age_20;
    private Button btn_age_30;
    private Button btn_age_40;
    private Button btn_age_50;
    private Button btn_age_60;
    private Button next;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstsurvey);
        getSupportActionBar().setTitle("Survey");

        sharedMemory = SharedMemory.getinstance();

        next = (Button)findViewById(R.id.btn_firstsurvey_next);
        next.setOnClickListener(bListener);
        btn_sex_man = (Button)findViewById(R.id.btn_sex_man);
        btn_sex_man.setOnClickListener(bListener);
        btn_sex_woman = (Button)findViewById(R.id.btn_sex_woman);
        btn_sex_woman.setOnClickListener(bListener);

//        btn_age_10 = (Button)findViewById(R.id.btn_age_10);
//        btn_age_20 = (Button)findViewById(R.id.btn_age_20);
//        btn_age_30 = (Button)findViewById(R.id.btn_age_30);
//        btn_age_40 = (Button)findViewById(R.id.btn_age_40);
//        btn_age_50 = (Button)findViewById(R.id.btn_age_50);
//        btn_age_60 = (Button)findViewById(R.id.btn_age_60);
//
//        btn_age_10.setOnClickListener(bListener);
//        btn_age_20.setOnClickListener(bListener);
//        btn_age_30.setOnClickListener(bListener);
//        btn_age_40.setOnClickListener(bListener);
//        btn_age_50.setOnClickListener(bListener);
//        btn_age_60.setOnClickListener(bListener);


    }


    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_age_10:
                    sharedMemory.getUserinfo().setAge("10");
                    break;
                case R.id.btn_age_20:
                    sharedMemory.getUserinfo().setAge("20");
                    break;
                case R.id.btn_age_30:
                    sharedMemory.getUserinfo().setAge("30");
                    break;
                case R.id.btn_age_40:
                    sharedMemory.getUserinfo().setAge("40");
                    break;
                case R.id.btn_age_50:
                    sharedMemory.getUserinfo().setAge("50");
                    break;
                case R.id.btn_age_60:
                    sharedMemory.getUserinfo().setAge("60");
                    break;

                case R.id.btn_sex_man:
                    sharedMemory.getUserinfo().setSex("man");
                    break;

                case R.id.btn_sex_woman:
                    sharedMemory.getUserinfo().setSex("woman");
                    break;

                case R.id.btn_firstsurvey_next:
                    Intent intent = new Intent(FirstSurveyActivity.this,SecondSurveyActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
