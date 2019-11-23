package com.orlinskas.rickandmortywiki;

import java.io.IOException;

public class ApiController {
    private ApiResponsibleListener apiResponsibleListener;

    public ApiController(ApiResponsibleListener apiResponsibleListener) {
       this.apiResponsibleListener = apiResponsibleListener;
    }

    public void getCharacters() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    apiResponsibleListener.onDoneResponse(new Repository().getCharacters());
                } catch (IOException e) {
                    apiResponsibleListener.onFailResponse(e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
