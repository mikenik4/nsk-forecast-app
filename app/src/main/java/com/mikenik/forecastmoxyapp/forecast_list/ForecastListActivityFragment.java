package com.mikenik.forecastmoxyapp.forecast_list;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikenik.forecastmoxyapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastListActivityFragment extends Fragment {

    public ForecastListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forecast_list, container, false);
    }
}
