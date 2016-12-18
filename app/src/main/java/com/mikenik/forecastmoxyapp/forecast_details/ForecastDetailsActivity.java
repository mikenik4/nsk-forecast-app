package com.mikenik.forecastmoxyapp.forecast_details;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.api.xml.IntRange;
import com.mikenik.forecastmoxyapp.api.xml.Wind;
import com.mikenik.forecastmoxyapp.databinding.ActivityForecastDetailsBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        bind((Forecast) getIntent().getSerializableExtra(FORECAST));
    }

    private void bind(Forecast forecast) {
        binding.date.setText(
                SimpleDateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT)
                        .format(forecast.getTimeDate()));
        IntRange temperature = forecast.getTemperature();
        binding.temperatureMin.setText(getString(R.string.min, temperature.getMin()));
        binding.temperatureMax.setText(getString(R.string.max, temperature.getMax()));
        IntRange heat = forecast.getHeat();
        binding.heatMin.setText(getString(R.string.min, heat.getMin()));
        binding.heatMax.setText(getString(R.string.max, heat.getMax()));
        Wind wind = forecast.getWind();
        binding.windMin.setText(getString(R.string.min, wind.getMin()));
        binding.windMax.setText(getString(R.string.max, wind.getMax()));
        String[] windDirections = getResources().getStringArray(R.array.item_wind_direction);
        String windDirection = windDirections[wind.getDirection()];
        binding.windDirection.setText(getString(R.string.details_wind_direction, windDirection));
        IntRange pressure = forecast.getPressure();
        binding.pressureMin.setText(getString(R.string.min, pressure.getMin()));
        binding.pressureMax.setText(getString(R.string.max, pressure.getMax()));
        IntRange relwet = forecast.getRelwet();
        binding.relwetMin.setText(getString(R.string.min, relwet.getMin()));
        binding.relwetMax.setText(getString(R.string.max, relwet.getMax()));
    }
}
