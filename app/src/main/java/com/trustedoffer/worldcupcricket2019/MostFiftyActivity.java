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

public class MostFiftyActivity extends AppCompatActivity {
    public ArrayList<MostFiftyModelClass> dataitem = new ArrayList();
    private MostFiftyAdapter mostFiftyAdapter;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    public String url = "https://api.jsonbin.io/b/5ca79aa824f5074645ee913f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_fifty);
        recyclerView =  findViewById(R.id.rvmostfiftyid);
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
                    JSONArray jsonArray = jsonObject.getJSONArray("Most_Fifties");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String player = receive.getString("player");
                        String team = receive.getString("Team");
                        String fifty = receive.getString("fifties");


                        MostFiftyModelClass data = new MostFiftyModelClass (player,team,fifty);
                        dataitem.add(data);
                    }
                    mostFiftyAdapter = new MostFiftyAdapter(getApplicationContext(), dataitem);
                    recyclerView.setAdapter(mostFiftyAdapter);

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
