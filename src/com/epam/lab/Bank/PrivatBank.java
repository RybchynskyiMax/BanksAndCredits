package com.epam.lab.Bank;

import com.epam.lab.Currency;

import java.util.HashMap;
import java.util.Map;

public class PrivatBank extends Bank{

    public PrivatBank() {
        Map<Currency, Double> bankMoney = new HashMap<>();
        bankMoney.put(Currency.UAH,1000000000000d);
        bankMoney.put(Currency.EUR,10000000000d);
        bankMoney.put(Currency.PLN,1000000000000d);
        bankMoney.put(Currency.RUB,1000000000000d);
        bankMoney.put(Currency.USD,100000000000d);
        super.setBankMoney(bankMoney);
    }

    @Override
    public String toString() {
        return "PrivatBank";
    }
}
