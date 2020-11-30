package com.partfinder.test.model.drom;

import com.partfinder.test.model.PartAd;
import lombok.*;


@AllArgsConstructor
public class DromPartAd extends PartAd {

    public DromPartAd(@NonNull String vendorCode,
                      @NonNull Double price,
                      String brand,
                      @NonNull String url,
                      String city) {
        this.vendorCode = vendorCode;
        this.price = price;
        this.brand = brand;
        this.url = url;
        this.city = city;
    }
}
