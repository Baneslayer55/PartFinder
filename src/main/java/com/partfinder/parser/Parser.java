package com.partfinder.parser;

import com.partfinder.model.SearchResult;

import java.io.IOException;

public interface Parser {

    SearchResult findByVendorCode(String vendorCode) throws IOException;

}
