package com.trustedoffer.worldcupcricket2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class HighScoreAdapter extends Adapter<HighScoreAdapter.HighScoreViewHolder> {
    private Context context;
    private ArrayList<HighScoreModelClass> datalist;

    public class HighScoreViewHolder extends ViewHolder {
        TextView tvname;
        TextView tvruns;
        TextView tvteam;

        public HighScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvhsnameid);
            tvteam = (TextView) itemView.findViewById(R.id.tvhsteamid);
            tvruns = (TextView) itemView.findViewById(R.id.tvhsrunid);
        }
    }

    public HighScoreAdapter(Context context, ArrayList<HighScoreModelClass> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    public HighScoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HighScoreViewHolder(LayoutInflater.from(this.context).inflate(R.layout.high_score_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull HighScoreViewHolder highScoreViewHolder, int i) {
        HighScoreModelClass highScoreModelClass = (HighScoreModelClass) this.datalist.get(i);
        highScoreViewHolder.tvname.setText(highScoreModelClass.getName());
        highScoreViewHolder.tvteam.setText(highScoreModelClass.getTeam());
        highScoreViewHolder.tvruns.setText(highScoreModelClass.getRun());
    }

    public int getItemCount() {
        return this.datalist.size();
    }
}

