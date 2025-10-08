/* 977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 
Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order. */

// Brute Force Solution
class SquaresOfArray {
    public int[] sortedSquares(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]>nums[j]){
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
        }
        return nums;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)



/* // method -2 (Two Pointer)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n-1;
        int idx = n-1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[idx--] = nums[left]*nums[left];
                left++;
            }
            else {
                res[idx--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) */