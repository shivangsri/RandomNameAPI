package com.example.assignment_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.assignment_api.Model.JSONResponse;
import com.example.assignment_api.Model.Results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private  Adapter adapter;
    private  RecyclerView recyclerView;

    List<Results> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyler);
        results = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        API api = retrofit.create(API.class);


        Call<JSONResponse> call = api.getResults();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                    results = new ArrayList<>(Arrays.asList(response.body().getResult()));
                    adapter = new Adapter(MainActivity.this, results);

                    recyclerView.setAdapter(adapter);
                    Log.d("shiva", "onResponse: ");


                }


            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("shiva", "onFailure: ");

            }
        });

    }


}