package com.partfinder.parser;

import com.partfinder.model.PartModel;
import com.partfinder.model.drom.DromPartModel;

import java.io.IOException;
import java.util.List;

public interface Parser {

    List<PartModel> findByVendorCode(String vendorCode) throws IOException;

}
