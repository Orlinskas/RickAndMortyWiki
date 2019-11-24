package com.orlinskas.rickandmortywiki;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.entity.Episode;
import com.orlinskas.rickandmortywiki.entity.EpisodesPage;
import com.orlinskas.rickandmortywiki.entity.Location;
import com.orlinskas.rickandmortywiki.entity.LocationsPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RickAndMortyApi {
    @GET("character")
    Call<CharactersPage> getCharacterPage(@Query("page") int pageNumber);

    @GET("character/{id}/")
    Call<Character> getConcreteCharacter(@Path("id") int id);

    @GET("location")
    Call<LocationsPage> getLocationPage(@Query("page") int pageNumber);

    @GET("location/{id}/")
    Call<Location> getConcreteLocation(@Path("id") int id);

    @GET("episode")
    Call<EpisodesPage> getEpisodesPage(@Query("page") int pageNumber);

    @GET("episode/{id}/")
    Call<Episode> getConcreteEpisode(@Path("id") int id);
}
