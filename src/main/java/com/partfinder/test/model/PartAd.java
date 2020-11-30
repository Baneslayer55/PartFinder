package com.partfinder.test.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PartAd {

    protected String vendorCode;

    protected Double price;

    protected String brand;

    protected String url;

    protected String city;

}
