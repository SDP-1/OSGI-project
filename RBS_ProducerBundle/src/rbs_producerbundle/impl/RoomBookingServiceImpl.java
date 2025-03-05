package rbs_producerbundle.impl;

import rbs_producerbundle.service.RoomBookingService;

public class RoomBookingServiceImpl implements RoomBookingService {
    @Override
    public void bookRoom(String guestName, String roomType) {
        System.out.println("Room booked for: " + guestName + " in " + roomType + ".");
    }
}
