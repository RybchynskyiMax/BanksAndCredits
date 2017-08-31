package com.epam.lab.Bank;

import com.epam.lab.Currency;

import java.util.HashMap;
import java.util.Map;

public class OTPBank extends Bank {
    public OTPBank() {
        Map<Currency, Double> bankMoney = new HashMap<>();
        bankMoney.put(Currency.UAH,100000000000d);
        bankMoney.put(Currency.EUR,30000000000d);
        bankMoney.put(Currency.PLN,500000000000d);
        bankMoney.put(Currency.RUB,21000000000d);
        bankMoney.put(Currency.USD,132300000d);
        super.setBankMoney(bankMoney);
    }

    @Override
    public String toString() {
        return "OTPBank";
    }
}
