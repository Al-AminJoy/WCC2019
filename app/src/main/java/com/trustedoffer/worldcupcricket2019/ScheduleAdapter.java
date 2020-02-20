package com.trustedoffer.worldcupcricket2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScheduleAdapter extends Adapter<ScheduleAdapter.ScheduleViewHolder> {
    Context context;
    ArrayList<ScheduleModelClass> listItem;

    public class ScheduleViewHolder extends ViewHolder {
        TextView dateView;
        TextView leftCounrtyView;
        ImageView leftImgView;
        TextView matchView;
        TextView rightCountryzview;
        ImageView rightImgView;
        TextView stadiumView;
        TextView statusView;
        TextView timeView;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            dateView = itemView.findViewById(R.id.dateid);
            timeView = itemView.findViewById(R.id.timeid);
            matchView = itemView.findViewById(R.id.matchid);
            stadiumView = itemView.findViewById(R.id.stadiumid);
            statusView = itemView.findViewById(R.id.matchresultid);
            leftCounrtyView = itemView.findViewById(R.id.leftcountryid);
            rightCountryzview = itemView.findViewById(R.id.rightcountryid);
            leftImgView = itemView.findViewById(R.id.leftimgid);
            rightImgView = itemView.findViewById(R.id.rightimgid);
        }
    }

    public ScheduleAdapter(Context context, ArrayList<ScheduleModelClass> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @NonNull
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ScheduleViewHolder(LayoutInflater.from(this.context).inflate(R.layout.schedule_layout, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull ScheduleViewHolder scheduleViewHolder, int i) {
        ScheduleModelClass scheduleModelClass = this.listItem.get(i);
        scheduleViewHolder.dateView.setText(scheduleModelClass.getDate());
        scheduleViewHolder.timeView.setText(scheduleModelClass.getTime());
        scheduleViewHolder.matchView.setText(scheduleModelClass.getMatch());
        scheduleViewHolder.stadiumView.setText(scheduleModelClass.getStadium());
        scheduleViewHolder.statusView.setText(scheduleModelClass.getStatus());
        scheduleViewHolder.leftCounrtyView.setText(scheduleModelClass.getLeftCountry());
        scheduleViewHolder.rightCountryzview.setText(scheduleModelClass.getRightCountry());
        Picasso.get().load(scheduleModelClass.getLeftCountryImgUrl()).into(scheduleViewHolder.leftImgView);
        Picasso.get().load(scheduleModelClass.getRightCountryImgUrl()).into(scheduleViewHolder.rightImgView);
    }

    public int getItemCount() {
        return this.listItem.size();
    }
}
