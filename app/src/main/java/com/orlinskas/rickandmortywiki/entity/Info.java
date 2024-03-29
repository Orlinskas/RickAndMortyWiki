package com.orlinskas.rickandmortywiki.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.Objects;

@Parcel(Parcel.Serialization.BEAN)
public class Info {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("prev")
    @Expose
    private String prev;

    @ParcelConstructor
    public Info(Integer count, Integer pages, String next, String prev) {
        super();
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        Info info = (Info) o;
        return Objects.equals(getCount(), info.getCount()) &&
                Objects.equals(getPages(), info.getPages()) &&
                Objects.equals(getNext(), info.getNext()) &&
                Objects.equals(getPrev(), info.getPrev());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount(), getPages(), getNext(), getPrev());
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

}
