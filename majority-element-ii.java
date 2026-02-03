/* 229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2] */


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        /* n/3 times means there can be at most 2 majority elements */

        int val1 = 0, count1 = 0;
        int val2 = 0, count2 = 0;

        for (int num:nums) {
            // assign candidates
            if (val1 == num) count1++;
            else if (val2 == num) count2++;

            else if (count1 == 0) {
                val1 = num;
                count1++;
            }
            else if (count2 == 0) {
                val2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // verify candidates
        count1 = 0;
        count2 = 0;
        for (int num:nums) {
            if (val1 == num) count1++;
            else if (val2 == num) count2++;
        }

        // add to result if count > n/3
        if (count1 > nums.length/3) res.add(val1);
        if (count2 > nums.length/3) res.add(val2);

        return res;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)