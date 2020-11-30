package com.partfinder.test.parser;

import com.partfinder.test.model.SearchResult;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface Parseable {

    SearchResult findByVendorCode(String vendorCode) throws IOException, ExecutionException, InterruptedException;

}
