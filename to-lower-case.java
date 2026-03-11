/* 709. To Lower Case

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely" */


class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch += 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)