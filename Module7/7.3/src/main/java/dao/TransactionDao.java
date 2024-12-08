package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void persist(Transaction transaction) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
            errorMessage = null; // Clear error if operation succeeds
        } catch (Exception e) {
            em.getTransaction().rollback(); // Ensure rollback
            errorMessage = "Failed to persist Currency: " + e.getMessage();
        }
    }
}
