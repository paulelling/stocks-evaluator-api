package org.mp.stocksevaluatorapi.api.model;

public class Stock {

    private String ticker;
    private String company;

    public Stock(String ticker, String company) {
        this.ticker = ticker;
        this.company = company;
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
}

