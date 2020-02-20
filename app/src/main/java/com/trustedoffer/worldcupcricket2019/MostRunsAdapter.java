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

public class MostRunsAdapter extends Adapter<MostRunsAdapter.MostRunsViewHolder> {
    Context context;
    ArrayList<MostRunsModelClass> mostrunslist;

    public class MostRunsViewHolder extends ViewHolder {
        TextView mrname;
        TextView mrruns;
        TextView mrteam;

        public MostRunsViewHolder(@NonNull View itemView) {
            super(itemView);
            mrname = (TextView) itemView.findViewById(R.id.mrnameid);
            mrteam = (TextView) itemView.findViewById(R.id.mrteamid);
            mrruns = (TextView) itemView.findViewById(R.id.mrrunid);
        }
    }

    public MostRunsAdapter(Context context, ArrayList<MostRunsModelClass> mostrunslist) {
        this.context = context;
        this.mostrunslist = mostrunslist;
    }

    @NonNull
    public MostRunsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MostRunsViewHolder(LayoutInflater.from(this.context).inflate(R.layout.most_runs_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MostRunsViewHolder mostRunsViewHolder, int i) {
        MostRunsModelClass mostRunsModelClass = (MostRunsModelClass) this.mostrunslist.get(i);
        mostRunsViewHolder.mrname.setText(mostRunsModelClass.getPlayer());
        mostRunsViewHolder.mrteam.setText(mostRunsModelClass.getTeam());
        mostRunsViewHolder.mrruns.setText(mostRunsModelClass.getRuns());
    }

    public int getItemCount() {
        return this.mostrunslist.size();
    }
}

