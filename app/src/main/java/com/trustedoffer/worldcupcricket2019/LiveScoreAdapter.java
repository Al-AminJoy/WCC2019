package com.trustedoffer.worldcupcricket2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LiveScoreAdapter extends RecyclerView.Adapter<LiveScoreAdapter.LiveScoreViewHolder> {
    Context context;
    ArrayList<LiveScoreModelClass> listitem;

    public LiveScoreAdapter(Context context, ArrayList<LiveScoreModelClass> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    @Override
    public LiveScoreAdapter.LiveScoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.live_score_layout, viewGroup, false);
        return new LiveScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveScoreAdapter.LiveScoreViewHolder liveScoreViewHolder, int i) {
        LiveScoreModelClass list = listitem.get(i);
        String batteamname = list.getBatteamname();
        String batteamscore = list.getBatteamscore();
        String batteamover = list.getBatteamover();

        String bowlteamname = list.getBowlteamname();
        String bowlteamscore = list.getBowlteamscore();
        String bowlteamover = list.getBowlteamover();
        String type = list.getType();
        String matchstatus = list.getStatus();

        String target = list.getTarget();

        liveScoreViewHolder.batteamnameview.setText(batteamname);
        liveScoreViewHolder.batteamscoreview.setText("Score : " + batteamscore);
        if (type.equals("T20") || type.equals("T20I")) {
            batteamover = batteamover + "/20";
            liveScoreViewHolder.batteamoverview.setText("Overs: " + batteamover);
        } else if (type.equals("ODI")) {
            batteamover = batteamover + "/50";
            liveScoreViewHolder.batteamoverview.setText("Overs: " + batteamover);
        } else {
            batteamover = batteamover;
            liveScoreViewHolder.batteamoverview.setText("Overs: " + batteamover);
        }


        if (target.equals("") || target.equals("0") || target.equals("00")) {
            liveScoreViewHolder.targetview.setVisibility(View.GONE);
        } else {
            liveScoreViewHolder.targetview.setText("Target : " + target);
        }
        if (bowlteamscore.equals("") || bowlteamscore.equals("0") || bowlteamscore.equals("00")) {
            liveScoreViewHolder.bowlteamscoreview.setVisibility(View.GONE);
        } else {
            liveScoreViewHolder.bowlteamscoreview.setText("Score : " + bowlteamscore);
        }
        if (bowlteamover.equals("") || bowlteamover.equals("0") || bowlteamover.equals("00")) {
            liveScoreViewHolder.bowlteamoverview.setVisibility(View.GONE);
        } else {
            liveScoreViewHolder.bowlteamoverview.setText("Overs : " + bowlteamover);
        }

        liveScoreViewHolder.bowlteamnameview.setText(bowlteamname);
        liveScoreViewHolder.tvstatusview.setText(matchstatus);


        Picasso.get().load(list.getBatteamimg()).into(liveScoreViewHolder.batteamimgview);
        Picasso.get().load(list.getBowlteamimg()).into(liveScoreViewHolder.bowlteamimgview);


    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class LiveScoreViewHolder extends RecyclerView.ViewHolder {
        TextView batteamnameview, batteamscoreview, batteamoverview, bowlteamnameview, bowlteamscoreview, bowlteamoverview, targetview, tvstatusview;
        ImageView batteamimgview, bowlteamimgview;

        public LiveScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            batteamnameview = itemView.findViewById(R.id.tvbatteamname);
            batteamscoreview = itemView.findViewById(R.id.tvbatteamscore);
            batteamoverview = itemView.findViewById(R.id.tvbatteamover);
            batteamimgview = itemView.findViewById(R.id.ivbatteam);

            bowlteamnameview = itemView.findViewById(R.id.tvbowlteamname);
            bowlteamscoreview = itemView.findViewById(R.id.tvbowlteamscore);
            bowlteamoverview = itemView.findViewById(R.id.tvbowlteamover);
            bowlteamimgview = itemView.findViewById(R.id.ivbowlteam);

            targetview = itemView.findViewById(R.id.tvtarget);
            tvstatusview = itemView.findViewById(R.id.tvstatus);


        }
    }
}
