import java.util.Arrays;
import java.util.Random;
import java.util.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HiringProblem {

    public static double factSum = 0;

    public static void main(String[] args) {

        HiringProblem hiringProblem = new HiringProblem();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Candidates:");
        int size = sc.nextInt();
        int[] candidateRanks = new int[size];

        for (int i = 0; i < size; i++)
        {
            candidateRanks[i] = i+1; 
        }

        System.out.printf("Rank order of Candidates in an array: %s%n", Arrays.toString(candidateRanks));

        Double numberOfHiredat = hiringProblem.sumProbability(candidateRanks);
        System.out.println("Expected number of hires for these ranks: " + numberOfHiredat);
	
        Double numberOfHiredRandom = hiringProblem.randomized(candidateRanks);
        System.out.println("Randomized Average Estimate: " + numberOfHiredRandom);

        Double numberOfLn = hiringProblem.Ln(size);
        System.out.println("Output of LN " + size + ": "+ numberOfLn);

        Double numberOfPermutation = hiringProblem.Permutate(candidateRanks);
        System.out.println("Permutation Average Estimate: " + numberOfPermutation);

    }


    public Double sumProbability(int[] candidates) 
    {
        Double pSum = 0.0;
        for (int i = 0; i < candidates.length; ++i)
        {
            Double div = 1.0/candidates[i];
            pSum = pSum + div;
        }

        pSum = Math.round(pSum * 100.0) / 100.0;

        return pSum;
    }


    public int hireAssistant(int[] candidates) 
    {
        int best = Integer.MAX_VALUE;
        int numberOfHired = 0;

        for (int i = 0; i < candidates.length; ++i) 
        {
            if (candidates[i] < best) 
            {
                
                best = candidates[i];
                numberOfHired += 1;
            }
        }
        return numberOfHired;
    }


    public Double randomized(int[] candidates) 
    {
        int[] candidateList = Arrays.copyOf(candidates, candidates.length);
        double sum = 0;
        int permutSize = 10000;

        for (int i = 0; i < permutSize; i++)
        {
            randomizeInPlace(candidateList);
            int numberOfHiredRandom = hireAssistant(candidateList);
            sum = sum + numberOfHiredRandom;

        }

        double averageRandomHired = Math.round((sum / permutSize) * 100.0) / 100.0;
        
        return averageRandomHired;
    }



    private void randomizeInPlace(int[] array) 
    {
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; ++i) 
        {
            swap(array, i, random.nextInt(n - i) + i);
        }
    }


    private void swap(int[] array, int a, int b) 
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public Double Permutate(int[] array) 
    {    
        int[] permutateArrays = Arrays.copyOf(array, array.length);
        int fact = 1;

        for (int i = array.length; i > 0; i--)
        {
            fact = fact * i;
        }

        double permutatedSum = PermutateArray(permutateArrays, 0); 
        double mul = Math.round((permutatedSum/fact)*100.0) / 100.0;

        return mul;     
    
    }



    public Double PermutateArray(int[] array, int start)
    {
        if (start == array.length-1)
        {
            int numberOfHired = hireAssistant(array);
            factSum = factSum + numberOfHired;
        }

        for(int i = start; i < array.length; i++)
        {
            swap(array, i, start);
            PermutateArray(array, start+1);
            swap(array, i, start);
        }

        return factSum;
    }


    public Double Ln(int size)
    {
        double res = (Math.log(size)) ;
        res = Math.round(res* 100.0)/100.0;

        return res;
    }

}
