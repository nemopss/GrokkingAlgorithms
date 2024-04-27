package com.nemopss.Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    private static long factorial(long i) {
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }
}
