package com.epam.lab.Credit;

public enum CreditRate {
    ZERO_PERCENT,FIVE_PERCENT,TEN_PERCENT,FIFTEEN_PERCENT,TWENTY_PERCENT;


    public int getRate() {
        switch (this) {
            case ZERO_PERCENT:
                return 0;
            case FIVE_PERCENT:
                return 5;
            case TEN_PERCENT:
                return 10;
            case FIFTEEN_PERCENT:
                return 15;
            case TWENTY_PERCENT:
                return 20;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ZERO_PERCENT:
                return "0%";
            case FIVE_PERCENT:
                return "5%";
            case TEN_PERCENT:
                return "10%";
            case FIFTEEN_PERCENT:
                return "15%";
            case TWENTY_PERCENT:
                return "20%";
            default:
                return "";
        }
    }
}
