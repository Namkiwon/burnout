package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class FourthSurveyActivity extends AppCompatActivity {
    SharedMemory sharedMemory;
    TextView textView;
    Button yes;
    Button no;
    Button btn_fourthsurvey_next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthsurvey);
        getSupportActionBar().setTitle("Survey");
        sharedMemory = SharedMemory.getinstance();

        btn_fourthsurvey_next = (Button) findViewById(R.id.btn_fourthsurvey_next);
        btn_fourthsurvey_next.setOnClickListener(bListener);

        yes = (Button)findViewById(R.id.btn_fourthsurvey_yes);
        no = (Button) findViewById(R.id.btn_fourthsurvey_no);
        textView = (TextView) findViewById(R.id.txt_fourthsurvey);
        switch (sharedMemory.getUserinfo().getJob()){
            case  "학생" :
                textView.setText("공부 때문에 무기력해짐을 느끼시나요?");
                break;
            case  "직장인" :
                textView.setText("업무 때문에 무기력해짐을 느끼시나요?");
                break;
            case  "무직" :
                textView.setText("무직이라는 사실 때문에 무기력해짐을 느끼시나요?");
                break;
            case  "취준생" :
                textView.setText("취업 준비하는 것 떄문에 무기력해짐을 느끼시나요?");
                break;
            case  "주부" :
                textView.setText("가사 노동 때문에 무기력해짐을 느끼시나요?");
                break;
            case  "이직준비" :
                textView.setText("이직 준비 때문에 무기력해짐을 느끼시나요?");
                break;
        }
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case  R.id.btn_fourthsurvey_yes:
                    sharedMemory.getUserinfo().setWork("yes");
                case R.id.btn_fourthsurvey_no:
                    sharedMemory.getUserinfo().setWork("no");
                case R.id.btn_fourthsurvey_next:
                    Intent intent = new Intent(FourthSurveyActivity.this,FiveSurveyActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
