package com.partfinder.model.avito;

import com.partfinder.model.PartModel;
import lombok.NonNull;

public class AvitoPartModel extends PartModel {

    public AvitoPartModel(@NonNull String vendorCode,
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
