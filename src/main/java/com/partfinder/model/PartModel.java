package com.partfinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PartModel {

    private String vendorCode;

    private Double price;

    private String Brand;

    private String url;

    private String city;

}
