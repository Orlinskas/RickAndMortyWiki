package com.orlinskas.rickandmortywiki.entity;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class LocationsPage {
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Location> locations = null;

    @ParcelConstructor
    public LocationsPage(Info info, List<Location> locations) {
        super();
        this.info = info;
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationsPage)) return false;
        LocationsPage that = (LocationsPage) o;
        return Objects.equals(getInfo(), that.getInfo()) &&
                Objects.equals(getLocations(), that.getLocations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo(), getLocations());
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
