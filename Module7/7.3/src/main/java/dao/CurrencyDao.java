package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CurrencyDao {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void persist(Currency currency) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
            errorMessage = null; // Clear error if operation succeeds
        } catch (Exception e) {
            em.getTransaction().rollback(); // Ensure rollback
            errorMessage = "Failed to persist Currency: " + e.getMessage();
        }
    }

    public Currency findById(int id) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            Currency currency = em.find(Currency.class, id);
            errorMessage = null; // Clear error if operation succeeds
            return currency;
        } catch (Exception e) {
            errorMessage = "Failed to find Currency by ID: " + e.getMessage();
            return null; // Return null on failure
        }
    }

    public List<Currency> findAll() {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            List<Currency> currencies = em.createQuery("select c from Currency c", Currency.class).getResultList();
            errorMessage = null; // Clear error if operation succeeds
            return currencies;
        } catch (Exception e) {
            errorMessage = "Failed to find all Currencies: " + e.getMessage();
            return null; // Return null on failure
        }
    }

    public void update(Currency currency) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.merge(currency);
            em.getTransaction().commit();
            errorMessage = null; // Clear error if operation succeeds
        } catch (Exception e) {
            em.getTransaction().rollback(); // Ensure rollback
            errorMessage = "Failed to update Currency: " + e.getMessage();
        }
    }

    public void delete(Currency currency) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.remove(currency);
            em.getTransaction().commit();
            errorMessage = null; // Clear error if operation succeeds
        } catch (Exception e) {
            em.getTransaction().rollback(); // Ensure rollback
            errorMessage = "Failed to delete Currency: " + e.getMessage();
        }
    }
}
