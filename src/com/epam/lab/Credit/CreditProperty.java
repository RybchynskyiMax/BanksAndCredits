package com.epam.lab.Credit;

import com.epam.lab.Bank.Bank;
import com.epam.lab.Currency;

public class CreditProperty {
    private CreditDuration creditDuration;
    private CreditLimit creditLimit;
    private CreditRate creditRate;
    private Currency currency;
    private Bank bank;

    public CreditProperty(CreditDuration creditDuration, CreditLimit creditLimit, CreditRate creditRate, Currency currency, Bank bank) {
        this.creditDuration = creditDuration;
        this.creditLimit = creditLimit;
        this.creditRate = creditRate;
        this.currency = currency;
        this.bank = bank;
    }

    public CreditDuration getCreditDuration() {
        return creditDuration;
    }

    public void setCreditDuration(CreditDuration creditDuration) {
        this.creditDuration = creditDuration;
    }

    public CreditLimit getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(CreditLimit creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditRate getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(CreditRate creditRate) {
        this.creditRate = creditRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Credit in "+bank.toString()+": credit duration "+creditDuration.toString()+"; credit limit "+creditLimit.toString()+currency.toString()+";credit rate "+creditRate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditProperty that = (CreditProperty) o;

        if (creditDuration != that.creditDuration) return false;
        if (creditLimit != that.creditLimit) return false;
        if (creditRate != that.creditRate) return false;
        if (currency != that.currency) return false;
        return bank != null ? bank.equals(that.bank) : that.bank == null;
    }

    @Override
    public int hashCode() {
        int result = creditDuration != null ? creditDuration.hashCode() : 0;
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        result = 31 * result + (creditRate != null ? creditRate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }
}
