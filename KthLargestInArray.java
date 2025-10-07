/* 215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104 */

class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int greater = 0;
        int equal = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (nums[i] < nums[j]) {
                    greater++;
                }
                else if (nums[i] == nums[j]) {
                    equal++;
                }
            }
            if (greater < k && greater + equal >= k) {
                return nums[i];
            }
            greater = 0;
            equal = 0;
        }
        return -1;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)