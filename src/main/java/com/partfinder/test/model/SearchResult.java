package com.partfinder.test.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SearchResult {

    private String searchUrl;

    private List<PartAd> searchResult;
}
