package org.mp.stocksevaluatorapi.service;

import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.repository.Database;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private List<Stock> stockList;

    public StockService() throws ParserConfigurationException, IOException, SAXException {
        this.stockList = new ArrayList<>();

        Database database = new Database();
        String company = database.GetStock();

        Stock stock1 = new Stock("IBM", company);
        Stock stock2 = new Stock("MSFT", "Microsoft");
        Stock stock3 = new Stock("F", "Ford");

        stockList.addAll(Arrays.asList(stock1, stock2, stock3));
    }

    public Optional<Stock> getStock(String ticker) {
        Optional optional = Optional.empty();
        for (Stock stock : stockList) {
            if (ticker.equals(stock.getTicker())) {
                optional = Optional.of(stock);
                return optional;
            }
        }
        return optional;
    }
}
