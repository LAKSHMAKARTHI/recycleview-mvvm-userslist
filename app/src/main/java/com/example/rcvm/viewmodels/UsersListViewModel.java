package com.example.rcvm.viewmodels;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.rcvm.apis.APIServices;
import com.example.rcvm.apis.RetroInstance;
import com.example.rcvm.models.ResponseModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersListViewModel extends ViewModel {
    private MutableLiveData<ResponseModal> data;

    public UsersListViewModel(){
        data=new MutableLiveData<>();
    }

    public MutableLiveData<ResponseModal> getUserslistObserver()
    {
        return data;
    }

    public void makeApiCall()
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<ResponseModal> call = apiServices.getUsersList();
        call.enqueue(new Callback<ResponseModal>() {
            @Override
            public void onResponse(Call<ResponseModal> call, Response<ResponseModal> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModal> call, Throwable t) {
                data.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });
    }
}
