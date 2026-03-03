/* 796. Rotate String

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

    For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false */


class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int n = s.length();

        for (int shift=0; shift<n; shift++) {
            int i=0;

            while (i<n && s.charAt((i+shift) % n) == goal.charAt(i)) {
                i++;
            }
            if (i == n) return true;
        }
        return false;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)