package twosum;

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        var pairMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var pairValue = target - nums[i];
            var pairIndex = pairMap.get(pairValue);
            if (pairIndex != null) {
                return new int[]{i, pairIndex};
            }

            pairMap.put(nums[i], i);
        }
        throw new RuntimeException();
    }
}