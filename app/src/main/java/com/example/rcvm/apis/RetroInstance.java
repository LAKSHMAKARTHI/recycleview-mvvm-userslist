package com.example.rcvm.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String baseurl= "https://reqres.in/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit==null) {
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
