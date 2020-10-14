package com.partfinder.parser;

import com.partfinder.model.SearchResult;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface Parseable {

    SearchResult findByVendorCode(String vendorCode) throws IOException, ExecutionException, InterruptedException;

}
