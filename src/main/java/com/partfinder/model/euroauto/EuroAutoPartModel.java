package com.partfinder.model.euroauto;

import com.partfinder.model.PartModel;
import lombok.NonNull;

public class EuroAutoPartModel extends PartModel {

    public EuroAutoPartModel(@NonNull String vendorCode,
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
