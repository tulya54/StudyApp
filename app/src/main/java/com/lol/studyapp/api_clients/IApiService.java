package com.lol.studyapp.api_clients;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface IApiService {

    @GET("v1/")
    Observable<Response<Response>> getResult();
}
