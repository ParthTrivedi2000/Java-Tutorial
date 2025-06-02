package org.allTopics.Greedy;

// Problem Link :- https://leetcode.com/problems/lemonade-change/description/

// Problem Description :-
/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a
time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or
$20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every
customer with the correct change, or false otherwise.


Example 1:
Input: bills = [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
Example 2:
Input: bills = [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.

Constraints:

1 <= bills.length <= 105
bills[i] is either 5, 10, or 20.

 */

public class G02LemonadeChange {
    public static void main(String[] args) {}

    // Intuition & Approach:-
    /*
    Lemonade is nothing but a place (you can imagine like you book a separate small space of garden for an hour) for
    specific purpose like for your child to play, you want to work by sitting there etc etc...
    So owner is renting this place. Now here owner costing 5$ for specific hours (for example 1 hour). Now customer
    are one by one booking it. but all the customers have money in this coins only (5$, 10$ or 20$ coins). So whenever
    customer completes his hour in the lemonade area, he has to pay 5& ryt as per the renting cost. But customer can
    have either of this 3 coins only.
    So we have been given bill array which represents each customer i.e ith customer is paying by giving which coin. means
    suppose bill[i]=10 i.e. he has given 10 rupees coin. And owner has to take 5 ruppes from it & has to give change of
    5 rupees back. similarly bill[i]=20 means customer gave 20 rupees coin, and owner has to return back 15 rupees (since
    charge is 5 rupees only).
    So at starting owner has 0 rupees, and then he is taking coins from customers one by one & managing of giving change
    back to the customer.

    So we have to return true if we are able to return back changes to all the customers else return false.

    Logic:-
    - start iterating on bills arr.
    - if coin given by ith customer is i.e. bill[i] = 5, then simply increase the cnt5++.
    - if he has given 10 rupees coin, i.e. bill[i]=10 --> the check do we have 5 rupees coin available with us?
        -> if yes --> then we have to reduce cnt5 count since owner give this change back to customer.
        -> if no --> then we simply have to return false from there.
    - if he has given 20 rupees coin, i.e. bill[i]=20
        --> then check do we have 1 10rupees coin & 1 5rupees coin with us? --> if yes --> reduce both values by -1.
        --> else if check do we have 3 5rupees coins --> if yes reduce cnt5 by 3
        --> else return false from there.
     */

    // TC :- O(N), SC:- O(1)
    public boolean lemonadeChange(int[] bills) {
        int cnt5,cnt10,cnt20;
        cnt5=cnt10=cnt20=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                cnt5+=1;
            }
            else if(bills[i]==10){
                cnt10+=1;
                if(cnt5>0) cnt5--;
                else return false;
            }
            else if(bills[i]==20){
                cnt20+=1;
                if(cnt5>0 && cnt10>0){
                    cnt5--;
                    cnt10--;
                }
                else if(cnt5>=3) cnt5-=3;
                else return false;
            }
        }
        return true;
    }
}
