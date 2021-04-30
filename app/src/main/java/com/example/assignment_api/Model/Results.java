package com.example.assignment_api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("name")
    @Expose
    private Name name;

    public Results(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
}}
