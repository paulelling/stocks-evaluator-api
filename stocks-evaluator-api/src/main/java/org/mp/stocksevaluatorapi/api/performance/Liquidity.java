package org.mp.stocksevaluatorapi.api.performance;

public class Liquidity {

    private Double currentRatio;
    private Double quickRatio;
    private Double cashRatio;

    public Liquidity() {

    }

    public Double getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(Double currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Double getQuickRatio() {
        return quickRatio;
    }

    public void setQuickRatio(Double quickRatio) {
        this.quickRatio = quickRatio;
    }

    public Double getCashRatio() {
        return cashRatio;
    }

    public void setCashRatio(Double cashRatio) {
        this.cashRatio = cashRatio;
    }

    public Double calculateCurrentRatio(Double currentAssets, Double currentLiabilities) {
        if (currentLiabilities > 0) {
            currentRatio = (currentAssets / currentLiabilities);
        }
        return currentRatio;
    }

    public Double calculateQuickRatio(Double currentAssets, Double currentLiabilities, Double inventory) {
        if (currentLiabilities > 0) {
            quickRatio = (currentAssets - inventory) / currentLiabilities;
        }
        return quickRatio;
    }

    public Double calculateCashRatio(Double totalCash, Double currentLiabilities) {
        if (currentLiabilities > 0) {
            cashRatio = totalCash / currentLiabilities;
        }
        return cashRatio;
    }
}
