package rfos_producerbundle.impl;

import rfos_producerbundle.service.FoodOrderingService;

public class FoodOrderingServiceImpl implements FoodOrderingService {
    @Override
    public void placeOrder(String customerName, String foodItem, int quantity) {
        System.out.println("Order placed for: " + customerName +
                " - " + quantity + "x " + foodItem);
    }
}
