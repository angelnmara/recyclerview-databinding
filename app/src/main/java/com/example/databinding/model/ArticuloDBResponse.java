package com.example.databinding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticuloDBResponse {
    @SerializedName("plpResults")
    @Expose
    private plpResults PlpResults;

    public plpResults getPlpResults() {
        return PlpResults;
    }

    public void setPlpResults(plpResults plpResults) {
        PlpResults = plpResults;
    }
}
