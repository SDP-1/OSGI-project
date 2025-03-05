package rbs_consumerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import rbs_producerbundle.service.RoomBookingService;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("Consumer Bundle Started.");

        // Get a reference to the RoomBookingService
        ServiceReference<RoomBookingService> ref = (ServiceReference<RoomBookingService>) context.getServiceReference(RoomBookingService.class.getName());

        if (ref != null) {
            RoomBookingService service = context.getService(ref);

            if (service != null) {
                System.out.println("Using RoomBookingService...");
                service.bookRoom("John Doe", "Deluxe Suite");
            } else {
                System.out.println("RoomBookingService is NULL.");
            }
        } else {
            System.out.println("RoomBookingService NOT FOUND.");
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Room Booking Consumer Stopped.");
    }
}
