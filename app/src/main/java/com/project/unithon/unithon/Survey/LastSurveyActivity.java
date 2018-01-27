package com.project.unithon.unithon.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.unithon.unithon.HomeActivity;
import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class LastSurveyActivity extends AppCompatActivity {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastsurvey);
        getSupportActionBar().setTitle("Survey");

        next = (Button) findViewById(R.id.lastsurvey_next);
        next.setOnClickListener(bListener);
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.lastsurvey_next:
                    Intent HomeIntent = new Intent(LastSurveyActivity.this,HomeActivity.class);
                    startActivity(HomeIntent);

//                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);

                    finish();
            }
        }
    };
}
