package org.mp.stocksevaluatorapi.api.model;

import org.json.JSONObject;
import org.mp.stocksevaluatorapi.api.performance.CashFlow;

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
    private Double qualityOfIncomeRatio;
    private Double currentRatio;
    private Double cashRatio;
    private Double netAssetValue;
    private Double totalDebtRatio;
    private Double debtEquityRatio;
    private Double equityMultiplier;
    private Double financialLeverageRatio;
    private Double longTermDebtRatio;
    private Double returnOnAssets;
    private Double returnOnEquity;
    private Double sharesOutstanding;
    private Double earningsYield;
    private Double priceEarningsRatio;

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

    public Double getQualityOfIncomeRatio() {
        return qualityOfIncomeRatio;
    }

    public void setQualityOfIncomeRatio(Double qualityOfIncomeRatio) {
        this.qualityOfIncomeRatio = qualityOfIncomeRatio;
    }

    public Double getCurrentRatio() {
        return currentRatio;
    }
    public void setCurrentRatio(Double currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Double getCashRatio() {
        return cashRatio;
    }

    public void setCashRatio(Double cashRatio) {
        this.cashRatio = cashRatio;
    }

    public Double getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(Double netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public Double getTotalDebtRatio() {
        return totalDebtRatio;
    }

    public void setTotalDebtRatio(Double totalDebtRatio) {
        this.totalDebtRatio = totalDebtRatio;
    }

    public Double getDebtEquityRatio() {
        return debtEquityRatio;
    }

    public void setDebtEquityRatio(Double debtEquityRatio) {
        this.debtEquityRatio = debtEquityRatio;
    }

    public Double getEquityMultiplier() {
        return equityMultiplier;
    }

    public void setEquityMultiplier(Double equityMultiplier) {
        this.equityMultiplier = equityMultiplier;
    }

    public Double getFinancialLeverageRatio() {
        return financialLeverageRatio;
    }

    public void setFinancialLeverageRatio(Double financialLeverageRatio) {
        this.financialLeverageRatio = financialLeverageRatio;
    }

    public Double getLongTermDebtRatio() {
        return longTermDebtRatio;
    }

    public void setLongTermDebtRatio(Double longTermDebtRatio) {
        this.longTermDebtRatio = longTermDebtRatio;
    }

    public Double getReturnOnAssets() {
        return returnOnAssets;
    }

    public void setReturnOnAssets(Double returnOnAssets) {
        this.returnOnAssets = returnOnAssets;
    }

    public Double getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Double returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public Double getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(Double sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public Double getEarningsYield() {
        return earningsYield;
    }

    public void setEarningsYield(Double earningsYield) {
        this.earningsYield = earningsYield;
    }

    public Double getPriceEarningsRatio() {
        return priceEarningsRatio;
    }

    public void setPriceEarningsRatio(Double priceEarningsRatio) {
        this.priceEarningsRatio = priceEarningsRatio;
    }
}

