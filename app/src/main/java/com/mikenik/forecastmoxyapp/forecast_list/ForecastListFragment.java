package com.mikenik.forecastmoxyapp.forecast_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.forecast_details.ForecastDetailsActivity;

import java.util.List;

/**
 * A fragment representing a list of Forecast.
 */
public class ForecastListFragment extends Fragment implements ForecastRecyclerViewAdapter.ItemClickListener {

    private List<Forecast> forecasts;
    private ForecastRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
     * screen orientation changes).
     */
    public ForecastListFragment() {
    }

    public static ForecastListFragment newInstance() {
        return new ForecastListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView =
                (RecyclerView) inflater.inflate(R.layout.fragment_forecast_list, container, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        adapter = new ForecastRecyclerViewAdapter(getResources(), forecasts, this);
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    @Override
    public void onDestroyView() {
        adapter = null;
        super.onDestroyView();
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
        if (adapter != null) {
            adapter.setForecasts(forecasts);
            adapter.notifyDataSetChanged();//possibly change to diffutil
        }
    }

    /**
     * on list item click
     */
    @Override
    public void onClick(Forecast forecast) {
        startActivity(ForecastDetailsActivity.getStartingIntent(getContext(), forecast));
    }
}
