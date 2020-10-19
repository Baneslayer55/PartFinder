package com.partfinder.controllers;

import com.partfinder.model.TotalSearchResult;
import com.partfinder.model.SearchResult;
import com.partfinder.parser.avitoru.ParseAvito;
import com.partfinder.parser.dromru.ParseDrom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class FindController {

    @GetMapping("/checkdrom")
    public SearchResult ParseDrom(@RequestParam(value = "code")String vendorCode) throws InterruptedException, ExecutionException, IOException {

        return new ParseDrom().findByVendorCode(vendorCode);
    }

    @GetMapping("/checkavito")
    public SearchResult ParseAvito(@RequestParam(value = "code")String vendorCode) throws InterruptedException, ExecutionException, IOException {

        return new ParseAvito().findByVendorCode(vendorCode);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
