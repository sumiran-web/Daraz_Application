package com.example.daraz_application.api;

import com.example.daraz_application.Model.Users;
import com.example.daraz_application.Model.product;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersAPI {
    @GET("daraz_products")
    Call<List<Users>> getallItem();

    @GET("daraz_products")
//    Call<List<Products>> getallProducts();

    Call<List<product>> getallProduct();
}
