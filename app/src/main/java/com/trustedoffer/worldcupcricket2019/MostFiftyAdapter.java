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

public class MostFiftyAdapter extends Adapter<MostFiftyAdapter.MostFiftyViewHolder> {
    Context context;
    ArrayList<MostFiftyModelClass> dataitem;

    public class MostFiftyViewHolder extends ViewHolder {
        TextView tvfifty;
        TextView tvname;
        TextView tvteam;

        public MostFiftyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvhfnameid);
            tvteam = (TextView) itemView.findViewById(R.id.tvhfteamid);
            tvfifty = (TextView) itemView.findViewById(R.id.tvhffid);
        }
    }

    public MostFiftyAdapter(Context context, ArrayList<MostFiftyModelClass> dataitem) {
        this.context = context;
        this.dataitem = dataitem;
    }

    @NonNull
    public MostFiftyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MostFiftyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.most_fifty_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MostFiftyViewHolder mostFiftyViewHolder, int i) {
        MostFiftyModelClass mostFiftyModelClass = (MostFiftyModelClass) this.dataitem.get(i);
        mostFiftyViewHolder.tvname.setText(mostFiftyModelClass.getName());
        mostFiftyViewHolder.tvteam.setText(mostFiftyModelClass.getTeam());
        mostFiftyViewHolder.tvfifty.setText(mostFiftyModelClass.getFifty());
    }

    public int getItemCount() {
        return this.dataitem.size();
    }
}
