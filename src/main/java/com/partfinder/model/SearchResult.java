package com.partfinder.model;

import java.util.List;


public class SearchResult {

    private String searchUrl;

    private List<PartModel> searchResult;

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public List<PartModel> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<PartModel> searchResult) {
        this.searchResult = searchResult;
    }

}
