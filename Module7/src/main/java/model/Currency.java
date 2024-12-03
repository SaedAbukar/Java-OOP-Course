package model;

import java.util.HashMap;

public class Currency {
    private static HashMap<String, Double> currencies = new HashMap<>();
    private String abbreviation;
    private String name;
    private double rate;


    public Currency(String abbreviation, String name, double rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
        currencies.put(abbreviation, rate);
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

    public static double getRate(String abbreviation) {
        return currencies.get(abbreviation);
    }

    public static HashMap<String, Double> getCurrencies() {
        return currencies;
    }
}
