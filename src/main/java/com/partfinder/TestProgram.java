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

public class TestProgram {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        test();
//        long time = System.currentTimeMillis();
//
//        Parser parser = new ParseDrom();
//
//        SearchResult searchResult = parser.findByVendorCode("34116767191");
//
//        System.out.println(System.currentTimeMillis() - time);
//
//        List<PartModel> parts = searchResult.getSearchResult();
//
//        System.out.println(System.currentTimeMillis() - time);
//
//
////        for (PartModel p: parts) {
////            System.out.println(p.getPrice());
////            System.out.println(p.getBrand());
////            System.out.println(p.getCity());
////            System.out.println(p.getVendorCode());
////            System.out.println(p.getUrl() + "\n");
////        }
//        System.out.println(parts.size());
//        System.out.println(searchResult.getSearchUrl());
    }
    public static void test() throws IOException {

        long time = System.currentTimeMillis();

        boolean hasNext = true;

        List<Document> pages = new ArrayList<>();

        String searchUrl = "https://baza.drom.ru/oem/34116767191";

        while (hasNext){

            URL oracle = new URL(searchUrl);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){

            }

            in.close();
            System.out.println(System.currentTimeMillis() - time + "after reading page");

            Document doc = Jsoup.parse(inputLine);

            System.out.println(System.currentTimeMillis() - time + "after creating doc page");
            pages.add(doc);

            Element nextPageLink = doc.selectFirst("link[rel^=next]");

            if (nextPageLink != null) {
                hasNext = true;
                searchUrl = "https://baza.drom.ru" + nextPageLink.attr("href");
            }else {
                hasNext = false;
            }
            System.out.println(System.currentTimeMillis() - time + "ending getting page");
        }

        System.out.println(pages.size());

        List<PartModel> findedParts = new ArrayList<>();

        System.out.println(System.currentTimeMillis() - time + "after getting pages");
    }

    public static void nextTest() throws IOException {
        long time = System.currentTimeMillis();

        URL oracle = new URL("https://baza.drom.ru/oem/34116767191");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){}

        in.close();
        System.out.println(System.currentTimeMillis() - time + "after reading page");

        Document doc = Jsoup.parse(inputLine);

    }
}
