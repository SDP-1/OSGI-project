package bcs_consumerbundle.consumer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import bcs_producerbundle.service.BillingService;

public class BillingConsumer {
    public void consumeService(BundleContext context) {
        // Get a reference to the BillingService
        ServiceReference<?> ref = context.getServiceReference(BillingService.class.getName());

        if (ref != null) {
            System.out.println("BillingService Reference Found.");
            BillingService service = (BillingService) context.getService(ref);

            if (service != null) {
                System.out.println("Using BillingService...");
                service.processPayment("Alice Johnson", 150.00);
            } else {
                System.out.println("BillingService is NULL.");
            }
        } else {
            System.out.println("BillingService NOT FOUND.");
        }
    }
}
