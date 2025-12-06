/* 345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede" */


class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length-1;

        while (l < r) {
            if (!isVowel(ch[l])) {
                l++;
                continue;
            }
            else if (!isVowel(ch[r])) {
                r--;
                continue;
            }
            else {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return new String(ch);
    }
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)