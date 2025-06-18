/*Given an array, arr[]. Sort the array using bubble sort algorithm.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [1, 2, 3, 4, 5]
Output: [1, 2, 3, 4, 5]

Explanation: An array that is already sorted should remain unchanged after applying bubble sort.

Constraints:
1 <= arr.size() <= 103
1 <= arr[i] <= 103 */


import java.util.Arrays;

public class BubbleSort {
    // Function to sort the array using bubble sort algorithm
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 4, 2, 8};
        int[] nums2 = {3, 0, -2, 7, 1};

        System.out.println("Before sorting nums1: " + Arrays.toString(nums1));
        bubbleSort(nums1);
        System.out.println("After sorting nums1 : " + Arrays.toString(nums1));

        System.out.println("\nBefore sorting nums2: " + Arrays.toString(nums2));
        bubbleSort(nums2);
        System.out.println("After sorting nums2 : " + Arrays.toString(nums2));
    }
}
