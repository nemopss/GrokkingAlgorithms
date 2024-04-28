package com.nemopss.DijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstrasAlgorithm {

    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    private static String findLowestCostNode(Map<String, Double> costs) {
        double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            if ((cost < lowestCost) && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());

        // The costs table
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        // the parents table
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);
            Map<String, Double> neighbors = graph.get(node);

            for (String n : neighbors.keySet()) {
                double new_cost = cost + neighbors.get(n);
                if (costs.get(n) > new_cost) {
                    costs.put(n, new_cost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }
        System.out.println(costs);
    }
}
