package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class Episode {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("episode")
    @Expose
    private String episode;
    @SerializedName("characters")
    @Expose
    private List<String> characters;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created")
    @Expose
    private String created;

    @ParcelConstructor
    public Episode(Integer id, String name, String airDate, String episode, List<String> characters, String url, String created) {
        super();
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.episode = episode;
        this.characters = characters;
        this.url = url;
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;
        Episode episode1 = (Episode) o;
        return Objects.equals(getId(), episode1.getId()) &&
                Objects.equals(getName(), episode1.getName()) &&
                Objects.equals(getAirDate(), episode1.getAirDate()) &&
                Objects.equals(getEpisode(), episode1.getEpisode()) &&
                Objects.equals(getUrl(), episode1.getUrl()) &&
                Objects.equals(getCreated(), episode1.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAirDate(), getEpisode(), getUrl(), getCreated());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
