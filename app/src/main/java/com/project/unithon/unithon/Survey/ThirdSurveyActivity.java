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

public class ThirdSurveyActivity extends AppCompatActivity {
    SharedMemory sharedMemory;
    TextView textView;

    Button btn_thirdsurvey_next;
    Button yes;
    Button no;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdsurvey);
        getSupportActionBar().setTitle("Survey");
        sharedMemory = SharedMemory.getinstance();

        btn_thirdsurvey_next = (Button) findViewById(R.id.btn_thirdsurvey_next);
        btn_thirdsurvey_next.setOnClickListener(bListener);
        yes = (Button)findViewById(R.id.btn_thirdsurvey_yes);
        no = (Button) findViewById(R.id.btn_thirdsurvey_no);
        textView = (TextView) findViewById(R.id.txt_thirdsurvey);
        switch (sharedMemory.getUserinfo().getJob()){
            case  "학생" :
                textView.setText("공부하고 있는 환경 때문에 힘이 드나요?");
                break;
            case  "직장인" :
                textView.setText("일하고있는 환경 때문에 힘이 드나요?");
                break;
            case  "무직" :
                textView.setText("일하고있는 환경 때문에 힘이 드나요?");
                break;
            case  "취준생" :
                textView.setText("현재 취업 준비하고있는 주변 환경 때문에 힘이 드나요?");
                break;
            case  "주부" :
                textView.setText("주변 환경에서 무기력함을 느끼게 되나요?");
                break;
            case  "이직준비" :
                textView.setText("일하고있는 환경 때문에 힘이 드나요?");
                break;
        }
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case  R.id.btn_thirdsurvey_yes:
                    sharedMemory.getUserinfo().setEnvironment("yes");
                case R.id.btn_thirdsurvey_no:
                    sharedMemory.getUserinfo().setEnvironment("no");
                case R.id.btn_thirdsurvey_next:
                    Intent intent = new Intent(ThirdSurveyActivity.this,FourthSurveyActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
