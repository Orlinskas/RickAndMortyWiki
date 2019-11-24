package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class EpisodesPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Episode> episodes = null;

    @ParcelConstructor
    public EpisodesPage(Info info, List<Episode> episodes) {
        super();
        this.info = info;
        this.episodes = episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EpisodesPage)) return false;
        EpisodesPage that = (EpisodesPage) o;
        return Objects.equals(getInfo(), that.getInfo()) &&
                Objects.equals(getEpisodes(), that.getEpisodes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo(), getEpisodes());
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}
