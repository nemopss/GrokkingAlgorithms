package com.nemopss.BreadthFirstSearch;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        bfs("you");
    }

    private static Map<String, List<String>> graph;

    private static boolean bfs(String name) {
        Deque<String> search_queue = new ArrayDeque<>(graph.get(name));
        List<String> searched = new ArrayList<>();

        while (!search_queue.isEmpty()) {
            String person = search_queue.poll();
            if (!searched.contains(person)) {
                if (is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    search_queue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean is_seller(String name) {
        return name.endsWith("ny");
    }
}

