package com.example.currencywebserver.controller;


import com.example.currencywebserver.component.RateComponent;
import com.example.currencywebserver.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
public class RateController {


    @Autowired
    RateComponent rateComponent;

    @GetMapping("/rates")
    public List<Rate> init() throws IOException, ParserConfigurationException, SAXException {



        return rateComponent.downloadRateInfo();
    }



}
