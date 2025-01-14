package org.allTopics.Maths;

public class MathsProperties {
    /*
    Properties of Modulo (%) :-
    1) (a+b)%m = (a%m + b%m)%m
    2) (a*b)%m = (a%m * b%m)%m
    3) (a/b)%m = (a%m / b%m)%m
    4) (a-b)%m = (a%m - b%m + m)%m
    5) (a+m)%m = a%m
    6) (a%m) = a%m%m%m
    7) (a^b %m) = ((a%m)^b)%m


    Properties of GCD :-
    1) gcd(a,b) = gcd(b,a)
    2) gcd(0,elem) = elem; // GCD of any number with 0 has value of gcd=number itself.
    3) gcd(a,b,c) = gcd(a,gcd(b,c)) = gcd(gcd(a,b),c)
    4) Euclid Algorithm :-
    gcd(a,b) = gcd(a-b,b); {given A>=B>0}
    5) Extended Euclid Algorithm :-
    gcd(a,b) = gcd(a%b,b); {given A>=B>0}

    Standard GCD code:-
    Always remember where you put your greater number in the argument. based on that your return statement should be
    decided.

    gcd(smaller,greater) => gcd(greater%smaller, smaller)

    private int gcd(int A, int B){
        if(A==0) return B;
        return gcd(B%A,A);
    }




    Permutations:-
    nPr = n!/(n-r)!

    Combinations:-
    nCr = n!/(r!*(n-r)!)
    nCr = nPr/r!

    Properties of Combinations:-
    1) nC0 = 1
    2) nCn = 1
    3) nCr = nCn-r
    4) nCr = n-1Cr-1 + n-1Cr


     */
}
