package com.mikenik.forecastmoxyapp.forecast_list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;

import java.util.List;

/**
 * Created by mikenik4 on 14.12.2016.
 */
@StateStrategyType(SkipStrategy.class)
public interface ForecastListView extends MvpView {
    void showEmptyList();

    void showProgress();

    void hideProgress();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showForecastList(List<Forecast> forecasts);

    void showConnectionError();

    void showServerError();
}
