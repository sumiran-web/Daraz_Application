package com.example.daraz_application.url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {

        public static Retrofit retrofit = null;
        public static Retrofit getRetrofit(){

            /*if (retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.137.1:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }*/
            if (retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

    }
