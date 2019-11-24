package com.orlinskas.rickandmortywiki.repository;

interface ApiRepository {
    void getResultPage(int pageNumber);
    void getConcreteResult(int id);
}
