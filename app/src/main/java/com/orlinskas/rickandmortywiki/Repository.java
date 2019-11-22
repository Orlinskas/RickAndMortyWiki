package com.orlinskas.rickandmortywiki;

import android.util.Log;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private RickAndMortyApi messagesApi;
    private CharactersPage charactersPage;

    public Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        messagesApi = retrofit.create(RickAndMortyApi.class);
    }

    public CharactersPage getCharacters() {
        messagesApi.getCharacterPage().enqueue(new Callback<CharactersPage>() {
            @Override
            public void onResponse(Call<CharactersPage> call, Response<CharactersPage> response) {
               charactersPage = response.body();
            }

            @Override
            public void onFailure(Call<CharactersPage> call, Throwable t) {
                charactersPage = new CharactersPage();
                Log.e(getClass().getName(), t.getMessage());
            }
        });

        return charactersPage;
    }

    /*public List getLocations() {
        messagesApi.getLocations().enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                data = response.body();
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                data = new ArrayList();
            }
        });

        return data;
    }

    public List getEpisodes() {
        messagesApi.getEpisodes().enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                data = response.body();
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                data = new ArrayList();
            }
        });

        return data;
    }

     */
}
