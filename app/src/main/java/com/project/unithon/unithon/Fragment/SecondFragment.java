package com.project.unithon.unithon.Fragment;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.project.unithon.unithon.CompassView2;
import com.project.unithon.unithon.MainSecondPage.RecyclerAdapter;
import com.project.unithon.unithon.MainSecondPage.RecyclerItemClickListener;
import com.project.unithon.unithon.MainSecondPage.ListviewVO;
import com.project.unithon.unithon.R;

import java.util.ArrayList;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class SecondFragment extends Fragment implements SensorEventListener {
    RelativeLayout compasslayout;
    CompassView2 compassView;
    LinearLayout ll;
    RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ListviewVO> items;

    public SecondFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        compasslayout = (RelativeLayout) view.findViewById(R.id.compass);
//        compassView = new CompassView2(getActivity());
//        getActivity().setContentView(compassView);


        //시스템으로부터 센서 메니저 객체 얻어오기
        SensorManager sensorM = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        //센서값이 바뀔때마다 수정되야 하므로 리스너를 등록한다.
        //센서 리스너 객체(센서이벤트리스너 임플리먼츠), 센서타입, 센서 민감도를 매니져에 등록한다.
        sensorM.registerListener(this,//Activity가 직접 리스너를 구현
                sensorM.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);

        // 배경원
//        ImageView circle = new ImageView(getActivity());
//        circle.setImageResource(R.drawable.circle);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
//        circle.setLayoutParams(layoutParams);
//        compasslayout.addView(circle);

        //자기 자신
        ImageView dot = new ImageView(getActivity());
//        dot.setImageResource(R.drawable.red);

        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams1.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        dot.setLayoutParams(layoutParams1);
//        compassView.setLayoutParams(layoutParams1);
//        compasslayout.addView(compassView);
//        ll.addView(compassView);


        recyclerView = (RecyclerView) view.findViewById(R.id.testfragment_recycle);
        items = new ArrayList<ListviewVO>();
        ListviewVO a = new ListviewVO();
        a.setA("a");
        a.setB("b");
        a.setC("c");
        ListviewVO b = new ListviewVO();
        b.setA("a");
        b.setB("b");
        b.setC("c");
        items.add(a);
        items.add(b);

        setRecyclerView();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),String.valueOf(position)+"아이템 클릭",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getActivity(),String.valueOf(position)+"아이템 롱클릭",Toast.LENGTH_LONG).show();
            }
        }));


        return view;
    }


    private void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
    }

    //센서의 정확도가 바뀌었을때(호출될일 없음, 향후 업데이트를 위해서)
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    //등록한 방향 센서 값이 바뀌었을 때 호출되는 콜백 메소드
    @Override
    public void onSensorChanged(SensorEvent event) {
        //event 객체에 센서값에 대한 정보가 들어있다.
        switch(event.sensor.getType()){
            case Sensor.TYPE_ORIENTATION : //방향센서 값이 바뀌었을때
                int heading = (int)event.values[0];
                //헤딩값을 View에 반영한다.
//                compassView.updateUI(heading);
                break;
        }
    }


}
