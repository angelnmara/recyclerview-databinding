package com.example.databinding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.R;
import com.example.databinding.databinding.ArticuloListItemBinding;
import com.example.databinding.databinding.EmployeeListItemBinding;
import com.example.databinding.model.Articulo;
import com.example.databinding.model.Employee;

import java.util.ArrayList;

public class ArticuloDataAdapter extends RecyclerView.Adapter<ArticuloDataAdapter.ArticuloViewHolder> {

    private ArrayList<Articulo> articulos;

    @NonNull
    @Override
    public ArticuloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticuloListItemBinding articuloListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.articulo_list_item, parent, false);
        return new ArticuloDataAdapter.ArticuloViewHolder(articuloListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticuloViewHolder holder, int position) {
        Articulo currentArticulo = articulos.get(position);
        holder.articuloListItemBinding.setArticulo(currentArticulo);
    }

    @Override
    public int getItemCount() {
        if (articulos != null) {
            return articulos.size();
        } else {
            return 0;
        }
    }

    public void setArticuloList(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
        notifyDataSetChanged();
    }

    class ArticuloViewHolder extends RecyclerView.ViewHolder {

        private ArticuloListItemBinding articuloListItemBinding;

        public ArticuloViewHolder(@NonNull ArticuloListItemBinding articuloListItemBinding) {
            super(articuloListItemBinding.getRoot());

            this.articuloListItemBinding = articuloListItemBinding;
        }
    }
}