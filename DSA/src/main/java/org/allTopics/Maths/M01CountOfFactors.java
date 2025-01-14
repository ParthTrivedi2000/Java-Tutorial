package org.allTopics.Maths;

public class M01CountOfFactors {
    public int countOfFactors(int A) {

        // BruteForce Approach:- T.C:- O(N), SC:- O(1)
        // int count = 0;
        // for(int i=1;i<=A;i++){
        //     if(A%i==0) count++;
        // }
        // return count;

        // Optimal Approach :- TC:-O(sqrt(N)), SC:- O(1)
        int count = 0;
        for(int i=1; i*i<=A; i++){
            if(A%i == 0){
                if(i==A/i){
                    count++;
                }
                else{
                    count = count+2;
                }
            }
        }
        return count;
    }
}
