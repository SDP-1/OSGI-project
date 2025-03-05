package rfos_consumerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import rfos_consumerbundle.consumer.FoodOrderingConsumer;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        System.out.println("RFOS Consumer Bundle Started.");

        // Create an instance of FoodOrderingConsumer
        FoodOrderingConsumer consumer = new FoodOrderingConsumer();
        consumer.consumeService(context);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("RFOS Consumer Bundle Stopped.");
    }
}
