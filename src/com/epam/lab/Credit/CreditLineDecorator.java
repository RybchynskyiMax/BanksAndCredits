package com.epam.lab.Credit;

public class CreditLineDecorator extends CreditDecorator{

    public CreditLineDecorator(Credit credit) {
        super(credit);
        setMoneyToPay(getMoneyToPay()+5/ getMoneyToPay()*100);
    }


    public void upCreditLine(double money) {
        if(money+getCreditMoney()<getCreditProperty().getCreditLimit().getLimit()){
            setMoneyToPay(getCreditMoney()+money);
        }
    }

    @Override
    public String toString() {
        return "(With credit line) "+super.toString();
    }
}
