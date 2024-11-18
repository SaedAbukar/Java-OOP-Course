package controller;

import model.Currency;
import view.CurrencyView;

import java.util.ArrayList;

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

    public double getCurrencyRate(Currency currency) {
        return currency.getRate();
    }

    public ArrayList<Currency> getAvailableCurrencies() {
        return Currency.getCurrencies();
    }

    public ArrayList<String> getAbbreviations() {
        ArrayList<Currency> currencies = Currency.getCurrencies();
        ArrayList<String> abbreviations = new ArrayList<>();
        for (Currency currency : currencies) {
            abbreviations.add(currency.getAbbreviation());
        }
        return abbreviations;
    }

    public double convertCurrency(String initialCurrencyAbbreviation, String targetCurrencyAbbreviation, double amount) {
        double rate = 0;
        double convertedAmount = 0;
        if (initialCurrencyAbbreviation.equals("USD") && targetCurrencyAbbreviation.equals("USD")) {
            convertedAmount = amount;
        }
        if (initialCurrencyAbbreviation.equals("USD") && targetCurrencyAbbreviation.equals("GBP")) {
            rate = GBP.getRate();
            convertedAmount = amount * rate;
        }
        if (initialCurrencyAbbreviation.equals("USD") && targetCurrencyAbbreviation.equals("EUR")) {
            rate = EUR.getRate();
            convertedAmount = amount * rate;
        }
        if (initialCurrencyAbbreviation.equals("GBP") && targetCurrencyAbbreviation.equals("GBP")) {
            convertedAmount = amount;
        }
        if (initialCurrencyAbbreviation.equals("GBP") && targetCurrencyAbbreviation.equals("USD")) {
            rate = GBP.getRate();
            convertedAmount = amount / rate;
        }
        if (initialCurrencyAbbreviation.equals("GBP") && targetCurrencyAbbreviation.equals("EUR")) {
            rate = EUR.getRate() / GBP.getRate();
            convertedAmount = amount * rate;
        }
        if (initialCurrencyAbbreviation.equals("EUR") && targetCurrencyAbbreviation.equals("EUR")) {
            convertedAmount = amount;
        }
        if (initialCurrencyAbbreviation.equals("EUR") && targetCurrencyAbbreviation.equals("USD")) {
            rate = EUR.getRate();
            convertedAmount = amount / rate;
        }
        if (initialCurrencyAbbreviation.equals("EUR") && targetCurrencyAbbreviation.equals("GBP")) {
            rate = GBP.getRate() / EUR.getRate();
            convertedAmount = amount * rate;
        }
        return convertedAmount;
    }
}
