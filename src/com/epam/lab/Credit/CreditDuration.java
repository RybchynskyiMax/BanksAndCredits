package com.epam.lab.Credit;

public enum CreditDuration {
    ONE_MONTH,TEN_MONTH,ONE_YEAR,TWO_YEARS,FIVE_YEARS;

    public int getDuretionInMonth(){
        switch (this) {
            case ONE_MONTH:
                return 1;
            case TEN_MONTH:
                return 10;
            case ONE_YEAR:
                return 12;
            case TWO_YEARS:
                return 24;
            case FIVE_YEARS:
                return 60;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ONE_MONTH:
                return "1 month";
            case TEN_MONTH:
                return "10 month";
            case ONE_YEAR:
                return "1 year";
            case TWO_YEARS:
                return "2 years";
            case FIVE_YEARS:
                return "5 years";
            default:
                return "";
        }
    }
}
