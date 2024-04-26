package com.nemopss.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(arr)); // [2, 3, 5, 6, 10]
    }


    public static int findSmallest(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (smallest > arr.get(i)) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }
        return  smallestIndex;
    }

    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> sortedArray = new ArrayList<>(arr.size());
        int smallestIndex;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            smallestIndex = findSmallest(arr);
            sortedArray.add(arr.get(smallestIndex));
            arr.remove(smallestIndex);
        }
        return sortedArray;
    }

}