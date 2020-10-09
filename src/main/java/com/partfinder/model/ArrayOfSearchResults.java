package com.partfinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArrayOfSearchResults {
    private List<SearchResult> searchResults;
}
