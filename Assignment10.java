package csula.cs3112.assignments;

import java.util.*;
public class Assignment10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println("Enter Number of Elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = rd.nextInt(100);
        }

        System.out.println("Random Array:");
        PrintArray(arr);

        RadixSortArray(arr, n);

    }

    private static void RadixSortArray(int[] arr, int n) {

        int largest = getLargest(arr, n);

        int[] result = new int[n];
        int[] temp = new int[n];

        int k = 0;
        while (largest != 0){
            int exp = (int) Math.pow(10, k);

            int[][] bin = new int[10][100];


            // Adding elements into a bin array
            for (int i = 0; i < arr.length; i++){
                int j = 0;
                int arrayIndex = (arr[i] / exp) % 10;
                int elementIndex = 0;

                if (bin[arrayIndex][j] != 0) {
                    while (bin[arrayIndex][j] != 0) {
                        j++;
                    }
                    elementIndex = j;
                }
                else
                    bin[arrayIndex][elementIndex] += arr[i];
            }

            //
            for (int i = 0; i < n; i++){
                for (int j = 0; j < 99; j++){
                    result[i] = bin[i][j];
                }
                for (int j = 0; j < 99; j++){
                    bin[i][j] = bin[i][j + 1];
                }
            }

            k++;
            largest /= 10;
        }

        System.out.println("Sorted Array:");
        PrintArray(result);
    }

    private static int getLargest(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 0; i < n; i++){
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    static void PrintArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}