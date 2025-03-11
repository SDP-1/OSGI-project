package bcs_room_type_price;

import java.util.HashMap;
import java.util.Map;

public class RoomTypePriceServiceImpl implements IRoomTypePriceService {

    // Simulating a database with a HashMap
    public static HashMap<String, RoomTypePrices> roomPriceDatabase = new HashMap<>();

    @Override
    public RoomTypePrices getRoomPriceByTag(String type) {
        // Fetch the RoomTypePrices using the tag as the key
        RoomTypePrices roomPrice = roomPriceDatabase.get(type);

        if (roomPrice != null) {
            System.out.println("RoomPrice found for Type: " + type);
        } else {
            System.out.println("No RoomPrice found for Type: " + type);
        }
        return roomPrice;
    }

    @Override
    public void addRoomPriceWithTag(RoomTypePrices roomPrice) {
        // Add the room price to the "database" with tag as the key
        roomPriceDatabase.put(roomPrice.Roomtype, roomPrice);
        System.out.println("RoomPrice added: " + roomPrice.Roomtype + " with price: " + roomPrice.price + " and discount: " + roomPrice.discount + "%");
    }
    
    @Override
    public HashMap<String, RoomTypePrices>  getRoomPriceDatabase(){
    	return roomPriceDatabase;
    }
    
}
