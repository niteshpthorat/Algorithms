package csula.cs3112.assignments;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment7Hiring
{

    public static double factorialSum = 0;

    public static void main(String[] args) {

        Assignment7Hiring ass7 = new Assignment7Hiring();

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of candidates ");

        int number=input.nextInt();

        int[] candidateArray = new int[number];

        for (int i = 0; i < number; i++)
        {
            candidateArray[i] = i+1;
        }
        ass7.calculateSummation(number);
        ass7.randomized(candidateArray);
        ass7.CalculatePermutations(candidateArray);
        ass7.calculateLog(number);

    }


    public void calculateSummation(int number)
    {
        float sum=0;
        for(float i=1;i<=number;i++)
            sum=sum+(1/i);
        System.out.println("The summation of the value is: "+sum);

    }

    public void randomized(int[] candidatesArray)
    {
        int[] candidateList = Arrays.copyOf(candidatesArray, candidatesArray.length);
        double sum = 0;
        int totalCalculations = 10000;
        for (int i = 0; i < totalCalculations; i++)
        {
            generateRandomArray(candidateList);
            int bestRank = Integer.MAX_VALUE;
            int count = 0;

            for (int j = 0; j < candidateList.length; ++j)
            {
                if (candidateList[j] < bestRank)
                {

                    bestRank = candidateList[j];
                    count ++;
                }
            }
            sum = sum + count;

        }

        double averageRandomHired = Math.round((sum / totalCalculations) * 100.0) / 100.0;
        System.out.println("The average of output hires for 10000 random arrays : "+averageRandomHired);
    }

    private void generateRandomArray(int[] array)
    {
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; ++i)
        {
            swapArray(array, i, random.nextInt(n - i) + i);
        }
    }

    public int hireAssistant(int[] candidates)
    {
        int bestRank = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < candidates.length; ++i)
        {
            if (candidates[i] < bestRank)
            {
                bestRank = candidates[i];
                count ++;
            }
        }
        return count;
    }


    private void swapArray(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public void CalculatePermutations(int[] candidateArray)
    {
        int[] tempPermutations = Arrays.copyOf(candidateArray, candidateArray.length);
        int fact = 1;

        for (int i = candidateArray.length; i > 0; i--)
        {
            fact = fact * i;
        }

        double sumOfPermutations = CalculatePermutations(tempPermutations, 0);
        double multiply = Math.round((sumOfPermutations/fact)*100.0) / 100.0;

        System.out.println("The Average of Permutations of the Candidate is: " + multiply);

    }



    public Double CalculatePermutations(int[] candidateArrays, int start)
    {
        if (start == candidateArrays.length-1)
        {
            int sizeHired = hireAssistant(candidateArrays);
            factorialSum +=  sizeHired;
        }

        for(int i = start; i < candidateArrays.length; i++)
        {
            swapArray(candidateArrays, i, start);
            CalculatePermutations(candidateArrays, start+1);
            swapArray(candidateArrays, i, start);
        }

        return factorialSum;
    }


    public void calculateLog(int number)
    {
        double log=Math.log(number);
        System.out.println("Calculations of the log is:= "+log);
    }

}


