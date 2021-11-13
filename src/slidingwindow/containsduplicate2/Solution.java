package slidingwindow.containsduplicate2;

import java.util.HashMap;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var numberIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (numberIndex.containsKey(num)) {
                var indexOfFirstNum = numberIndex.get(num);
                if (Math.abs(i - indexOfFirstNum) <= k) {
                    return true;
                }
            }
            numberIndex.put(num, i);
        }
        return false;
    }
}
