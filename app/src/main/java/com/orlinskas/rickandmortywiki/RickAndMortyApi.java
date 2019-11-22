package com.orlinskas.rickandmortywiki;

import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.entity.Episode;
import com.orlinskas.rickandmortywiki.entity.EpisodesPage;
import com.orlinskas.rickandmortywiki.entity.Location;
import com.orlinskas.rickandmortywiki.entity.LocationsPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyApi {
    @GET("character")
    Call<CharactersPage> getCharacterPage();

    @GET("location")
    Call<LocationsPage> getLocationPage();

    @GET("episode")
    Call<EpisodesPage> getEpisodesPage();

    @GET("character")
    Call<Character> getCharacter(@Path("id") int id);

    @GET("location")
    Call<Location> getLocation(@Path("id") int id);

    @GET("episode")
    Call<Episode> getEpisode(@Path("id") int id);
}
