package com.example.jesustovartrujillo.barbermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainPeluquerias extends AppCompatActivity implements PeluqueriaAdapter.OnItemClickListener{

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NAME = "name";

    private RecyclerView mRecyclerView;
    private PeluqueriaAdapter mPeluqueriaAdapter;
    private ArrayList<Peluqueria> mPeluqueriaList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_peluquerias);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPeluqueriaList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url = "https://api.myjson.com/bins/126lj8";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("peluquerias");

                            for(int i=0; i<jsonArray.length(); i++) {
                                JSONObject peluqueria = jsonArray.getJSONObject(i);

                                String name = peluqueria.getString("name");
                                String imageUrl = peluqueria.getString("icono");

                                mPeluqueriaList.add(new Peluqueria(imageUrl, name));
                            }

                            mPeluqueriaAdapter = new PeluqueriaAdapter(MainPeluquerias.this, mPeluqueriaList);
                            mRecyclerView.setAdapter(mPeluqueriaAdapter);

                            mPeluqueriaAdapter.setOnItemClickListener(MainPeluquerias.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, PeluqueriaDetalleActivity.class);
        Peluqueria peluqueria = mPeluqueriaList.get(position);

        detailIntent.putExtra(EXTRA_URL, peluqueria.getImageUrl());
        detailIntent.putExtra(EXTRA_NAME, peluqueria.getName());

        startActivity(detailIntent);
    }
}
