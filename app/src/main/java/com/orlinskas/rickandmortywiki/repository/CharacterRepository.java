package com.orlinskas.rickandmortywiki.repository;

import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.entity.CharactersPage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterRepository implements ApiRepository {
    private RickAndMortyApi rickAndMortyApi;
    private ApiResponsibleListener apiResponsibleListener;

    public CharacterRepository(ApiResponsibleListener apiResponsibleListener) {
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
                    CharactersPage charactersPage = rickAndMortyApi.getCharacterPage(pageNumber).execute().body();
                    apiResponsibleListener.onDonePageResponse(charactersPage);
                } catch (Exception e) {
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
                    Character character = rickAndMortyApi.getConcreteCharacter(id).execute().body();
                    apiResponsibleListener.onDoneConcreteResponse(character);
                } catch (Exception e) {
                    apiResponsibleListener.onFailResponse(e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
