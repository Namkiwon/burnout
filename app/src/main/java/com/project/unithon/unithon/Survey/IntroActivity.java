package com.project.unithon.unithon.Survey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.project.unithon.unithon.Fragment.FirstFragment;
import com.project.unithon.unithon.Fragment.SecondFragment;
import com.project.unithon.unithon.HomeActivity;
import com.project.unithon.unithon.R;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class IntroActivity extends AppCompatActivity {
    private ViewPager vp;
    private Intro_Fragment1 first;
    private Intro_Fragment2 second;
    Fragment cur_fragment = new Fragment();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().setTitle("Survey");
        vp = (ViewPager) findViewById(R.id.intro_viewpager);
        vp.setAdapter(new IntroActivity.pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        first = new Intro_Fragment1();
        second = new Intro_Fragment2();

    }

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
                default:
                    return null;
            }

        }
        @Override
        public int getCount()
        {
            return 2;
        }


    }

}
