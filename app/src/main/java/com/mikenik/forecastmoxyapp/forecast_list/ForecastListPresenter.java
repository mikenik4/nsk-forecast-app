package com.mikenik.forecastmoxyapp.forecast_list;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mikenik.forecastmoxyapp.api.GismeteoApi;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.api.xml.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mikenik4 on 14.12.2016.
 */
@InjectViewState
public class ForecastListPresenter extends MvpPresenter<ForecastListView> {
    private GismeteoApi gismeteoApi;

    public ForecastListPresenter(GismeteoApi gismeteoApi) {
        this.gismeteoApi = gismeteoApi;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showEmptyList();
    }

    public void refreshForecasts() {
        getViewState().showProgress();
        gismeteoApi.getTownForecast(GismeteoApi.NOVOSIBIRSK)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call,
                                           Response<WeatherResponse> response) {
                        getViewState().hideProgress();
                        if (response.isSuccessful() && response.body() != null
                                && response.body().getTown() != null) {
                            List<Forecast> forecasts = response.body().getTown().getForecastList();
                            if (forecasts == null || forecasts.isEmpty()) {
                                getViewState().showEmptyList();
                            } else {
                                getViewState().showForecastList(forecasts);
                            }
                        } else {
                            getViewState().showServerError();
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        getViewState().hideProgress();
                        getViewState().showConnectionError();
                    }
                });
    }
}
