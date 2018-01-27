package com.project.unithon.unithon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.TreeMap;


/**
 * Created by Jun on 2018-01-27.
 */

public class TimelineActivity extends AppCompatActivity {

    ListView listView;
    Timelineadapter timelineadapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);

        TreeMap<String, ArrayList<TimelineVO>> hashMap = new TreeMap<String, ArrayList<TimelineVO>>();
        listView = (ListView) findViewById(R.id.list);

        timelineadapter = new Timelineadapter();
        listView.setAdapter(timelineadapter);

//        new TimelineServer("http://52.232.198.231:8000/Unithon/wordingLisrt",hashMap,settleAdapter).run();

        timelineadapter.addItem("한번 실패가 영원한 실패는 아니다.", 123);
        timelineadapter.addItem("namgi93", "한번 실패가 영원한 실패는 아니다.", 52);
        timelineadapter.addItem("익명", "한번 실패가 영원한 실패는 아니다.", 23);

    }
}