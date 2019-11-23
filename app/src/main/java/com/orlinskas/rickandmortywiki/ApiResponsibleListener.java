package com.orlinskas.rickandmortywiki;

interface ApiResponsibleListener {
    void onDoneResponse(Object data);
    void onFailResponse(String message);
}