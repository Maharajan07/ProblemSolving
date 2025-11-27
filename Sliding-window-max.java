/* 239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is
moving from the very left of the array to the very right. You can only see the k numbers
in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1] */


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i=0; i<k; i++) {
            if (nums[i] > max) max = nums[i];
        }
        list.add(max);

        for (int i=k; i<nums.length; i++) {
            if (nums[i-k] == max) {
                max = Integer.MIN_VALUE;
                for (int j=i-k+1; j<=i; j++) {
                    if (nums[j] > max) max = nums[j];
                }
            }
            if (nums[i] > max) max = nums[i];
            list.add(max);
        }
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

// Time Complexity: O(n*k)
// Space Complexity: O(n)