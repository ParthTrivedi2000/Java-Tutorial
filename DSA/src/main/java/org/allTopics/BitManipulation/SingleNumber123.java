package org.allTopics.BitManipulation;

// Problem Link :-  https://leetcode.com/problems/single-number/

/*
Problem Description:-
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.
 */

import java.util.Arrays;

public class SingleNumber123 {

    /*
    Approach - 1:- BruteForce Approach:-  TC:-O(N^2), SC:-O(1)

    Approach - 2:- Using Hashmap :- TC:-O(N) SC:- O(N)
     */

    // Approach - 3:- Using bit representation
    public int singleNumber1(int[] nums) {
        int xor=0;
        for(int elem:nums) xor=xor^elem;
        return xor;
    }

    // Approach - 4:- Bit Representation (pls understand this approach bec it will be used in other versions of
    // similar problem.
    /*
    If you see bit by bit in the question, then you came to know that no of 1 in sum of 0th bit of all the element is
    3 and noOf zeros are = 4. out of both this things, no of ones are odd hence choosing 1 as the 0th bit to form an ans
    same to choose 1st bit of ans, sum the no of 1's and sum the no of 0's of 1st bit of all the elems of the array.
    and again choose odd numbered from both this. similarly choose for all the remaining bits of an ans.
     */


    /*
Problem Link :- https://leetcode.com/problems/single-number-ii/description/
Problem Description :-
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find
the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3
Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:
1 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */

    /*
    Approach - 1:- BruteForce Approach:-  TC:-O(N^2), SC:-O(1)

    Approach - 2:- Using Hashmap :- TC:-O(N) SC:- O(N)
     */

    // Approach - 3:-
    /*
    Intuition and Idea:-
    suppose consider the following array as an example:-
    [12, 8, 12, 8, 12, 8]
    for above array, represent elem in bits format.
    12 --> 1 1 0 0
     8 --> 1 0 0 0
    12 --> 1 1 0 0
     8 --> 1 0 0 0
    12 --> 1 1 0 0
     8 --> 1 0 0 0
     ---------------
no of 1's: 6 3 0 0
no of 0's: 0 3 6 6

    - Above very good observation is:- at each index sum of no of 1's and sum of no of 0's are multiple of 3 since
    each number repeated 3 times.
    - So we can use this property to get the answer. means we will find the sum of no of 0's and 1's of all the elems
    and then check. whichever sum is not in multiple of 3 that can be chosen to put my bit at that place.

     */

    // Approach - 3:- Using bit representation
    // TC:- O(N*32) Be it for any case best, better or worst case analysis, everytime it will run 32 times always.
    /*
    public int singleNumber2(int[] nums) {
        int ones=0;
        long res = 0;
        for(int i=31;i>=0;i--){
            ones=0;
            for(int elem:nums){
                // Checking the ith bit of element is 0 or 1. And if 1, do count++ for 1's.
                if((elem & (1<<i))!=0) ones++;
            }
            // below basically, what we wants to do is, if my ones count is not in multiple
            // of 3, then I want to put bit=1 on that bit's place else 0 on that bit's place
            // and then I want to generate the number by performing below operation.
            // if(ones%3!=0) res = res + Math.pow(2,i);
            // but with above line, it's giving incorrect result for array having -ve numbers.
            // and reason for that is because, for each -ve, we are having MSB=1 in 2's complement.
            // so instead, we have to use below line to calculate the number.
            // So here in this line what we are doing is, at starting res=0 ryt? i.e. all the 64 bits are 0
            // hence res has value =0. now suppose I find a place which needs to be added in answer, it simply
            // means I have to set bit to 1 for that place. And if you recall, to set any unset bit, we can use
            // the OR operator.
            if(ones%3!=0) res |= (1L << i);
        }
        return (int)res;
    }

     */

    // Approach - 4:- Using concept of cluster/grouping

    // Intuition & Idea :-
        /*
        So intuition is, suppose array given is [1,1,1,2,2,2,3,4,4,4]
        Now see, we will start checking from 1st index (not 0th). We will check if 1st index elem is equals to prev
        elem i.e. 0th idx. if yes, we will move my currentIndex to 3 places ahead. (try to follow by visualising
        solution to above array).
        - Now see, since array is sorted next time my currentIndex will represent element of middle 2 in above array.
        So again keep on checking like elem at currIdx is same as prev idx, if yes move it again to 3 places ahead.
        same keep on checking till end.
        - Suppose if elem at currIdx is not equals as prev idx, then we return prev idx elem then and there. see above
        for elem 2 we have checked, then if we move to 3 steps ahead, it will be on 7th idx i.e. on 1st occurrence of
        4 in above array. because 3 (or any single time occurred element comes in between else at 7th idx 2nd occurrence
        of 4 should be present ryt). So in short whenever currIdx elem != prev idx elems, in that case we must have
        any single occurred element present in-between. And that should be on currIdx-1th place. Hence it should
        be returned.
        - Now if we talk about edge cases, then suppose elem is present at 0th index then array would be
        [1,2,2,2,3,3,3,4,4,4] => in this case, obviously in 1st time checking only we got my answer based on above logic
        itself. So no issue with this case.
        - But suppose if single occurred element present at last then what? --> [1,1,1,3,3,3,4]
        in this case, if you dry run, you came to know like if you complete iterating whole array and didn't return
        anything, then last element will be my answer because since question already states that always there will be
        single occurrence of element is there.

        Note:- Obviously this approach will only work if elems is sorted. hence 1st of all we have to sort the whole
        array then only above approach possible.
         */
    // TC:- O(NlogN) + O(N/3), SC:- O(1)
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=3){
            if(nums[i]!=nums[i-1]) return nums[i-1];
        }
        return nums[nums.length-1];
    }

    // Note:-
    /*
     above approach 4 is better than approach 3. you might think but in 4th approach we are doing sorting
     of array, ryt so complexity will become O(NlogN), but let me tell you the logic.
     Let's compare the complexity with previous one. because above approach-3 always run in O(N*32 times).
     So when this O(NlogN) of approach-4 will behave as O(N*32)? --> only & only in case of array with size
     2^32 is given ryt, else it will be lesser since log of something will behave smaller only. and that log of size
     we are multiplying here with N always in case of best/better/worst case. but in approach-3 we multiplying
     always with 32 so it should be always much more complexity than this approach-4.
     */




    // Approach - 5:- Using Concept of Bucket
    // Note:- This approach you can never think in interview if you never seen it before.

    // Intuition && Approach :-
    /*
    So we will be having 3 variables. ones,twos & threes. so as from the name itself, ones will be having elems which
    occurs ones in the array, twos having elems which occurs 2 times in an array, threes having elems which occurs
    3 times in an array.

    - Now see,

     */




// Single Number III :-
    /*
    Problem Link:- https://leetcode.com/problems/single-number-iii/
    Problem Description :- Given an integer array nums, in which exactly two elements appear only once and all the
    other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in
    any order.
    You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

    Example 1:
    Input: nums = [1,2,1,3,2,5]
    Output: [3,5]
    Explanation:  [5, 3] is also a valid answer.
    Example 2:
    Input: nums = [-1,0]
    Output: [-1,0]
    Example 3:
    Input: nums = [0,1]
    Output: [1,0]

    Constraints:
    2 <= nums.length <= 3 * 10^4
    -2^31 <= nums[i] <= 2^31 - 1
    Each integer in nums will appear twice, only two integers will appear once.
     */

    // Approach:-
    /*
    So here in all these types of questions, in which more than 1 element is single time and remaining elems present
    are multiple times, And we have to find those numbers which are single times, then we have to use below approach only.

    So in the approach, we have to use the concept of RSB.
    Steps:-
    - 1st we need to perform the xor operations of all the elems of an array. (So whichever elems are present 2 times,
    got 0 and at last there is only remaining elems which are present single times, those are present in the xor variable.
    But now problem is how to get those 2 different distinct elems from the xor variable separately. So here we have to
    use the concept of RSB (Rightmost Set Bits).
    - So to find RSB of any elem, we have to perform just ANDing of 1's complement with that elem so we got the RSB.
    So here 2nd step is, we have to get 2 numbers from xor variable, then I must have to know RSB of xor variable.
    So 2nd stp is to perform xor = xor ANDing xor' (1's compliment of xor). And get RSB of xor.
    - So now once you will be having RSB, then to get different elem from that single xor element, we just need to do
    following thing. See, property says those 2 elems we can get from,
        - number1 & RSB == 0
        - number2 & RSB !=0
    - So just need to perform the above thing to get separate 2 variables and store it in ans[] array and we are done.

    Summary:-
    - Perform xor operation on array.
    - get RSB of xor.
    - perform the separation of elems from xor variable.
     */
    public int[] singleNumber3(int[] nums) {
        // Performing xor operation on arr
        int xor=0;
        for(int elem:nums) xor=xor^elem;

        // get RSB for xor variable.
        int xor1 = ~(xor) + 1; // doing 2's compliment of xor
        int RSB = xor & xor1; // getting RSB
        // pls understand this thing very well. here RSB is not any index. it
        // contains something whole value.

        // Seperation of numbers
        int num1=0;
        int num2=0;
        for(int elem:nums){
            if((elem&RSB)==0) num1=num1^elem;  // got 1st number seperately and stored it into num1
            else num2=num2^elem; // got 2nd number seperately and stored it into num2
        }
        int[] ans = {num1,num2};
        return ans;
    }

}


