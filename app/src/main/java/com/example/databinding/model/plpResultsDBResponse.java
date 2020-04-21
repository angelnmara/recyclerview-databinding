package com.example.databinding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class plpResultsDBResponse {
    @SerializedName("plpResults")
    @Expose
    private List<plpResults> plpResults;
}
