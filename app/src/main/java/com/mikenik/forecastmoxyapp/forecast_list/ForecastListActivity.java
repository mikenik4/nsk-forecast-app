package com.mikenik.forecastmoxyapp.forecast_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.forecast_details.ForecastDetailsActivity;

public class ForecastListActivity extends AppCompatActivity {

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
                startActivity(new Intent(ForecastListActivity.this, ForecastDetailsActivity.class));
            }
        });

        if (savedInstanceState == null) {
            loadEmptyListFragment();
        }
    }

    private void loadEmptyListFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new ForecastEmptyListFragment())
                .commit();
    }
}
