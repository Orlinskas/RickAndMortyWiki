package com.orlinskas.rickandmortywiki.repository;

public interface ApiResponsibleListener {
    void onDonePageResponse(Object data);
    void onDoneConcreteResponse(Object data);
    void onFailResponse(String message);
}