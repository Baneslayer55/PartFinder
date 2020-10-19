package com.partfinder.parser.avitoru;

import com.partfinder.model.PartModel;
import com.partfinder.model.SearchResult;
import com.partfinder.model.avito.AvitoPartModel;
import com.partfinder.parser.Parseable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParseAvito implements Parseable {

    @Override
    public SearchResult findByVendorCode(String vendorCode) throws IOException, ExecutionException, InterruptedException {

        SearchResult searchResult = new SearchResult();

        String searchUrl = "https://www.avito.ru/rossiya/zapchasti_i_aksessuary/zapchasti/dlya_avtomobiley/?q=" + vendorCode;

        searchResult.setSearchUrl(searchUrl);

        Document doc = Jsoup.connect(searchUrl).get();

        int partsFinded = Integer.parseInt(doc.selectFirst("span[class^=page-title-count]").text().replaceAll("[^0-9]",""));

        searchResult.setSearchResult(parseAllPages(vendorCode, (int) Math.ceil(partsFinded/50.0)));

        return searchResult;
    }

    private List<PartModel> parseAllPages(String vendorCode, int pageCount) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Integer> pageArray = new ArrayList<>();

        for (int i = 1; i < pageCount + 1; i++) pageArray.add(i);

        List<Callable<List<PartModel>>> tasks = new ArrayList<>();

        for (int i : pageArray) tasks.add( () -> parseAvitoPage(vendorCode, i) );

        List<PartModel> findedParts = new ArrayList<>();

        List<Future<List<PartModel>>> results = executor.invokeAll(tasks);

        for (Future<List<PartModel>>  result: results) {
            findedParts.addAll(result.get());
        }
        return findedParts;
    }

    private List<PartModel> parseAvitoPage(String vendorCode, int pageNum) throws IOException {

        List<PartModel> partOnSinglePage = new ArrayList<>();

        String searchUrl = "https://www.avito.ru/rossiya/zapchasti_i_aksessuary/zapchasti/dlya_avtomobiley?p=" + pageNum + "&q=" + vendorCode;

        Document doc = Jsoup.connect(searchUrl).get();

        Elements goods = doc.select("div.item_table-wrapper");

        for (Element e: goods) {
            try {
                partOnSinglePage.add(
                    new AvitoPartModel(
                        vendorCode,
                        Double.valueOf(e.selectFirst("meta[content~=[0-9]+]").attr("content")), //Price
                        "", // Brand
                        "https://www.avito.ru" + e.selectFirst("a.snippet-link").attr("href"), // URL
                        e.selectFirst("span.item-address__string").text()) // City
                );
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return  partOnSinglePage;
    }
}
