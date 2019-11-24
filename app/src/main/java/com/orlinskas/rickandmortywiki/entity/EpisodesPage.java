package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpisodesPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Episode> episodes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EpisodesPage() {
    }

    /**
     * 
     * @param episodes
     * @param info
     */
    public EpisodesPage(Info info, List<Episode> episodes) {
        super();
        this.info = info;
        this.episodes = episodes;
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
