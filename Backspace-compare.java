/* 844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b". */


class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c:s.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            }
            else stackS.push(c);
        }
        for (char c:t.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            }
            else stackT.push(c);
        }

        return stackS.equals(stackT);
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)

/* 
// using Two-pointers

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            char c1 = (i >= 0) ? s.charAt(i) : '\0';
            char c2 = (j >= 0) ? t.charAt(j) : '\0';

            if (c1 != c2) return false;
            i--;
            j--;
        }
        return true;
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(1)
 */