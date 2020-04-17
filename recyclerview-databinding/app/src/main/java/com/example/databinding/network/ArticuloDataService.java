package com.example.databinding.network;

import com.example.databinding.model.ArticuloDBResponse;
import com.example.databinding.model.EmployeeDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticuloDataService {
    @GET("v3/plp?force-plp=true&page-number=1&number-of-items-per-page=20")
    //&search-string=xbox
    Call<ArticuloDBResponse> getArticulos(@Query("search-string") String articulo);
}
