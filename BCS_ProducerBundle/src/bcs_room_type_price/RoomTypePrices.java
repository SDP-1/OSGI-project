package bcs_room_type_price;

public class RoomTypePrices {
	public String Roomtype;
    public double discount;
    public double price;

    // Constructor
    public RoomTypePrices(String roomtype, double discount, double price) {
        this.Roomtype = roomtype;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomTypePrices{Roomtype='" + Roomtype + "', discount=" + discount + ", price=" + price + '}';
    }
}