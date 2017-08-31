package com.epam.lab.Credit;

public abstract class CreditDecorator extends Credit {
    private Credit credit;

    public CreditDecorator(Credit credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return credit.toString();
    }
}
