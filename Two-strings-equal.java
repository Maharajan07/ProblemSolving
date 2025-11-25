/* 1662. Check If Two String Arrays are Equivalent

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:
Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true */


class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);

        return s1.equals(s2);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)


/* 
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int p = 0, q = 0;

        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(p) != word2[j].charAt(q)) {
                return false;
            }
            p++;
            q++;

            if (p == word1[i].length()) {
                p = 0;
                i++;
            }
            if (q == word2[j].length()) {
                q = 0;
                j++;
            }
        }
        return i == word1.length && j == word2.length;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
 */