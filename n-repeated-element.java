/* 961. N-Repeated Element in Size 2N Array

You are given an integer array nums with the following properties:
    - nums.length == 2 * n.
    - nums contains n + 1 unique elements.
    - Exactly one element of nums is repeated n times.

Return the element that is repeated n times.

Example 1:
Input: nums = [1,2,3,3]
Output: 3

Example 2:
Input: nums = [2,1,2,5,3,2]
Output: 2

Example 3:
Input: nums = [5,1,5,2,5,3,5,4]
Output: 5 */


class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n:nums) {
            if (!set.add(n)) return n;
        }
        return -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)


/* 
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-2; i++) {
            if (nums[i] == nums[i+1] || nums[i] == nums[i+2]) {
                return nums[i];
            }
        }

        if (nums[n-1] == nums[n-2]) return nums[n-1];
        if (nums[0] == nums[n-1]) return nums[0];

        return -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
 */