package com.epam.lab.Bank;

import com.epam.lab.Credit.Credit;
import com.epam.lab.Currency;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public abstract class Bank {
    private Map<Currency,Double> bankMoney;


    public void setBankMoney(Map<Currency, Double> bankMoney) {
        this.bankMoney = bankMoney;
    }

    public Map<Currency, Double> getBankMoney() {
        return bankMoney;
    }





}
