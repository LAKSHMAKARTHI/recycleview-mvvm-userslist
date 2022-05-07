package com.example.rcvm.apis;

import com.example.rcvm.models.ResponseModal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    @GET("users")
    Call<ResponseModal> getUsersList();
}
