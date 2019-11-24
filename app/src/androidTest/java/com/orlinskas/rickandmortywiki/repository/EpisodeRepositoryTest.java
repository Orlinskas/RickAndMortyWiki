package com.orlinskas.rickandmortywiki.repository;

import android.util.Log;

import com.orlinskas.rickandmortywiki.ApiResponsibleListener;
import com.orlinskas.rickandmortywiki.entity.Episode;
import com.orlinskas.rickandmortywiki.entity.EpisodesPage;

import org.junit.Test;

import static com.orlinskas.rickandmortywiki.TestConstants.WAIT_OF_RESPONSE_TIME_MILLIS;
import static org.junit.Assert.*;

public class EpisodeRepositoryTest implements ApiResponsibleListener {
    private EpisodeRepository episodeRepository;
    private EpisodesPage episodesPage;
    private Episode episode;

    public EpisodeRepositoryTest() {
        episodeRepository = new EpisodeRepository(this);
    }

    @Test
    public void getResultPage() {
        episodeRepository.getResultPage(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sizeResultList = episodesPage.getEpisodes().size();
        Log.i("--My log", "SizeResultList: " + sizeResultList);

        assertEquals(20, sizeResultList);
    }

    @Test
    public void getConcreteResult() {
        episodeRepository.getConcreteResult(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String characterName = episode.getName();
        Log.i("--My log", "Name: " + characterName);

        assertEquals("Pilot", characterName);
    }

    @Override
    public void onDonePageResponse(Object data) {
        try {
            episodesPage = (EpisodesPage) data;
        } catch (Exception e) {
            onFailResponse(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onDoneConcreteResponse(Object data) {
        try {
            episode = (Episode) data;
        } catch (Exception e) {
            onFailResponse(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onFailResponse(String message) {
        Log.e("TestFail", getClass().getName() + ":" + message);
    }
}
