package com.app.esd.esd.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.esd.esd.Activity.PracticeRead;
import com.app.esd.esd.Modals.Sentence;
import com.app.esd.esd.R;
import com.sackcentury.shinebuttonlib.ShineButton;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciqaz on 27/05/2017.
 */

public class PracticeReadFragment extends Fragment implements OnClick {
    private int pos;
    private RecyclerView rv;
    private Adapter adapter;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final PracticeReadFragment newInstance(int pos) {
        PracticeReadFragment f = new PracticeReadFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt(EXTRA_MESSAGE, pos);
        f.setArguments(bundle);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pos = getArguments().getInt(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.fragment_practice_read, container, false);
        rv = (RecyclerView) v.findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutCompat = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutCompat);
        adapter = new Adapter(getActivity(), this);
        rv.setAdapter(adapter);
            List<Sentence> sentences=new ArrayList<>();
            for(int i=0;i<PracticeRead.sentences.size();i++) {
                sentences.add(PracticeRead.sentences.get(i));
            }
            adapter.addData(sentences);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void read(int pos) {

    }

    @Override
    public void rec(int pos) {

    }

    @Override
    public void listen(int pos) {

    }
}

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
        Context context;
        List<Sentence> sentences;
        OnClick onClick;
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=LayoutInflater.from(context).inflate(R.layout.item_practice_read,parent,false);
            return new MyViewHolder(v);

        }
        public Adapter(Context context,OnClick onClick){
            sentences=new ArrayList<>();
            this.context=context;
            this.onClick=onClick;
        }
        public void addData(List<Sentence> sentences){
            this.sentences.addAll(sentences);
            notifyDataSetChanged();
        }
        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.txtText.setText(sentences.get(holder.getAdapterPosition()).getText());
            holder.textPronun.setText(sentences.get(holder.getAdapterPosition()).getPronunciation());
            if(sentences.get(holder.getAdapterPosition()).isChoosed()){
                holder.shineButton.init((Activity) context);
                holder.shineButton.setChecked(true);
                holder.shineButton.showAnim();
                holder.shineButton. setSrcColor(holder.shineButton.getColor());


            }
            holder.imgRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.read(holder.getAdapterPosition());
                }
            });
            holder.imgListen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.listen(holder.getAdapterPosition());
                }
            });
            holder.imgRec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.rec(holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            return sentences.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView txtText,textPronun;
            private ImageView imgRec,imgRead,imgListen;
            private ShineButton shineButton;
            public MyViewHolder(View itemView) {
                super(itemView);
                txtText= (TextView) itemView.findViewById(R.id.txt_text);
                textPronun= (TextView) itemView.findViewById(R.id.txt_pronun);
                imgRec= (ImageView) itemView.findViewById(R.id.img_rec);
                imgListen=(ImageView) itemView.findViewById(R.id.img_listen);
                imgRead=(ImageView) itemView.findViewById(R.id.img_read);
                shineButton= (ShineButton) itemView.findViewById(R.id.po_image1);
            }
        }

    }
    interface OnClick{
        void read(int pos);
        void rec(int pos);
        void listen(int pos);
    }

