package com.example.covidretrofitrapidapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.covidretrofitrapidapi.history.CovidHistory;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-193.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Test t = new Test.Builder()
                .setI(5)
                .build();

        CovidInfoService service = retrofit.create(CovidInfoService.class);

        Call<CovidHistory> call = service.covidHistory("usa", "2020-06-02");
        call.enqueue(new Callback<CovidHistory>() {
            @Override
            public void onResponse(Call<CovidHistory> call, Response<CovidHistory> response) {
                CovidHistory covidHistory = (CovidHistory) response.body();
                Log.d("RESULT", covidHistory.getResponse().get(0).getCountry());
            }

            @Override
            public void onFailure(Call<CovidHistory> call, Throwable t) {

            }
        });
    }
}



class Test{
    String s;
    int i;
    double d;
    Test(){
        s = "";
    }
    static class Builder{
        Test test = new Test();
        Builder setI(int i){
            test.i = i;
            return this;
        }
        Builder setS(String s){
            test.s = s;
            return this;
        }
        Builder setD(double d){
            test.d = d;
            return this;
        }
        Test build(){
            return test;
        }
    }
}

/*
используемые ссылки:
https://rapidapi.com/matchilling/api/chuck-norris/
https://www.jsonschema2pojo.org/
https://github.com/google/gson
*/