package com.partfinder.test.model.avito;

import com.partfinder.test.model.PartAd;
import lombok.NonNull;

public class AvitoPartAd extends PartAd {

    public AvitoPartAd(@NonNull String vendorCode,
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
