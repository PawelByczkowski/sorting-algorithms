package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        SelectionSort selectionSort = new SelectionSort();
        HeapSort heapSort = new HeapSort();
        IterativeQuickSort iterativeQuickSort = new IterativeQuickSort();
        RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj dlugosc tablicy do sortowania ");
        int arraylength = scanner.nextInt();
        System.out.println("dlugosc tablicy " + arraylength);

        System.out.println("wybierz z typow danych sortowania: RANDOM, ASCENDING, DESCENDING, CONSTANT, V_SHAPE ");
        Scanner scn = new Scanner(System.in);
        String ordertype = scn.nextLine();
        System.out.println("wybrany typ danych do sortowania " + ordertype);

        ArrayList<Integer> list = randomArrayGenerator.generate(arraylength, RandomArrayGenerator.DataShape.valueOf(ordertype));
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
//insertionsort time
        double start = System.currentTimeMillis();
        Integer[] insertionSorted = insertionSort.sort(arr, list.toArray().length);
        double finish = System.currentTimeMillis();
        double timeElapsed = (finish - start);
//        System.out.println(Arrays.toString(insertionSorted));
        System.out.println("insertion sort time(ms)= " + timeElapsed);
//mergesort time
        arr = new Integer[list.size()];
        list.toArray(arr);
        start = System.currentTimeMillis();
        Integer[] mergeSorted = mergeSort.sort(arr, list.toArray().length);
        finish = System.currentTimeMillis();
        timeElapsed = (finish - start);
//        System.out.println(Arrays.toString(mergeSorted));
        System.out.println("merge sort time(ms)= " + timeElapsed);
//selectionsort time
        arr = new Integer[list.size()];
        list.toArray(arr);
        start = System.currentTimeMillis();
        Integer[] selectionSorted = selectionSort.sort(arr);
        finish = System.currentTimeMillis();
        timeElapsed = (finish - start);
//        System.out.println(Arrays.toString(mergeSorted));
        System.out.println("selection sort time(ms)= " + timeElapsed);
//heapsort time
        arr = new Integer[list.size()];
        list.toArray(arr);
        start = System.currentTimeMillis();
        Integer[] heapSorted = heapSort.sort(arr);
        finish = System.currentTimeMillis();
        timeElapsed = (finish - start);
//      System.out.println(Arrays.toString(heapSorted));
        System.out.println("heap sort time(ms)= " + timeElapsed);


//      quicksort zadanie drugie
        Scanner scannerquicksort = new Scanner(System.in);
        System.out.println("podaj wielkość tablicy A_SHAPE do drugiego zadania: ");
        arraylength = scannerquicksort.nextInt();
        list = randomArrayGenerator.generate(arraylength, RandomArrayGenerator.DataShape.A_SHAPE);
        arr = new Integer[list.size()];
        list.toArray(arr);
        for (IterativeQuickSort.PivotPosition position : IterativeQuickSort.PivotPosition.values()) {
            start = System.currentTimeMillis();
            Integer[] quickSorted = iterativeQuickSort.sort(arr, arr.length - 1, position);
            finish = System.currentTimeMillis();
            timeElapsed = (finish - start);
            System.out.println(position.toString() + " - " + timeElapsed + "ms");
        }
    }
}
