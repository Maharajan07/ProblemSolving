/* 3095. Shortest Subarray With OR at Least K I

You are given an array nums of non-negative integers and an integer k.

An array is called special if the bitwise OR of all of its elements is at least k.

Return the length of the shortest special non-empty subarray of nums, or return -1 if no special subarray exists.

Example 1:
Input: nums = [1,2,3], k = 2
Output: 1
Explanation:
The subarray [3] has OR value of 3. Hence, we return 1.
Note that [2] is also a special subarray.

Example 2:
Input: nums = [2,1,8], k = 10
Output: 3
Explanation:
The subarray [2,1,8] has OR value of 11. Hence, we return 3.

Example 3:
Input: nums = [1,2], k = 0
Output: 1
Explanation:
The subarray [1] has OR value of 1. Hence, we return 1. */


public class ShortestSubarrayOR {
    public int minimumSubarrayLength(int[] nums, int k) {
        for (int j=1; j<=nums.length; j++) {
            int wOr = 0;

            for (int i=0; i<j; i++) {
                wOr |= nums[i];

                if (wOr >= k) {
                    return j;
                }
            }

            for (int i=j; i<nums.length; i++) {
                int cOr = 0;
                for (int t=i-j+1; t<=i; t++) {
                    cOr |= nums[t];
                }

                if (cOr >= k) return j;
            }
        }
        return -1;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)