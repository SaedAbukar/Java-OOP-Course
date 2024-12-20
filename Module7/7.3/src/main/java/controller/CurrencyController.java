package controller;

import dao.CurrencyDao;
import entity.Currency;
import view.CurrencyView;

import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    private CurrencyView view;
    private CurrencyDao currencyDao;
    private String errorMessage;

    public CurrencyController(CurrencyView view) {
        this.view = view;
        this.currencyDao = new CurrencyDao();
    }

    public CurrencyController() {
        this.currencyDao = new CurrencyDao();
    }

    public String getAbbreviation(Currency currency) {
        return currency.getAbbreviation();
    }

    public String getCurrencyName(Currency currency) {
        return currency.getName();
    }

    public Double getExchangeRate(Currency currency) {
        return currency.getRate();
    }

    public Currency createCurrency(String abbreviation, String currencyName, double exchangeRate) {
        return new Currency(abbreviation, currencyName, exchangeRate);
    }

    public void persistCurrency(Currency currency) {
        currencyDao.persist(currency);
    }

    public Double getExchangeRate(String abbreviation) {
        List<Currency> currencyList = currencyDao.findAll();
        double exchange_rate = 0.0;
        for (Currency currency : currencyList) {
            if (currency.getAbbreviation().equals(abbreviation)) {
                exchange_rate = currency.getRate();
                break;
            }
        }
        return exchange_rate;
    }

    public ArrayList<String> getAbbreviations() {
        List<Currency> currencyList = currencyDao.findAll();
        ArrayList<String> abbreviations = new ArrayList<>();
        for (Currency currency : currencyList) {
            System.out.println(currency.getAbbreviation());
            abbreviations.add(currency.getAbbreviation());
        }
        return abbreviations;
    }

    public double convertCurrency(String initialCurrencyAbbreviation, String targetCurrencyAbbreviation, double amount) {
        List<Currency> currencyList = currencyDao.findAll();
        if (initialCurrencyAbbreviation.equals(targetCurrencyAbbreviation)) {
            System.out.println(getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(getExchangeRate(targetCurrencyAbbreviation));
            System.out.println(amount);
            return amount;
        } else if (initialCurrencyAbbreviation.equals("USD")) {
            System.out.println(getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(getExchangeRate(targetCurrencyAbbreviation));
            return amount * getExchangeRate(targetCurrencyAbbreviation);
        } else if (targetCurrencyAbbreviation.equals("USD")) {
            System.out.println(getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(getExchangeRate(targetCurrencyAbbreviation));
            return amount / getExchangeRate(initialCurrencyAbbreviation);
        } else
            System.out.println(getExchangeRate(initialCurrencyAbbreviation));
        System.out.println(getExchangeRate(targetCurrencyAbbreviation));
        return getExchangeRate(targetCurrencyAbbreviation) / getExchangeRate(initialCurrencyAbbreviation) * amount;
    }

    public String getErrorMessage() {
        errorMessage = currencyDao.getErrorMessage();
        return errorMessage;
    }
}
