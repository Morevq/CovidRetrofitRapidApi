package com.example.covidretrofitrapidapi;

import com.example.covidretrofitrapidapi.history.CovidHistory;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CovidInfoService {
    @GET("history")
    @Headers({
            "X-RapidAPI-Host: covid-193.p.rapidapi.com",
            "X-RapidAPI-Key: 61055453d2msh4eb1ae532c057cfp1a05afjsnb6e5a75c1989"
    })
    Call<CovidHistory> covidHistory(@Query("country") String country, @Query("day")String day);
    
    
    /*@GET("statistics")
    @Headers({
            "X-RapidAPI-Host: covid-193.p.rapidapi.com",
            "X-RapidAPI-Key: 61055453d2msh4eb1ae532c057cfp1a05afjsnb6e5a75c1989"
    })
    Call<CovidStatistics> covidStatisticsForCountry(@Query("country") String country);
    
    
    @GET("statistics")
    @Headers({
            "X-RapidAPI-Host: covid-193.p.rapidapi.com",
            "X-RapidAPI-Key: 61055453d2msh4eb1ae532c057cfp1a05afjsnb6e5a75c1989"
    })
    Call<CovidStatistics> covidStatisticsForAll();*/
}
//https://covid-193.p.rapidapi.com/history?country=usa&day=2020-06-02
