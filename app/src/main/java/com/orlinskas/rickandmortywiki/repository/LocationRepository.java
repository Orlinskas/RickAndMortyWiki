package com.orlinskas.rickandmortywiki.repository;

import com.orlinskas.rickandmortywiki.ApiResponsibleListener;
import com.orlinskas.rickandmortywiki.RickAndMortyApi;
import com.orlinskas.rickandmortywiki.entity.Location;
import com.orlinskas.rickandmortywiki.entity.LocationsPage;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationRepository implements ApiRepository {
    private RickAndMortyApi rickAndMortyApi;
    private ApiResponsibleListener apiResponsibleListener;

    public LocationRepository(ApiResponsibleListener apiResponsibleListener) {
        this.apiResponsibleListener = apiResponsibleListener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        rickAndMortyApi = retrofit.create(RickAndMortyApi.class);
    }

    @Override
    public void getResultPage(final int pageNumber) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    LocationsPage locationsPage = rickAndMortyApi.getLocationPage(pageNumber).execute().body();
                    apiResponsibleListener.onDonePageResponse(locationsPage);
                } catch (IOException e) {
                    apiResponsibleListener.onFailResponse(e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void getConcreteResult(final int id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Location location = rickAndMortyApi.getConcreteLocation(id).execute().body();
                    apiResponsibleListener.onDoneConcreteResponse(location);
                } catch (IOException e) {
                    apiResponsibleListener.onFailResponse(e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

