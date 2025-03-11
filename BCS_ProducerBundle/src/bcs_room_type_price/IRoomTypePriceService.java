package bcs_room_type_price;

import java.util.HashMap;

public interface IRoomTypePriceService {

    // Method to get room price by tag
    RoomTypePrices getRoomPriceByTag(String tag);
    
    // Method to add a room price with a tag
    void addRoomPriceWithTag(RoomTypePrices roomPrice);

	HashMap<String, RoomTypePrices> getRoomPriceDatabase();
}

