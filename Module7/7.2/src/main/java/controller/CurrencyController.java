package controller;

import dao.CurrencyDao;
import entity.Currency;
import view.CurrencyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyController {
    private CurrencyView view;
    private CurrencyDao currencyDao;

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

    public double getCurrencyRate(String abbreviation) {
        return Currency.getRate(abbreviation);
    }

    public HashMap<String, Double> getAvailableCurrencies() {
        return Currency.getCurrencies();
    }

    public ArrayList<String> getAbbreviations() {
        List<Currency> currencyList = currencyDao.getAllCurrencies();
        ArrayList<String> abbreviations = new ArrayList<>();
        for (Currency currency : currencyList) {
            System.out.println(currency.getAbbreviation());
            abbreviations.add(currency.getAbbreviation());
        }
        return abbreviations;
    }

    public double convertCurrency(String initialCurrencyAbbreviation, String targetCurrencyAbbreviation, double amount) {
        if (initialCurrencyAbbreviation.equals(targetCurrencyAbbreviation)) {
            System.out.println(currencyDao.getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(currencyDao.getExchangeRate(targetCurrencyAbbreviation));
            System.out.println(amount);
            return amount;
        } else if (initialCurrencyAbbreviation.equals("USD")) {
            System.out.println(currencyDao.getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(currencyDao.getExchangeRate(targetCurrencyAbbreviation));
            return amount * currencyDao.getExchangeRate(targetCurrencyAbbreviation);
        } else if (targetCurrencyAbbreviation.equals("USD")) {
            System.out.println(currencyDao.getExchangeRate(initialCurrencyAbbreviation));
            System.out.println(currencyDao.getExchangeRate(targetCurrencyAbbreviation));
            return amount / currencyDao.getExchangeRate(initialCurrencyAbbreviation);
        } else
            System.out.println(currencyDao.getExchangeRate(initialCurrencyAbbreviation));
        System.out.println(currencyDao.getExchangeRate(targetCurrencyAbbreviation));
        return currencyDao.getExchangeRate(targetCurrencyAbbreviation) / currencyDao.getExchangeRate(initialCurrencyAbbreviation);
    }

    public static void main(String[] args) {
        CurrencyController currencyController = new CurrencyController();
        currencyController.getAbbreviations();
        currencyController.convertCurrency("EUR", "USD", 1.0);
    }
}
