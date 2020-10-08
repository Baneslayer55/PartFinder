package com.partfinder.parser.dromru;

import com.partfinder.model.PartModel;
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


    @Override
    public List<PartModel> findByVendorCode(String vendorCode) throws IOException {

        List<PartModel> findedParts = new ArrayList<>();

        String searchUrl = "https://baza.drom.ru/oem/" + vendorCode;

        Document doc = Jsoup.connect(searchUrl).get();

        Element pageCount = doc.selectFirst("span.pagebarInner");

        Elements goods = doc.select("div.bull-item-content__content-wrapper");

        for (Element e: goods) {
            try {
                String _vendorCode = vendorCode;
                double price =  0;
                String brand = e.select().text();
                String url = "https://baza.drom.ru/" + e.select().text();
                String city = e.select().text();
            }
        }


        return findedParts;
    }

    private double parseDromPrice(String price) throws Exception {
        try{
            return  Double.valueOf(price.substring(0, price.length()-1).replace(" ", ""));
        }
        catch (Exception e){
            throw new Exception("Cant parse price");
        }
    }
}
