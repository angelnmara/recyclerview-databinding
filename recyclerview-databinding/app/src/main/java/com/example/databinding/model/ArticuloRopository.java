package com.example.databinding.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.databinding.network.ArticuloDataService;
import com.example.databinding.network.EmployeeDataService;
import com.example.databinding.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticuloRopository {
    private static final String TAG = "EmployeeRepository";
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private MutableLiveData<List<Articulo>> mutableLiveData = new MutableLiveData<>();

    public ArticuloRopository() {
    }

    public MutableLiveData<List<Articulo>> getMutableLiveData(String articulo) {

        final ArticuloDataService userDataService = RetrofitClient.getArticuloService();

        Call<ArticuloDBResponse> call = userDataService.getArticulos(articulo);
        call.enqueue(new Callback<ArticuloDBResponse>() {
            @Override
            public void onResponse(Call<ArticuloDBResponse> call, Response<ArticuloDBResponse> response) {
                ArticuloDBResponse articuloDBResponse = response.body();
                if (articuloDBResponse != null && articuloDBResponse.getPlpResults() != null) {
                    if(articuloDBResponse.getPlpResults().getArticulos().size()>0){
                        articulos = (ArrayList<Articulo>) articuloDBResponse.getPlpResults().getArticulos();
                        mutableLiveData.setValue(articulos);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArticuloDBResponse> call, Throwable t) {
                Log.d(TAG, "error" + t.getMessage());
            }
        });

        return mutableLiveData;
    }
}
