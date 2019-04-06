package Competitive_programming;

import java.util.*;

/**
 * Given bus routes, if there is an overlap between routes of 2 buses, replace them with 1 bus.
 * Example:
 * 3 routes
 * 1 5
 * 4 8
 * 11 15
 * Explanation: 2 buses => 1-8 and 11-15
 * first line has N number of routes. Routes start from 1. Next N lines have bus routes from A to B (Space separated)
 * Sample input:
 * 4
 * 2 8
 * 6 10
 * 12 14
 * 12 20
 * Output: 2
 */
public class ReduceBusRoutes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int routeCount = Integer.parseInt(scan.nextLine());
        Map<Integer, Integer> busRouteMap = new HashMap<>();
        while (routeCount > 0) {
            routeCount--;
            String path[] = scan.nextLine().split(" ");
            int from = Integer.parseInt(path[0]);
            int to = Integer.parseInt(path[1]);
            if (busRouteMap.get(from) == null) {
                busRouteMap.put(from, to);
            } else {
                if (busRouteMap.get(from) < to) {
                    busRouteMap.put(from, to);
                }
            }
        }
        int currentRouteCount = busRouteMap.size();
        int newRouteCount = -1;
        while (currentRouteCount != newRouteCount) {
            newRouteCount = currentRouteCount;
            reduceRoutes(busRouteMap);
            currentRouteCount = busRouteMap.size();
        }
        System.out.println(busRouteMap.size());
    }

    public static void reduceRoutes(Map<Integer, Integer> routeMap) {
        List<Integer> startRouteKey = new ArrayList<>(routeMap.keySet());
        Collections.sort(startRouteKey);
        for (int i = 0; i < startRouteKey.size(); i++) {
            for (int j = i + 1; j < startRouteKey.size(); j++) {
                int currentDestination = routeMap.get(startRouteKey.get(i));
                if (currentDestination >= startRouteKey.get(j)) {
                    routeMap.put(startRouteKey.get(i), routeMap.get(startRouteKey.get(j)));
                    routeMap.remove(startRouteKey.get(j));
                    startRouteKey.remove(j);
                }
            }
        }
    }
}