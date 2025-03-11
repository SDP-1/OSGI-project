//package bcs_resturent_menu_price;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import rfos_producerbundle.IResturentMenuService;
//import rfos_producerbundle.ResturentMenu;
//
//public class ResturentMenuWithPriceServiceImpl implements IResturentMenuWithPriceService {
//	
//	 // HashMap to store menu name as the key and price as the value
//    private Map<String, Double> menuPriceMap = new HashMap<>();
//
//    @Override
//    public Map<String, Double> getMenusWithPrice() {
//        return menuPriceMap;
//    }
//
//    // This method is called by the consumer to add menus and their prices
//    @Override
//    public void addMenusWithPrice(Map<String, ResturentMenu> rawMenus) {
//        // Iterate over the menus and add them to the price map with calculated or default prices
//        rawMenus.forEach((name, menu) -> {
//            double price = calculateDefaultPrice(menu);  // Calculate the price based on the menu
//            menuPriceMap.put(name, price); // Store the price in the map
//            System.out.println("Added/Updated price for " + name + ": " + price);
//        });
//    }
//
//    // Method to calculate a default price based on the menu
//    private double calculateDefaultPrice(ResturentMenu menu) {
//        return switch (menu.name) {
//            case "Pasta" -> 800.0;
//            case "Pizza" -> 1200.0;
//            case "Burger" -> 500.0;
//            default -> 1000.0; // Default price for any unrecognized item
//        };
//    }
//	
//}
