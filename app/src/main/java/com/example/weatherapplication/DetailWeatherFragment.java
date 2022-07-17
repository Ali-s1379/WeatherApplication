package com.example.weatherapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailWeatherFragment extends Fragment {

    public static final String QUERY = "com.example.";
    ImageView imageViewIcon;
    TextView textViewCity;
    TextView textViewState;
    private WeatherRepository repository;

    private String url;
    private String cityName;
    private String state;
    private WeatherStatus weatherStatus;

    public static DetailWeatherFragment newInstance() {

        Bundle args = new Bundle();

        DetailWeatherFragment fragment = new DetailWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public DetailWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_weather, container, false);
        textViewCity = view.findViewById(R.id.text_city_name);
        textViewState = view.findViewById(R.id.text_state);
        imageViewIcon = view.findViewById(R.id.img_icon);

        repository = WeatherRepository.getInstance();
        weatherStatus = repository.getWeatherStatus();

        cityName = weatherStatus.getName();
        state = weatherStatus.getWeatherList().get(0).getState();
        url = "https://openweathermap.org/img/w" + weatherStatus.getWeatherList()
                .get(0).getIcon() + ".png";

        textViewState.setText(state);
        textViewCity.setText(cityName);
        Picasso.get().load(url).into(imageViewIcon);
        return view;
    }

}
