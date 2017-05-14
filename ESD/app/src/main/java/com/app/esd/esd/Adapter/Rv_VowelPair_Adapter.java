package com.app.esd.esd.Adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.esd.esd.R;

/**
 * Created by PTT on 5/14/2017.
 */

public class Rv_VowelPair_Adapter extends RecyclerView.Adapter<Rv_VowelPair_Adapter.ViewHolder> {
    private Activity activity;

    public Rv_VowelPair_Adapter(Activity activity) {
        this.activity = activity;
    }

    public interface OnItemClickListener {
        void ItemClick(Activity activity, int ID);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_vowelpair, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final VowelPair vowelPair1 = VowelPair.values()[position];
        holder.tv_vowel1.setText(vowelPair1.getVeowel());
        holder.tv_word1.setText(vowelPair1.getWord());
        holder.cardv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.ItemClick(activity, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        int length = VowelPair.values().length;
        if (length % 2 == 0) {
            count = length / 2;
        } else {
            count = (length / 2) + 1;
        }
        return VowelPair.values().length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardv1;
        TextView tv_vowel1, tv_word1;

        public ViewHolder(View itemView) {
            super(itemView);
            cardv1 = (CardView) itemView.findViewById(R.id.cardv1_vowelpair);
            tv_vowel1 = (TextView) itemView.findViewById(R.id.txtv_vowel1_itemrv);
            tv_word1 = (TextView) itemView.findViewById(R.id.txtv_wordpair1_itemrv);
        }
    }

    public enum VowelPair {
        VOWEL1("/I/ & /iː/", "Ship & Sheep"),
        VOWEL2("/e/ & /æ/", "Men & Man"),
        VOWEL3("/ʊ/ & /uː/", "Foot & Food"),
        VOWEL4("/ʌ/ & /ɑː/", "Come & Calm");
        private String veowel;
        private String word;

        VowelPair(String veowel, String word) {
            this.veowel = veowel;
            this.word = word;
        }

        public String getVeowel() {
            return veowel;
        }

        public String getWord() {
            return word;
        }
    }
}
