package com.partfinder.controllers;

import com.partfinder.model.SearchResult;
import com.partfinder.parser.Parser;
import com.partfinder.parser.dromru.ParseDrom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {

    @GetMapping("/find")
    public SearchResult FindByVendorCode(String vendorCode) {

        Parser dromParser = new ParseDrom();

        SearchResult searchResult = new SearchResult();

        try {
            searchResult = dromParser.findByVendorCode("34116767191");
        } catch (Exception e) {

        }
        return searchResult;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
