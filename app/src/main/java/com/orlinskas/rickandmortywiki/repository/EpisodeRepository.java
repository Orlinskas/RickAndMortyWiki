package com.orlinskas.rickandmortywiki.repository;

import com.orlinskas.rickandmortywiki.entity.Episode;
import com.orlinskas.rickandmortywiki.entity.EpisodesPage;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpisodeRepository implements ApiRepository {
    private RickAndMortyApi rickAndMortyApi;
    private ApiResponsibleListener apiResponsibleListener;

    public EpisodeRepository(ApiResponsibleListener apiResponsibleListener) {
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
                    EpisodesPage episodesPage = rickAndMortyApi.getEpisodesPage(pageNumber).execute().body();
                    apiResponsibleListener.onDonePageResponse(episodesPage);
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
                    Episode episode = rickAndMortyApi.getConcreteEpisode(id).execute().body();
                    apiResponsibleListener.onDoneConcreteResponse(episode);
                } catch (IOException e) {
                    apiResponsibleListener.onFailResponse(e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
