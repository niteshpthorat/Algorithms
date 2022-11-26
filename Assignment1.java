package csula.cs3112.assignments;

import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner inputPrime = new Scanner(System.in);
        System.out.print("Enter the positive number till which you need to find Prime Numbers: ");
        int numberOfPrime = inputPrime.nextInt();
        System.out.print("Output:");

        for (int i = 1; i <= numberOfPrime; i++) {
            if (checkPrime(i)) {
                System.out.print("," + i);
            }
        }
    }

    static boolean checkPrime(int number) {
        if (number == 1 || number == 0) {
            return false;
        }
        if (number == 2) {
            System.out.print("2");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;  //NotPrime
        }
        return true; //Prime
    }

}
