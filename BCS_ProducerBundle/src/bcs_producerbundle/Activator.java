package bcs_producerbundle;

import java.util.Map;

import javax.swing.SwingUtilities;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bcs_room_booking_bill.*;
import bcs_room_type_price.*;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
    	 System.out.println("BCS Producer Bundle Started...");

    	    // Register Room Booking Bill Service
    	    IRoomBookingBillService RBService = new RoomBookingBillServiceImpl();
    	    context.registerService(IRoomBookingBillService.class.getName(), RBService, null);

    	    // Register Room Type Price Service
    	    IRoomTypePriceService RTPService = new RoomTypePriceServiceImpl();
    	    context.registerService(IRoomTypePriceService.class.getName(), RTPService, null);

    	    // Register the Menu with Price Service
//    	    IResturentMenuWithPriceService RMWPService = new ResturentMenuWithPriceServiceImpl();
//    	    context.registerService(IResturentMenuWithPriceService.class.getName(), RMWPService, null);
    	    
    	    System.out.println("All Services Started in BCS Producer Bundle.");

        // Add sample data to the services
        addSampleRoomPrices(RTPService);
        generateSampleBill(RBService);
        getRoomPriceById(RTPService);
        showAllRoomTagPrices(RTPService);
//        getMenuWithPrice(RMWPService);
    }

	@Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Billing & Checkout Service Stopped.");
    }

    // Private method to add sample room prices to the RoomTypePriceService
    private void addSampleRoomPrices(IRoomTypePriceService RTPService) {
        RoomTypePrices room1 = new RoomTypePrices("Single Room", 0.0, 10000);
        RoomTypePrices room2 = new RoomTypePrices("Double Room", 5.0, 20000);
        RoomTypePrices room3 = new RoomTypePrices("Suite", 10.0, 50000);
        RoomTypePrices room4 = new RoomTypePrices("Deluxe", 15.0, 100000);
        RoomTypePrices room5 = new RoomTypePrices("Standard Room", 5.0, 35000);

        // Adding room prices to the service
        RTPService.addRoomPriceWithTag(room1);
        RTPService.addRoomPriceWithTag(room2);
        RTPService.addRoomPriceWithTag(room3);
        RTPService.addRoomPriceWithTag(room4);
        RTPService.addRoomPriceWithTag(room5);

        System.out.println("Sample room prices added successfully.");
    }
    
    private void getRoomPriceById(IRoomTypePriceService RTPService) {
    	String type = "Double Room";
    	
    	RoomTypePrices roomTypePrices =  RTPService.getRoomPriceByTag(type);
    	System.out.println("\n type = "+roomTypePrices.Roomtype+
    			"\n price = "+roomTypePrices.price+
    			"\n discount = "+ roomTypePrices.discount
    			);
    }
    
    private void showAllRoomTagPrices(IRoomTypePriceService roomService) {
   	 SwingUtilities.invokeLater(() -> {
            new RoomTypePriceEditorUI(roomService).setVisible(true);
        });
   }

    // Private method to generate a sample bill
    private void generateSampleBill(IRoomBookingBillService RBService) {
        // Create a RoomBookingBill object and set its properties
        RoomBookingBill bill = new RoomBookingBill();
        bill.roomId = 101;
        bill.RoomType = "Deluxe";
        bill.TotalPricce = 500.00;  // Initial price
        bill.dates = 3;  // Duration in days
        bill.descount = 10.0;  // Discount in percentage

        // Generate the bill using the service
        RBService.generateBill(bill);

    }
   
    
}
