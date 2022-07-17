package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    public ProgressBar progressBar;
    private API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = RetrofitInstance.getRetrofit().create(API.class);

        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                onQueryNetwork(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void onQueryNetwork(String query) {
        api.getCurrentWeather(query,"0c9bc42de02c9735bbe5292140adf038").enqueue(new Callback<WeatherStatus>() {
            @Override
            public void onResponse(Call<WeatherStatus> call, Response<WeatherStatus> response) {
                if (response.isSuccessful()) {
                    WeatherRepository.getInstance().setWeatherStatus(response.body());
                    setUpFragment();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<WeatherStatus> call, Throwable t) {

            }
        });
    }

    public void setUpFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
//        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.beginTransaction().replace(R.id.fragment_container,DetailWeatherFragment.newInstance())
                    .commit();
//        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
}
