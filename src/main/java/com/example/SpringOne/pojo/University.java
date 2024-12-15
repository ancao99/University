package com.example.SpringOne.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class University {
    @JsonProperty("state-province")
    private String stateProvince;
    @JsonProperty("alpha_two_code")
    private String alphaTwoCode;
    @JsonProperty("web_pages")
    private List<String> webPages;
    private String country;
    private String name;
    private List<String> domains;


    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return "University{" +
                "stateProvince='" + stateProvince + '\'' +
                ", alphaTwoCode='" + alphaTwoCode + '\'' +
                ", webPages=" + webPages +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", domains=" + domains +
                '}';
    }
}
