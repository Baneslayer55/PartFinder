package com.partfinder;

import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.model.TotalSearchResult;
import com.partfinder.parser.Parseable;
import com.partfinder.parser.avitoru.ParseAvito;
import com.partfinder.parser.dromru.ParseDrom;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TestProgram {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ExecutionException, InterruptedException {

        TotalSearchResult totalSearchResult = new TotalSearchResult();

        totalSearchResult.addSearchResult(
                new ParseDrom().findByVendorCode("34116767191"),
                new ParseAvito().findByVendorCode("34116767191")
        );

        System.out.println(totalSearchResult.getMergedResult().size());

    }
    public static void intsCount(Integer... i){
        for (int in:i) {
            System.out.println(in);
        }
    }
}
