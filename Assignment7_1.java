package csula.cs3112.assignments;

import java.util.Random;
import java.util.Scanner;

public class Assignment7_1 {
    int array[];

    Assignment7_1(int size)
    {
        array=new int[size];
    }
    public void calculationOfAverage(int number)
    {
        Random rand=new Random();
        int array[]=new int[10000];
        int bestRank = Integer.MAX_VALUE;
        for(int i=0;i<10000;i++)
        {
            int count=0;
            int temp[]=new int[number];
            for(int j=0;j<number;j++)
                temp[j]=rand.nextInt(number);
            for (int j = 0; j < number; ++j)
            {
                if (temp[j] < bestRank)
                {
                    bestRank = temp[j];
                    count++;
                }
            }
            array[i]=count;
        }
        float sum1=0;
        for(int i=0;i<10000;i++)
        {
            sum1=sum1+array[i];
        }
        sum1=sum1/10000;
        System.out.println("The average of output hires for 10000 random arrays : "+sum1);
    }
    public void findFactorial(int number)
    {
        long fact=1;
        long sum=0,Average;

        for(int i=0;i<number;i++)
        {
            for(int j=1;j<=array[i];j++)
            {
                fact=fact*j;
            }
            sum=sum+fact;
            fact=1;
        }
        Average=sum/number;
        System.out.println("The Average of Permutations of the Candidate is:"+Average);
    }
    public void calculateLog(int number)
    {
        double p=Math.log(number);
        System.out.println("Calculations of the log is:= "+p);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number:= ");

        int number=input.nextInt();
        Assignment7_1 ass=new Assignment7_1(number);
        ass.calculateSummation(number);
        ass.calculationOfAverage(number);
        ass.findFactorial1(number);
        ass.calculateLog(number);
    }
    public void findFactorial1(int number)
    {
        Random rand=new Random();
        int mul=1;
        for(int i=number;i>0;i--)
            mul=mul*i;
        int arr[]=new int[mul];
        for(int i=0;i<mul;i++)
        {
            int count=0;
            int a[]=new int[mul];
            for(int j=0;j<mul;j++)
                a[j]=rand.nextInt();
            for(int j=1;j<mul;j++)
                if(a[j]<a[j-1])
                    count++;
            arr[i]=count;
        }
        float sum1=0;
        for(int i=0;i<mul;i++)
            sum1=sum1+arr[i];
        sum1=sum1/mul;
        System.out.println("The average of permutations of factorial is : "+sum1);
    }

    static void calculateSummation(int number)
    {
        float sum=0;
        for(float i=1;i<=number;i++)
            sum=sum+(1/i);
        System.out.println("The summation of the value is: "+sum);
    }
}
