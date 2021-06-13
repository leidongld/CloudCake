package com.openld.cloudcake.main.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openld.cloudcake.CloudCakeApplication;
import com.openld.cloudcake.R;
import com.openld.cloudcake.WeatherIconFactory;
import com.openld.cloudcake.beans.CityWeatherBean;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/6/3 15:25
 * description:
 */
public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.ViewHolder> {
    private final List<CityWeatherBean.DataDTO.ForecastDTO> mForecastDTOList;

    public FutureWeatherAdapter(List<CityWeatherBean.DataDTO.ForecastDTO> forecastDTOList) {
        this.mForecastDTOList = forecastDTOList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(CloudCakeApplication.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (getItemCount() == 0) {
            return;
        }

        CityWeatherBean.DataDTO.ForecastDTO forecastDTO = mForecastDTOList.get(position);
        if (forecastDTO == null) {
            return;
        }

        holder.imgWeatherType.setImageDrawable(CloudCakeApplication.getContext().getResources().getDrawable(WeatherIconFactory.calculateWeatherIcon(forecastDTO.type)));
        holder.txtWeatherType.setText(forecastDTO.type);
        holder.txtDate.setText(forecastDTO.date);
        holder.txtTemperatureLow.setText(forecastDTO.low);
        holder.txtTemperatureHigh.setText(forecastDTO.high);
        holder.txtWindOrientation.setText(forecastDTO.fengxiang);
        holder.txtWindPower.setText(forecastDTO.fengli);
    }

    @Override
    public int getItemCount() {
        return mForecastDTOList == null ? 0 : mForecastDTOList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgWeatherType;

        private final TextView txtWeatherType;

        private final TextView txtDate;

        private final TextView txtTemperatureLow;

        private final TextView txtTemperatureHigh;

        private final TextView txtWindOrientation;

        private final TextView txtWindPower;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgWeatherType = itemView.findViewById(R.id.img_weather_type);
            txtWeatherType = itemView.findViewById(R.id.txt_weather_type);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtTemperatureLow = itemView.findViewById(R.id.txt_temperature_low);
            txtTemperatureHigh = itemView.findViewById(R.id.txt_temperature_high);
            txtWindOrientation = itemView.findViewById(R.id.txt_wind_orientation);
            txtWindPower = itemView.findViewById(R.id.txt_wind_power);
        }
    }
}
