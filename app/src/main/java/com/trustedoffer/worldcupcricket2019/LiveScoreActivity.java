package com.trustedoffer.worldcupcricket2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LiveScoreActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
      LiveScoreAdapter liveScoreAdapter;
    private ArrayList<LiveScoreModelClass> datalist= new ArrayList<>();
    String url="http://ams.mapps.cricbuzz.com/cbzandroid/2.0/currentmatches.json";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);
        recyclerView=findViewById(R.id.rvlivescoreid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue= Volley.newRequestQueue(this);
        loaddata();
    }

    private void loaddata() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String BatTeamName="";
                String BatTeamImg="";
                String BowlTeamName="";
                String BowlTeamImg="";
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject object=jsonArray.getJSONObject(i);
                        String MatchID=object.getString("matchId");

                        JSONObject header=object.getJSONObject("header");
                        String MatchState=header.getString("mchState");
                        String type=header.getString("type");

                        if((MatchState.equals("inprogress")|| MatchState.equals("complete")) && (type.equals("ODI")|| type.equals("T20")|| type.equals("T20I")))
                        {

                            String status=header.getString("status");
                            JSONObject miniscore=object.getJSONObject("miniscore");
                            String BatTeamID=miniscore.getString("batteamid");
                            String BatTeamScore=miniscore.getString("batteamscore");
                            String BowlTeamScore=miniscore.getString("bowlteamscore");
                            String target =BowlTeamScore;
                            if (target.equals("")||target.equals("00"))
                            {
                               target="0";
                            }
                            else
                            {
                                String [] trg=target.split("/");
                                int res=Integer.parseInt(trg[0]);
                                String trget=String.valueOf(res+1);
                                target=trget;
                            }
                            String BatTeamOver=miniscore.getString("overs");
                            String BowlTeamOver=miniscore.getString("bowlteamovers");

                            JSONObject TeamOne=object.getJSONObject("team1");
                            String TeamOneID=TeamOne.getString("id");
                            JSONObject TeamTwo=object.getJSONObject("team2");
                            String TeamTwoID=TeamTwo.getString("id");
                            if (TeamOneID.equals(BatTeamID))
                            {
                               String BatTeamIDNo=TeamOne.getString("id");
                                String BowlTeamIDNo=TeamTwo.getString("id");
                                BatTeamName=TeamOne.getString("name");
                               BowlTeamName=TeamTwo.getString("name");

                               BatTeamImg="http://i.cricketcb.com/cbzandroid/2.0/flags/team_"+BatTeamIDNo+"_50.png";
                               BowlTeamImg="http://i.cricketcb.com/cbzandroid/2.0/flags/team_"+BowlTeamIDNo+"_50.png";
                            }
                          else
                            {
                                String BatTeamIDNo=TeamTwo.getString("id");
                                String BowlTeamIDNo=TeamOne.getString("id");
                                BatTeamName=TeamTwo.getString("name");
                                BowlTeamName=TeamOne.getString("name");

                                BatTeamImg="http://i.cricketcb.com/cbzandroid/2.0/flags/team_"+BatTeamIDNo+"_50.png";
                                BowlTeamImg="http://i.cricketcb.com/cbzandroid/2.0/flags/team_"+BowlTeamIDNo+"_50.png";
                            }
                          LiveScoreModelClass data=new LiveScoreModelClass(BatTeamName,BatTeamImg,BatTeamScore,BatTeamOver,BowlTeamName,BowlTeamImg,BowlTeamScore,BowlTeamOver,target,type,status);
                          datalist.add(data);
                        }

                    }
                    liveScoreAdapter=new LiveScoreAdapter(getApplicationContext(),datalist);
                    recyclerView.setAdapter(liveScoreAdapter);
                    liveScoreAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                   Log.d("JSON_EXCEPTION",e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley_Error",error.getMessage());

            }
        });
        requestQueue.add(stringRequest);

    }
}
