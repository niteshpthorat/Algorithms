package csula.cs3112.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {
    static void sieveOfEratosthenes(int N, int s[])
    {
        // Create a boolean array
        // "prime[0..n]"  and initialize
        // all entries in it as false.
        boolean[] prime = new boolean[N + 1];

        // Initializing smallest
        // factor equal to 2
        // for all the even numbers
        for (int i = 2; i <= N; i += 2)
            s[i] = 2;

        // For odd numbers less
        // then equal to n
        for (int i = 3; i <= N; i += 2)
        {
            if (prime[i] == false)
            {
                // s(i) for a prime is
                // the number itself
                s[i] = i;

                // For all multiples of
                // current prime number
                for (int j = i; j * i <= N; j += 2)
                {
                    if (prime[i * j] == false)
                    {
                        prime[i * j] = true;

                        // i is the smallest prime
                        // factor for number "i*j".
                        s[i * j] = i;
                    }
                }
            }
        }
    }

    // Function to generate prime
// factors and its power
    static void generatePrimeFactors(int N)
    {
        // factorsPrime[i] is going to store
        // smallest prime factor of i.
        int[] factorsPrime = new int[N + 1];

        // Filling values in factorsPrime[] using sieve
        sieveOfEratosthenes(N, factorsPrime);

        int curr = factorsPrime[N]; // Current prime factor of N
        int cnt = 1; // Power of current prime factor

        // Printing prime factors
        // and their powers
        while (N > 1)
        {
            N /= factorsPrime[N];

            // N is now N/factorsPrime[N]. If new N
            // also has smallest prime
            // factor as curr, increment power
            if (curr == factorsPrime[N])
            {
                cnt++;
                continue;
            }

            System.out.print(curr + "^" + cnt+ " " );

            // Update current prime factor
            // as factorsPrime[N] and initializing
            // count as 1.
            curr = factorsPrime[N];
            cnt = 1;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for which prime factors should be displayed:");

        int number = scanner.nextInt();
        generatePrimeFactors(number);
    }
}


