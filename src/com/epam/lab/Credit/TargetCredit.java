package com.epam.lab.Credit;

import com.epam.lab.Bank.Bank;
import com.epam.lab.Currency;

public class TargetCredit extends Credit {
    private String target;
    public TargetCredit(CreditProperty creditProperty, double money,String target) {
        super.setCreditProperty(creditProperty);
        super.setCreditMoney(money);
        super.setMoneyToPay(money+getCreditProperty().getCreditRate().getRate()/money*100);
        setNumberOfPayments(getCreditProperty().getCreditDuration().getDuretionInMonth());
        this.target=target;
    }

    public String getTarget() {
        return target;
    }


    @Override
    public String toString() {
        return super.toString()+"\n ("+target+")";
    }

}
