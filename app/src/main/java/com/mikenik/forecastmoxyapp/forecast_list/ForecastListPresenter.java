package com.mikenik.forecastmoxyapp.forecast_list;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

/**
 * Created by mikenik4 on 14.12.2016.
 */
@InjectViewState
public class ForecastListPresenter extends MvpPresenter<ForecastListView> {
    public ForecastListPresenter() {
    }

    public void refreshForecasts(){
        //TODO make api request
    }
}
