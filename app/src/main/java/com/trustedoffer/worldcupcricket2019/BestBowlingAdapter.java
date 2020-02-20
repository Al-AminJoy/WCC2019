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

public class BestBowlingAdapter extends Adapter<BestBowlingAdapter.BestBowlingViewHolder> {
    Context context;
    ArrayList<BestBowlingModelClass> listitem;

    public class BestBowlingViewHolder extends ViewHolder {
        TextView tvname;
        TextView tvteam;
        TextView tvwicket;

        public BestBowlingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvbbnameid);
            tvteam = (TextView) itemView.findViewById(R.id.tvbbteamid);
            tvwicket = (TextView) itemView.findViewById(R.id.tvbbwicketid);
        }
    }

    public BestBowlingAdapter(Context context, ArrayList<BestBowlingModelClass> listitem) {
        this.context = context;
         this.listitem = listitem;
    }

    @NonNull
    public BestBowlingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BestBowlingViewHolder(LayoutInflater.from(context).inflate(R.layout.best_bowling_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull BestBowlingViewHolder bestBowlingViewHolder, int i) {
        BestBowlingModelClass bestBowlingModelClass = (BestBowlingModelClass) listitem.get(i);
        bestBowlingViewHolder.tvname.setText(bestBowlingModelClass.getPlayer());
        bestBowlingViewHolder.tvteam.setText(bestBowlingModelClass.getTeam());
        bestBowlingViewHolder.tvwicket.setText(bestBowlingModelClass.getWicket());
    }

    public int getItemCount() {
        return this.listitem.size();
    }
}

