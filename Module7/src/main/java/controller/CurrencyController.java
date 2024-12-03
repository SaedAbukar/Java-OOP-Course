package controller;

import model.Currency;
import view.CurrencyView;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyController {
    private CurrencyView view;
    private final Currency USD = new Currency("USD", "US Dollar", 1.00);
    private final Currency GBP = new Currency("GBP", "Great Britain Pound", 0.7922);
    private final Currency EUR = new Currency("EUR", "Euro", 0.9486);

    public CurrencyController(CurrencyView view) {
        this.view = view;
    }

    public String getAbbreviation(Currency currency) {
        return currency.getAbbreviation();
    }

    public String getCurrencyName(Currency currency) {
        return currency.getName();
    }

    public double getCurrencyRate(String abbreviation) {
        return Currency.getRate(abbreviation);
    }

    public HashMap<String, Double> getAvailableCurrencies() {
        return Currency.getCurrencies();
    }

    public ArrayList<String> getAbbreviations() {
        HashMap<String, Double> currencies = Currency.getCurrencies();
        ArrayList<String> abbreviations = new ArrayList<>();
        for (String currency : currencies.keySet()) {
            abbreviations.add(currency);
        }
        return abbreviations;
    }

    public double convertCurrency(String initialCurrencyAbbreviation, String targetCurrencyAbbreviation, double amount){
        if (initialCurrencyAbbreviation.equals(targetCurrencyAbbreviation)) {
            return amount;
        } else if (initialCurrencyAbbreviation.equals("USD")) {
            return amount * Currency.getRate(targetCurrencyAbbreviation);
        } else if (targetCurrencyAbbreviation.equals("USD")) {
            return amount / Currency.getRate(initialCurrencyAbbreviation);
        } else return Currency.getRate(targetCurrencyAbbreviation) / Currency.getRate(initialCurrencyAbbreviation);
    }
}
