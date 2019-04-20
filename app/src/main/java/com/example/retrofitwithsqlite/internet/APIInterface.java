package com.example.retrofitwithsqlite.internet;

import com.example.retrofitwithsqlite.model.LoginToken;
import com.example.retrofitwithsqlite.model.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginToken> logInUser(@Field("email") String userName,
                               @Field("password") String password);

    @GET("/princex11/AppLog/productData")
    Call<ArrayList<ProductModel>> getProductModel();

}
