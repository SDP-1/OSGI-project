package bcs_producerbundle.impl;

import bcs_producerbundle.service.BillingService;

public class BillingServiceImpl implements BillingService {
    @Override
    public void processPayment(String customerName, double amount) {
        System.out.println("Payment of $" + amount + " processed for: " + customerName);
    }
}
