package com.partfinder.test.model.euroauto;

import com.partfinder.test.model.PartAd;
import lombok.NonNull;

public class EuroAutoPartAd extends PartAd {

    public EuroAutoPartAd(@NonNull String vendorCode,
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
