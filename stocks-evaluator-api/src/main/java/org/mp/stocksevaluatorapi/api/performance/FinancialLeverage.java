package org.mp.stocksevaluatorapi.api.performance;

public class FinancialLeverage {

    private Double netAssetValue;
    private Double totalDebtRatio;
    private Double debtEquityRatio;
    private Double equityMultiplier;
    private Double financialLeverageRatio;
    private Double longTermDebtRatio;

    public FinancialLeverage() {

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

    public Double calculateNetAssetValue(Double assets, Double liabilities) {
        return assets - liabilities;
    }

    public Double calculateTotalDebtRatio(Double totalAssets, Double totalEquity) {
        Double totalDebtRatio = 0.0;
        if (totalAssets > 0) {
            totalDebtRatio = (totalAssets - totalEquity) / totalAssets;
        }
        return totalDebtRatio;
    }

    public Double calculateDebtEquityRatio(Double totalDebt, Double totalEquity) {
        Double debtEquityRatio = 0.0;
        if (totalEquity > 0) {
            debtEquityRatio = totalDebt / totalEquity;
        }
        return debtEquityRatio;
    }

    public Double calculateEquityMultiplier(Double totalAssets, Double totalEquity) {
        Double equityMultiplier = 0.0;
        if (totalEquity > 0) {
            equityMultiplier = totalAssets / totalEquity;
        }
        return equityMultiplier;
    }

    public Double calculateFinancialLeverageRatio(Double totalAssets, Double ownersEquity) {
        Double financialLeverageRatio = 0.0;
        if (ownersEquity > 0) {
            financialLeverageRatio = totalAssets / ownersEquity;
        }
        return financialLeverageRatio;
    }

    public Double calculateLongTermDebtRatio(Double longTermDebt, Double totalEquity) {
        Double longTermDebtRatio = 0.0;
        if (longTermDebt + totalEquity > 0) {
            longTermDebtRatio = longTermDebt / (longTermDebt + totalEquity);
        }
        return longTermDebtRatio;
    }
}
