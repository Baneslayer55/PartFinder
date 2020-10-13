package com.partfinder;

import java.net.*;
import java.io.*;
import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.parser.Parser;
import com.partfinder.parser.dromru.ParseDrom;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestProgram {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();

        Parser parser = new ParseDrom();
        SearchResult searchResult = parser.findByVendorCode("34116767191");

        for (PartModel part:searchResult.getSearchResult()) {
            System.out.println(part.getPrice());
            System.out.println(part.getBrand());
            System.out.println(part.getCity());
            System.out.println(part.getUrl());
            System.out.println(part.getVendorCode());
            System.out.println("_______________________________________________________________");
        }

        System.out.println(System.currentTimeMillis() - time);

    }
}
