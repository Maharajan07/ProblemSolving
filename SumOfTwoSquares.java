/* 633. Sum of Square Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: c = 3
Output: false */


class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = sqrt(c);

        while (left <= right) {
            long sum = (long) left*left + (long) right*right;
            if (sum == c) return true;
            else if (sum < c) left++;
            else right--;
        }
        return false;
    }
    private int sqrt(int c) {
        int low = 0;
        int high = c;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            long sqr = (long) mid * mid;

            if  (sqr == c) return mid;
            else if (sqr < c) low = mid+1;
            else high = mid-1;
        }
        return high;
    }
}

/* 
public class SumOfTwoSquares {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            long sqrSum = (long) left*left + (long) right*right;

            if (sqrSum == c) return true;
            else if (sqrSum < c) left++;
            else right--;
        }
        return false;
    }
}
 */

/*
// using Math Formula (a² + b² = c)

class Solution {
    public boolean judgeSquareSum(int c) {
        for (int a=0; a*a<=c; a++) {
            int b = (int) Math.sqrt(c - a*a);       // (b² = c - a²)

            if (b*b == c-a*a) return true;
        }
        return false;
    }
}
*/



// Time Complexity: O(√c)
// Space Complexity: O(1)