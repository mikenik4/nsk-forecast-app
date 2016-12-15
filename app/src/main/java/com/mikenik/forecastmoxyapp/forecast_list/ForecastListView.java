package com.mikenik.forecastmoxyapp.forecast_list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by mikenik4 on 14.12.2016.
 */

public interface ForecastListView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showEmptyList();

    void showForecastList();//TODO give list or id

    void showError(int message);

    void showForecastDetails();//TODO which forecast?
}
