package com.project.unithon.unithon;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class FirstSurveyActivity extends AppCompatActivity{
    Button next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstsurvey);
        getSupportActionBar().setTitle("Survey");

        next = (Button) findViewById(R.id.firstsurvey_next);
        next.setOnClickListener(bListener);

    }


    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.firstsurvey_next:
                    Intent HomeIntent = new Intent(FirstSurveyActivity.this,HomeActivity.class);
                    startActivity(HomeIntent);
                    finish();
            }
        }
    };
}
