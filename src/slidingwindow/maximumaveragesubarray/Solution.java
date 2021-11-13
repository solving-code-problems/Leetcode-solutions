package slidingwindow.maximumaveragesubarray;
/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000


Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;

        double max = 0;
        int sum = 0;

        for(int i = left; i < right; i++) {
            sum += nums[i];
        }

        max = sum == 0 ? 0 : sum / (double)k;
        double average = 0;

        while(right < nums.length) {
            left++;
            right++;

            sum -= nums[left-1];
            sum += nums[right-1];

            average = sum == 0 ? 0.0 : sum/(double)k;

            max = Math.max(max,average);
        }
        return max;
    }
}
