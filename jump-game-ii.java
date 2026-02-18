/* 45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
    0 <= j <= nums[i] and
    i + j < n
    
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2 */


class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int reach = 0;
        int curEnd = 0;

        for (int i=0; i<nums.length-1; i++) {
            reach = Math.max(reach, i + nums[i]);

            if (i == curEnd) {
                jumps++;
                curEnd = reach;
            }
        }
        return jumps;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)


/* 
// DP Solution
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i=1; i<n; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j=0; j<i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
 */