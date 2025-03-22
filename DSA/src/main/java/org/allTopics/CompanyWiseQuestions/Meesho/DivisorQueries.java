package org.allTopics.CompanyWiseQuestions.Meesho;

// Problem Description:- Divisor queries
/*

Given an array a of N numbers. You have to perform Q queries of these types:

1. 1 l r: for each i with 1 <i<r,ai = ai/d, where d is the smallest prime factor of a
2. 2 l r: print the sum of all ai with l≤i≤r.
3. 3 i k: set ai = k
Function description
Complete the Divisor_Queries function. This function takes the following 4 parameters and returns the answer:
- N: An Integer representing the length of array a
- Q: An Integer representing the number of queries
- a. An Array of length N representing array a
- Queries. A 2D-Array of Q rows and 3 columns representing the three types of Queries

Input format for custom testing
Note: Use this input format if you are testing against custom input or writing code in a language where we don't
provide boilerplate code.
- The first line contains two space-separated integers N and Q.
- The next line contains N space-separated integers a¿.
- The next Q lines contain three space-separated integers denoting the type of the query and its parameters

Output format
Print K lines, where K is equal to the number of queries of type 2, with the corresponding answer.

Constraints
1≤ N ≤2*10^5
1 ≤ Q ≤ 10^5
1 ≤ ai,k ≤ 10^6

Sample input
5 3
10 2 8 7 6
2 1 4
1 1 4
2 1 4

Sample output
27
11

Explanation
First operation (2 1 4)
sum 10+2+8+7=27
Second operation (1 1 4)
new array: 51416
Third operation (2 1 4)
sum 5+1+4+1=11

Note:
Your code must be able to print the sample output from the provided sample input. However, your code is run against
multiple hidden test cases. Therefore, your code must pass these hidden test cases to solve the problem
statement.

Limits
Time Limit: 2.0 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB


 */

import java.util.ArrayList;
import java.util.List;

public class DivisorQueries {
    // This question is solved by Segment or Fenwick Trees. But I have tried solution from my side without using
    // Segment tree.

    // My Solution:-
    public static int[] pf = new int[10000001];
    public static int[] spf = new int[10000001];

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] ipArr = {10,2,8,7,6};
        int[][] queries = {{2,1,4},{1,1,4},{2,1,4}};

        List<Long> ans = Divisor_Queries(5,3,ipArr, queries);

        for(long elem:ans) System.out.println(elem);

    }

    public static List<Long> Divisor_Queries(int N, int Q, int[] a, int[][] queries){
        // long[] result = {0,9};
        List<Long> result = new ArrayList<>();

        // To create 1st time prefix
        pf[0] = a[0];
        for(int i=1;i<a.length;i++){
            pf[i] = pf[i-1]+a[i];
        }

        // To create 1st time SPF
        for(int i=1;i<spf.length;i++) spf[i]=i;
        for(int i=2;i*i<spf.length;i++){
            if(spf[i]==i){
                for(int j=i*i;j<spf.length;j=j+i){
                    if(spf[j]==j) spf[j]=i;
                }
            }
        }


        for(int i=0;i<Q;i++){
            int type = queries[i][0];
            int l = queries[i][1];
            int r = queries[i][2];
            l=l-1;

            if(type==2){
                r=r-1;
                long ans=-1;
                if(l==0) ans = pf[r];
                else ans=pf[r]-pf[l-1];
                result.add(ans);
            }
            else if(type==1){
                r=r-1;
                for(int j=l;j<=r;j++){
                    if(a[j]!=1){
                        int myspf = spf[a[j]];
                        int oldVal = a[j];
                        a[j] = a[j]/myspf;
                        pfCalculation(a,j,oldVal,a[j]);
                    }
                    System.out.println("jth arr val: "+ a[j] + " jth pf val: "+ pf[j]);
                }
            }
            else if(type==3){
                int oldVal = a[l];
                a[l] = r;
                pfCalculation(a,l,oldVal,a[l]);
            }
        }

        return result;
    }

    public static void pfCalculation(int[] a, int startIdx, int oldVal, int newVal){
        if(startIdx==0){
            pf[0] = a[0]-oldVal+newVal;
            for(int i=1;i<pf.length;i++){
                pf[i]=pf[i]-oldVal + newVal;
            }
        }
        else{
            for(int i=startIdx;i<pf.length;i++){
                pf[i]=pf[i]-oldVal + newVal;
            }
        }
    }

}
