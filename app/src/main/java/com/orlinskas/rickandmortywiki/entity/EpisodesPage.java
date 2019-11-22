package com.orlinskas.rickandmortywiki.entity;

import java.util.List;

public class EpisodesPage {
    private Info info;
    private List<Episode> episodes = null;

    public EpisodesPage() {
    }

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
