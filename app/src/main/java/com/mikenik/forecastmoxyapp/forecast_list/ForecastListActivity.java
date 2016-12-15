package com.mikenik.forecastmoxyapp.forecast_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.forecast_details.ForecastDetailsActivity;

public class ForecastListActivity extends MvpAppCompatActivity implements ForecastListView {

    @InjectPresenter
    ForecastListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        if (savedInstanceState == null) {
            showEmptyList();
        }
    }

    @Override
    public void showEmptyList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ForecastEmptyListFragment()).commit();
    }

    @Override
    public void showForecastList() {
        //TODO change fragment, load in recyclerview
    }

    @Override
    public void showError(int message) {
        //TODO show snackbar
    }

    @Override
    public void showForecastDetails() {
        //TODO give some info through intent
        startActivity(new Intent(ForecastListActivity.this, ForecastDetailsActivity.class));
    }
}
