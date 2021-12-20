package com.lol.studyapp.mvvm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PidorList {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
  //  private List<String> releaseDate;

    @SerializedName("manufacturer")
    @Expose
    private Pidor manufacturer;


    public Pidor getManufacturer() {
        return manufacturer;
    }
}
