package com.poc.citrusadtester.controllers;

import com.poc.citrusadtester.models.AdRequest;
import com.poc.citrusadtester.models.SvcResponse;
import com.poc.citrusadtester.services.CitrusAdRequestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AdsBannerController {

    @Autowired
    CitrusAdRequestInterface citrusAdReqSvc;

    @PostMapping(value = "/adRequest")
    public SvcResponse requestAds(@RequestBody AdRequest adRequest) throws IOException {
        SvcResponse svcResponse = new SvcResponse();
        svcResponse = citrusAdReqSvc.requestAdCitrus(adRequest);

        return svcResponse;
    }

}
