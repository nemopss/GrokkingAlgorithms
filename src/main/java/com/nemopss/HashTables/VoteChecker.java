package com.nemopss.HashTables;

import java.util.HashMap;
import java.util.Map;

public class VoteChecker {
    public static void main(String[] args) {
        check("Mike");
        check("John");
        check("John");

    }
    private static Map<String, Boolean> voted = new HashMap<>();
    private static void check(String name) {
        if (!voted.containsKey(name)) {
            voted.put(name, true);
            System.out.println("Thanks for your vote, " + name);
        } else {
            System.out.println("You already voted, " + name);
        }
    }
}
