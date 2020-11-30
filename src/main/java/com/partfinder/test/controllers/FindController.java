package com.partfinder.test.controllers;

import com.partfinder.test.model.SearchResult;
import com.partfinder.test.parser.avitoru.ParseAvito;
import com.partfinder.test.parser.dromru.ParseDrom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("find")
public class FindController {

    @GetMapping("/drom")
    public SearchResult ParseDrom(@RequestParam(value = "code")String vendorCode) throws InterruptedException, ExecutionException, IOException {

        return new ParseDrom().findByVendorCode(vendorCode);
    }

    @GetMapping("/avito")
    public SearchResult ParseAvito(@RequestParam(value = "code")String vendorCode) throws InterruptedException, ExecutionException, IOException {

        return new ParseAvito().findByVendorCode(vendorCode);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

} //checkavito?code=34116767191
