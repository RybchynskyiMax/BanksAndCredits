package com.epam.lab;

import com.epam.lab.Credit.CreditProperty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FindOptimalCredit {
    public static CreditProperty findOptimalCredit(Set<CreditProperty> properties){
       try {
           int again;
           Set<CreditProperty> result = properties;
           do {
               System.out.println("Choose property: \n" +
                       "1-rate \n" +
                       "2-duration \n" +
                       "3-limit \n" +
                       "4-currency");
               Scanner scannerForProperties = new Scanner(System.in);
               int property = scannerForProperties.nextByte();
               switch (property) {
                   case 1:
                       result = findCreditByRate(result);
                       break;
                   case 2:
                       result = findCreditByDuration(result);
                       break;
                   case 3:
                       result = findCreditByLimit(result);
                       break;
                   case 4:
                       result = findByCurrency(result);
                       break;
                   default:
                       System.out.println("Bad number!");
                       break;
               }
               System.out.println("--------------------------------");
               System.out.println("We find:");
               for (CreditProperty creditProperty : result) {
                   System.out.println(creditProperty);
               }
               System.out.println("--------------------------------");
               if (result.size()==1){
                   again=2;
               }else {
               System.out.println("Again? 1-Yes,2-No");
               Scanner scannerForChoose = new Scanner(System.in);
               again=scannerForChoose.nextByte();}
           }while (again != 2);
           for (CreditProperty creditProperty : result) {
               return creditProperty;
           }
           return null;
       }catch (Exception e){
           System.out.println("Please write only numbers when choose variant!");
           FindOptimalCredit.findCreditByLimit(properties);
       }
       return null;
    }
    public static Set<CreditProperty> findCreditByRate(Set<CreditProperty> creditsProperty){
        Set<CreditProperty> result = new HashSet<>();
       try {
           System.out.println("Input rate you want:");
           Scanner scannerForRate = new Scanner(System.in);
           int rate = scannerForRate.nextInt();
           for (CreditProperty creditProperty : creditsProperty) {
               if(creditProperty.getCreditRate().getRate()==rate){
                   result.add(creditProperty);
               }
           }
           return result;
       }catch (Exception e){
           System.out.println("please write in 0/5/10/15/20");
           FindOptimalCredit.findOptimalCredit(creditsProperty);
       }
       return creditsProperty;
    }
    public static Set<CreditProperty> findCreditByDuration(Set<CreditProperty> creditsProperty){
        Set<CreditProperty> result = new HashSet<>();
        try {
            System.out.println("Input duration you want:");
            Scanner scannerForDuretion = new Scanner(System.in);
            String duration = scannerForDuretion.nextLine();
            for (CreditProperty creditProperty : creditsProperty) {
                if(creditProperty.getCreditDuration().toString().equalsIgnoreCase(duration)){
                    result.add(creditProperty);
                }
            }
            return result;
        }catch (Exception e){
            System.out.println("please write  1/2/5/10 month/year/years");
            FindOptimalCredit.findOptimalCredit(creditsProperty);
        }
        return creditsProperty;
    }
    public static Set<CreditProperty> findCreditByLimit(Set<CreditProperty> creditsProperty){
        Set<CreditProperty> result = new HashSet<>();
        try {
            System.out.println("Input limit you want:");
            Scanner scannerForLimit = new Scanner(System.in);
            int limit = scannerForLimit.nextInt();
            for (CreditProperty creditProperty : creditsProperty) {
                if(creditProperty.getCreditLimit().getLimit()==limit){
                    result.add(creditProperty);
                }
            }
            return result;
        }catch (Exception e){
            System.out.println("please write  1000/5000/10000/20000/100000/1000000");
            FindOptimalCredit.findOptimalCredit(creditsProperty);
        }
        return creditsProperty;

    }
    public static Set<CreditProperty> findByCurrency(Set<CreditProperty> creditsProperty){
        Set<CreditProperty> result = new HashSet<>();
        try {
            System.out.println("Input currency you want:");
            Scanner scannerForCurrency = new Scanner(System.in);
            String currency = scannerForCurrency.nextLine();
            for (CreditProperty creditProperty : creditsProperty) {
                if(creditProperty.getCurrency().toString().equalsIgnoreCase(currency)){
                    result.add(creditProperty);
                }
            }
            return result;
        }catch (Exception e){
            System.out.println("please write  UAH/EUR/PLN/RUB/USD");
            FindOptimalCredit.findOptimalCredit(creditsProperty);
        }
        return creditsProperty;
    }
}
