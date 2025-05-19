package org.mp.stocksevaluatorapi.thirdparty;

import org.json.JSONObject;
import org.mp.stocksevaluatorapi.Configuration;
import org.mp.stocksevaluatorapi.api.model.Stock;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Finnhub {

    private String token;

    public Finnhub() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        token = cfg.GetFinnhubToken();
    }

    public Stock getStockData(String ticker) throws IOException {
        ApiCall json = new ApiCall();
        JSONObject quote = new JSONObject();
        quote = json.readJsonFromUrl("https://finnhub.io/api/v1/stock/metric?symbol=" + ticker + "&metric=all&token=" + token);
        Object metric = new JSONObject();
        metric = quote.get("metric");
        JSONObject data = new JSONObject();
        data = (JSONObject) metric;

        Stock stock = new Stock();
        stock.setFiftyTwoWeekHigh(data.get("52WeekHigh").toString());
        stock.setFiftyTwoWeekHighDate(data.get("52WeekHighDate").toString());
        stock.setFiftyTwoWeekLow(data.get("52WeekLow").toString());
        stock.setFiftyTwoWeekLowDate(data.get("52WeekLowDate").toString());
        stock.setDividendPerShare(data.get("dividendPerShareTTM").toString());
        stock.setAssetTurnover(data.get("assetTurnoverTTM").toString());
        stock.setBeta(data.get("beta").toString());
        stock.setEarningsPerShare(data.get("epsAnnual").toString());
        stock.setGrossMargin(data.get("grossMarginAnnual").toString());
        stock.setInventoryTurnover(data.get("inventoryTurnoverAnnual").toString());
        stock.setLongTermDebtPerEquity(data.get("longTermDebt/equityAnnual").toString());
        stock.setMarketCapitalization(data.get("marketCapitalization").toString());
        stock.setOperatingMargin(data.get("operatingMarginAnnual").toString());
        stock.setQuickRatio(data.get("quickRatioAnnual").toString());
        stock.setReceivablesTurnover(data.get("receivablesTurnoverAnnual").toString());

        return stock;
    }
}
