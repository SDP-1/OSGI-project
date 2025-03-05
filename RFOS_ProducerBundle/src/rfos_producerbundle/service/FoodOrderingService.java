package rfos_producerbundle.service;

public interface FoodOrderingService {
    void placeOrder(String customerName, String foodItem, int quantity);
}
