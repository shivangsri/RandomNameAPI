package com.example.assignment_api;

import com.example.assignment_api.Model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/api/?results=100&inc=name")
    Call<JSONResponse> getResults();
}
