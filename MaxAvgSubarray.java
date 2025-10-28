/* 643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000 */

public class MaxAvgSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double wSum = 0;
        double mSum;

        for (int i=0; i<k; i++) {
            wSum += nums[i];
        }
        mSum = wSum;

        for (int i=k; i<nums.length; i++) {
            wSum = wSum - nums[i-k] + nums[i];
            mSum = Math.max(mSum, wSum);
        }
        return mSum/k;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)