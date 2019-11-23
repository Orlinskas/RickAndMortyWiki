package com.orlinskas.rickandmortywiki;

import android.util.Log;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;

import org.junit.Test;

import static org.junit.Assert.*;


public class ApiControllerTest implements ApiResponsibleListener {
    private ApiController apiController;
    private CharactersPage charactersPage;

    public ApiControllerTest() {
        apiController = new ApiController(this);
        apiController.getCharacters();
    }

    @Test
    public void getCharacters() {
        assertTrue(charactersPage.getCharacters().size() > 0);
    }

    @Override
    public void onDoneResponse(Object data) {
        charactersPage = (CharactersPage) data;
        getCharacters();
    }

    @Override
    public void onFailResponse(String message) {
        Log.e("TestFail", getClass().getName() + ":" + message);
    }
}