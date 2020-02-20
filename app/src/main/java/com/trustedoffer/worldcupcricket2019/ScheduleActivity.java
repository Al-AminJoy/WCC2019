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


public class ScheduleActivity extends AppCompatActivity {
    ArrayList<ScheduleModelClass> listItem = new ArrayList();
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    String url = "https://api.myjson.com/bins/12zdu7";
    ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        recyclerView = findViewById(R.id.schedulervid);
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
                    JSONArray jsonArray = jsonObject.getJSONArray("schedule_data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject receive = jsonArray.getJSONObject(i);
                        String date = receive.getString("date");
                        String time = receive.getString("time");
                        String match = receive.getString("match");
                        String status = receive.getString("status");
                        String stadium = receive.getString("stadium");
                        String leftcoun = receive.getString("left_country");
                        String rightcoun = receive.getString("right_country");
                        String leftcounimg = receive.getString("left_country_img");
                        String rightcounimg = receive.getString("right_country_img");
                        ScheduleModelClass data = new ScheduleModelClass(date, time, match, stadium, status, leftcoun, rightcoun, leftcounimg, rightcounimg);
                        listItem.add(data);
                    }
                    scheduleAdapter = new ScheduleAdapter(getApplicationContext(), listItem);
                    recyclerView.setAdapter(scheduleAdapter);

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
