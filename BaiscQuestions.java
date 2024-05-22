// Q) Given number is prime or not.
import java.util.*;
  
public class BaiscQuestions{

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     // write ur code here
//     int testCase = scn.nextInt();
//     for(int i=1;i<=testCase;i++)
//     {
//         int n = scn.nextInt();
        
//         int count = 0;
//         for(int j=1;j<=n;j++)
//         {
//             if(n%j==0)
//             {
//                 count++;
//             }
//         }
//         if(count==2){
//             System.out.println("prime");
//         }
//         else{
//             System.out.println("not prime");
//         }
//     }

// }
// }

// Optimized Solution :- 
// Now just notice this thing. for any number n, it's factors can not be greater than the root of n.
// so we can use this thing to optimize the prime number question.

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     // write ur code here
//     int testCase = scn.nextInt();
//     for(int i=1;i<=testCase;i++)
//     {
//         int n = scn.nextInt();
        
//         int count = 0;
//         for(int j=2;j*j<=n;j++) // applying root of n condition
//         {
//             if(n%j==0)
//             {
//                 count++;
//                 break;  // appying one more optimization jst by breaking the loop when
//                 // number is divisible by other number.
//             }
//         }
//         if(count==0){
//             System.out.println("prime");
//         }
//         else{
//             System.out.println("not prime");
//         }
//     }

// }
// }



// Q) Print all the prime numbers between 2 given numbers range.
// Solution:-

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//      // write ur code here
//      int low = scn.nextInt();
//      int high = scn.nextInt();
     
//      for(int i=low; i<=high;i++){
//          int count = 0;
//          for(int div=2;div*div<=i;div++)
//          {
//              if(i%div==0){
//                   count++;
//                   break;
//              }   
//          }
//          if(count==0)
//          {
//              System.out.println(i);
//          }
//      }
//  }
// }


// Q) Print the all th fibonacci numbers till nth number from Fibonacci series.
// Solution:-

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int n = scn.nextInt();
//     int a = 0;
//     int b = 1;
//     for(int i=0;i<n;i++)
//     {
//         System.out.println(a);
//         int c = a+b;
//         a = b;
//         b = c;
//     }
// }
// }


// Q) Count the number of digits in a number.
// Solution:- 

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     long number = scn.nextLong();

//     int count = 0;
//     while(number!=0)
//     {
//         number = number/10;
//         count++;
//     }
//     System.out.println(count);
// }
// }


// Q) Print the digits of a number in left to right  sequence.
// Solution:-

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
  
//     int number = scn.nextInt();
    
//     int numberOfDigits = 0;
//     int temp = number;
//     while(temp!=0)
//     {
//         temp = temp/10;
//         numberOfDigits++;
//     }
    
//     int div = (int)Math.pow(10,numberOfDigits-1);
    
//     while(div!=0)
//     {
//         int quotient = number/div;
//         System.out.println(quotient);
//         number = number%div;
//         div = div/10;
        
//     }
// }
// }


// Q) Reverse a number. or print the digits from right to left.
// Solution:- 

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
    
//  //   8265 
//  // first find modulo of number.
//  // print it.
//  // update the number with number/10. till number!=0
 
//     int number = scn.nextInt();
    
//     while(number!=0)
//     {
//         System.out.println(number%10);
//         number = number/10;
//     }
// }   
// }



// Q) Inverse a number.

// 1. You are given a number following certain constraints.
// 2. The key constraint is if the number is 5 digits long, it'll contain all the digits from 1 
// to 5 without missing any and without repeating any. e.g. 23415 is a 5 digit long number containing 
// all digits from 1 to 5 without missing and repeating any digit from 1 to 5.Take a look at few 
// other valid numbers - 624135, 81456273 etc.Here are a few invalid numbers - 139, 7421357 etc.
// 3. The inverse of a number is defined as the number created by interchanging the face value 
// and index of digits of number.e.g. for 426135 (reading from right to left, 5 is in place 1, 3 
// is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 and 4 is in place 6), 
// the inverse will be 416253 (reading from right to left, 3 is in place 1, 5 is in place 2, 2 
// is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6) 
// More examples - inverse of 2134 is 1243 and inverse of 24153 is 24153.    
// 4. Take as input number "n", assume that the number will follow constraints.
// 5. Print it's inverse.
// Input Format
// "n" where n is any integer, following constraints defined above.
// Output Format
// "i", the inverted number.
// Constraints
// 1 <= n < 10^8, and follwing other constraints defined above.
// Sample Input
// 28346751
// Sample Output
// 73425681

// Solution:-

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int temp=n;
//     int count =0;
//     while(temp!=0){
//         count++;
//         temp=temp/10;
//     }
    
//     int sum=0;
//     for(int position=1;position<=count;position++)
//     {
//         int digit = n%10;
//         n = n/10;
//         sum = sum+(position*((int)Math.pow(10,digit-1)));
//     }
//     System.out.println(sum);
// }
// }


// In Python:-

// n = int(input('Enter the number : '))
// count=0
// new_num=0
// while(n!=0):
//     count=count+1
//     rem = n%10
//     new_num = new_num + int(count*(10**(rem-1)))
//     n=n//10
    
// print(new_num)



// Q) Rotate a Number.
// 1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is 
// positive, rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for 
// negative value of k. Also k can have an absolute value larger than number of digits in n.
// 2. Take as input n and k.
// 3. Print the rotated number.
// 4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such 
// an input will not be given
//    n = 12340056
//    k = 3
//    r = 05612340
// Input Format
// "n" where n is any integer.
// "K" where k is any integer.
// Output Format
// "r", the rotated number
// Constraints
// 1 <= n < 10^9
// -10^9 < k < 10^9
// Sample Input
// 562984
// 2
// Sample Output
// 845629

// Solution:-
// public static void main(String[] args) {
//     // System.out.println("Hello World");
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int k = scn.nextInt();
    
//     int temp=n;
//     int count=0;
//     while(temp!=0)
//     {
//         temp = temp/10;
//         count++;
//     }
    
//     int tempNumber=n;
//     int sum=0;
//     int lastDigit=0;
//     if(k%count==0)
//     {
//         System.out.println(n);
//     }
//     else if(k>0)
//     {
//         for(int i=1;i<=k%count;i++)
//         {
//             lastDigit = tempNumber%10;
//             sum = lastDigit*(int)Math.pow(10,count-1) + (int)(tempNumber/10);
//             tempNumber=sum;
//         }
//         System.out.println(sum);
//     }
//     else
//     {
//         int div = (int)Math.pow(10,count-1);
//         for(int i=k%count;i<0;i++)
//         {
//             int firstDigit = tempNumber/div;
//             sum = (tempNumber%div)*10 + firstDigit;
//             tempNumber=sum;
//         }
//         System.out.println(sum);
//     }
// }
// }

// Optimized Solution by Sumeet sir:-
// public static void main(String[] args) {
    
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt(0);
//     int k = scn.nextInt();

//     int temp = n;
//     int count = 0;
//     while(temp>0)
//     {
//         temp = temp/10;
//         count++;
//     }

//     // To handle -ve rotations and extra rotations
//     k = k%count; // handled for extra rotations
//     if(k<0)      // handled for -ve rotations
//     {
//         k = k+count;
//     }

//     int div = 1;
//     int mult = 1;
//     for(int i=0;i<=count;i++)
//     {
//         if(i<=k)
//         {
//             div = div*10;
//         }
//         else{
//             mult = mult*10;
//         }
//     }

//     int quotient = n/div;
//     int rem = n%div;

//     int rotatedNumber = rem*mult + quotient;
//     System.out.println(rotatedNumber);
// }
// }

// Q) GCD and LCM
// 1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
// 2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
// 3. Take input "num1" and "num2" as the two numbers.
// 4. Print their GCD and LCM.
// Input Format
// num1
// num2
// .. the numbers whose GCD and LCM we have to find.
// Output Format
// a
// b
// .. where 'a' and 'b' are the GCD and LCM respectively.
// Constraints
// 2 <= n <= 10^9
// Sample Input
// 36
// 24
// Sample Output
// 12
// 72

// Solution:-
// public static void main(String[] args) {
    
//     Scanner scn = new Scanner(System.in);
//     int num1 = scn.nextInt(0);
//     int num2 = scn.nextInt();

//     int originalNum1 = num1;
//     int originalNum2 = num2;

//     while(num1%num2 != 0)
//     {
//         int rem = num1%num2;
//         num1 = num2;
//         num2 = rem;
//     }

//     int gcd = num2;

//     int lcm = (originalNum1*originalNum2)/gcd;

//     System.out.println(gcd);
//     System.out.println(lcm);
// }
// }


public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
		int n = scn.nextInt(); //1440
		
		int div = 2;
		
		while(n!=0)
		{
		    System.out.println(div);
		    if(n/div == 0)
		    {
		        div=div;
		    }
		    else
		    {
		        div++;
		    }
		    
		    n=n/div;
		}
	}
}

// Q) Prime Factorization
// 1. You are required to display the prime factorization of a number.
// 2. Take as input a number n.
// 3. Print all its prime factors from smallest to largest.
                               
// Input Format
// n, an integer
// Output Format
// p1  p2  p3  p4.. all prime factors of n
// Constraints
// 2 <= n < 10 ^ 9
// Sample Input
// 1440
// Sample Output
// 2 2 2 2 2 3 3 5

// Solution:-

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     int num = scn.nextInt();

//     for(int i=2;i<num;i++)
//     {
//         while(num%i!=0){
//             System.out.print(i+" ");
//             num = num/i;
//         }
//     }
// }
// }


// Optimized Solution :- As we know for any 2 numbers p,q = n
// it is not possible to be p and q both > sqrt(n). So we will run our loop till root n only

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     int num = scn.nextInt();

//     for(int i=2;i*i<num;i++)
//     {
//         while(num%i==0){
//             System.out.print(i+" ");
//             num = num/i;
//         }
//     }

//     if(num!=1)
//     {
//         System.out.print(num);
//     }
// }
// }

