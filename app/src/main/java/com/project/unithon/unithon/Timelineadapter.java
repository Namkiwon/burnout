package com.project.unithon.unithon;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;


/**
 * Created by Jun on 2018-01-27.
 */


public class Timelineadapter extends BaseAdapter {
    private static final int TIMELINE_MAIN = 0;
    private static final int TIMELINE_SUB = 1;
    private static final int ITEM_VIEW_TYPE_MAX = 2;
    private ArrayList<TimelineVO> listViewItemList = new ArrayList<TimelineVO>();

    public Timelineadapter() {
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_MAX;
    }

    @Override
    public int getItemViewType(int position) {
        return listViewItemList.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        int viewType = getItemViewType(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            TimelineVO timelineVO = listViewItemList.get(position);
            switch (viewType) {
                case TIMELINE_MAIN:
                    convertView = inflater.inflate(R.layout.timeline_main_vo, parent, false);
                    TextView mainwording = (TextView) convertView.findViewById(R.id.wording_main);
                    TextView highfive = (TextView) convertView.findViewById(R.id.highfive_main);
                    Log.d("TAGTAGTAG",timelineVO.getContents()+"/"+timelineVO.getHighfive()+"/");
                    mainwording.setText(timelineVO.getContents());
                    highfive.setText(""+timelineVO.getHighfive());
                    break;
                case TIMELINE_SUB:
                    convertView = inflater.inflate(R.layout.timeline_sub_vo, parent, false);
                    TextView subwording = (TextView) convertView.findViewById(R.id.wording_sub);
                    TextView highfive_sub = (TextView) convertView.findViewById(R.id.highfive_sub);
                    TextView idtextview = (TextView) convertView.findViewById(R.id.userid);
                    subwording.setText(timelineVO.getContents());
                    highfive_sub.setText(""+timelineVO.getHighfive());
                    idtextview.setText(timelineVO.getName());
                    break;
            }
        }
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String wording, int highfive) {
        TimelineVO item = new TimelineVO();
        item.setType(TIMELINE_MAIN);
        item.setContents(wording);
        item.setHighfive(highfive);
        listViewItemList.add(item);
    }

    public void addItem(String userid,String wording,int highfive) {
        TimelineVO item = new TimelineVO();
        item.setType(TIMELINE_SUB);
        item.setContents(wording);
        item.setName(userid);
        item.setHighfive(highfive);
        listViewItemList.add(item);
    }
}