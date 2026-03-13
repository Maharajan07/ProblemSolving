/* 3120. Count the Number of Special Characters I

You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

Example 1:
Input: word = "aaAbcBC"
Output: 3
Explanation:
The special characters in word are 'a', 'b', and 'c'.

Example 2:
Input: word = "abc"
Output: 0
Explanation:
No character in word appears in uppercase.

Example 3:
Input: word = "abBCab"
Output: 1
Explanation:
The only special character in word is 'b'. */


class Solution {
    public int numberOfSpecialChars(String word) {
        int[] seen = new int[26];
        int count = 0;

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int idx = 0;

            // 0 - not seen
            // 1 - seen as lowercase
            // 2 - seen as uppercase
            // 3 - seen as both

            if (ch >= 'a' && ch <= 'z') {
                idx = ch - 'a';

                if (seen[idx] == 2) {   // already seen as uppercase
                    count++;    // count as special char
                    seen[idx] = 3;  // mark as both
                }
                else if (seen[idx] == 0) {  // seen as lowercase for the first time
                    seen[idx] = 1;
                }
            }
            if (ch >= 'A' && ch <= 'Z') {
                idx = ch - 'A';

                if (seen[idx] == 1) {   // already seen as lowercase
                    count++;    // count as special char
                    seen[idx] = 3;  // mark as both
                }
                else if (seen[idx] == 0) { // seen as uppercase for the first time
                    seen[idx] = 2;
                }
            }
        }
        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)