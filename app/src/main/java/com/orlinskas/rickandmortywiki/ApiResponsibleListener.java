package com.orlinskas.rickandmortywiki;

public interface ApiResponsibleListener {
    void onDonePageResponse(Object data);
    void onDoneConcreteResponse(Object data);
    void onFailResponse(String message);
}