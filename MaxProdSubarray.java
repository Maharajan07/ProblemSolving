/* 152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray. */


public class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int result = nums[0];

        for (int i=1; i<nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            result = Math.max(result, maxProd);
        }
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)