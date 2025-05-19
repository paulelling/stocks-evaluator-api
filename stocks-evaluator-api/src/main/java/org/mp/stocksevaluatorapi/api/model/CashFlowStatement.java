package org.mp.stocksevaluatorapi.api.model;

public class CashFlowStatement {

    private String ticker;
    private String date;
    private String operatingCashFlow;
    private String taxes;
    private String changeInNetWorkingCapital;
    private String inventory;

    public CashFlowStatement() {

    }

    public CashFlowStatement(String ticker) {
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

    public String getOperatingCashFlow() {
        return operatingCashFlow;
    }

    public void setOperatingCashFlow(String operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getChangeInNetWorkingCapital() {
        return changeInNetWorkingCapital;
    }

    public void setChangeInNetWorkingCapital(String changeInNetWorkingCapital) {
        this.changeInNetWorkingCapital = changeInNetWorkingCapital;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
}
