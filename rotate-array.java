/* 189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100] */


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;  // handle cases where k >= n

        reverse(nums, 0, n-1);  // reverse the whole array
        reverse(nums, 0, k-1);  // reverse first k elements
        reverse(nums, k, n-1);  // reverse the rest n-k elements
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)


/* 
// alternative approach (index-math based)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i=0; i<n; i++) {
            temp[(i+k) % n] = nums[i];
        }
        for (int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
 */


/* 
// brute force approach

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        for (int i=0; i<k; i++) {
            int last = nums[n-1];
            for (int j=n-1; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}

// Time Complexity: O(n*k)
// Space Complexity: O(1)
 */