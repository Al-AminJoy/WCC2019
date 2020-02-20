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

public class MostWicketAdapter extends Adapter<MostWicketAdapter.MostWicketViewHlder> {
    Context context;
    ArrayList<MostWicketModelClass> listitem;

    public class MostWicketViewHlder extends ViewHolder {
        TextView tvname;
        TextView tvteam;
        TextView tvwicket;

        public MostWicketViewHlder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvmwnameid);
            tvteam = (TextView) itemView.findViewById(R.id.tvmwteamid);
            tvwicket = (TextView) itemView.findViewById(R.id.tvmwwicketid);
        }
    }

    public MostWicketAdapter(Context context, ArrayList<MostWicketModelClass> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    public MostWicketViewHlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MostWicketViewHlder(LayoutInflater.from(this.context).inflate(R.layout.most_wicket_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MostWicketViewHlder mostWicketViewHlder, int i) {
        MostWicketModelClass mostWicketModelClass = (MostWicketModelClass) this.listitem.get(i);
        mostWicketViewHlder.tvname.setText(mostWicketModelClass.getName());
        mostWicketViewHlder.tvteam.setText(mostWicketModelClass.getTeam());
        mostWicketViewHlder.tvwicket.setText(mostWicketModelClass.getWicket());
    }

    public int getItemCount() {
        return this.listitem.size();
    }
}

