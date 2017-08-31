package com.epam.lab.Credit;

public enum  CreditLimit {
    ONE_THOUSAND,FIVE_THOUSAND,TEN_THOUSAND,TWENTY_THOUSAND,FIFTY_THOUSAND,HUNDRED_THOUSAND,ONE_MILLION;

    public double getLimit(){
        switch (this) {
            case ONE_THOUSAND:
                return 1000;
            case FIVE_THOUSAND:
                return 5000;
            case TEN_THOUSAND:
                return 10000;
            case TWENTY_THOUSAND:
                return 20000;
            case FIFTY_THOUSAND:
                return 50000;
            case HUNDRED_THOUSAND:
                return 100000;
            case ONE_MILLION:
                return 1000000;
            default:
                return 0;
        }
    }
    @Override
    public String toString() {
        switch (this) {
            case ONE_THOUSAND:
                return "1000";
            case FIVE_THOUSAND:
                return "5000";
            case TEN_THOUSAND:
                return "10 000";
            case TWENTY_THOUSAND:
                return "20 000";
            case FIFTY_THOUSAND:
                return "50 000";
            case HUNDRED_THOUSAND:
                return "100 000";
            case ONE_MILLION:
                return "1 000 000";
            default:
                return "";
        }
    }
}
