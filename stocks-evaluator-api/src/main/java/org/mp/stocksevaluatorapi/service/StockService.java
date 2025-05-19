package org.mp.stocksevaluatorapi.service;

import org.mp.stocksevaluatorapi.api.model.BalanceSheet;
import org.mp.stocksevaluatorapi.api.model.CashFlowStatement;
import org.mp.stocksevaluatorapi.api.model.IncomeStatement;
import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.repository.TableStock;
import org.mp.stocksevaluatorapi.thirdparty.FinancialModelingPrep;
import org.mp.stocksevaluatorapi.thirdparty.Finnhub;
import org.mp.stocksevaluatorapi.thirdparty.Marketstack;
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

    public Stock getStock(String ticker) throws IOException, ParserConfigurationException, SAXException {
        FinancialModelingPrep financialModelingPrep = new FinancialModelingPrep();
        Finnhub finnhub = new Finnhub();
        Marketstack marketstack = new Marketstack();
        Stock stockCompany = marketstack.getStockData(ticker);
        Stock stockPrice = financialModelingPrep.getStockData(ticker);
        Stock stock = finnhub.getStockData(ticker);
        stock.setTicker(ticker);
        stock.setCompany(stockCompany.getCompany());
        stock.setPrice(stockPrice.getPrice());
        BalanceSheet balanceSheet = financialModelingPrep.getBalanceSheet(ticker);
        stock.setBalanceSheet(balanceSheet);
        IncomeStatement incomeStatement = financialModelingPrep.getIncomeStatement(ticker);
        stock.setIncomeStatement(incomeStatement);
        CashFlowStatement cashFlowStatement = financialModelingPrep.getCashFlowStatement(ticker);
        stock.setCashFlowStatement(cashFlowStatement);
        return stock;
    }

//    public Stock getStock(String ticker) throws ParserConfigurationException, IOException, SAXException, SQLException {
//        TableStock tableStock = new TableStock();
//        return tableStock.getStock(ticker);
//    }

    public List<Stock> getStockList() throws ParserConfigurationException, IOException, SAXException, SQLException {
        TableStock tableStock = new TableStock();
        return tableStock.getStocks();
    }
}
