/* 13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However,
the numeral for four is not IIII. Instead, the number four is written as IV. Because
the one is before the five we subtract it making four. The same principle applies to
the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. */


class Solution {

    // public int romanToInt(String s) {
    //    int sum = 0;
    //    int prev = 0;

    //    for (int i=s.length()-1; i>=0; i--) {
    //         int cur = value(s.charAt(i));

    //         if (cur < prev) {
    //             sum -= cur;
    //         }
    //         else {
    //             sum += cur;
    //         }
    //         prev = cur;
    //    } 
    //    return sum;
    // }

    public int romanToInt(String s) {
       int sum = 0;

       for (int i=0; i<s.length(); i++) {
            int cur = value(s.charAt(i));

            if (i < s.length()-1 && cur < value(s.charAt(i+1))) {
                sum -= cur;
            }
            else {
                sum += cur;
            }
       } 
       return sum;
    }
    private int value (char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

/* 
// using HashMap
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            int value = map.get(s.charAt(i));

            if (i < s.length()-1 && value < map.get(s.charAt(i+1))) {
                sum -= value;
            }
            else sum += value;
        }
        return sum;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
*/