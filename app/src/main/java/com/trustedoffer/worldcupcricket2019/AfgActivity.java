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

public class AfgActivity extends AppCompatActivity {
    ArrayList<BdModelClass> dataitem = new ArrayList<>();
    RecyclerView recyclerView;
    BdAdapter bdAdapter;
    RequestQueue requestQueue;
    String url = "https://api.myjson.com/bins/q7m53";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afg);
        recyclerView = findViewById(R.id.rvafgplayerdetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        loaddata();
    }

    private void loaddata() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("afganistan");
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject receive=jsonArray.getJSONObject(i);
                        String imgurl=receive.getString("img");
                        String name=receive.getString("player");
                        String role=receive.getString("role");
                        BdModelClass data=new BdModelClass(imgurl,name,role);
                        dataitem.add(data);

                    }
                    bdAdapter=new BdAdapter(getApplicationContext(),dataitem);
                    recyclerView.setAdapter(bdAdapter);
                    bdAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("JSON_EXCEPTION",e.getMessage());
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
