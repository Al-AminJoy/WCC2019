package com.trustedoffer.worldcupcricket2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView point;
    CardView schedule;
    CardView squad;
    CardView stats;
    CardView livescore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       squad =  findViewById(R.id.squadid);
        schedule =  findViewById(R.id.scheduleid);
        point =  findViewById(R.id.pointid);
        stats =  findViewById(R.id.statsid);
        livescore=findViewById(R.id.livescoreid);
        squad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TeamsActivity.class);
                startActivity(intent);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PointTableActivity.class);
                startActivity(intent);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ScheduleActivity.class);
                startActivity(intent);
            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StatsActivity.class);
                startActivity(intent);
            }
        });
        livescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LiveScoreActivity.class);
                startActivity(intent);
            }
        });


    }
}
