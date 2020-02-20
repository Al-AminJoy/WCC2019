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

public class MostRunsActivity extends AppCompatActivity {
    MostRunsAdapter mostRunsAdapter;
    ArrayList<MostRunsModelClass> dataitem = new ArrayList();
    RecyclerView recyclerView;
    private RequestQueue requestQueue;
    String url = "https://api.jsonbin.io/b/5ca48fc59d43d80f8dba1f83";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_runs);
        recyclerView = (RecyclerView) findViewById(R.id.mostrunrvid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        loaddata();
    }

    private void loaddata() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("Most_Run");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String player = receive.getString("player");
                        String team = receive.getString("Team");
                        String runs = receive.getString("Runs");


                        MostRunsModelClass data = new MostRunsModelClass (player,team,runs);
                        dataitem.add(data);
                    }
                    mostRunsAdapter = new MostRunsAdapter(getApplicationContext(), dataitem);
                    recyclerView.setAdapter(mostRunsAdapter);

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
