package other.squaresofsortedarray;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int firstPositive = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                firstPositive = i;
                break;
            }
        }
        if(firstPositive == -1) {
            squareRange(nums, 0, nums.length);
            reverseRange(nums,0, nums.length-1);
            return nums;
        }
        var sorted = new int[nums.length];
        var leftIndex = 0;
        var rightIndex = firstPositive;

        squareRange(nums, 0, nums.length);
        reverseRange(nums, 0, firstPositive - 1);

        int pointer = 0;

        while(true) {
            if(leftIndex == firstPositive) {
                while(rightIndex != nums.length) {
                    sorted[pointer++] = nums[rightIndex++];
                }
                break;
            }
            if(rightIndex == nums.length) {

                while(leftIndex != firstPositive) {
                    sorted[pointer++] = nums[leftIndex++];
                }
                break;
            }
            if(nums[leftIndex] < nums[rightIndex]) {
                sorted[pointer++] = nums[leftIndex++];
            } else {
                sorted[pointer++] = nums[rightIndex++];
            }
        }
        return sorted;
    }

    private void reverseRange(int[] nums, int start, int end) {
        while(end >= start) {
            var temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    private void squareRange(int[] nums, int start, int end) {
        for(int i = start; i < end; i++) {
            nums[i] = nums[i] * nums[i];
        }
    }
}