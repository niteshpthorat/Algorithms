package csula.cs3112.assignments;

import java.util.*;

class RadixSort {

    static void countSort(int array[], int number, int exp)
    {
        int output[] = new int[number];
        int i;
        int count[] = new int[10];

        for (i = 0; i < number; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = number - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[  (array[i] / exp) % 10]--;
        }

        for (i = 0; i < number; i++)
            array[i] = output[i];
    }

    static void radixSort(int arr[], int number)
    {
        int maxNumber = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; maxNumber / exp > 0; exp *= 10)
            countSort(arr, number, exp);
    }

    static void printArray(int array[], int number)
    {
        for (int i = 0; i < number; i++)
            System.out.print(array[i] + " ");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Elements: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter minimum number in the elements: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter maximum number in the elements: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        int[] array = new int[number];
        for (int i = 0; i < number; i++){
            array[i] = (int)(Math.random() * (max - min + 1) + min);;
        }

        System.out.println("Random Array:");
        printArray(array,array.length);
        System.out.println();
        radixSort(array, number);
        printArray(array, number);
    }
}