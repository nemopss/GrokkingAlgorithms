package com.nemopss.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordA = scanner.nextLine();
        String wordB = scanner.nextLine();

        int[][] cells = new int[wordA.length()][wordB.length()];

        for (int i = 0; i < wordA.length(); i++) {
            for (int j = 0; j < wordB.length(); j++) {
                if (wordA.charAt(i) == wordB.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cells[i][j] = cells[i - 1][j - 1] + 1;
                    } else {
                        cells[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j == 0) {
                        cells[i][j] = cells[i - 1][j];
                    } else if (i == 0 && j > 0) {
                        cells[i][j] = cells[i][j - 1];
                    } else if (i > 0 && j > 0) {
                        cells[i][j] = Math.max(cells[i][j - 1], cells[i - 1][j]);
                    } else {
                        cells[i][j] = 0;
                    }
                }
            }
        }
        displayResults(cells);
    }

    private static void displayResults(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
