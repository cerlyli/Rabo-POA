package nl.rabobank.powerofattorney.api.products;

import javax.persistence.Id;


public class CreditCard extends GenericCard{
    private double monthlyLimit;

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }
}
