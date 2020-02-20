package com.trustedoffer.worldcupcricket2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TeamsActivity extends AppCompatActivity {
    CardView afg,aus,bd,engl,india,newz,pak,sa,sri,wi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        bd = (CardView) findViewById(R.id.cvbdid);
        engl=findViewById(R.id.cvengid);
        afg=findViewById(R.id.cvafgid);
        aus=findViewById(R.id.cvausid);
        india=findViewById(R.id.cvindid);
        newz=findViewById(R.id.cvnewzid);
        pak=findViewById(R.id.cvpakid);
        sa=findViewById(R.id.cvsaid);
        sri=findViewById(R.id.cvsriid);
        wi=findViewById(R.id.cvwiid);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,BdActivity.class);
                startActivity(intent);
            }
        });
        engl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,EngActivity.class);
                startActivity(intent);
            }
        });
        afg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,AfgActivity.class);
                startActivity(intent);
            }
        });
        aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,AusActivity.class);
                startActivity(intent);
            }
        });
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,IndActivity.class);
                startActivity(intent);
            }
        });
        newz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,NewzActivity.class);
                startActivity(intent);
            }
        });
        pak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,PakActivity.class);
                startActivity(intent);
            }
        });
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,SaActivity.class);
                startActivity(intent);
            }
        });
        sri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,SriActivity.class);
                startActivity(intent);
            }
        });
        wi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeamsActivity.this,WiActivity.class);
                startActivity(intent);
            }
        });
    }
}
