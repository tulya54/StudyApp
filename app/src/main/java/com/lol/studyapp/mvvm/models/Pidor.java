package com.lol.studyapp.mvvm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pidor {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("homePage")
    @Expose
    private String homePage;

    @SerializedName("phone")
    @Expose
    private String phone;
}
