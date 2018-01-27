package com.project.unithon.unithon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.unithon.unithon.Fragment.FirstFragment;
import com.project.unithon.unithon.Fragment.SecondFragment;
import com.project.unithon.unithon.Fragment.ThirdFragment;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class HomeActivity extends AppCompatActivity {
    ViewPager vp;
    Button firstpage;
    Button secondpage;
    Button thirdpage;
    FirstFragment first;
    SecondFragment second;
    ThirdFragment third;
    String type;
    String token;

    Fragment cur_fragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        token = getIntent().getStringExtra("token");
        type = getIntent().getStringExtra("type");
        vp = (ViewPager) findViewById(R.id.home_viewpager);
        firstpage = (Button) findViewById(R.id.home_btn_first);
        secondpage = (Button) findViewById(R.id.home_btn_second);
        thirdpage = (Button) findViewById(R.id.home_btn_third);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        firstpage.setOnClickListener(movePageListener);
        firstpage.setTag(0);
        secondpage.setOnClickListener(movePageListener);
        secondpage.setTag(1);
        thirdpage.setOnClickListener(movePageListener);
        thirdpage.setTag(2);

        first = new FirstFragment();
        second = new SecondFragment();
        third= new ThirdFragment();
    }

    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            switch(position)
            {
                case 0:
                    return first;
                case 1:
                    return second;
                case 2:
                    return third;
                default:
                    return null;
            }

        }
        @Override
        public int getCount()
        {
            return 3;
        }
    }
}
