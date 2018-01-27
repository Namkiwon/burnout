package com.project.unithon.unithon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.project.unithon.unithon.Survey.FirstSurveyActivity;

/**
 * Created by namgiwon on 2018. 1. 27..
 */

public class LoginActivity extends FragmentActivity {

    private Button GuestLogin;
    private Button EmailLogin;
    private Intent FirstSurveyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        GuestLogin = (Button) findViewById(R.id.login_guest);
        EmailLogin = (Button) findViewById(R.id.login_email);

        GuestLogin.setOnClickListener(bListener);
        EmailLogin.setOnClickListener(bListener);

    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login_guest:
                    FirstSurveyIntent = new Intent(LoginActivity.this,FirstSurveyActivity.class);
                    startActivity(FirstSurveyIntent);
                    finish();
                    break;
                case R.id.login_email:
                    FirstSurveyIntent = new Intent(LoginActivity.this,FirstSurveyActivity.class);
                    startActivity(FirstSurveyIntent);
                    finish();
                    break;

            }
        }
    };
}
