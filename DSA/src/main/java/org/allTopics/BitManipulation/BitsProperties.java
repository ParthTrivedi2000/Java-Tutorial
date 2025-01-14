package org.allTopics.BitManipulation;

public class BitsProperties {
    /*
    Below are the useful properties to remember for bit manipulation problems.

    1) n & 1 /----- if result=1 ===> i.e.number n is odd
             \_____ if result=0 ===> i.e.number n is even

    most important property to remember
    2) n^0 = n
    3) n^n = 0

    properties related to shift operators.
    4) n << x ==? i.e.  n * 2^x
    5) n >> x ==> i.e.  n/2^x

    2nd most important property to remember
    6) n & 1<<k --> to know what's the value of kth bit of number n without explicitly converting it into binary form.
        if result of above operation = 0 then kth bit was 0 in the number n.
        else if result is not equal to 0 then kth bit was 1 in the number n.
        So basically it is used to check weather kth bit of number is set or not? if result of above operation is 0 then
        it's not set else it is set.
    7) n | 1<<k --> used to set the kth bit of number n. if it already 1 then nothing will change.
    8) n ^ 1<<k --> used to toggle the kth bit of number n.

    less important properties
    just doing &,|,^ operations with 0 and number itself
    9) n & 0 = 0
    10) n & n = n
    11) n & 1 ==> odd/even check. like if n&1==1 then odd else even

    12) n | 0 = n
    13) n | n = n

    14) n ^ 0 = n
    15) n ^ n = 0
     */
}
