package arrays.intersectionoftwoarraystwo;

import java.util.HashMap;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        var numberFrequency = new HashMap<Integer, Integer>();
        for(int num : nums2) {
            numberFrequency.compute(num, (k,v) -> v==null ? 1 : v+1);
        }


        var buffer = new int[Math.max(nums1.length, nums2.length)];
        var writePointer = 0;


        for(int num : nums1) {
            if(numberFrequency.containsKey(num)) {
                var times = numberFrequency.get(num);
                if(times == 0)
                    continue;
                numberFrequency.compute(num, (k,v) -> v-1);
                buffer[writePointer++] = num;
            }
        }
        var result = new int[writePointer];
        System.arraycopy(buffer, 0, result, 0, writePointer);
        return result;
    }
}