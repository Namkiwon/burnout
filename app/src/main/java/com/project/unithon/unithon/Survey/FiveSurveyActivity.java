package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.unithon.unithon.HomeActivity;
import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class FiveSurveyActivity extends AppCompatActivity {
    SharedMemory sharedMemory;
    TextView textView;
    Button yes;
    Button no;
    Button btn_fivesurvey_next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivesurvey);
        getSupportActionBar().setTitle("Survey");
        sharedMemory = SharedMemory.getinstance();
        btn_fivesurvey_next = (Button)findViewById(R.id.btn_fivesurvey_next);
        btn_fivesurvey_next.setOnClickListener(bListener);
        yes = (Button)findViewById(R.id.btn_fivesurvey_yes);
        no = (Button) findViewById(R.id.btn_fivesurvey_no);
        textView = (TextView) findViewById(R.id.txt_fivesurvey);
        switch (sharedMemory.getUserinfo().getJob()){
            case  "학생" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
            case  "직장인" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
            case  "무직" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
            case  "취준생" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
            case  "주부" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
            case  "이직준비" :
                textView.setText("사람들과의 관계에서 지치고 무기력해지나요?");
                break;
        }
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case  R.id.btn_fivesurvey_yes:
                    sharedMemory.getUserinfo().setRelation("yes");
                case R.id.btn_fivesurvey_no:
                    sharedMemory.getUserinfo().setRelation("no");
                case R.id.btn_fivesurvey_next:
                    Intent intent = new Intent(FiveSurveyActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
}
