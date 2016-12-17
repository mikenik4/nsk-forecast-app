package com.mikenik.forecastmoxyapp.forecast_list;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikenik.forecastmoxyapp.R;
import com.mikenik.forecastmoxyapp.api.xml.Forecast;
import com.mikenik.forecastmoxyapp.api.xml.Wind;
import com.mikenik.forecastmoxyapp.databinding.ForecastItemBinding;

import java.text.SimpleDateFormat;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastRecyclerViewAdapter.ViewHolder> {
    public interface ItemClickListener {
        void onClick(Forecast forecast);
    }

    private List<Forecast> forecasts;
    private final ItemClickListener itemClickListener;

    private final Resources resources;
    private final SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm, EEE, d MMM");
    private final String[] windDirections;

    public ForecastRecyclerViewAdapter(Resources resources, List<Forecast> forecasts, ItemClickListener listener) {
        this.resources = resources;
        this.forecasts = forecasts;
        this.itemClickListener = listener;
        windDirections = resources.getStringArray(R.array.item_wind_direction);
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ForecastItemBinding binding = ForecastItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTo(forecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ForecastItemBinding binding;

        ViewHolder(ForecastItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        void bindTo(Forecast forecast) {
            binding.date.setText(dateformat.format(forecast.getTimeDate()));
            binding.temperature.setText(resources.getString(R.string.item_temperature,
                    forecast.getTemperature().getMean()));
            binding.heat.setText(resources.getString(R.string.item_feels_like,
                    forecast.getHeat().getRoundedMean()));
            Wind wind = forecast.getWind();
            binding.wind.setText(resources.getString(R.string.item_wind, wind.getRoundedMean(),
                    windDirections[wind.getDirection()]));
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            if (pos != NO_POSITION) {
                itemClickListener.onClick(forecasts.get(pos));
            }
        }
    }
}
