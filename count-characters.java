/* 1160. Find Words That Can Be Formed by Characters

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).

Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10. */


class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freqChars = new int[26];

        for (char c:chars.toCharArray()) {
            freqChars[c - 'a']++;
        }

        int sum = 0;
        for (String word:words) {
            int[] freq = freqChars.clone();
            boolean match = true;

            for (char c:word.toCharArray()) {
                freq[c - 'a']--;
                if (freq[c - 'a'] < 0) {
                    match = false;
                }
            }
            if (match) sum += word.length();
        }
        return sum;
    }
}

// Time Complexity: O(m * n)
// Space Complexity: O(1)