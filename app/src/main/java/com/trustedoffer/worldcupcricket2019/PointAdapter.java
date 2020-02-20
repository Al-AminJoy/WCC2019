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

public class PointAdapter extends Adapter<PointAdapter.PointViewHolder> {
    Context context;
    ArrayList<PointModelClass> pointlistitem;

    public class PointViewHolder extends ViewHolder {
        TextView lostView;
        TextView playedView;
        TextView pointView;
        TextView runRateView;
        TextView teamView;
        TextView tieView;
        TextView wonView;

        public PointViewHolder(@NonNull View itemView) {
            super(itemView);
            teamView = (TextView) itemView.findViewById(R.id.teamid);
            playedView = (TextView) itemView.findViewById(R.id.playedid);
            wonView = (TextView) itemView.findViewById(R.id.wonid);
            lostView = (TextView) itemView.findViewById(R.id.lostid);
            tieView = (TextView) itemView.findViewById(R.id.tieid);
            pointView = (TextView) itemView.findViewById(R.id.totalpointid);
            runRateView = (TextView) itemView.findViewById(R.id.nrrid);
        }
    }

    public PointAdapter(Context context, ArrayList<PointModelClass> pointlistitem) {
        this.context = context;
        this.pointlistitem = pointlistitem;
    }

    @NonNull
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PointViewHolder(LayoutInflater.from(this.context).inflate(R.layout.point_table_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull PointViewHolder pointViewHolder, int i) {
        PointModelClass pointModelClass = (PointModelClass) this.pointlistitem.get(i);
        pointViewHolder.teamView.setText(pointModelClass.getTeam());
        pointViewHolder.playedView.setText(pointModelClass.getPlayed());
        pointViewHolder.wonView.setText(pointModelClass.getWon());
        pointViewHolder.lostView.setText(pointModelClass.getLost());
        pointViewHolder.tieView.setText(pointModelClass.getTie());
        pointViewHolder.pointView.setText(pointModelClass.getPpoint());
        pointViewHolder.runRateView.setText(pointModelClass.getNetrr());
    }

    public int getItemCount() {
        return this.pointlistitem.size();
    }
}
