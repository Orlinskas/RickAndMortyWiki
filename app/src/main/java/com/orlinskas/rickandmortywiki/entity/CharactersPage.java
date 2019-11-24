package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class CharactersPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Character> characters;

    @ParcelConstructor
    public CharactersPage(Info info, List<Character> characters) {
        this.info = info;
        this.characters = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharactersPage)) return false;
        CharactersPage that = (CharactersPage) o;
        return Objects.equals(getInfo(), that.getInfo()) &&
                Objects.equals(getCharacters(), that.getCharacters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo(), getCharacters());
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
