package org.mp.stocksevaluatorapi.thirdparty;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mp.stocksevaluatorapi.Configuration;
import org.mp.stocksevaluatorapi.ExceptionLog;
import org.mp.stocksevaluatorapi.api.model.BalanceSheet;
import org.mp.stocksevaluatorapi.api.model.Stock;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Marketstack {

    private String accessKey;
    private ExceptionLog exceptionLog;

    public Marketstack() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        accessKey = cfg.GetMarketStackAccessKey();
        exceptionLog = new ExceptionLog();
    }

    public Stock getStockData(String ticker) throws IOException, ParserConfigurationException, SAXException {
        try {
            ApiCall json = new ApiCall();
            JSONObject quote = json.readJsonFromUrl("https://api.marketstack.com/v2/eod?access_key=" + accessKey + "&symbols=" + ticker);
            Object data = quote.get("data");
            JSONArray company = (JSONArray) data;
            Stock stock = new Stock();

            if (!company.isEmpty()) {
                JSONObject record = company.getJSONObject(0);
                stock.setCompany(record.get("name").toString());
            }
            return stock;
        } catch (Exception e) {
            exceptionLog.saveException(e);
            return null;
        }
    }
}
