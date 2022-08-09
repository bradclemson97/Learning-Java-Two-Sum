package com.bradclemson97;

/* Given an array of integers 'nums' and an integer 'target', return indicies (indexes) of the two numbers such that
they add up to the 'target'. You may assume that each input would have exactly one solution, and you may not
use the same element twice. You can return the answer in any order.
 */

/* Example:
    Input: nums = [2, 7, 11, 15], target = 9
    Output: [0, 1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 */

/*  Our example:
    Input: nums = [5, 2, 4], target = 6
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        /*SOLUTION 1
        //one solution is a nested for loop, but this isn't the fastest solution...nested for loops add quadratic time complexity
        for (int i = 0; i < nums.length; i++){
            //this is the inner loop...
            for (int j = i + 1; j < nums.length; j++){
                //add two numbers together to see if they equal our target and return the indicies of the two numbers...
                if (nums[i] + nums[j] == target){
                   return  new int[]{i, j};
                }
            }

         */

        //SOLUTION 2
        //We are going to use a hashmap - a collection of key-value pairs (K -> V) - this has the benefit of 'constant time lookup'
        //We are going to loop through our array one time and for each number we look at, we are going to store the number we would
        //have to add to the number in our array in order to get to our target (as the key) and the index of the current number in the array we are looking at (as the value)
        // e.g. the second number in our array is 2, what would we have to add to 2 to get to six? = 4, this (4) would be stored as the key in the hashmap
        // and index of 4 (1) will be stored as the value.
        // as we keep iterating through our array, we know if we encounter a number in our array (e.g. 4) which matches an existing key in our hashmap, that number can be added
        // to our number in the array to get our target.
        /*  Our example:
        Input: nums = [5, 2, 4], target = 6
        Hashmap:
        K -> V
        1 -> 0 (1 is what we would have to add to 5 to get to 6)
        4 -> 1 (4 is what we would have to add to 2 to get to 6)
        when we iterate to the 3rd value in our array (4) we ask does 4 already exist as a key in our array? YES
        we know we can add 4 to the value as the first index in the array (1, 2) to get our target
        */

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //to see if the value in the array we are looking at already exists in the hashmap...we can call a method on the map,
            //passing in the number in the array we are currently looking at (the number at the index i)
            //we are retrieving the value (index) from the hashmap where the key (number to-add needed) matches a number in the array
            //we subsequently return the value (index) from the hashmap (of the complementing number)
            //and the index of the current number in the array we want to add the complementing number to, to get the target

            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null){
                return new int[]{i, complementIndex};
            }
            // if we don't find a match, we have to calculate the complement (number to-add needed) as our key,
            // and its index in the array as our value and add it to our map
            complements.put(target - nums[i], i);

        }

        return nums;
    }

}




