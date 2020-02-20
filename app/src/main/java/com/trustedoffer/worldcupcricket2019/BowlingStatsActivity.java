package com.trustedoffer.worldcupcricket2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class BowlingStatsActivity extends AppCompatActivity {
    private CardView bestbowl;
    private CardView besteconomy;
    private CardView mostwicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowling_stats);
        bestbowl = (CardView) findViewById(R.id.bestbowlingid);
        mostwicket = (CardView) findViewById(R.id.mostwicketid);
        besteconomy = (CardView) findViewById(R.id.besteconomyid);
        bestbowl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BowlingStatsActivity.this,BestBowlingActivity.class);
                startActivity(intent);
            }
        });
        mostwicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BowlingStatsActivity.this,MostWicketActivity.class);
                startActivity(intent);
            }
        });
        besteconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BowlingStatsActivity.this,BestEconomyActivity.class);
                startActivity(intent);
            }
        });
    }
}
