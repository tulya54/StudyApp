package com.lol.studyapp.api_clients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public IApiService apiService;

    public ApiClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder()
//                    .addHeader("Authorization", "Bearer " +token)
                    .method(original.method(),original.body());
            return  chain.proceed(builder.build());
        }).connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.create();

        apiService = new Retrofit.Builder()
                .baseUrl("")
                .client(clientBuilder.build())
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(IApiService.class);
    }
}
