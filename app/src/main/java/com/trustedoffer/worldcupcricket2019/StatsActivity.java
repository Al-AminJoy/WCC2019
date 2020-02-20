package com.trustedoffer.worldcupcricket2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class StatsActivity extends AppCompatActivity {
    CardView ball;
    CardView bat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        bat =  findViewById(R.id.batstatid);
        ball =  findViewById(R.id.bowlstatid);
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StatsActivity.this,BattingStatsActivity.class);
                startActivity(intent);
            }
        });
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StatsActivity.this,BowlingStatsActivity.class);
                startActivity(intent);
            }
        });
    }
}
