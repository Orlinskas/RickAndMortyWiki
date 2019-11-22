package com.orlinskas.rickandmortywiki;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RepositoryTest {
    private Repository repository;

    @Test
    public void getCharacters() {
        repository = new Repository();
        CharactersPage charactersPage = repository.getCharacters();
        assertTrue(charactersPage.getCharacters().size() > 0);
    }

    @Test
    public void getLocations() {

    }

    @Test
    public void getEpisodes() {

    }
}