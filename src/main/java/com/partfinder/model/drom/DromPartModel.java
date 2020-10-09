package com.partfinder.model.drom;

import com.partfinder.model.PartModel;
import lombok.*;


@AllArgsConstructor
public class DromPartModel extends PartModel {


    public DromPartModel(@NonNull String vendorCode,
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
