package org.mp.stocksevaluatorapi.repository;

import org.mp.stocksevaluatorapi.api.model.Stock;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableStock {

    private Database database;

    public TableStock() throws ParserConfigurationException, IOException, SAXException {
        database = new Database();
    }

    public Stock getStock(String ticker) throws ParserConfigurationException, IOException, SAXException, SQLException {
        ResultSet stockResultSet = database.executeQuery("SELECT Ticker, Company FROM Stock WHERE Ticker = '" + ticker + "'");
        Stock stock = new Stock();
        while (stockResultSet.next()) {
            stock.setTicker(stockResultSet.getString("Ticker"));
            stock.setCompany(stockResultSet.getString("Company"));
        }
        return stock;
    }

    public List<Stock> getStocks() throws ParserConfigurationException, IOException, SAXException, SQLException {
        ResultSet stockResultSet = database.executeQuery("SELECT Ticker, Company FROM Stock");
        List<Stock> stocks = new ArrayList<>();
        while (stockResultSet.next()) {
            Stock stock = new Stock();
            stock.setTicker(stockResultSet.getString("Ticker"));
            stock.setCompany(stockResultSet.getString("Company"));
            stocks.add(stock);
        }
        return stocks;
    }

}
