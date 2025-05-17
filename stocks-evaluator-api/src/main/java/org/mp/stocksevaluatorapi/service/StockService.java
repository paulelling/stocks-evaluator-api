package org.mp.stocksevaluatorapi.service;

import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.repository.TableStock;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class StockService {

    public StockService() throws ParserConfigurationException, IOException, SAXException {
    }

    public Stock getStock(String ticker) throws ParserConfigurationException, IOException, SAXException, SQLException {
        TableStock tableStock = new TableStock();
        return tableStock.getStock(ticker);
    }

    public List<Stock> getStockList() throws ParserConfigurationException, IOException, SAXException, SQLException {
        TableStock tableStock = new TableStock();
        return tableStock.getStocks();
    }
}
