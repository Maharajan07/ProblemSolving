/* 917. Reverse Only Letters

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!" */


class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length-1;

        while (left < right) {
            if (isLetter(ch[left]) && isLetter(ch[right])) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            else if (!isLetter(ch[left])) {
                left++;
            }
            else {
                right--;
            }
        }
        return new String(ch);
    }
    public boolean isLetter(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)