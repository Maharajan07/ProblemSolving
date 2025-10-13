/* 260. Single Number III

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0] */


import java.util.*;
class SingleNUmberIII {
    public int[] singleNumber(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=0; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) res.add(nums[i]);
        }

        int[] ans = new int[res.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}

// Time complexity: O(n²)
// Space Complexity: O(1)