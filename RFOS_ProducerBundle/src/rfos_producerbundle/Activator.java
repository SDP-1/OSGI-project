package rfos_producerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import rfos_producerbundle.service.FoodOrderingService;
import rfos_producerbundle.impl.FoodOrderingServiceImpl;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        FoodOrderingService service = new FoodOrderingServiceImpl();
        context.registerService(FoodOrderingService.class.getName(), service, null);
        System.out.println("Restaurant & Food Ordering Service Started.");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Restaurant & Food Ordering Service Stopped.");
    }
}
