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

public class MostCenturyAdapter extends Adapter<MostCenturyAdapter.MostCenturyViewHolder> {
    Context context;
    private ArrayList<MostCenturyModelClass> listitem;

    public class MostCenturyViewHolder extends ViewHolder {
        TextView tvcentury;
        TextView tvname;
        TextView tvteam;

        public MostCenturyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvhcnameid);
           tvteam = (TextView) itemView.findViewById(R.id.tvhcteamid);
            tvcentury = (TextView) itemView.findViewById(R.id.tvhccid);
        }
    }

    public MostCenturyAdapter(Context context, ArrayList<MostCenturyModelClass> dataitem) {
        this.context = context;
        this.listitem = dataitem;
    }

    @NonNull
    public MostCenturyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MostCenturyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.most_century_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MostCenturyViewHolder mostCenturyViewHolder, int i) {
        MostCenturyModelClass mostCenturyModelClass = (MostCenturyModelClass) listitem.get(i);
        mostCenturyViewHolder.tvname.setText(mostCenturyModelClass.getName());
        mostCenturyViewHolder.tvteam.setText(mostCenturyModelClass.getTeam());
        mostCenturyViewHolder.tvcentury.setText(mostCenturyModelClass.getCenturies());
    }

    public int getItemCount() {
        return this.listitem.size();
    }
}

