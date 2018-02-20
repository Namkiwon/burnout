package com.project.unithon.unithon.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project.unithon.unithon.MainFirstPage.ListviewVO;
import com.project.unithon.unithon.MainFirstPage.RecyclerAdapter;
import com.project.unithon.unithon.MainFirstPage.RecyclerItemClickListener;
import com.project.unithon.unithon.R;
import com.project.unithon.unithon.SharedMemory;
import com.project.unithon.unithon.TimelineActivity;

import java.util.ArrayList;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class FirstFragment extends Fragment {
    SharedMemory sharedMemory;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ListviewVO> items;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        sharedMemory = SharedMemory.getinstance();
        View view = inflater.inflate(R.layout.fragment_first,null);

        recyclerView = (RecyclerView) view.findViewById(R.id.firstfragment_recyclerview);

        items = new ArrayList<ListviewVO>();
        ListviewVO a = new ListviewVO();
        a.setWiseSaying("오늘은 어떤 하루를 보내셨나요?");
        ListviewVO b = new ListviewVO();
        b.setWiseSaying("다시 돌아오셔서 기뻐요. 오늘의 추천 글귀 보여드릴게요.");
        ListviewVO c = new ListviewVO();
        c.setWiseSaying("단순하게 살아라 현대인은 쓸데없는 절차와 일때문에 얼마나 복잡한 삶을 살아가는가.");
        items.add(a);
        items.add(b);
        items.add(c);

        setRecyclerView();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),String.valueOf(position)+"아이템 클릭",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), TimelineActivity.class);
                startActivity(intent);
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
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
    }

}