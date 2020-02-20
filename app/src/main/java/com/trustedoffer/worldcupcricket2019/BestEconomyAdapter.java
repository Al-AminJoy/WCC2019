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

public class BestEconomyAdapter extends Adapter<BestEconomyAdapter.BestEconomyViewHolder> {
    Context context;
    ArrayList<BestEconomyModelClass> listitem;

    public class BestEconomyViewHolder extends ViewHolder {
        TextView tveco;
        TextView tvname;
        TextView tvteam;

        public BestEconomyViewHolder(@NonNull View itemView) {
            super(itemView);
           tvname = (TextView) itemView.findViewById(R.id.tvbenameid);
            tvteam = (TextView) itemView.findViewById(R.id.tvbeteamid);
           tveco = (TextView) itemView.findViewById(R.id.tvbeeconomyid);
        }
    }

    public BestEconomyAdapter(Context context, ArrayList<BestEconomyModelClass> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    public BestEconomyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BestEconomyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.best_economy_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull BestEconomyViewHolder bestEconomyViewHolder, int i) {
        BestEconomyModelClass bestEconomyModelClass = (BestEconomyModelClass) this.listitem.get(i);
        bestEconomyViewHolder.tvname.setText(bestEconomyModelClass.getName());
        bestEconomyViewHolder.tvteam.setText(bestEconomyModelClass.getTeam());
        bestEconomyViewHolder.tveco.setText(bestEconomyModelClass.getEconomy());
    }

    public int getItemCount() {
        return this.listitem.size();
    }
}

