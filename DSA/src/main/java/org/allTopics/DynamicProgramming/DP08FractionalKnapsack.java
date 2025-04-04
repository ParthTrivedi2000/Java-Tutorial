package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

/*
Problem Description :-
Given two arrays, val[] and wt[], representing the values and weights of items, and an integer capacity representing
the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in
the knapsack. You are allowed to break items into fractions if necessary.
Return the maximum value as a double, rounded to 6 decimal places.

Examples :
Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120
and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0
Thus, total maximum value of item we can have is 240.00 from the given capacity of sack.
Input: val[] = [60, 100], wt[] = [10, 20], capacity = 50
Output: 160.000000
Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from
the given capacity of sack.
Input: val[] = [10, 20, 30], wt[] = [5, 10, 15], capacity = 100
Output: 60.000000
Explanation: In this case, the knapsack capacity exceeds the combined weight of all items (5 + 10 + 15 = 30).
Therefore, we can take all items completely, yielding a total maximum value of 10 + 20 + 30 = 60.000000.

Constraints:
1 <= val.size=wt.size <= 10^5
1 <= capacity <= 10^9
1 <= val[i], wt[i] <= 10^4

 */


import java.util.*;

public class DP08FractionalKnapsack {

    // This is knapsack problem. As it is fractional knapsack, I have to create an array to store the values.
    // values store inside this array will be per unit value. i.e. here per kg value. so suppose for 3 kg there
    // is given value 10, then per kg =3/10 = 0.value/kg. so let's store values per kg.

    class Item{
        int value;
        int weight;
        double perUnit;

        Item(int val, int wt){
            this.value = val;
            this.weight = wt;
            this.perUnit = (double)val/wt; // have to use double division instead of integer division.
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {

        // creating items array
        ArrayList<Item> items = new ArrayList<>();
        for(int i=0;i<val.size();i++){
            items.add(new Item(wt.get(i),val.get(i)));
        }

        // So I have to fill  the knapsack. means I have to pick the values from perunitvalues array in descending
        // order means in larger value first. So we have to sort it.

        // Arrays.sort(valuesPerWeight, new Comparator<Items>(){
        //     @Override
        //     public int compare(Items i1, Items i2){
        //         // return (i2.perUnit - i1.perUnit); // not working bec it returns double type value.
        //         if(i1.perUnit > i2.perUnit) return -1;
        //         else if(i1.perUnit < i2.perUnit) return 1;
        //         return 0;
        //     }
        // });


        // // Sorting the Items array on basis of PPU
        // Collections.sort(items, new Comparator<Item>(){
        //     @Override
        //     public int compare(Item i1, Item i2){
        //         if(i1.ppu>=i2.ppu) return -1;
        //         else if(i1.ppu<i2.ppu) return 1;
        //         else{
        //             return i2.val-i1.val;
        //         }
        //     }
        // });

        // Another way to sort the array using lambda expr.
        Collections.sort(items, (i1, i2) -> Double.compare(i2.perUnit,i1.perUnit));

        double profit = 0.0;
        for(Item item : items) {
            if(capacity >= item.weight) {
                // Take the whole item
                profit += item.value;
                capacity -= item.weight;
            } else {
                // Take a fraction of the item
                profit += capacity * item.perUnit;
                break;
            }
        }
        return profit;
    }

}
