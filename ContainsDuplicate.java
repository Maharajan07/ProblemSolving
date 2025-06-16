/* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109 */


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {7, 8, 9, 10, 7};

        System.out.println("nums1 contains duplicate? " + cd.containsDuplicate(nums1)); // false
        System.out.println("nums2 contains duplicate? " + cd.containsDuplicate(nums2)); // true
        System.out.println("nums3 contains duplicate? " + cd.containsDuplicate(nums3)); // true
    }
}
