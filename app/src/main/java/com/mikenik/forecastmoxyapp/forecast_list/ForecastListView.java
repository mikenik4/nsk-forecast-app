package com.mikenik.forecastmoxyapp.forecast_list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;

import java.util.List;

/**
 * Created by mikenik4 on 14.12.2016.
 */

public interface ForecastListView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showEmptyList();

    @StateStrategyType(SkipStrategy.class)
    void showProgress();

    @StateStrategyType(SkipStrategy.class)
    void hideProgress();

    void showForecastList(List<Forecast> forecasts);

    @StateStrategyType(SkipStrategy.class)
    void showConnectionError();

    @StateStrategyType(SkipStrategy.class)
    void showServerError();

    void showForecastDetails();//TODO which forecast?
}
