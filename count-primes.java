/* 204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0 */


class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];

        for (int i=2; i<n; i++) {
            prime[i] = true;
        }

        for (int i=2; i*i<n; i++) {
            if (prime[i] == true) {
                for (int j=i*i; j<n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (prime[i] == true) count++;
        }

        return count;
    }
}

// Time Complexity: O(n log log n)
// Space Complexity: O(n)