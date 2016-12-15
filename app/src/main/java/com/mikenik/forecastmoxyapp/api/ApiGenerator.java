package com.mikenik.forecastmoxyapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by mikenik4 on 15.12.2016.
 */

public final class ApiGenerator {
    private static final String API_BASE_URL = "http://informer.gismeteo.ru/";

    private ApiGenerator() {
    }

    public static GismeteoApi createApi() {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build()
                .create(GismeteoApi.class);
    }
}
