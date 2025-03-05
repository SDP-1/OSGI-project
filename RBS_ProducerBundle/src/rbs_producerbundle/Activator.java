package rbs_producerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import rbs_producerbundle.service.RoomBookingService;
import rbs_producerbundle.impl.RoomBookingServiceImpl;

public class Activator implements BundleActivator {
    private static BundleContext context;

    public void start(BundleContext bundleContext) throws Exception {
        RoomBookingService service = new RoomBookingServiceImpl();
        bundleContext.registerService(RoomBookingService.class.getName(), service, null);
        System.out.println("Room Booking Service Started.");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Room Booking Service Stopped.");
    }
    //to book a room
}
