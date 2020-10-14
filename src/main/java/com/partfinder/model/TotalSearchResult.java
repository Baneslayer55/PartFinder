package com.partfinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalSearchResult {

    private List<SearchResult> mergedResult = new ArrayList<>();

    public void addSearchResult(SearchResult ... searchResults){

        for (SearchResult s: searchResults) {
            try{
                mergedResult.add(s);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
