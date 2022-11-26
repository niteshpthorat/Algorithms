package csula.cs3112.assignments;

import java.util.Scanner;

public class PrimeFactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the positive number for which prime factors should be displayed:");

        int number = scanner.nextInt();
        if (number > 0)
            primeFactors(number);
        else
            System.out.println("Enter positive integer");
    }

    public static void primeFactors(int number) {
        int power = 0;
        for (int i = 2; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                while (number % i == 0) {
                    power++;
                    number /= i;
                }
                System.out.print(i + "^" + power);
                if (number > 1)
                    System.out.print(" * ");
                power = 0;
            }
            if (i == 2)
                i--;
        }
        if (number > 1)
            System.out.print(number + "^1");
    }

}
