package com.partfinder;

import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.parser.Parser;
import com.partfinder.parser.dromru.ParseDrom;

import java.io.IOException;
import java.util.List;

public class TestProgram {
    public static void main(String[] args) throws IOException {

        Parser parser = new ParseDrom();

        SearchResult searchResult = parser.findByVendorCode("34116767191");

        List<PartModel> parts = searchResult.getSearchResult();


        for (PartModel p: parts) {
            System.out.println(p.getPrice());
            System.out.println(p.getBrand());
            System.out.println(p.getCity());
            System.out.println(p.getVendorCode());
            System.out.println(p.getUrl() + "\n");
        }
        System.out.println(parts.size());
        System.out.println(searchResult.getSearchUrl());
    }
}
