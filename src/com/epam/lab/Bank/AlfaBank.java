package com.epam.lab.Bank;

import com.epam.lab.Credit.*;
import com.epam.lab.Currency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlfaBank extends Bank {


    public AlfaBank() {
        Map<Currency, Double> bankMoney = new HashMap<>();
        bankMoney.put(Currency.UAH,1000000000d);
        bankMoney.put(Currency.EUR,20000000d);
        bankMoney.put(Currency.PLN,1000000d);
        bankMoney.put(Currency.RUB,1000000000d);
        bankMoney.put(Currency.USD,100000d);
        super.setBankMoney(bankMoney);
    }

    @Override
    public String toString() {
        return "Alfa-Bank";
    }
}
