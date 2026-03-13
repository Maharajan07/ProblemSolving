/* 2309. Greatest English Letter in Upper and Lower Case

Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s. The returned letter should be in uppercase. If no such letter exists, return an empty string.

An English letter b is greater than another letter a if b appears after a in the English alphabet.

Example 1:
Input: s = "lEeTcOdE"
Output: "E"
Explanation:
The letter 'E' is the only letter to appear in both lower and upper case.

Example 2:
Input: s = "arRAzFif"
Output: "R"
Explanation:
The letter 'R' is the greatest letter to appear in both lower and upper case.
Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than 'F' or 'A'.

Example 3:
Input: s = "AbCdEfGhIjK"
Output: ""
Explanation:
There is no letter that appears in both lower and upper case. */


class Solution {
    public String greatestLetter(String s) {
        int[] seen = new int[26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                if (seen[idx] == 2) {
                    seen[idx] = 3;
                }
                else if (seen[idx] == 0) {
                    seen[idx] = 1;
                }
            }
            else if (ch >= 'A' && ch <= 'Z') {
                int idx = ch - 'A';
                if (seen[idx] == 1) {
                    seen[idx] = 3;
                }
                else if (seen[idx] == 0) {
                    seen[idx] = 2;
                }
            }
        }

        for (int i=25; i>=0; i--) {
            if (seen[i] == 3) {
                char res = (char) ('A' + i);
                return String.valueOf(res);
            }
        }
        return "";
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)