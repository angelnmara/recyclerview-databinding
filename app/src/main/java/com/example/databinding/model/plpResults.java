package com.example.databinding.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class plpResults {
    @SerializedName("label")
    private String label;

    @SerializedName("records")
    private List<Articulo> articulos;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
