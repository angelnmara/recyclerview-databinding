package com.example.databinding;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.adapter.ArticuloDataAdapter;
import com.example.databinding.adapter.EmployeeDataAdapter;
import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.model.Articulo;
import com.example.databinding.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements androidx.appcompat.widget.SearchView.OnQueryTextListener {
  private MainViewModel mainViewModel;
  private EmployeeDataAdapter employeeDataAdapter;
  private ArticuloDataAdapter articuloDataAdapter;

  androidx.appcompat.widget.SearchView svBuscaArticulo;
  RecyclerView recyclerView;

  Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    context = this;

    ActivityMainBinding activityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main);

    // bind RecyclerView
    recyclerView = activityMainBinding.viewEmployees;
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);

    /*mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    employeeDataAdapter = new EmployeeDataAdapter();
    recyclerView.setAdapter(employeeDataAdapter);*/

    mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    articuloDataAdapter = new ArticuloDataAdapter();
    recyclerView.setAdapter(articuloDataAdapter);

    //Busqueda

    svBuscaArticulo = findViewById(R.id.svBuscaArticulo);
    svBuscaArticulo.setOnQueryTextListener(this);

    // Get the search close button image view
    ImageView closeButton = (ImageView)svBuscaArticulo.findViewById(R.id.search_close_btn);

    // Set on click listener
    closeButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        //Log.d("", "Search close button clicked");
        //Toast.makeText(context, "click", Toast.LENGTH_LONG).show();
        EditText et = (EditText) findViewById(R.id.search_src_text);
        et.setText("");
        getAllArticulo("");
        recyclerView.setVisibility(View.INVISIBLE);
      }
    });

    //getAllEmployee();
  }

  private void getAllEmployee() {
    mainViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
      @Override
      public void onChanged(@Nullable List<Employee> employees) {
        employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
      }
    });
  }

  private void getAllArticulo(String articulo){
    mainViewModel.getAllArticulos(articulo).observe(this, new Observer<List<Articulo>>() {
      @Override
      public void onChanged(@Nullable List<Articulo> articulos) {
        articuloDataAdapter.setArticuloList((ArrayList<Articulo>) articulos);
      }
    });
  }

  @Override
  public boolean onQueryTextSubmit(String query) {
    getAllArticulo(query);
    recyclerView.setVisibility(View.VISIBLE);
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }
}
