package com.orlinskas.rickandmortywiki.repository;

import android.util.Log;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.entity.Character;

import org.junit.Test;

import static com.orlinskas.rickandmortywiki.TestConstants.WAIT_OF_RESPONSE_TIME_MILLIS;
import static org.junit.Assert.*;

public class CharacterRepositoryTest implements ApiResponsibleListener {
    private CharacterRepository characterRepository;
    private CharactersPage charactersPage;
    private Character character;

    public CharacterRepositoryTest() {
        characterRepository = new CharacterRepository(this);
    }

    @Test
    public void getResultPage() {
        characterRepository.getResultPage(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sizeResultList = charactersPage.getCharacters().size();
        Log.i("--My log", "SizeResultList: " + sizeResultList);

        assertEquals(20, sizeResultList);
    }

    @Test
    public void getConcreteResult() {
        characterRepository.getConcreteResult(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String characterName = character.getName();
        Log.i("--My log", "Name: " + characterName);

        assertEquals("Rick Sanchez", characterName);
    }

    @Override
    public void onDonePageResponse(Object data) {
        try {
            charactersPage = (CharactersPage) data;
        } catch (Exception e) {
            onFailResponse(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onDoneConcreteResponse(Object data) {
        try {
            character = (Character) data;
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