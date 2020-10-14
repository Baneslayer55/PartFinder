package com.partfinder.parser.dromru;

import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.model.drom.DromPartModel;
import com.partfinder.parser.Parseable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParseDrom implements Parseable {

    private boolean hasNextPage = false;

    @Override
    public SearchResult findByVendorCode(String vendorCode) throws IOException, ExecutionException, InterruptedException {

        SearchResult searchResult = new SearchResult();

        String searchUrl = "https://baza.drom.ru/oem/" + vendorCode;

        searchResult.setSearchUrl(searchUrl);

        Document doc = Jsoup.connect("https://baza.drom.ru/oem/"+ vendorCode).get();  //itemsCount_placeholder

        int partsFinded = Integer.valueOf(doc.selectFirst("span[id^=itemsCount_placeholder]").attr("data-count"));

        searchResult.setSearchResult(parseAllPages(vendorCode, (int) Math.ceil(partsFinded/50.0)));

        return searchResult;
    }

    private List<PartModel> parseAllPages(String vendorCode, int pageCount) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Integer> pageArray = new ArrayList<>();

        for (int i = 1; i < pageCount + 1; i++) pageArray.add(i);

        List<Callable<List<PartModel>>> tasks = new ArrayList<>();

        for (int i : pageArray) tasks.add( () -> parseDromPage(vendorCode, i) );

        List<PartModel> findedParts = new ArrayList<>();

        List<Future<List<PartModel>>> results = executor.invokeAll(tasks);

        for (Future<List<PartModel>>  result: results) {
            findedParts.addAll(result.get());
        }
        return findedParts;
    }

    private List<PartModel> parseDromPage(String vendorCode, int pageNum) throws IOException {

        List<PartModel> partOnSinglePage = new ArrayList<>();

        String searchUrl = "https://baza.drom.ru/oem/" + vendorCode + "/?page=" + pageNum;

        Document doc = Jsoup.connect(searchUrl).get();

        Elements goods = doc.select("div.bull-item-content__content-wrapper");

        for (Element e: goods) {
            try {
                partOnSinglePage.add(
                        new DromPartModel(
                                vendorCode,
                                parseDromPrice(
                                        e.selectFirst("span.price-per-quantity__price") != null ?
                                                e.selectFirst("span.price-per-quantity__price").text():
                                                e.selectFirst("span[class^=price-block__price]").text()
                                ), //Два варианта цены
                                e.selectFirst("div[class^=bull-item__annotation-row]").text(), // Brand
                                "https://baza.drom.ru" + e.select("a").first().attr("href"), // URL
                                e.selectFirst("span.bull-delivery__city").text()) // City
                );
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return  partOnSinglePage;
    }

    private double parseDromPrice(String price) {
        return  Double.valueOf(price.replaceAll("[^0-9]",""));
    }
}