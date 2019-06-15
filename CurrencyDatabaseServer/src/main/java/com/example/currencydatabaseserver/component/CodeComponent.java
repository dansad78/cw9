package com.example.currencydatabaseserver.component;

import com.example.currencydatabaseserver.model.Codes;
import com.example.currencydatabaseserver.model.Rate;
import com.example.currencydatabaseserver.repository.CodesRepository;
import com.example.currencydatabaseserver.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class CodeComponent {
    @Value("${rates.uri}")
    private String url;

    @Value("${rates.init}")
    private Boolean isInit;

    List<Codes> rateList = new ArrayList<>();

    @Autowired
    CodesRepository codesRepository;


    @PostConstruct
    public void init() throws IOException, ParserConfigurationException, SAXException {
        if (isInit)
            this.downloadCodesInfo();
    }


    public String downloadCodesInfo() throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Currency");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                Codes codes = new Codes(String.valueOf(eElement.getAttribute("ISOCode")));

                System.out.println(codes);
                rateList.add(codes);


            }

        }
        codesRepository.saveAll(rateList);


        return String.valueOf(rateList);

    }
}
