package csula.cs3112.assignments;

import java.util.Random;
import java.util.Scanner;

public class Assignment7
{
    int array[];
    Assignment7(int size)
    {
        array=new int[size];
    }
    public void GenerateRanks(int size)
    {
        int rank;
        long sum=0,Average;
        Random rand = new Random();
        System.out.println("--------------------");
        System.out.println("Student\tRank");
        System.out.println("--------------------");
        for(int i=0;i<size;i++)
        {
            rank = rand.nextInt(10);
            array[i]=rank;
            System.out.println(i+"\t"+rank);
            sum=array[i]+sum;
        }
        Average=sum/size;
        System.out.println("The Average of Ranks of the Candidate is:"+Average);
    }
    public void FindPermutation(int size)
    {
        long fact=1;
        long sum=0,Average;
        System.out.println("--------------------");
        System.out.println("Student\tPermutation");
        System.out.println("--------------------");
        for(int i=0;i<size;i++)
        {
            for(int j=1;j<=array[i];j++)
            {
                fact=fact*j;
            }
            System.out.println(i+"\t"+fact);
            sum=sum+fact;
            fact=1;
        }
        Average=sum/size;
        System.out.println("The Average of Permutations of the Candidate is:"+Average);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter the No.of Candiadtes:");
        int size=sc.nextInt();
        Assignment7 obj=new Assignment7(size);
        obj.GenerateRanks(size);
        obj.FindPermutation(size);
        sc.close();
    }
}


