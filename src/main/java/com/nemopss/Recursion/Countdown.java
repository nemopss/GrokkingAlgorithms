package com.nemopss.Recursion;

public class Countdown {

    public static void main(String[] args) {
        countdown(3);
    }
    public static void countdown(int i) {
        System.out.println(i + "!");

        if (i <= 1) {
            return;
        } else {
            countdown(i - 1);
        }
    }

}
