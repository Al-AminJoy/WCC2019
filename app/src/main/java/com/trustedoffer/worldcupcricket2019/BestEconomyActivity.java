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

public class BestEconomyActivity extends AppCompatActivity {
    private BestEconomyAdapter bestEconomyAdapter;
    public ArrayList<BestEconomyModelClass> dataitem = new ArrayList();
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    public String url = "https://api.jsonbin.io/b/5ca879a185438b0272ef68f4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_economy);
        recyclerView =findViewById(R.id.rvbesteconomyid);
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
                    JSONArray jsonArray = jsonObject.getJSONArray("Best_Eco");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String player = receive.getString("player");
                        String team = receive.getString("Team");
                        String eco = receive.getString("Eco");


                        BestEconomyModelClass data = new BestEconomyModelClass (player,team,eco);
                        dataitem.add(data);
                    }
                    bestEconomyAdapter = new BestEconomyAdapter(getApplicationContext(), dataitem);
                    recyclerView.setAdapter(bestEconomyAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY_ERROR",error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }
}
