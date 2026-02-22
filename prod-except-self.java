/* 238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer. */


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1];  // ans[i] is the product of all the elements to the left of i
        }

        int right = 1;
        for (int i=n-1; i>=0; i--) {
            ans[i] *= right;
            right *= nums[i];   // right is the product of all the elements to the right of i
        }

        return ans;
    }
}

/* 
class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i=0; i<n; i++) {
            res[i] = 1;
        }

        int left = 1;               // left is the product of all the elements to the left of i
        for (int i=0; i<n; i++) {
            res[i] *= left;
            left *= nums[i];
        }
            
        int right = 1;              // right is the product of all the elements to the right of i
        for (int i=n-1; i>=0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
 */

// Time Complexity: O(n)
// Space Complexity: O(1)


/* // Brute-force solution O(n²) Time

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i=0; i<n; i++) {
            int prod = 1;
            for (int j=0; j<n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
} */