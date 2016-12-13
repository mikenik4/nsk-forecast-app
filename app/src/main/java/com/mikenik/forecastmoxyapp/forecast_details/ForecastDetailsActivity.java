package com.mikenik.forecastmoxyapp.forecast_details;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mikenik.forecastmoxyapp.R;

public class ForecastDetailsActivity extends MvpAppCompatActivity implements HelloWorldView {

    @InjectPresenter
    HelloWorldPresenter helloWorldPresenter;

    private TextView helloWorldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_details);
        helloWorldTextView = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void showMessage(int message) {
        helloWorldTextView.setText(message);
    }
}
