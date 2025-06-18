/* Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.

Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.

Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.

Constraints:
1 <= arr.size()<= 106
0 <= arr[i] <= 103
0 <= target <= 109 */


import java.util.ArrayList;
import java.util.Scanner;

public class IndexesOfSubarraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0, j = 0, sum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (j < arr.length) {
            sum += arr[j];

            while (i <= j && sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {
                result.add(i + 1); // 1-based index
                result.add(j + 1);
                return result;
            }
            j++;
        }

        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " non-negative integers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        ArrayList<Integer> result = subarraySum(arr, target);

        if (result.size() == 2) {
            System.out.println("Subarray found from index " + result.get(0) + " to " + result.get(1));
        } else {
            System.out.println("No subarray with the given sum found.");
        }
    }
}
