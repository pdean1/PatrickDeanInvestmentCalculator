package edu.westga.cs6242.patrickdeaninvestmentcalculator.model;

/**
 * Created by Patrick on 3/8/2016.
 */
public class InvestmentCalculator {
    private double dblPeriodicPayment;
    private double dblRatePerPeriod;
    private int    dblNumberOfPeriods;

    public InvestmentCalculator() {

    }

    public InvestmentCalculator(double _periodicPayment,
                                double _ratePerPeriod,
                                int    _numberOfPeriods) throws IllegalArgumentException {
        this.dblNumberOfPeriods = _numberOfPeriods;
        this.dblPeriodicPayment = _periodicPayment;
        this.dblRatePerPeriod   = _ratePerPeriod;
        if (!aValidCalculator())
            throw new IllegalArgumentException("Unable to create an InvestmentCalculator");
    }

    private boolean aValidCalculator() {
        if (this.dblNumberOfPeriods < 1) {
            return false;
        }
        if (this.dblPeriodicPayment <= 0)
        {
            return false;
        }
        if (this.dblRatePerPeriod < 0.0001)
        {
            return false;
        }
        return true;
    }

    public double calculateFutureValueOfAnAnnuity() {
        double arg1 = (Math.pow((1 + this.dblRatePerPeriod),this.dblNumberOfPeriods) - 1);
        double result = 0;
        arg1 /= this.dblRatePerPeriod;
        result = this.dblPeriodicPayment * arg1;
        return result;
    }

    public double getDblPeriodicPayment() {
        return dblPeriodicPayment;
    }
    public void setDblPeriodicPayment(double dblPeriodicPayment) {
        this.dblPeriodicPayment = dblPeriodicPayment;
    }
    public double getDblRatePerPeriod() {
        return dblRatePerPeriod;
    }
    public void setDblRatePerPeriod(double dblRatePerPeriod) {
        this.dblRatePerPeriod = dblRatePerPeriod;
    }
    public int getDblNumberOfPeriods() {
        return dblNumberOfPeriods;
    }
    public void setDblNumberOfPeriods(int dblNumberOfPeriods) {
        this.dblNumberOfPeriods = dblNumberOfPeriods;
    }
}
