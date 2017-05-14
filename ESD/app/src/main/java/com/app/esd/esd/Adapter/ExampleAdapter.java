package com.app.esd.esd.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.app.esd.esd.Activity.DetailVowelActivity;
import com.app.esd.esd.R;
import com.app.esd.esd.Utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/05/2017.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.RecyclerViewHolder> {
    private List<String> listData = new ArrayList<String>();
    private DetailVowelActivity detailVowelActivity;
    private int typeTime;
    private int previousPosition = 0;
    private int lastPosition = -1;

    public ExampleAdapter() {
    }

    public ExampleAdapter(DetailVowelActivity detailVowelActivity, List<String> listData) {
        this.detailVowelActivity = detailVowelActivity;
        this.listData = listData;
    }

    @Override
    public int getItemCount() {
        if (listData == null)
            return 0;
        else return listData.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        if (listData != null) {
            return listData.get(position);
        }
        return null;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_list, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder viewHolder, int position) {
        viewHolder.tvExample.setText(listData.get(position));
        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {

                } else {
                    detailVowelActivity.speakExample(listData.get(position).toString().trim());
                }
            }
        });
        setAnimation(viewHolder.itemView, position);
        previousPosition = position;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {

        private TextView tvExample;
        private ItemClickListener clickListener;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvExample = (TextView) itemView.findViewById(R.id.tvExample);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(detailVowelActivity, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
