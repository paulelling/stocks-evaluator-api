package org.mp.stocksevaluatorapi.api.performance;

public class MarketValue {

    private Double sharesOutstanding;
    private Double earningsYield;
    private Double priceEarningsRatio;

    public MarketValue() {

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

    public Double calculateSharesOutstanding(Double netIncome, Double earningsPerShare) {
        Double sharesOutstanding = 0.0;
        if (earningsPerShare > 0) {
            sharesOutstanding = netIncome / earningsPerShare;
        }
        return sharesOutstanding;
    }

    public Double calculateEarningsYield(Double earningsPerShare, Double price) {
        Double earningsYield = 0.0;
        if (price > 0) {
            earningsYield = earningsPerShare / price;
        }
        return earningsYield;
    }

    public Double calculatePriceEarningsRatio(Double price, Double earingsPerShare) {
        Double priceEarningsRatio = 0.0;
        if (earingsPerShare > 0) {
            priceEarningsRatio = price / earingsPerShare;
        }
        return priceEarningsRatio;
    }
}
