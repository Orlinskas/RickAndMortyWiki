package com.orlinskas.rickandmortywiki;

import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.entity.Episode;
import com.orlinskas.rickandmortywiki.entity.Location;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyApi {

   //@GET <E>
   //Call<ArrayList<E>> getDataList(@Path("type") String type);

   //@GET <E>
   //Call<E> getData(@Path("type") String type, @Path("id") int id);

    @GET("character")
    Call<CharactersPage> getCharacterPage();

    @GET("character")
    Call<ArrayList<Character>> getCharacters();

    @GET("location")
    Call<List<Location>> getLocations();

    @GET("episode")
    Call<List<Episode>> getEpisodes();

    @GET("character")
    Call<Character> getCharacter(@Path("id") int id);

    @GET("location")
    Call<Location> getLocation(@Path("id") int id);

    @GET("episode")
    Call<Episode> getEpisode(@Path("id") int id);
}
