package com.epam.lab;

import com.epam.lab.Bank.AlfaBank;
import com.epam.lab.Bank.OTPBank;
import com.epam.lab.Bank.OschadBank;
import com.epam.lab.Bank.PrivatBank;
import com.epam.lab.Credit.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<CreditProperty> creditsProperty = new HashSet<>();
        AlfaBank alfaBank = new AlfaBank();
        OschadBank oschadBank = new OschadBank();
        OTPBank otpBank = new OTPBank();
        PrivatBank privatBank = new PrivatBank();
        creditsProperty.add(new CreditProperty(CreditDuration.TEN_MONTH, CreditLimit.TWENTY_THOUSAND, CreditRate.FIVE_PERCENT,Currency.UAH,alfaBank));
        creditsProperty.add(new CreditProperty(CreditDuration.FIVE_YEARS, CreditLimit.HUNDRED_THOUSAND, CreditRate.FIFTEEN_PERCENT,Currency.USD,privatBank));
        creditsProperty.add(new CreditProperty(CreditDuration.TWO_YEARS, CreditLimit.ONE_MILLION, CreditRate.FIVE_PERCENT,Currency.UAH,otpBank));
        creditsProperty.add(new CreditProperty(CreditDuration.ONE_MONTH, CreditLimit.FIVE_THOUSAND, CreditRate.ZERO_PERCENT,Currency.UAH,oschadBank));
        creditsProperty.add(new CreditProperty(CreditDuration.ONE_YEAR, CreditLimit.TWENTY_THOUSAND, CreditRate.TEN_PERCENT,Currency.PLN,alfaBank));
        creditsProperty.add(new CreditProperty(CreditDuration.TEN_MONTH, CreditLimit.FIFTY_THOUSAND, CreditRate.TWENTY_PERCENT,Currency.UAH,privatBank));
        creditsProperty.add(new CreditProperty(CreditDuration.FIVE_YEARS, CreditLimit.HUNDRED_THOUSAND, CreditRate.TEN_PERCENT,Currency.USD,otpBank));
        creditsProperty.add(new CreditProperty(CreditDuration.ONE_MONTH, CreditLimit.ONE_THOUSAND, CreditRate.FIVE_PERCENT,Currency.PLN,oschadBank));
        Map<Currency,Double> clientMoney = new HashMap<>();
        clientMoney.put(Currency.UAH,1000d);
        clientMoney.put(Currency.USD,500d);
        clientMoney.put(Currency.PLN,2000d);
        BankClient bankClient = new BankClient("Jon","Snow",clientMoney);
        bankClient.openNewCreditInBank(FindOptimalCredit.findOptimalCredit(creditsProperty),5000,"for the new dragon");
        bankClient.openNewCreditInBank(FindOptimalCredit.findOptimalCredit(creditsProperty),100000,"for the new army");
        bankClient.openNewCreditInBank(FindOptimalCredit.findOptimalCredit(creditsProperty),4000,"for the new wall");
        bankClient.openNewCreditInBank(FindOptimalCredit.findOptimalCredit(creditsProperty),1000,"for the new sword");
        for (Credit credit : bankClient.getOpenCredits()) {
            credit.mouthPayment(bankClient);
            System.out.println(credit);
            credit = new CreditLineDecorator(credit);
            System.out.println(credit);
        }
        for (Credit credit : bankClient.getOpenCredits()) {
            credit.earlyRepaymentOfTheCredit(bankClient);
        }


    }

}
