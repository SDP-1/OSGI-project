package rfos_consumerbundle.consumer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import rfos_producerbundle.service.FoodOrderingService;

public class FoodOrderingConsumer {
    public void consumeService(BundleContext context) {
        // Get a reference to the FoodOrderingService
        ServiceReference<?> ref = context.getServiceReference(FoodOrderingService.class.getName());

        if (ref != null) {
            System.out.println("FoodOrderingService Reference Found.");
            FoodOrderingService service = (FoodOrderingService) context.getService(ref);

            if (service != null) {
                System.out.println("Using FoodOrderingService...");
                service.placeOrder("Bob Smith", "Pizza", 2);
            } else {
                System.out.println("FoodOrderingService is NULL.");
            }
        } else {
            System.out.println("FoodOrderingService NOT FOUND.");
        }
    }
}
