package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomArrayGenerator {

    public enum DataShape {
        RANDOM, ASCENDING, DESCENDING, CONSTANT, V_SHAPE, A_SHAPE
    }

    private List<Integer> randomArray = new ArrayList<>();

    public RandomArrayGenerator() {
    }

    public ArrayList<Integer> generate(int arraySize, DataShape dataShape) {
        QuickSort quickSort = new QuickSort();

        switch (dataShape) {
            case RANDOM -> {
                int[] arr = this.random(arraySize);
                return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            case ASCENDING -> {
                int[] arr = this.random(arraySize);
                arr = quickSort.sort(arr, 0, arr.length - 1);
                return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            case DESCENDING -> {
                int[] arr = this.random(arraySize);
                arr = quickSort.sort(arr, 0, arr.length - 1);
                arr = this.reverse(arr, arr.length);
                return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            case CONSTANT -> {
                int[] arr = new int[arraySize];
                Random rd = new Random();
                int num = rd.nextInt(arraySize);
                Arrays.fill(arr, num);
                return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            case V_SHAPE -> {
                int[] arr = this.random(arraySize);
                List<Integer> descList = new ArrayList<>();
                for (int i = 0; i < arr.length / 2; i++) {
                    descList.add(arr[i]);
                }
                Collections.sort(descList);
                Collections.reverse(descList);
                List<Integer> ascList = new ArrayList<>();
                for (int i = arr.length / 2; i < arr.length; i++) {
                    ascList.add(arr[i]);
                }
                Collections.sort(ascList);
                return (ArrayList<Integer>) Stream.concat(descList.stream(), ascList.stream())
                        .collect(Collectors.toList());
            }
            case A_SHAPE -> {
                int[] arr = this.random(arraySize);
                List<Integer> ascList = new ArrayList<>();
                for (int i = 0; i < arr.length / 2; i++) {
                    ascList.add(arr[i]);
                }
                Collections.sort(ascList);
                List<Integer> descList = new ArrayList<>();
                for (int i = arr.length / 2; i < arr.length; i++) {
                    descList.add(arr[i]);
                }
                Collections.sort(descList);
                Collections.reverse(descList);
                return (ArrayList<Integer>) Stream.concat(ascList.stream(), descList.stream())
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    private int[] random(int arraySize) {
        int[] arr = new int[arraySize];
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(arraySize);
        }
        return arr;
    }

    private int[] reverse(int[] a, int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    public RandomArrayGenerator(List<Integer> randomArray) {
        this.randomArray = randomArray;
    }

    public List<Integer> getRandomArray() {
        return randomArray;
    }

    public void setRandomArray(List<Integer> randomArray) {
        this.randomArray = randomArray;
    }
}
