package csula.cs3112.assignments;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int startNumber = 3;
        int totalNumberOfOp;
        int check = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of prime numbers to be displayed:");

        totalNumberOfOp = scanner.nextInt();
        if (totalNumberOfOp <= 0)
            System.out.println("Enter Positive number");
        else {
            if (totalNumberOfOp >= 1) {
                System.out.print("Output : 2");
            }

            for (int i = 2; i <= totalNumberOfOp; ) {
                for (int j = 2; j <= Math.sqrt(startNumber); j++) {
                    if (startNumber % j == 0) {
                        check = 0;
                        break;
                    }
                }
                if (check != 0) {
                    System.out.print(" ," + startNumber);
                    i++;
                }
                check = 1;
                startNumber++;
            }
        }
    }
}