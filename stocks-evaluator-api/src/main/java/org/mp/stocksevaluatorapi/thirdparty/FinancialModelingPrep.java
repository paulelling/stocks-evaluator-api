package org.mp.stocksevaluatorapi.thirdparty;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mp.stocksevaluatorapi.Configuration;
import org.mp.stocksevaluatorapi.api.model.BalanceSheet;
import org.mp.stocksevaluatorapi.api.model.CashFlowStatement;
import org.mp.stocksevaluatorapi.api.model.IncomeStatement;
import org.mp.stocksevaluatorapi.api.model.Stock;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class FinancialModelingPrep {

    private String apiKey;

    public FinancialModelingPrep() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        apiKey = cfg.GetFinancialModelingPrepApiKey();
    }

    public Stock getStockData(String ticker) throws IOException {
        ApiCall json = new ApiCall();
        JSONObject quote = json.readJsonFromUrlJackson("https://financialmodelingprep.com/api/v3/stock/full/real-time-price/" + ticker + "?apikey=" + apiKey);
        Stock stock = new Stock();
        stock.setPrice(quote.get("lastSalePrice").toString());
        return stock;
    }

    public BalanceSheet getBalanceSheet(String ticker) throws IOException {
        ApiCall json = new ApiCall();
        JSONObject jsonData = json.readJsonFromUrlJackson("https://financialmodelingprep.com/stable/balance-sheet-statement?symbol=" + ticker + "&apikey=" + apiKey);

        BalanceSheet balanceSheet = new BalanceSheet();
        balanceSheet.setTicker(ticker);
        balanceSheet.setDate(jsonData.get("date").toString());
        balanceSheet.setCurrentAssets(jsonData.get("totalCurrentAssets").toString());
        balanceSheet.setCurrentLiabilities(jsonData.get("totalCurrentLiabilities").toString());
        balanceSheet.setTotalCash(jsonData.get("cashAndCashEquivalents").toString());
        balanceSheet.setTotalDebt(jsonData.get("totalDebt").toString());
        balanceSheet.setTotalEquity(jsonData.get("totalEquity").toString());
        balanceSheet.setOwnersEquity(jsonData.get("totalStockholdersEquity").toString());
        balanceSheet.setLongTermDebt(jsonData.get("longTermDebt").toString());
        balanceSheet.setInventory(jsonData.get("inventory").toString());
        balanceSheet.setAccountsReceivable(jsonData.get("accountsReceivables").toString());

        return balanceSheet;
    }

    public IncomeStatement getIncomeStatement(String ticker) throws IOException {
        ApiCall json = new ApiCall();
        JSONObject jsonData = json.readJsonFromUrlJackson("https://financialmodelingprep.com/stable/income-statement?symbol=" + ticker + "&apikey=" + apiKey);

        IncomeStatement incomeStatement = new IncomeStatement();
        incomeStatement.setTicker(ticker);
        incomeStatement.setDate(jsonData.get("date").toString());
        incomeStatement.setEbit(jsonData.get("ebit").toString());
        incomeStatement.setEbitda(jsonData.get("ebitda").toString());
        incomeStatement.setDepreciationAndAmortization(jsonData.get("depreciationAndAmortization").toString());
        incomeStatement.setNetIncome(jsonData.get("netIncome").toString());
        incomeStatement.setOperatingIncome(jsonData.get("operatingIncome").toString());

        return incomeStatement;
    }

    public CashFlowStatement getCashFlowStatement(String ticker) throws IOException {
        ApiCall json = new ApiCall();
        JSONObject jsonData = json.readJsonFromUrlJackson("https://financialmodelingprep.com/stable/cash-flow-statement?symbol=" + ticker + "&apikey=" + apiKey);

        CashFlowStatement cashFlowStatement = new CashFlowStatement();
        cashFlowStatement.setTicker(ticker);
        cashFlowStatement.setDate(jsonData.get("date").toString());
        cashFlowStatement.setOperatingCashFlow(jsonData.get("operatingCashFlow").toString());
        cashFlowStatement.setTaxes(jsonData.get("incomeTaxesPaid").toString());
        cashFlowStatement.setChangeInNetWorkingCapital(jsonData.get("changeInWorkingCapital").toString());
        cashFlowStatement.setInventory(jsonData.get("inventory").toString());

        return cashFlowStatement;
    }
}
