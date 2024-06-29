package com.local.coding_practice.Array;

public class RearrangePosNegArray {

    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrage(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void rearrage(int[] arr, int n) {

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                if (i != j) {
                    swap(arr, i, j);
                }
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                j = i;
                break;
            }
        }

        int k = 0;
        while (k < n && j < n) {
            swap(arr, k, j);
            j = j + 1;
            k = k + 2;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
