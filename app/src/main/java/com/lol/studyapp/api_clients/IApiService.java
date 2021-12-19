package com.lol.studyapp.api_clients;

import com.lol.studyapp.mvvm.models.PidorList;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IApiService {

  //  @Headers("Content-Type: application/json")
    @GET("inventory")
    Observable<Response<List<PidorList>>> getResult();
}
