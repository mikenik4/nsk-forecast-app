package com.mikenik.forecastmoxyapp.forecast_list;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.ApiGenerator;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.databinding.ActivityForecastListBinding;
import com.mikenik.forecastmoxyapp.forecast_details.ForecastDetailsActivity;

import java.util.List;

public class ForecastListActivity extends MvpAppCompatActivity implements ForecastListView {
    private ActivityForecastListBinding binding;

    @InjectPresenter
    ForecastListPresenter presenter;

    @ProvidePresenter
    ForecastListPresenter provideForecastListPresenter() {
        return new ForecastListPresenter(ApiGenerator.createApi());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.i(getLocalClassName(), "onCreate");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast_list);
        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.refreshForecasts();
            }
        });

        if (savedInstanceState == null) {
            showEmptyList();
        }
    }

    @Override
    public void showEmptyList() {
//        Log.i(getLocalClassName(), "showEmptyList");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ForecastEmptyListFragment()).commit();
    }

    @Override
    public void showProgress() {
//        Log.i(getLocalClassName(), "showProgress");
        binding.fab.setEnabled(false);
    }

    @Override
    public void hideProgress() {
//        Log.i(getLocalClassName(), "hideProgress");
        binding.fab.setEnabled(true);
    }

    @Override
    public void showForecastList(List<Forecast> forecasts) {
//        Log.i(getLocalClassName(), "showForecastList");
        //TODO change fragment, load in recyclerview
    }

    @Override
    public void showConnectionError() {
//        Log.i(getLocalClassName(), "showConnectionError ");
        showErrorSnackbar(R.string.connection_error);
    }

    @Override
    public void showServerError() {
//        Log.i(getLocalClassName(), "showServerError");
        showErrorSnackbar(R.string.server_error);
    }

    private void showErrorSnackbar(@StringRes int message) {
        Snackbar.make(binding.coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showForecastDetails() {
        //TODO give some info through intent
        startActivity(new Intent(ForecastListActivity.this, ForecastDetailsActivity.class));
    }
}
