package com.example.covidretrofitrapidapi;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CovidInfoService {
    @Headers({
            "X-RapidAPI-Host: covid-193.p.rapidapi.com",
            "X-RapidAPI-Key: 61055453d2msh4eb1ae532c057cfp1a05afjsnb6e5a75c1989"
    })
    @GET("history")
    Call<CovidHistory> covidHistory(@Query("country") String country, @Query("day")String day);
}
//https://covid-193.p.rapidapi.com/history?country=usa&day=2020-06-02
