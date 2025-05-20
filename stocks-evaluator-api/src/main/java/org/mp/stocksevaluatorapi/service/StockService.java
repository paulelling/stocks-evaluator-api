package org.mp.stocksevaluatorapi.service;

import org.mp.stocksevaluatorapi.ExceptionLog;
import org.mp.stocksevaluatorapi.api.model.BalanceSheet;
import org.mp.stocksevaluatorapi.api.model.CashFlowStatement;
import org.mp.stocksevaluatorapi.api.model.IncomeStatement;
import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.api.performance.*;
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
        Stock stock = new Stock();

        try {
            Finnhub finnhub = new Finnhub();
            stock = finnhub.getStockData(ticker);

            FinancialModelingPrep financialModelingPrep = new FinancialModelingPrep();
            Stock stockPrice = financialModelingPrep.getStockData(ticker);
            Stock stockCompany = financialModelingPrep.getStockProfile(ticker);

            stock.setTicker(ticker);
            stock.setCompany(stockCompany.getCompany());
            stock.setPrice(stockPrice.getPrice());

            BalanceSheet balanceSheet = financialModelingPrep.getBalanceSheet(ticker);
            IncomeStatement incomeStatement = financialModelingPrep.getIncomeStatement(ticker);
            CashFlowStatement cashFlowStatement = financialModelingPrep.getCashFlowStatement(ticker);

            if (balanceSheet != null && incomeStatement != null && cashFlowStatement != null) {
                stock.setBalanceSheet(balanceSheet);
                stock.setIncomeStatement(incomeStatement);
                stock.setCashFlowStatement(cashFlowStatement);

                CashFlow cashFlow = setCashFlowCalculations(cashFlowStatement, incomeStatement);
                stock.setQualityOfIncomeRatio(cashFlow.getQualityOfIncomeRatio());

                Liquidity liquidity = setLiquidityCalculations(balanceSheet);
                stock.setCurrentRatio(liquidity.getCurrentRatio());
                stock.setCashRatio(liquidity.getCashRatio());

                FinancialLeverage financialLeverage = setFinancialLeverageCalculations(balanceSheet);
                stock.setNetAssetValue(financialLeverage.getNetAssetValue());
                stock.setTotalDebtRatio(financialLeverage.getTotalDebtRatio());
                stock.setDebtEquityRatio(financialLeverage.getDebtEquityRatio());
                stock.setEquityMultiplier(financialLeverage.getEquityMultiplier());
                stock.setFinancialLeverageRatio(financialLeverage.getFinancialLeverageRatio());
                stock.setLongTermDebtRatio(financialLeverage.getLongTermDebtRatio());

                Profitability profitability = setProfitabilityCalculations(balanceSheet, incomeStatement);
                stock.setReturnOnAssets(profitability.getReturnOnAssets());
                stock.setReturnOnEquity(profitability.getReturnOnEquity());

                MarketValue marketValue = setMarketValueCalculations(incomeStatement, stock.getEarningsPerShare(), stock.getPrice());
                stock.setSharesOutstanding(marketValue.getSharesOutstanding());
                stock.setEarningsYield(marketValue.getEarningsYield());
                stock.setPriceEarningsRatio(marketValue.getPriceEarningsRatio());
            }
        } catch (Exception e) {
            ExceptionLog exceptionLog = new ExceptionLog();
            exceptionLog.saveException(e);
        }

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

    private CashFlow setCashFlowCalculations(CashFlowStatement cashFlowStatement, IncomeStatement incomeStatement) {
        CashFlow cashFlow = new CashFlow();
        cashFlow.setQualityOfIncomeRatio(cashFlow.calculateQualityOfIncomeRatio(Double.parseDouble(cashFlowStatement.getOperatingCashFlow()), Double.parseDouble(incomeStatement.getNetIncome())));
        return cashFlow;
    }

    private Liquidity setLiquidityCalculations(BalanceSheet balanceSheet) {
        Liquidity liquidity = new Liquidity();
        liquidity.setCurrentRatio(liquidity.calculateCurrentRatio(Double.parseDouble(balanceSheet.getCurrentAssets()), Double.parseDouble(balanceSheet.getCurrentLiabilities())));
        liquidity.setCashRatio(liquidity.calculateCashRatio(Double.parseDouble(balanceSheet.getTotalCash()), Double.parseDouble(balanceSheet.getCurrentLiabilities())));
        return liquidity;
    }

    private FinancialLeverage setFinancialLeverageCalculations(BalanceSheet balanceSheet) {
        FinancialLeverage financialLeverage = new FinancialLeverage();
        financialLeverage.setNetAssetValue(financialLeverage.calculateNetAssetValue(Double.parseDouble(balanceSheet.getCurrentAssets()), Double.parseDouble(balanceSheet.getCurrentLiabilities())));
        financialLeverage.setTotalDebtRatio(financialLeverage.calculateTotalDebtRatio(Double.parseDouble(balanceSheet.getCurrentAssets()), Double.parseDouble(balanceSheet.getTotalEquity())));
        financialLeverage.setDebtEquityRatio(financialLeverage.calculateDebtEquityRatio(Double.parseDouble(balanceSheet.getTotalDebt()), Double.parseDouble(balanceSheet.getCurrentLiabilities())));
        financialLeverage.setEquityMultiplier(financialLeverage.calculateEquityMultiplier(Double.parseDouble(balanceSheet.getCurrentAssets()), Double.parseDouble(balanceSheet.getTotalEquity())));
        financialLeverage.setFinancialLeverageRatio(financialLeverage.calculateFinancialLeverageRatio(Double.parseDouble(balanceSheet.getCurrentAssets()), Double.parseDouble(balanceSheet.getOwnersEquity())));
        financialLeverage.setLongTermDebtRatio(financialLeverage.calculateLongTermDebtRatio(Double.parseDouble(balanceSheet.getLongTermDebt()), Double.parseDouble(balanceSheet.getTotalEquity())));
        return financialLeverage;
    }

    private Profitability setProfitabilityCalculations(BalanceSheet balanceSheet, IncomeStatement incomeStatement) {
        Profitability profitability = new Profitability();
        profitability.setReturnOnAssets(profitability.calculateReturnOnAssets(Double.parseDouble(incomeStatement.getNetIncome()), Double.parseDouble(balanceSheet.getCurrentAssets())));
        profitability.setReturnOnEquity(profitability.calculateReturnOnEquity(Double.parseDouble(incomeStatement.getNetIncome()), Double.parseDouble(balanceSheet.getCurrentAssets())));
        return profitability;
    }

    private MarketValue setMarketValueCalculations(IncomeStatement incomeStatement, String earningsPerShare, String price) {
        MarketValue marketValue = new MarketValue();
        marketValue.setSharesOutstanding(marketValue.calculateSharesOutstanding(Double.parseDouble(incomeStatement.getNetIncome()), Double.parseDouble(earningsPerShare)));
        marketValue.setEarningsYield(marketValue.calculateEarningsYield(Double.parseDouble(earningsPerShare), Double.parseDouble(price)));
        marketValue.setPriceEarningsRatio(marketValue.calculatePriceEarningsRatio(Double.parseDouble(price), Double.parseDouble(earningsPerShare)));
        return marketValue;
    }
}
