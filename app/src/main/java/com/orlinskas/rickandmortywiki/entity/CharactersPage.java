
package com.orlinskas.rickandmortywiki.entity;

import java.util.List;

public class CharactersPage {

    private Info info;
    private List<Character> results = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CharactersPage() {
    }

    /**
     * 
     * @param results
     * @param info
     */
    public CharactersPage(Info info, List<Character> results) {
        super();
        this.info = info;
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

}
