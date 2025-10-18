/* 3289. The Two Sneaky Numbers of Digitville

In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.

As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.

Example 1:
Input: nums = [0,1,1,0]
Output: [0,1]
Explanation:
The numbers 0 and 1 each appear twice in the array.

Example 2:
Input: nums = [0,3,2,1,3,2]
Output: [2,3]
Explanation:
The numbers 2 and 3 each appear twice in the array.

Example 3:
Input: nums = [7,1,5,4,3,4,6,0,9,5,8,2]
Output: [4,5]
Explanation:
The numbers 4 and 5 each appear twice in the array. */


import java.util.ArrayList;
import java.util.List;

class TwoSneakyNumbers {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    if (!list.contains(nums[i])) {
                        list.add(nums[i]);
                    }
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(n)


/* 
// optimized solution

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        List<Integer> res = new  ArrayList<>();

        for (int num:nums) {
            freq[num]++;
            if (freq[num] == 2) {
                res.add(num);
            }
        }
        
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
} 
*/

/* 
// method -2 (using hashset)

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates= new HashSet<>();

        for (int num:nums) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        int[] res = new int[duplicates.size()];
        int i=0;
        for (int num:duplicates) {
            res[i++] = num;
        }
        return res;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) */