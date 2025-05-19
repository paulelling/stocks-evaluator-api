package org.mp.stocksevaluatorapi.api.model;

public class IncomeStatement {

    private String ticker;
    private String date;
    private String ebit;
    private String ebitda;
    private String depreciationAndAmortization;
    private String netIncome;
    private String operatingIncome;

    public IncomeStatement() {

    }

    public IncomeStatement(String ticker) {

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

    public String getEbit() {
        return ebit;
    }

    public void setEbit(String ebit) {
        this.ebit = ebit;
    }

    public String getEbitda() {
        return ebitda;
    }

    public void setEbitda(String ebitda) {
        this.ebitda = ebitda;
    }

    public String getDepreciationAndAmortization() {
        return depreciationAndAmortization;
    }

    public void setDepreciationAndAmortization(String depreciationAndAmortization) {
        this.depreciationAndAmortization = depreciationAndAmortization;
    }

    public String getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(String operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }
}
