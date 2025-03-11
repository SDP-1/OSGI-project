package bcs_consumerbundle;

import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("BCS Consumer Bundle Started...");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("BCS Consumer Bundle Stopped.");
    }

}
