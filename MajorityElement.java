/* 169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2 */


class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        for (int i=0; i<nums.length-1; i++) {
            int count = 1;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length/2) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)


/* 
// method -2 (Optimized using Boyer–Moore Voting Algorithm)
class Solution {
    public int majorityElement(int[] nums) {
        int value = 0;
        int count = 0;

        for (int num:nums) {
            if (count == 0) {
                value = num;
            }
            if (value == num) {
                count++;
            }
            else {
                count--;
            }
        }
        return value;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1) */