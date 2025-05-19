package org.mp.stocksevaluatorapi.api.model;

public class BalanceSheet {

    private String ticker;
    private String date;
    private String currentAssets;
    private String currentLiabilities;
    private String totalCash;
    private String totalDebt;
    private String totalEquity;
    private String ownersEquity;
    private String longTermDebt;
    private String inventory;
    private String accountsReceivable;

    public BalanceSheet() {

    }

    public BalanceSheet(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(String currentAssets) {
        this.currentAssets = currentAssets;
    }

    public String getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(String currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public String getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(String totalCash) {
        this.totalCash = totalCash;
    }

    public String getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(String totalDebt) {
        this.totalDebt = totalDebt;
    }

    public String getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(String totalEquity) {
        this.totalEquity = totalEquity;
    }

    public String getOwnersEquity() {
        return ownersEquity;
    }

    public void setOwnersEquity(String ownersEquity) {
        this.ownersEquity = ownersEquity;
    }

    public String getLongTermDebt() {
        return longTermDebt;
    }

    public void setLongTermDebt(String longTermDebt) {
        this.longTermDebt = longTermDebt;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(String accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }
}
