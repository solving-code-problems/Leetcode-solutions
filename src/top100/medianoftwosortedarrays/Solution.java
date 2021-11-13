package top100.medianoftwosortedarrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var sortedArray = fastMergeSorted(nums1, nums2);
        return median(sortedArray);
    }

    private double median(int[] sortedArray) {
        var midIndex = sortedArray.length / 2;
        return sortedArray.length % 2 == 0
                ? (sortedArray[midIndex] + sortedArray[midIndex - 1]) / 2.0
                : sortedArray[midIndex];
    }

    private int[] fastMergeSorted(int[] nums1, int[] nums2) {
        var mergedSortedArray = new int[nums1.length + nums2.length];
        var l1 = 0;
        var l2 = 0;
        var index = 0;

        while (true) {
            var l1Bound = inBounds(l1, nums1);
            var l2Bound = inBounds(l2, nums2);
            if (l1Bound && l2Bound) {
                var smallest = nums1[l1] < nums2[l2] ? nums1[l1++] : nums2[l2++];
                mergedSortedArray[index++] = smallest;
            } else if (l1Bound) {
                mergedSortedArray[index++] = nums1[l1++];
            } else if (l2Bound) {
                mergedSortedArray[index++] = nums2[l2++];
            } else {
                break;
            }
        }
        return mergedSortedArray;
    }

    private boolean inBounds(int index, int[] array) {
        return array.length > index;
    }


}