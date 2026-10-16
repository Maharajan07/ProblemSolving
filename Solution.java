/* 912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.
  */


class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        return mergeSort(nums, res, 0, nums.length);
    }

    public int[] mergeSort(int[] nums, int[] res, int start, int end) {
        if (end - start <= 1) return nums;

        int mid = (start + end) / 2;
        mergeSort(nums, res, start, mid);
        mergeSort(nums, res, mid, end);
        sort(nums, res, start, mid, end);
        return nums;
    }

    public void sort(int[] nums, int[] res, int start, int mid, int end) {
        int i=start, j=mid, k=start;

        while (i<mid && j<end) {
            if (nums[i] < nums[j]) {
                res[k] = nums[i];
                i++;
                k++;
            }
            else {
                res[k] = nums[j];
                j++;
                k++;
            }
        }
        while (i<mid) {
            res[k] = nums[i];
            i++;
            k++;
        }
        while (j<end) {
            res[k] = nums[j];
            j++;
            k++;
        }
        for (int itr=start; itr<end; itr++) {
            nums[itr] = res[itr];
        }
    }
}


// Time Complexity: O(nlogn) where n is the length of the input array nums. The merge sort algorithm divides the array into halves recursively, resulting in a logarithmic number of levels (logn). At each level, we perform a linear merge operation that takes O(n) time. Therefore, the overall time complexity is O(nlogn).
// Space Complexity: O(n) where n is the length of the input array nums. We use an additional array res of the same size as nums to store the merged results during the sorting process.