package rfos_producerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
    	 context.registerService(IResturentMenuService.class.getName(), new ResturentMenuServiceImpl(), null);
        System.out.println("Restaurant & Food Ordering Service Started.");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Restaurant & Food Ordering Service Stopped.");
    }
}
