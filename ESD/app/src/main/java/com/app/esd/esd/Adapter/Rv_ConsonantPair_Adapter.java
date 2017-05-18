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

public class Rv_ConsonantPair_Adapter extends RecyclerView.Adapter<Rv_ConsonantPair_Adapter.ViewHolder> {
    private Activity activity;

    public Rv_ConsonantPair_Adapter(Activity activity) {
        this.activity = activity;
    }

    public interface OnItemClickListener {
        void ItemClick(Activity activity, int ID, View itemView, String pair);
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CoonsonantPair coonsonantPair1 = CoonsonantPair.values()[position];
        holder.tv_vowel1.setText(coonsonantPair1.getConsonant());
        holder.tv_word1.setText(coonsonantPair1.getWord());
        holder.cardv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.ItemClick(activity, position, holder.itemView, coonsonantPair1.getConsonant());
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        int length = CoonsonantPair.values().length;
        if (length % 2 == 0) {
            count = length / 2;
        } else {
            count = (length / 2) + 1;
        }
        return CoonsonantPair.values().length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardv1;
        TextView tv_vowel1, tv_word1;

        public ViewHolder(View itemView) {
            super(itemView);
            cardv1 = (CardView) itemView.findViewById(R.id.cardv1_vowelpair);
            tv_vowel1 = (TextView) itemView.findViewById(R.id.txtv_vowel_itemrv);
            tv_word1 = (TextView) itemView.findViewById(R.id.txtv_wordpair_itemrv);
        }
    }

    public enum CoonsonantPair {
        VOWEL1("/s/ & /z/", "Sun & Zoo"),
        VOWEL2("/t/ & /d/", "Cart & Card"),
        VOWEL3("/θ/ & /ð/", "Think & Them"),
        VOWEL4("/p/ & /b/", "Pin & Bin");
        private String consonant;
        private String word;

        CoonsonantPair(String consonant, String word) {
            this.consonant = consonant;
            this.word = word;
        }

        public String getConsonant() {
            return consonant;
        }

        public String getWord() {
            return word;
        }
    }
}
