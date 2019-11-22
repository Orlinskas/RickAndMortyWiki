package com.orlinskas.rickandmortywiki.entity;

import java.util.List;

public class LocationsPage {
    private Info info;
    private List<Location> locations = null;

    public LocationsPage() {
    }

    public LocationsPage(Info info, List<Location> locations) {
        super();
        this.info = info;
        this.locations = locations;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
