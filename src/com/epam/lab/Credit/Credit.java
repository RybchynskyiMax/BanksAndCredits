package com.epam.lab.Credit;

import com.epam.lab.BankClient;
import com.epam.lab.Currency;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Credit {
    private CreditProperty creditProperty;
    private   double creditMoney;
    private double moneyToPay;
    private int numberOfPayments;


    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(int numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(double moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    public double getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(double creditMoney) {
        this.creditMoney = creditMoney;
    }

    public CreditProperty getCreditProperty() {
        return creditProperty;
    }

    public void setCreditProperty(CreditProperty creditProperty) {
        this.creditProperty = creditProperty;
    }

    public double getMonthPaymentSum(){
        return (getMoneyToPay()+creditProperty.getCreditRate().getRate()/ getMoneyToPay()*100)/getNumberOfPayments();
    }

    public void mouthPayment(BankClient bankClient) {
        Map<Currency, Double> clientMoney = bankClient.getMoney();
        if (clientMoney.containsKey(getCreditProperty().getCurrency()) && clientMoney.get(getCreditProperty().getCurrency()) > getMonthPaymentSum()) {
            clientMoney.put(getCreditProperty().getCurrency(), clientMoney.get(getCreditProperty().getCurrency()) - getMonthPaymentSum());
            bankClient.setMoney(clientMoney);
            Map<Currency,Double> bankMoney = getCreditProperty().getBank().getBankMoney();
            bankMoney.put(getCreditProperty().getCurrency(),bankMoney.get(getCreditProperty().getCurrency())+getMonthPaymentSum());
            getCreditProperty().getBank().setBankMoney(bankMoney);
            setMoneyToPay(getMoneyToPay() - getMonthPaymentSum());
            setNumberOfPayments(getNumberOfPayments() - 1);
            checkingRepaymentOfACredit(bankClient);
        } else System.out.println("You don`t have enough moneyToPay!");
    }

    public void earlyRepaymentOfTheCredit(BankClient bankClient){
        Map<Currency,Double> clientMoney = bankClient.getMoney();
        if (clientMoney.containsKey(getCreditProperty().getCurrency()) && clientMoney.get(getCreditProperty().getCurrency())> getMoneyToPay() ){
            clientMoney.put(getCreditProperty().getCurrency(),clientMoney.get(getCreditProperty().getCurrency())- getMoneyToPay());
            bankClient.setMoney(clientMoney);
            Map<Currency,Double> bankMoney = getCreditProperty().getBank().getBankMoney();
            bankMoney.put(getCreditProperty().getCurrency(),bankMoney.get(getCreditProperty().getCurrency())+getMonthPaymentSum());
            getCreditProperty().getBank().setBankMoney(bankMoney);
            setMoneyToPay(0);
            setNumberOfPayments(0);
            checkingRepaymentOfACredit(bankClient);
        }else System.out.println("You don`t have enough moneyToPay!");
    }

    public void checkingRepaymentOfACredit(BankClient bankClient){
        Set<Credit> openCredits = bankClient.getOpenCredits();
        Iterator<Credit> creditIterator = openCredits.iterator();
        while (creditIterator.hasNext()){
            Credit currentCredit = creditIterator.next();
            if(currentCredit.getNumberOfPayments()==0){
                if(currentCredit.getMoneyToPay()==0){
                    creditIterator.remove();
                }else {
                    creditIterator.remove();
                    System.out.println("Your credit is transferred to collectors!");
                }
            }
        }
    }


    @Override
    public String toString() {
        return "You must pay "+ moneyToPay +creditProperty.getCurrency().toString()+" "+numberOfPayments+" times for "+creditProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credit credit = (Credit) o;

        if (Double.compare(credit.creditMoney, creditMoney) != 0) return false;
        if (Double.compare(credit.moneyToPay, moneyToPay) != 0) return false;
        if (numberOfPayments != credit.numberOfPayments) return false;
        return creditProperty != null ? creditProperty.equals(credit.creditProperty) : credit.creditProperty == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = creditProperty != null ? creditProperty.hashCode() : 0;
        temp = Double.doubleToLongBits(creditMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(moneyToPay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfPayments;
        return result;
    }
}
