package csula.cs3112.assignments;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment8
{

    public static double factorialSum = 0;

    public static void main(String[] args) {

        Assignment8 ass8 = new Assignment8();

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of candidates ");

        int number=input.nextInt();

        int[] candidateArray = new int[number];

        for (int i = 0; i < number; i++)
        {
            candidateArray[i] = i+1;
        }
        ass8.calculateSummation(number);
        ass8.randomized(candidateArray);
        ass8.calculatePermutations(candidateArray);

        System.out.println("Enter the number of candidates (30,50,100)");

        int simulationInput=input.nextInt();
        int[] simulationArray = new int[simulationInput];

        for (int i = 0; i < simulationInput; i++)
        {
            simulationArray[i] = i+1;
        }

        ass8.calculateSimulationProbability(simulationArray);

    }

    private void calculateSimulationProbability(int[] simulationArray) {
        {
            int[] candidateList = Arrays.copyOf(simulationArray, simulationArray.length);
            int rank3Count = 0;
            for (float i = 0; i < simulationArray.length; i++)
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
                if (count == 3){
                    rank3Count++;
                }

            }
            float probability3Hires =(float) rank3Count / simulationArray.length;
            System.out.println("The number of arrays where we hire exactly three : "+probability3Hires);
        }
    }


    public void calculateSummation(int number)
    {
        float sum=0;
        for(float i=2;i<=number;i++) {
            sum = sum + 1/(i -1);
        }
        System.out.println("The summation of the value is: "+sum/number);

    }

    public void randomized(int[] candidatesArray)
    {
        int[] candidateList = Arrays.copyOf(candidatesArray, candidatesArray.length);
        int totalCalculations = 10000;
        int rank2Count = 0;
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
            if (count == 2){
                rank2Count++;
                if(candidateList.length ==7 ) {
                    for (int k =0 ; k < candidateList.length ; k++)
                    System.out.print(candidateList[k] + " ");
                    System.out.println();
                }

            }

        }
        float probability2Hires =(float) rank2Count / totalCalculations;
        System.out.println("The number of arrays where we hire exactly twice 10000 random arrays : "+probability2Hires);
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
        int rank2Count = 0;

        for (int i = 0; i < candidates.length; ++i)
        {
            if (candidates[i] < bestRank)
            {
                bestRank = candidates[i];
                count ++;
            }
        }

        if (count == 2){
            rank2Count++;
        }
        return rank2Count;
    }


    private void swapArray(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public void calculatePermutations(int[] candidateArray)
    {
        int[] tempPermutations = Arrays.copyOf(candidateArray, candidateArray.length);
        int fact = 1;

        for (int i = candidateArray.length; i > 0; i--)
        {
            fact = fact * i;
        }

        double sumOfPermutations = CalculatePermutations(tempPermutations, 0);
        double multiply = (sumOfPermutations/fact);

        System.out.println("The Average of Permutations Probability of the Candidate is: " + multiply);

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

}


