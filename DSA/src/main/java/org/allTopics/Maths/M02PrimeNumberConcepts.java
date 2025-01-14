package org.allTopics.Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class M02PrimeNumberConcepts {

    // Q-1) Check weather number is prime or not
    public boolean isPrime(int A) {

        // Bruteforce Approach:- TC:-O(N), SC:-O(1)
        // for(int i=1;i<=A;i++){
        //     if(A%i==0) cnt++;
        // }
        // if(cnt==2) return true;
        // return false;


        // Optimal Approach:- TC:-O(sqrt(N)), SC:-O(1)


        // Handling edge case
        if(A==0||A==1) return false;
        for(int i=2;i*i<=A;i++){
            if(A%i==0) return false;
        }
        return true;

//        // OR
//        int factors = countOfFactors(A);
//        if(factors!=2) return false;
//        return true;
    }

    // Q-2) Return all the prime numbers from 1 to N.
    public ArrayList<Integer> allPrimeNumbers(int N){
        // Approach - 1:- TC:- O(n*sqrt(n)), SC:- O(1)
        /*
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=2;i<=N;i++){
            if(isPrime(i)) ans.add(i);
        }
        return ans;

         */

        // Approach - 2:- Seive Of Eratosthenes:- TC:- O(n*log(log(n)), SC:- O(n)
        /*
        In this method simply we are trying to trade off the TC and SC i.e. we use SC to reduce the TC. let's see how.
        Steps:-
        - Create the boolean arr of size N+1 (in which each index represent ki that number is prime or not)
        - To fill the array:-
            - traverse from 2 to i*i<n.
                - if(seive[i]==true) --> Mark all the multiples of i as false in the array. And it's done.
         */

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] sieve = sieveOfEratosthenes(N);
        for(int i=2;i<N;i++){
            if(sieve[i]==true) ans.add(i);
        }
        return ans;

    }

    // TC:- O(log(logN)), SC:- O(N)
    public boolean[] sieveOfEratosthenes(int N){
        // Approach - 1:-
        /*
        boolean[] sieve = new boolean[N+1];
        // fill array with true at starting.
        Arrays.fill(sieve,true);
        // Start traversing till i*i<n
        for(int i=0;i*i<=N;i++){
            if(sieve[i]==true){
                // Mark all the multiples of i as false
                for(int j=2*i;j<=N;j=j+i) sieve[j]=false;
            }
        }
        return sieve;

         */

        // Approach - 2:- With small optimisation:-
        /*
         while we start marking multiples of i as false, then if it's
         previously marked as false by someone else, then I don't need to do it this time ryt, so if dry run
         on pen and paper, you came to know, ki for any i we can start from j=i*i instead of j=2*i bec previous
         wale sare primes previous iteration m true/false ho chuke hoge. So for any i we can directly start from
         i not from starting i.e. from 2.

         */
        boolean[] sieve = new boolean[N+1];
        // fill array with true at starting.
        Arrays.fill(sieve,true);
        // Start traversing till i*i<n
        for(int i=0;i*i<=N;i++){
            if(sieve[i]==true){
                // Mark all the multiples of i as false
                for(int j=i*i;j<=N;j=j+i) sieve[j]=false;
            }
        }
        return sieve;

    }


}
