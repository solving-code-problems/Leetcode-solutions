package arrays.arrayformationthroughconcatination.movezeros;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int zerosSeen = 0;
        int writeIndex = 0;
        for(int i = 0; i< nums.length; i++) {
            var number = nums[i];
            if(number == 0)
                zerosSeen++;
            else
                nums[writeIndex++] = number;
        }

        writeIndex = nums.length - 1;
        while(zerosSeen--> 0) {
            nums[writeIndex--] = 0;
        }
    }
}