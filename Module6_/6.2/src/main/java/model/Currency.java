package model;

import java.util.ArrayList;

public class Currency {
    private static ArrayList<Currency> currencies = new ArrayList<Currency>();
    private String abbreviation;
    private String name;
    private double rate;


    public Currency(String abbreviation, String name, double rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
        currencies.add(this);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public static ArrayList<Currency> getCurrencies() {
        return currencies;
    }
}
