package com.orlinskas.rickandmortywiki;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;

import java.io.IOException;

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

    public CharactersPage getCharacters() throws IOException {
        return messagesApi.getCharacterPage().execute().body();
    }

        //messagesApi.getCharacterPage().enqueue(new Callback<CharactersPage>() {
        //    @Override
        //    public void onResponse(Call<CharactersPage> call, Response<CharactersPage> response) {
        //       charactersPage = response.body();
        //    }
//
        //    @Override
        //    public void onFailure(Call<CharactersPage> call, Throwable t) {
        //        charactersPage = new CharactersPage();
        //        Log.e(getClass().getName(), t.getMessage());
        //    }
        //});
//
        //return charactersPage;
}
