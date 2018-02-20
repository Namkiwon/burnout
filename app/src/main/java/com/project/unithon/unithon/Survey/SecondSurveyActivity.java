package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import static android.R.layout.browser_link_context_header;
import static android.R.layout.simple_spinner_item;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class SecondSurveyActivity extends AppCompatActivity {
    SharedMemory sharedMemory;

    Button btn_job_student;
    Button btn_job_officeworker;
    Button btn_job_transfer;
    Button btn_job_ready;
    Button btn_job_no;
    Button btn_job_mom;
    Button btn_secondsurvey_next;



    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondsurvey);
        getSupportActionBar().setTitle("Survey");

        sharedMemory = SharedMemory.getinstance();

        btn_job_mom = (Button) findViewById(R.id.btn_job_mom);
        btn_job_student = (Button) findViewById(R.id.btn_job_mom);
        btn_job_officeworker = (Button) findViewById(R.id.btn_job_officeworker);
        btn_job_no = (Button) findViewById(R.id.btn_job_no);
        btn_job_transfer = (Button) findViewById(R.id.btn_job_transfer);
        btn_job_ready = (Button) findViewById(R.id.btn_job_ready);

        btn_secondsurvey_next = (Button)findViewById(R.id.btn_secondsurvey_next);

        btn_job_student.setOnClickListener(bListener);
        btn_job_officeworker.setOnClickListener(bListener);
        btn_job_no.setOnClickListener(bListener);
        btn_job_transfer.setOnClickListener(bListener);
        btn_job_ready.setOnClickListener(bListener);
        btn_job_mom.setOnClickListener(bListener);

        btn_secondsurvey_next.setOnClickListener(bListener);

    }




    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_job_student:
                    sharedMemory.getUserinfo().setJob("학생");
                    break;
                case R.id.btn_job_officeworker:
                    sharedMemory.getUserinfo().setJob("직장인");
                    break;
                case R.id.btn_job_transfer:
                    sharedMemory.getUserinfo().setJob("이직준비");
                    break;
                case R.id.btn_job_no:
                    sharedMemory.getUserinfo().setJob("무직");
                    break;
                case R.id.btn_job_mom:
                    sharedMemory.getUserinfo().setJob("주부");
                    break;
                case R.id.btn_job_ready:
                    sharedMemory.getUserinfo().setJob("취준생");
                    break;
                case R.id.btn_secondsurvey_next:
                    Intent intent = new Intent(SecondSurveyActivity.this,ThirdSurveyActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
}
