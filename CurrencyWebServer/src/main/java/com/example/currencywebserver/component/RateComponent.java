package  com.example.currencywebserver.component;


import com.example.currencywebserver.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
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
public class RateComponent {
    @Value("${rates.uri}")
    private String url;

    @Value("${rates.init}")
    private Boolean isInit;

    List<Rate> rateList = new ArrayList<>();




    @PostConstruct
    public void init() throws IOException, ParserConfigurationException, SAXException {
        if (isInit)
            this.downloadRateInfo();
    }


    public List<Rate> downloadRateInfo() throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Currency");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                Rate rate = new Rate(String.valueOf(eElement.getAttribute("ISOCode")),Double.valueOf(eElement.getElementsByTagName("Value").item(0).getTextContent().replaceAll(",",".") ), String.valueOf(LocalDate.now()));

                System.out.println(rate);
                rateList.add(rate);


            }

        }



        return rateList;

    }

}

