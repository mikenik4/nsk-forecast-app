package com.mikenik.forecastmoxyapp.forecast_details;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.databinding.ActivityForecastDetailsBinding;

public class ForecastDetailsActivity extends AppCompatActivity {
    private static final String FORECAST = ForecastDetailsActivity.class.getPackage() + ".Forecast";

    private ActivityForecastDetailsBinding binding;

    public static Intent getStartingIntent(Context context, Forecast forecast) {
        Intent intent = new Intent(context, ForecastDetailsActivity.class);
        intent.putExtra(FORECAST, forecast);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast_details);
        Forecast forecast = (Forecast) getIntent().getSerializableExtra(FORECAST);
    }
}
