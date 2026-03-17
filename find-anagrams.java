/* 438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab". */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[26];

        for (char ch:p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            char r = s.charAt(right);

            if (freq[r - 'a'] > 0) count--;
            freq[r - 'a']--;

            right++;

            if (count == 0) res.add(left);

            if (right - left == p.length()) {
                char l = s.charAt(left);

                if (freq[l - 'a'] >= 0) count++;
                freq[l - 'a']++;

                left++;
            }
        }
        return res;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)