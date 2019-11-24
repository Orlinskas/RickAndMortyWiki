package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationsPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Location> locations = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocationsPage() {
    }

    /**
     * 
     * @param locations
     * @param info
     */
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
