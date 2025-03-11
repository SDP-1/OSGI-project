package bcs_room_booking_bill;

public interface IRoomBookingBillService {
	 // Method to generate a new bill
    void generateBill(RoomBookingBill bill);

    // Method to find a bill by its ID
    RoomBookingBill findBillById(int billId);
}
