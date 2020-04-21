package com.example.databinding;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.databinding.model.Articulo;
import com.example.databinding.model.ArticuloRopository;
import com.example.databinding.model.Employee;
import com.example.databinding.model.EmployeeRepository;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
  private EmployeeRepository employeeRepository;
  private ArticuloRopository articuloRepository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    employeeRepository = new EmployeeRepository();
    articuloRepository = new ArticuloRopository();
  }

  public LiveData<List<Employee>> getAllEmployee() {
    return employeeRepository.getMutableLiveData();
  }

  public LiveData<List<Articulo>> getAllArticulos(String articulo){
    return articuloRepository.getMutableLiveData(articulo);
  }

}
