/* 290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false */


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i=0; i<pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(ch)) {
                if (!map1.get(ch).equals(word)) return false;
            }
            else {
                map1.put(ch, word);
            }

            if (map2.containsKey(word)) {
                if (!map2.get(word).equals(ch)) return false;
            }
            else {
                map2.put(word, ch);
            }
        }
        return true;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)