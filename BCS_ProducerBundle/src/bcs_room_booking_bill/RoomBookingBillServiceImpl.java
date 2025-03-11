package bcs_room_booking_bill;

import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;

public class RoomBookingBillServiceImpl implements IRoomBookingBillService{
	 // Simulating a database with a HashMap
    public static Map<Integer, RoomBookingBill> billDatabase = new HashMap<Integer, RoomBookingBill>();
    private int currentBillId = 1;

    @Override
    public void generateBill(RoomBookingBill bill) {
        // Assign a unique bill ID
        bill.billId = currentBillId++;
        
        // Calculate the total price considering the discount
        double totalPrice = bill.TotalPricce;
        double discount = bill.descount;
        
        // Apply discount
        double finalPrice = totalPrice * (1 - (discount / 100));
        bill.TotalPricce = finalPrice;
        
        // Store the bill in the "database"
        billDatabase.put(bill.billId, bill);
        
        System.out.println("Bill generated successfully: " + bill);
        
        SwingUtilities.invokeLater(() -> {
          new RoomBookingBillViewerUI(bill).setVisible(true);
      });
    }

    @Override
    public RoomBookingBill findBillById(int billId) {
        RoomBookingBill bill = billDatabase.get(billId);
        
        if (bill != null) {
            System.out.println("Bill found: " + bill);
        } else {
            System.out.println("Bill not found for ID: " + billId);
        }
        
        return bill;
    }
}
