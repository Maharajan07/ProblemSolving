/* 1684. Count the Number of Consistent Strings

You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent. */


class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();

        for (char ch:allowed.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (String word:words) {
            boolean ok = true;
            for (char ch:word.toCharArray()) {
                if (!set.contains(ch)) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }
}

// Time Complexity: O(m*n) where m is the number of words and n is the average length of the words
// Space Complexity: O(k) where k is the length of the allowed string