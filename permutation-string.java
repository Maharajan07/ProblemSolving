/* 567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false */


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for (char ch:s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            char ch = s2.charAt(right);

            if (freq[ch - 'a'] > 0) count--;
            freq[ch - 'a']--;

            right++;

            if (count == 0) return true;

            if (right - left == s1.length()) {
                char leftChar = s2.charAt(left);
                
                if (freq[leftChar - 'a'] >= 0) count++;
                freq[leftChar - 'a']++;

                left++;
            }
        }
        return false;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)