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

public class MostCenturyActivity extends AppCompatActivity {
    public ArrayList<MostCenturyModelClass> dataitem = new ArrayList();
    private MostCenturyAdapter mostCenturyAdapter;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    public String url = "https://api.jsonbin.io/b/5ca79d6da40eb3474aed1de6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_century);
        recyclerView =findViewById(R.id.rvmostcenturyid);
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
                    JSONArray jsonArray = jsonObject.getJSONArray("Most_Hundreds");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String player = receive.getString("player");
                        String team = receive.getString("Team");
                        String hundread = receive.getString("hundreads");


                        MostCenturyModelClass data = new MostCenturyModelClass (player,team,hundread);
                        dataitem.add(data);
                    }
                    mostCenturyAdapter = new MostCenturyAdapter(getApplicationContext(), dataitem);
                    recyclerView.setAdapter(mostCenturyAdapter);

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
