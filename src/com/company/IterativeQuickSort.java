package com.company;

import java.util.Random;

public class IterativeQuickSort {

    public enum PivotPosition {
        RIGHT,
        RANDOM,
        MIDDLE,
    }

    private int partition(Integer[] arr, int l, int h) {
        int pivot = arr[h];

        int i = (l - 1);

        for (int j = l; j <= h - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return (i + 1);
    }

    public Integer[] sort(Integer[] arr, int length, PivotPosition strategy) {
        quickSortIterative(arr, 0, length, strategy);
        return arr;
    }

    private void quickSortIterative(Integer[] arr, int l, int h, PivotPosition strategy) {
        MyStack stack = new MyStack(h - l + 1);
        int top = -1;

        stack.push(l);
        ++top;
        stack.push(h);
        ++top;

        while (top >= 0) {
            h = stack.pop();
            top--;
            l = stack.pop();
            top--;

            if (strategy == PivotPosition.RANDOM) {
                Random rd = new Random();
                int r = l + rd.nextInt(h - l + 1);
                int temp = arr[r];
                arr[r] = arr[h];
                arr[h] = temp;
            } else if (strategy == PivotPosition.MIDDLE) {
                int r = (l + h + 1) / 2;
                int temp = arr[r];
                arr[r] = arr[h];
                arr[h] = temp;
            }

            int p = partition(arr, l, h);

            if (p - 1 > l) {
                stack.push(l);
                ++top;
                stack.push(p - 1);
                ++top;
            }

            if (p + 1 < h) {
                stack.push(p + 1);
                ++top;
                stack.push(h);
                ++top;
            }
        }
    }
}
