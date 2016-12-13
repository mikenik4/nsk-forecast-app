package com.mikenik.forecastmoxyapp.forecast_details;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mikenik.forecastmoxyapp.R;

/**
 * Created by mikenik4 on 13.12.2016.
 */
@InjectViewState
public class HelloWorldPresenter extends MvpPresenter<HelloWorldView> {
    public HelloWorldPresenter() {
        getViewState().showMessage(R.string.app_name);
    }
}
