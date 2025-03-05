package bcs_consumerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import bcs_consumerbundle.consumer.BillingConsumer;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        System.out.println("BCS Consumer Bundle Started.");

        // Create an instance of BillingConsumer
        BillingConsumer consumer = new BillingConsumer();
        consumer.consumeService(context);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("BCS Consumer Bundle Stopped.");
    }
}
