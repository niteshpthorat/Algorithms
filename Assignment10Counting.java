package csula.cs3112.assignments;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Assignment10Counting {

    static void countSort(int[] arr , int max)
    {
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter Number of Elements: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Maximum number of the Element: ");
        int maxNumber = scanner.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++){
            array[i] = random.nextInt(maxNumber);
        }
        printArray(array);
        countSort(array,maxNumber);
        printArray(array);
    }
}