package com.orlinskas.rickandmortywiki.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharactersPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Character> characters = new ArrayList<Character>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CharactersPage() {
    }

    /**
     * 
     * @param characters
     * @param info
     */
    public CharactersPage(Info info, List<Character> characters) {
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
