package org.mp.stocksevaluatorapi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Configuration {

    private String configurationFile;
    private String databaseConnectionString;
    private String clientUrl;
    private String logFile;
    private String financialModelingPrepApiKey;
    private String finnhubToken;
    private String marketStackAccessKey;

    public Configuration() {
        configurationFile = "D:\\GitHub\\paulelling\\stocks-evaluator-api\\stocks-evaluator-api\\src\\main\\java\\org\\mp\\stocksevaluatorapi\\app.configuration.xml";
    }

    public String GetDatabaseConnectionString() throws ParserConfigurationException, IOException, SAXException {
        databaseConnectionString = readConfigurationFile("database", "connection_string");
        return databaseConnectionString;
    }

    public String GetClientUrl() throws ParserConfigurationException, IOException, SAXException {
        clientUrl = readConfigurationFile("client", "url");
        return clientUrl;
    }

    public String GetLogFile() throws ParserConfigurationException, IOException, SAXException {
        logFile = readConfigurationFile("log", "file");
        return logFile;
    }

    public String GetFinancialModelingPrepApiKey() throws ParserConfigurationException, IOException, SAXException {
        financialModelingPrepApiKey = readConfigurationFile("financial_modeling_prep", "api_key");
        return financialModelingPrepApiKey;
    }

    public String GetFinnhubToken() throws ParserConfigurationException, IOException, SAXException {
        finnhubToken = readConfigurationFile("finnhub", "token");
        return finnhubToken;
    }

    public String GetMarketStackAccessKey() throws ParserConfigurationException, IOException, SAXException {
        marketStackAccessKey = readConfigurationFile("marketstack", "access_key");
        return marketStackAccessKey;
    }

    private String readConfigurationFile(String configurationFileSection, String node) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(configurationFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document document = dBuilder.parse(file);
        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName(configurationFileSection);
        String value = "";

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element  eElement = (Element) nNode;
                value = eElement.getElementsByTagName(node).item(0).getTextContent();
            }
        }

        return value;
    }
}

