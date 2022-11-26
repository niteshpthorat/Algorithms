package csula.cs3112.assignments;

import java.util.Map;
import java.util.Random;

public class Assignment5 {

    public static void main(String[] args) {
        int[] array = {10, 1, 15, -1, 3, -5};
//        Random random = new Random();
//        int[] array = new int[5];
//        for (int i = 0; i < array.length; i++) {
//            array[i] =  random.nextInt();
//        }
        System.out.print("Input Array: ");
        printArray(array);
        System.out.println();

        maxSubArraySum(array);
        System.out.println();

        int [] divAndConq =findMaximumSum(array, 0, array.length - 1);

        System.out.println("The maximum sum of the subarray using divide and conquer is " +divAndConq[0]);
        System.out.print("Maximum sub array  ");
        for(int i=divAndConq[1]; i<=divAndConq[2]; i++)
            System.out.print(array[i] + " ");
    }


    static void maxSubArraySum(int[] array) {
        int tempSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int initialStart = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (tempSum < currentSum) {
                tempSum = currentSum;
                start = initialStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                initialStart = i + 1;
            }
        }
        System.out.println("Maximum sum using brute force " + tempSum);
        System.out.print("Maximum sub array  ");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static int[] findMaximumSum(int[] array, int left, int right) {
        if (left == right) {
            int[] maxArray = new int[3];
            maxArray[0] = array[left];
            maxArray[1] = left;
            maxArray[2] = right;
            return maxArray;
        }

        int mid = (left + right) / 2;
        int[] maxLeft = findMaximumSum(array, left, mid);
        int[] maxRight = findMaximumSum(array, mid + 1, right);
        int[] maxCrossing = findMaximumCrossingSum(array, left, mid, right);

        if (maxLeft[0] >= maxRight[0] && maxLeft[0] >= maxCrossing[0])
            return maxLeft;
        if (maxRight[0] >= maxLeft[0] && maxRight[0] >= maxCrossing[0])
            return maxRight;
        return maxCrossing;

    }

    private static int[] findMaximumCrossingSum(int[] array, int left, int mid, int right) {
        int rightMax = Integer.MIN_VALUE;
        int sum = 0;
        int end = -1;
        int start = -1;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if (sum > rightMax) {
                rightMax = sum;
                end = i;
            }
        }

        int leftMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += array[i];

            if (sum > leftMax) {
                leftMax = sum;
                start = i;
            }
        }
        int[] arrayValues = new int[3];
        arrayValues[0] = leftMax + rightMax;
        arrayValues[1] = start;
        arrayValues[2] = end;

        return arrayValues;
    }
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
