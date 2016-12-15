package com.mikenik.forecastmoxyapp.api;

import com.mikenik.forecastmoxyapp.api.xml.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mikenik4 on 15.12.2016.
 */

public interface GismeteoApi {
    String NOVOSIBIRSK = "29634_1";

    @GET("xml/{town}.xml")
    Call<WeatherResponse> getTownForecast(@Path("town") String town);
}
