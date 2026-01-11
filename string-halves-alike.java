/* 1704. Determine if String Halves Are Alike

You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

Example 2:
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice. */


class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int n = s.length();

        for (int i=0; i<n; i++) {
            if (isVowel(s.charAt(i))) {
                if (i < n/2) count++;
                else count--;
            }
        }

        return count == 0;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

/* 
class Solution {
    public boolean halvesAreAlike(String s) {
        int a = 0, b= 0;
        int mid = s.length()/2;

        for (int i=0; i<mid; i++) {
            if (alike(s.charAt(i))) a++;
        }

        for (int i=mid; i<s.length(); i++) {
            if (alike(s.charAt(i))) b++;
        }
        
        return a == b;
    }

    private boolean alike(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
 */