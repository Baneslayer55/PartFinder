package com.partfinder.parser.dromru;

import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.model.drom.DromPartModel;
import com.partfinder.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseDrom implements Parser {

    private boolean hasNextPage = false;

    @Override
    public SearchResult findByVendorCode(String vendorCode) throws IOException {

        long time = System.currentTimeMillis();

        SearchResult searchResult = new SearchResult();

        List<PartModel> findedParts = new ArrayList<>();

        String searchUrl = "https://baza.drom.ru/oem/" + vendorCode;

        searchResult.setSearchUrl(searchUrl);

        System.out.println(System.currentTimeMillis() - time + "before loop");

        do {
            Document doc = Jsoup.connect(searchUrl).get();

            Element nextPageLink = doc.selectFirst("link[rel^=next]");

            if (nextPageLink != null) {
                hasNextPage = true;
                searchUrl = "https://baza.drom.ru" + nextPageLink.attr("href");
            }else {
                hasNextPage = false;
            }

            Element pageCount = doc.selectFirst("span.pagebarInner");

            Elements goods = doc.select("div.bull-item-content__content-wrapper");
            System.out.println(System.currentTimeMillis() - time + "before creating partModel");
            for (Element e: goods) {
                try {
                    findedParts.add(
                        new DromPartModel(
                            vendorCode,
                            parseDromPrice(
                                e.selectFirst("span.price-per-quantity__price") != null ?
                                e.selectFirst("span.price-per-quantity__price").text():
                                e.selectFirst("span[class^=price-block__price]").text()
                            ), //Два варианта цены
                            e.selectFirst("div[class^=bull-item__annotation-row]").text(), // Brand
                            "https://baza.drom.ru/" + goods.select("a").first().attr("href"), // URL
                            e.selectFirst("span.bull-delivery__city").text()) // City
                            );
                } catch (Exception exception) {
                }
            }
            System.out.println(System.currentTimeMillis() - time + "after each loop");
        }
        while (hasNextPage);

        searchResult.setSearchResult(findedParts);
        System.out.println(System.currentTimeMillis() - time + "end of program");
        return searchResult;
    }

    private double parseDromPrice(String price) throws Exception {
        return  Double.valueOf(price.replaceAll("[^0-9]",""));
    }
}
