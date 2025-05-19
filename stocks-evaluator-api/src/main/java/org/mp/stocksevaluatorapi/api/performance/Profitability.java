package org.mp.stocksevaluatorapi.api.performance;

public class Profitability {

    private Double returnOnAssets;
    private Double returnOnEquity;

    public Profitability() {

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

    public Double calculateReturnOnAssets(Double netIncome, Double totalAssets) {
        Double returnOnAssets = 0.0;
        if (totalAssets > 0) {
            returnOnAssets = netIncome / totalAssets;
        }
        return returnOnAssets;
    }

    public Double calculateReturnOnEquity(Double netIncome, Double totalEquity) {
        Double returnOnEquity = 0.0;
        if (totalEquity > 0) {
            returnOnEquity = netIncome / totalEquity;
        }
        return returnOnEquity;
    }
}
