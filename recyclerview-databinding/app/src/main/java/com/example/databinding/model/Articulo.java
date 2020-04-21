package com.example.databinding.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.databinding.R;
import com.google.gson.annotations.SerializedName;

public class Articulo {
    @SerializedName("productDisplayName")
    private String productDisplayName;
    @SerializedName("listPrice")
    private Double listPrice;
    @SerializedName("isMarketPlace")
    private Boolean isMarketPlace;
    @SerializedName("smImage")
    private String smImage;

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Boolean getMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(Boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public String getSmImage() {
        return smImage;
    }

    public void setSmImage(String smImage) {
        this.smImage = smImage;
    }

    // important code for loading image here
    @BindingAdapter({ "smImage" })
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                /*.setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())*/
                .load(imageURL)
                //.placeholder(R.drawable.loading)
                .into(imageView);
    }
}
