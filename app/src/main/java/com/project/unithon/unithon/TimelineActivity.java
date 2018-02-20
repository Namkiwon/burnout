package com.project.unithon.unithon;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 * Created by Jun on 2018-01-27.
 */

public class TimelineActivity extends AppCompatActivity {

    ListView listView;
    Timelineadapter timelineadapter;
    Typeface fontnanum;
    Activity a;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);

        a=this;

        TreeMap<String, ArrayList<TimelineVO>> hashMap = new TreeMap<String, ArrayList<TimelineVO>>();
        listView = (ListView) findViewById(R.id.list);

        timelineadapter = new Timelineadapter(a);
        listView.setAdapter(timelineadapter);

//        new TimelineServer("http://52.232.198.231:8000/Unithon/wordingLisrt",hashMap,settleAdapter).run();

        timelineadapter.addItem("단순하게 살아라. 현대인은 쓸데없는 절차와 일 때문에 얼마나 복잡한 삶을 살아가는가? -이드리스 샤흐", 123);
        timelineadapter.addItem("익명의 번이웃", "일을 하면서 얻는 것이 없다고 생각했는데\n" +
                "너무 복잡하고 어렵게만 생각하고 있었던것 같아요.", 52,7);
        timelineadapter.addItem("익명의 번이웃", "일을 하면서 얻는 것이 없다고 생각했는데\n" +
                "너무 복잡하고 어렵게만 생각하고 있었던것 같아요.", 23,15);
        timelineadapter.addItem("익명의 번이웃", "일을 하면서 얻는 것이 없다고 생각했는데\n" +
                "너무 복잡하고 어렵게만 생각하고 있었던것 같아요.", 23,23);

    }
}