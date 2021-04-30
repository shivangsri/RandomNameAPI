package com.example.assignment_api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("last")
    @Expose
    private String last;

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }


    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }


}
