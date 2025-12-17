/* 240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 
Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while (row < matrix.length && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) return true;
            else {
                if (cur < target) row++;
                else col--;
            }
        }
        return false;
    }
}

// Time Complexity: O(m+n)
// Space Complexity: O(1)


/* 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length-1;

            while (left <= right) {
                int mid = (left + right)/2;
                if (matrix[i][mid] == target) {
                    return true;
                }
                else {
                    if (matrix[i][mid] < target) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}

// Time Complexity: O(m*log n)
// Space Complexity: O(1)
 */