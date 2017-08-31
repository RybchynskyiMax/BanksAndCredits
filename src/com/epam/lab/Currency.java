package com.epam.lab;

public enum Currency {
    UAH,USD,EUR,RUB,PLN;

    @Override
    public String toString() {
        switch (this){
            case UAH:
                return "UAH";
            case EUR:
                return "EUR";
            case PLN:
                return "PLN";
            case RUB:
                return "RUB";
            case USD:
                return "USD";
            default:
                return "";
        }
    }
}
