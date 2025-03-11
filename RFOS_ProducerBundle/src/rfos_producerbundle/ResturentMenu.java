package rfos_producerbundle;

public class ResturentMenu {
    public String name;
    public String description;
    public double weight; // in grams
    public boolean available;
    
    public ResturentMenu() {};
    
    // Constructors
    public ResturentMenu(String name, String description, double weight, boolean available) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Menu Item: " + name + " \n" +
               "Description: " + description + "\n" +
               "Weight: " + weight + "g\n" +
               "Available: " + (available ? "Yes" : "No") + "\n";
    }
}

