package org.mp.stocksevaluatorapi.api.model;

import org.json.JSONObject;

import java.math.BigDecimal;

public class Stock {

    private String ticker;
    private String company;
    private String price;
    private String fiftyTwoWeekHigh;
    private String fiftyTwoWeekHighDate;
    private String fiftyTwoWeekLow;
    private String fiftyTwoWeekLowDate;
    private String dividendPerShare;
    private String assetTurnover;
    private String beta;
    private String earningsPerShare;
    private String grossMargin;
    private String inventoryTurnover;
    private String longTermDebtPerEquity;
    private String marketCapitalization;
    private String operatingMargin;
    private String quickRatio;
    private String receivablesTurnover;
    private BalanceSheet balanceSheet;
    private IncomeStatement incomeStatement;
    private CashFlowStatement cashFlowStatement;

    public Stock() {}

    public Stock(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(String fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public String getFiftyTwoWeekHighDate() {
        return fiftyTwoWeekHighDate;
    }

    public void setFiftyTwoWeekHighDate(String fiftyTwoWeekHighDate) {
        this.fiftyTwoWeekHighDate = fiftyTwoWeekHighDate;
    }

    public String getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(String fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public String getFiftyTwoWeekLowDate() {
        return fiftyTwoWeekLowDate;
    }

    public void setFiftyTwoWeekLowDate(String fiftyTwoWeekLowDate) {
        this.fiftyTwoWeekLowDate = fiftyTwoWeekLowDate;
    }

    public String getDividendPerShare() {
        return dividendPerShare;
    }

    public void setDividendPerShare(String dividendPerShare) {
        this.dividendPerShare = dividendPerShare;
    }

    public String getAssetTurnover() {
        return assetTurnover;
    }

    public void setAssetTurnover(String assetTurnover) {
        this.assetTurnover = assetTurnover;
    }

    public String getBeta() {
        return beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public String getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(String earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public String getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(String grossMargin) {
        this.grossMargin = grossMargin;
    }

    public String getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(String inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }

    public String getLongTermDebtPerEquity() {
        return longTermDebtPerEquity;
    }

    public void setLongTermDebtPerEquity(String longTermDebtPerEquity) {
        this.longTermDebtPerEquity = longTermDebtPerEquity;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public String getOperatingMargin() {
        return operatingMargin;
    }

    public void setOperatingMargin(String operatingMargin) {
        this.operatingMargin = operatingMargin;
    }

    public String getQuickRatio() {
        return quickRatio;
    }

    public void setQuickRatio(String quickRatio) {
        this.quickRatio = quickRatio;
    }

    public String getReceivablesTurnover() {
        return receivablesTurnover;
    }

    public void setReceivablesTurnover(String receivablesTurnover) {
        this.receivablesTurnover = receivablesTurnover;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public IncomeStatement getIncomeStatement() {
        return incomeStatement;
    }

    public void setIncomeStatement(IncomeStatement incomeStatement) {
        this.incomeStatement = incomeStatement;
    }

    public CashFlowStatement getCashFlowStatement() {
        return cashFlowStatement;
    }

    public void setCashFlowStatement(CashFlowStatement cashFlowStatement) {
        this.cashFlowStatement = cashFlowStatement;
    }
}

