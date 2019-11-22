package com.orlinskas.rickandmortywiki.entity;

import java.util.List;

public class CharactersPage {
    private Info info;
    private List<Character> characters = null;

    public CharactersPage() {
    }

    public CharactersPage(Info info, List<Character> characters) {
        super();
        this.info = info;
        this.characters = characters;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

}
