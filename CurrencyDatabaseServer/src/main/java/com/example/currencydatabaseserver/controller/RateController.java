package com.example.currencydatabaseserver.controller;

import com.example.currencydatabaseserver.component.CodeComponent;
import com.example.currencydatabaseserver.component.RateComponent;
import com.example.currencydatabaseserver.model.Rate;
import com.example.currencydatabaseserver.repository.CodesRepository;
import com.example.currencydatabaseserver.repository.RateRepository;
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
    RateRepository rateRepository;

    @Autowired
    RateComponent rateComponent;

    @Autowired
    CodesRepository codesRepository;
    @Autowired
    CodeComponent codeComponent;

    @GetMapping("/init-rates")
    public String init() throws IOException, ParserConfigurationException, SAXException {

        rateComponent.downloadRateInfo();


        return rateComponent.downloadRateInfo();
    }

    @GetMapping("/rates")
    public List<Rate> getRates(){
        return rateRepository.findAll();
    }

    @GetMapping("/rates/{date}")
    public  List<Rate> getRatesByDate(@PathVariable ("date") String date) {

       return rateRepository.findAll();
    }

    @PostMapping("/rates")
    public void saveRates(@RequestBody List<Rate> rate){
        rateRepository.saveAll(rate);
    }

    @PostMapping("/rates/{date}")
    public  void saveRatesByDate(@RequestBody List<Rate> rate, @PathVariable ("date") Date date) {
        rateRepository.saveAll(rate);
    }

    @DeleteMapping("/rates")
    public void deleteRates(@RequestBody List<Rate> rate){
        rateRepository.deleteAll(rate);
    }

    @DeleteMapping("/rates/{date}")
    public void deleteRatesByDate(@RequestBody List<Rate> rate, @PathVariable ("date") Date date) {
        rateRepository.deleteAll(rate);
    }


}
