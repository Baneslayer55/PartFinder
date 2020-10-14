package com.partfinder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SearchResult {

    private String searchUrl;

    private List<PartModel> searchResult;
}
