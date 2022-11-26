package csula.cs3112.assignments;

import java.util.Random;
import java.util.Scanner;

public class Assignment2 {

    public static void main (String[] args){
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print("Input Array: ");
        for (int element: array) {
            System.out.print(element + " ");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect the sort you want to do : \n 1. Insertion Sort \n 2. Selection Sort");

        int caseSelection = scanner.nextInt();
        switch(caseSelection) {
            case 1:
                System.out.print("\n Sorted with Insertion Sort: ");
                insertionSort(array);
                break;
            case 2:
                System.out.print("\n Sorted with Selection Sort: ");
                selectionSort(array);
                break;
            default:
                System.out.println(" Invalid Input ");
                break;
        }



    }
    public static void insertionSort(int array[]) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j-1;
            while (i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }

        for (int element: array) {
            System.out.print(element + " ");
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++)
        {
            int minimumIndex = i;
            for (int j = i+1; j < array.length; j++)
                if (array[j] < array[minimumIndex])
                    minimumIndex = j;

            int temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
        for (int element: array) {
            System.out.print(element + " ");
        }
    }
}
