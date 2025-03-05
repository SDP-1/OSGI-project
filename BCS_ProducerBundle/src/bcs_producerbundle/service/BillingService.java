package bcs_producerbundle.service;

public interface BillingService {
    void processPayment(String customerName, double amount);
}
