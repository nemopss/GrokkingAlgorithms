package com.nemopss.Quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Qsort {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 3, 27, 66, 0, 6, 7, 9, 17);
        System.out.println(qsort(arr));
    }

    private static List<Integer> qsort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        Integer pivot = list.get(0);
        List<Integer> left = list.stream().skip(1).filter(el -> el <= pivot).toList();
        List<Integer> right = list.stream().skip(1).filter(el -> el > pivot).toList();

        return Stream.of(
                qsort(left).stream(),
                Stream.of(pivot),
                qsort(right).stream())
        .flatMap(Function.identity()).toList();

    }
}
