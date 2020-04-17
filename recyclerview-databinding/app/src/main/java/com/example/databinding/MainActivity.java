package com.example.databinding;

import android.os.Bundle;
import android.widget.SearchView;

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding activityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main);

    // bind RecyclerView
    RecyclerView recyclerView = activityMainBinding.viewEmployees;
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
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }
}
