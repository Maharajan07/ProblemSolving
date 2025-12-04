/* 557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "Mr Ding"
Output: "rM gniD" */


class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String w:words) {
            char[] ch = w.toCharArray();
            int i=0, j=ch.length-1;

            while (i < j) {
                char temp = ch[j];
                ch[j] = ch[i];
                ch[i] = temp;
                i++;
                j--;
            }
            res.append(new String(ch)).append(" ");
        }
        return res.toString().trim();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)