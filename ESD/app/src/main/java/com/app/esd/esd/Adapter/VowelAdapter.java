package com.app.esd.esd.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.app.esd.esd.Model.Vowel;
import com.app.esd.esd.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 08/05/2017.
 */

public class VowelAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "VowelAdapter";
    private Context context;
    private List<String> listType;
    private HashMap<String, List<Vowel>> listVowel;

    public VowelAdapter(Context context, List<String> listType, HashMap<String, List<Vowel>> listVowel) {
        this.context=context;
        this.listType=listType;
        this.listVowel=listVowel;
    }

    @Override
    public int getGroupCount() {
        return listType.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listVowel.get(listType.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listType.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listVowel.get(listType.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(context);
            convertView = li.inflate(R.layout.group_vowel, parent, false);
        }
        TextView tvHeader = (TextView) convertView.findViewById(R.id.tvHeader);
        tvHeader.setText(listType.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(context);
            convertView = li.inflate(R.layout.item_group, parent, false);
        }

        TextView tvVowel = (TextView) convertView.findViewById(R.id.tvVowel);
        tvVowel.setText((((Vowel) getChild(groupPosition, childPosition)).getVowel()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
