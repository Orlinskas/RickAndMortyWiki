
package com.orlinskas.rickandmortywiki;


public class Origin {

    private String name;
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Origin() {
    }

    /**
     * 
     * @param name
     * @param url
     */
    public Origin(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
