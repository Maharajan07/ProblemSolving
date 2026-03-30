/* 264. Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5. */


class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        ugly[0] = 1;

        for (int i=1; i<n; i++) {
            int next2 = ugly[i2]*2;
            int next3 = ugly[i3]*3;
            int next5 = ugly[i5]*5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));

            ugly[i] = nextUgly;
            
            if (nextUgly == next2) i2++;
            if (nextUgly == next3) i3++;
            if (nextUgly == next5) i5++;
        }
        return ugly[n-1];
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)