package com.epam.lab;

import com.epam.lab.Credit.TargetCredit;
import com.epam.lab.Credit.Credit;
import com.epam.lab.Credit.CreditProperty;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BankClient {
    private String name;
    private String surName;
    private Set<Credit> openCredits;
    private Map<Currency,Double> money;


    public BankClient(String name, String surName, Map<Currency, Double> money) {
        this.name = name;
        this.surName = surName;
        this.openCredits = new HashSet<>();
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Set<Credit> getOpenCredits() {
        return openCredits;
    }

    public void setOpenCredits(Set<Credit> openCredits) {
        this.openCredits = openCredits;
    }

    public Map<Currency, Double> getMoney() {
        return money;
    }

    public void setMoney(Map<Currency, Double> money) {
        this.money = money;
    }

    public void openNewCreditInBank(CreditProperty creditProperty, double money,String target){
        Map<Currency,Double> bankMoney = creditProperty.getBank().getBankMoney();
        if(bankMoney.get(creditProperty.getCurrency())>money && creditProperty.getCreditLimit().getLimit()>money) {
            Credit credit = new TargetCredit(creditProperty, money, target);
            Map<Currency, Double> clientMoney = getMoney();
            clientMoney.put(creditProperty.getCurrency(),clientMoney.get(creditProperty.getCurrency())+money);
            getOpenCredits().add(credit);
        }else System.out.println("Bank don`t have enough money or limit of this credit is too little!");
    }

}
