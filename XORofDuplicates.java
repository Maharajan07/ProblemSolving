/* 3158. Find the XOR of Numbers Which Appear Twice

You are given an array nums, where each number in the array appears either once or twice.

Return the bitwise XOR of all the numbers that appear twice in the array, or 0 if no number appears twice.

Example 1:
Input: nums = [1,2,1,3]
Output: 1
Explanation: The only number that appears twice in nums is 1.

Example 2:
Input: nums = [1,2,3]
Output: 0
Explanation: No number appears twice in nums.

Example 3:
Input: nums = [1,2,2,1]
Output: 3
Explanation: Numbers 1 and 2 appeared twice. 1 XOR 2 == 3. */


class XORofDuplicates {
    public int duplicateNumbersXOR(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res ^= nums[i];
                }
            }
        }
        return res;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)



/* // method -2

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dup = new HashSet<>();

        for (int n:nums) {
            if (!seen.add(n))
                dup.add(n);
        }

        int res = 0;
        for (int d:dup)
            res ^= d;

        return res;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) */