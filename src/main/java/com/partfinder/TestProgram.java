package com.partfinder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TestProgram {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ExecutionException, InterruptedException {

        Document doc = Jsoup.connect("https://www.exist.ru/Price/?pcode=34116767191").get();


    }
    public static void intsCount(Integer... i){
        for (int in:i) {
            System.out.println(in);
        }
    }

    public static <Type extends Comparable> Type min (Type generic){
        return generic;
    }
}
