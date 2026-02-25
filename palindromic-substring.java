/* 5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb" */


class Solution {
    int start = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        for (int i=0; i<s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start + maxLen);
    }
    private void expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;

        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)