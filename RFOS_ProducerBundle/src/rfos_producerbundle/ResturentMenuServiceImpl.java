package rfos_producerbundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResturentMenuServiceImpl implements IResturentMenuService {

	private Map<String, ResturentMenu> menuMap = new HashMap<String, ResturentMenu>();

    public ResturentMenuServiceImpl() {
        loadSampleMenus();
    }

    private void loadSampleMenus() {
        menuMap.put("Pasta", new ResturentMenu("Pasta", "Creamy Alfredo Pasta", 250, true));
        menuMap.put("Pizza", new ResturentMenu("Pizza", "Margherita Pizza", 500, true));
        menuMap.put("Burger", new ResturentMenu("Burger", "Chicken Burger", 300, false));
    }

    @Override
    public Map<String, ResturentMenu> getAllMenus() {
        return menuMap;
    }
}

