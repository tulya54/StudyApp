package com.lol.studyapp.api_clients;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Response;

public class ApiResponse {

    public final Status status;

    @Nullable
    public final Response data;

    @Nullable
    public final Response error;

    @Nullable
    public final Throwable throwabl;

    private ApiResponse(Status status, @Nullable retrofit2.Response data, @Nullable Response error, @Nullable Throwable throwabl) {
        this.status = status;
        this.data = data;
        this.error = error;
        this.throwabl = throwabl;
    }

    public static ApiResponse loading() {
        return new ApiResponse(Status.LOADING, null, null, null);
    }

    public static ApiResponse success(@NonNull retrofit2.Response data) {
        return new ApiResponse(Status.SUCCESS, data, null, null);
    }

    public static ApiResponse error(@NonNull Response error) {
        return new ApiResponse(Status.ERROR, null, error, null);
    }

    public static ApiResponse throwable(@NonNull Throwable throwabl) {
        return new ApiResponse(Status.THROWABLE, null, null, throwabl);
    }
}
