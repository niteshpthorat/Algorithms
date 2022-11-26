package csula.cs3112.assignments;

import java.util.Random;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String args[])
    {
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print("Input Array: ");
        printArray(array);

        // First Question
        Assignment3 sortSearch = new Assignment3();
        sortSearch.sort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        printArray(array);

        Scanner binarySearch = new Scanner(System.in);

        // Second Question
        System.out.print("Enter the Value to be searched ");
        int search = binarySearch.nextInt();
        int returnIndex = sortSearch.binarySearch(array, search, 0, array.length -1);
        if (returnIndex == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + returnIndex);

        // Third Question
        Scanner computePower = new Scanner(System.in);
        System.out.println("Enter the values for a^n to be computed :  ");
        int a = computePower.nextInt();
        int n = computePower.nextInt();

        System.out.println("The value of : " + a +"^"+n + " is " + power( a,n ));



    }

    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void sort(int arr[], int left, int right)
    {
        if (left < right) {
            int middle =left+ (right-left)/2;

            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    void merge(int arr[], int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[middle + 1 + j];


        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    int binarySearch(int arr[],int value, int left, int right)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == value)
                return mid;

            if (arr[mid] > value)
                return binarySearch(arr, value, left, mid - 1);

            return binarySearch(arr, value, mid + 1, right);
        }

        return -1;
    }

    static int power(int a, int n)
    {
        if (n == 0)
            return 1;
        if (a == 0)
            return 1;
        else if (n % 2 == 0)
            return power(a, n / 2) * power(a, n / 2);
        else
            return a * power(a, n / 2) * power(a, n / 2);
    }
}
