package org.mp.stocksevaluatorapi.api.performance;

public class CashFlow {

    private Double qualityOfIncomeRatio;

    public class CashFlowData {

    }

    public Double getQualityOfIncomeRatio() {
        return qualityOfIncomeRatio;
    }

    public void setQualityOfIncomeRatio(Double qualityOfIncomeRatio) {
        this.qualityOfIncomeRatio = qualityOfIncomeRatio;
    }

    public Double calculateQualityOfIncomeRatio(Double operatingCashFlow, Double netIncome) {
        if (netIncome > 0) {
            qualityOfIncomeRatio = operatingCashFlow / netIncome;
        }
        return qualityOfIncomeRatio;
    }
}
