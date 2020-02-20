package com.trustedoffer.worldcupcricket2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class BattingStatsActivity extends AppCompatActivity {
    private CardView century;
    private CardView fifty;
    private CardView highscore;
    private CardView mostrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting_stats);
        mostrun = (CardView) findViewById(R.id.mostrunid);
        highscore = (CardView) findViewById(R.id.highscoreid);
        century = (CardView) findViewById(R.id.mosthundreadid);
        fifty = (CardView) findViewById(R.id.mostfiftyid);
        mostrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BattingStatsActivity.this,MostRunsActivity.class);
                startActivity(intent);
            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BattingStatsActivity.this,HighScoreActivity.class);
                startActivity(intent);
            }
        });
        century.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BattingStatsActivity.this,MostCenturyActivity.class);
                startActivity(intent);
            }
        });
        fifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BattingStatsActivity.this,MostFiftyActivity.class);
                startActivity(intent);
            }
        });



    }
}
