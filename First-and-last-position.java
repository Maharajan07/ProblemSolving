/* 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1] */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};

        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)