package com.example.databinding.network;

import com.example.databinding.model.Articulo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static Retrofit retrofit;
  private static final String BASE_URL = "https://reqres.in/api/";
  private static final String BASE_URL_LIVERPOOL = "https://shoppapp.liverpool.com.mx/appclienteservices/services/";

  public static EmployeeDataService getService() {
    if (retrofit == null) {
      retrofit = new Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

    return retrofit.create(EmployeeDataService.class);
  }

  public static ArticuloDataService getArticuloService() {
    if (retrofit == null) {
      retrofit = new Retrofit
              .Builder()
              .baseUrl(BASE_URL_LIVERPOOL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
    }

    return retrofit.create(ArticuloDataService.class);
  }

}