/* 209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal
length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0 */


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, size = Integer.MAX_VALUE;

        for (int r=0; r<nums.length; r++) {
            sum += nums[r];

            while (sum >=target) {
                size = Math.min(size, r-l+1);
                sum -= nums[l];
                l++;
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)