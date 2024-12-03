package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    public List<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "select * from currencies";
        List<Currency> currencies = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String abbreaviation = rs.getString(2);
                String currency_name = rs.getString(3);
                double exchange_rate = rs.getDouble(4);
                Currency currency = new Currency(abbreaviation, currency_name, exchange_rate);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencies;
    }

    public Currency getCurrencyByAbbreviation(String abbreviation) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "select * from currencies where abbreviation=?";
        Currency currency = null;
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                String currency_name = rs.getString(3);
                double exchange_rate = rs.getDouble(4);
                currency = new Currency(abbreviation, currency_name, exchange_rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return currency;
        } else {
            return null;
        }
    }

    public void addCurrency(Currency currency) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "insert into currencies values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currency.getAbbreviation());
            ps.setString(2, currency.getName());
            ps.setDouble(3, currency.getRate());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getExchangeRate(String abbreviation) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "select * from currencies where abbreviation=?";
        double exchange_rate = 0;
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                exchange_rate = rs.getDouble(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return exchange_rate;
        } else {
            return 0;
        }
    }

    public String getCurrencyName(String abbreviation) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "select * from currencies where abbreviation=?";
        String name = null;
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                name = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return name;
        } else {
            return null;
        }
    }
}
