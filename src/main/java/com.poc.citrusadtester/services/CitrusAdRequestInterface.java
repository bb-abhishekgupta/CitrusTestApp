package com.poc.citrusadtester.services;



import com.poc.citrusadtester.models.AdRequest;
import com.poc.citrusadtester.models.SvcResponse;

import java.io.IOException;

public interface CitrusAdRequestInterface {
    public SvcResponse requestAdCitrus(AdRequest adRequest) throws IOException;

}
