package com.trustedoffer.worldcupcricket2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class BestBowlingActivity extends AppCompatActivity {
    private BestBowlingAdapter bestBowlingAdapter;
    public ArrayList<BestBowlingModelClass> dataitem = new ArrayList();
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    public String url = "https://api.myjson.com/bins/p8t1z";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_bowling);
        recyclerView = findViewById(R.id.rvbestbowlingid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        loadData();
    }

    private void loadData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("MostWickets");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String player = receive.getString("player");
                        String team = receive.getString("Team");
                        String wicket = receive.getString("wickets");


                        BestBowlingModelClass data = new BestBowlingModelClass (player,team,wicket);
                        dataitem.add(data);
                    }
                    bestBowlingAdapter = new BestBowlingAdapter(getApplicationContext(), dataitem);
                    recyclerView.setAdapter(bestBowlingAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
}
