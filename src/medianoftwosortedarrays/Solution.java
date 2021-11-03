package medianoftwosortedarrays;

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