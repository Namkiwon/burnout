package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class SecondSurveyActivity extends AppCompatActivity {
    SharedMemory sharedMemory;
    Spinner spinner_job;
    Spinner spinner_job2;
    TextView txt_job2;

    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondsurvey);
        getSupportActionBar().setTitle("Survey");

        spinner_job = (Spinner) findViewById(R.id.spinner_job);
        spinner_job.setOnItemSelectedListener(sListener);
        spinner_job2 = (Spinner) findViewById(R.id.spinner_job2);
        txt_job2 = (TextView) findViewById(R.id.txt_job2);

        next = (Button) findViewById(R.id.secondsurvey_next);
        next.setOnClickListener(bListener);
//        spinner_job2.setVisibility(View.GONE);
//        txt_job2.setVisibility(View.GONE);
    }


    Spinner.OnItemSelectedListener sListener = new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(spinner_job.getSelectedItem().toString().equals("직장인")){
                txt_job2.setVisibility(View.VISIBLE);
                spinner_job2.setVisibility(View.VISIBLE);
                ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(SecondSurveyActivity.this,R.array.officeworker,android.R.layout.simple_spinner_item);
                spinner_job2.setAdapter(arrayAdapter);

            }else if(spinner_job.getSelectedItem().toString().equals("이직준비")){
                txt_job2.setVisibility(View.VISIBLE);
                spinner_job2.setVisibility(View.VISIBLE);
                ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(SecondSurveyActivity.this,R.array.readytransfer,android.R.layout.simple_spinner_item);
                spinner_job2.setAdapter(arrayAdapter);
            }else{
                txt_job2.setVisibility(View.GONE);
                spinner_job2.setVisibility(View.GONE);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView){

        }
    };

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.firstsurvey_next:
                    Intent LastSurveyIntent = new Intent(SecondSurveyActivity.this,LastSurveyActivity.class);
                    sharedMemory.getUserinfo().setAge(spinner_job.getSelectedItem().toString());
                    startActivity(LastSurveyIntent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        }
    };
}
