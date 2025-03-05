package bcs_producerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import bcs_producerbundle.service.BillingService;
import bcs_producerbundle.impl.BillingServiceImpl;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        BillingService service = new BillingServiceImpl();
        context.registerService(BillingService.class.getName(), service, null);
        System.out.println("Billing & Checkout Service Started.");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Billing & Checkout Service Stopped.");
    }
}
