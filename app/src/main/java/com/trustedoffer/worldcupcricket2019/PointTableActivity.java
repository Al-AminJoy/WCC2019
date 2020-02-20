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

public class PointTableActivity extends AppCompatActivity {
    PointAdapter pointAdapter;
    ArrayList<PointModelClass> pointlistitem = new ArrayList();
    RecyclerView recyclerView;
    private RequestQueue requestQueue;
    String url = "https://api.jsonbin.io/b/5ca4b2779d43d80f8dba3890";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_table);
        recyclerView = findViewById(R.id.pointrvid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();
    }

    private void loadData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("PointData");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String team = receive.getString("team");
                        String played = receive.getString("played");
                        String won = receive.getString("won");
                        String lost = receive.getString("lost");
                        String tie = receive.getString("tie");
                        String point = receive.getString("point");
                        String runrate = receive.getString("runRate");

                        PointModelClass data = new PointModelClass(team,played,won,lost,tie,point,runrate);
                        pointlistitem.add(data);
                    }
                    pointAdapter = new PointAdapter(getApplicationContext(), pointlistitem);
                    recyclerView.setAdapter(pointAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}

