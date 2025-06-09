package Dispatch;

import java.util.HashMap;
import java.util.Map;

public class RoutePlanning {
    private String routeId;
    private Map<String, String> routeMap;

    public RoutePlanning(String routeId) {
        this.routeId = routeId;
        this.routeMap = new HashMap<>();
    }

    public void planRoute() {
        routeMap.put("A", "B");
        routeMap.put("B", "C");
    }

    public String getRouteDetails() {
        return "Rute " + routeId + ": " + routeMap.toString();
    }
}