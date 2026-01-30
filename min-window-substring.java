/* 76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string. */


class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int req = t.length();

        for (char c:t.toCharArray()) {
            freq[c]++;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left=0;

        for (int right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            
            if (freq[c] > 0) req--;
            freq[c]--;

            while (req == 0) {
                int len = right-left+1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char leftC = s.charAt(left);
                freq[leftC]++;
                if (freq[leftC] > 0) req++;
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start+minLen);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)