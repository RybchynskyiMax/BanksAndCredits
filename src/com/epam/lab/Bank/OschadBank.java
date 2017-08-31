package com.epam.lab.Bank;

import com.epam.lab.Currency;

import java.util.HashMap;
import java.util.Map;

public class OschadBank extends Bank {

    public OschadBank() {
        Map<Currency, Double> bankMoney = new HashMap<>();
        bankMoney.put(Currency.UAH,10000000d);
        bankMoney.put(Currency.EUR,2000022000d);
        bankMoney.put(Currency.PLN,100000000d);
        bankMoney.put(Currency.RUB,6000000000d);
        bankMoney.put(Currency.USD,1000000000d);
        super.setBankMoney(bankMoney);
    }

    @Override
    public String toString() {
        return "OschadBank";
    }
}
