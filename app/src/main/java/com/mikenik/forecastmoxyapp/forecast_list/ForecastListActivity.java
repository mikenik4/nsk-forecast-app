package com.mikenik.forecastmoxyapp.forecast_list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.ApiGenerator;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.databinding.ActivityForecastListBinding;

import java.util.List;

public class ForecastListActivity extends MvpAppCompatActivity implements ForecastListView {
    private static final String LIST_FRAGMENT_TAG = "list_fragment";
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast_list);
        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.refreshForecasts();
            }
        });
    }

    @Override
    public void showEmptyList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ForecastEmptyListFragment()).commit();
    }

    @Override
    public void showProgress() {
        binding.fab.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        binding.fab.setEnabled(true);
    }

    @Override
    public void showForecastList(List<Forecast> forecasts) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ForecastListFragment listFragment =
                (ForecastListFragment) fragmentManager.findFragmentByTag(LIST_FRAGMENT_TAG);
        if (listFragment == null) {
            listFragment = ForecastListFragment.newInstance();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, listFragment, LIST_FRAGMENT_TAG)
                    .commit();
        }
        listFragment.setForecasts(forecasts);
    }

    @Override
    public void showConnectionError() {
        showErrorSnackbar(R.string.connection_error);
    }

    @Override
    public void showServerError() {
        showErrorSnackbar(R.string.server_error);
    }

    private void showErrorSnackbar(@StringRes int message) {
        Snackbar.make(binding.coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
