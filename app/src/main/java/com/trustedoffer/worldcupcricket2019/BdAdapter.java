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

public class BdAdapter extends RecyclerView.Adapter<BdAdapter.BdViewHolder> {
    Context context;
    ArrayList<BdModelClass> list;

    public BdAdapter(Context context, ArrayList<BdModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BdViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(this.context);
        View view=layoutInflater.inflate(R.layout.bd_layout,viewGroup,false);

        return new BdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BdViewHolder bdViewHolder, int i) {
     BdModelClass bdModelClass=list.get(i);
     bdViewHolder.tvnameview.setText(bdModelClass.getName());
        bdViewHolder.tvroleview.setText(bdModelClass.getRole());
        Picasso.get().load(bdModelClass.getImage()).into(bdViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BdViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView tvnameview,tvroleview;
        public BdViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ivplayer);
            tvnameview=itemView.findViewById(R.id.tvplayername);
            tvroleview=itemView.findViewById(R.id.tvplayerrole);
        }
    }
}
