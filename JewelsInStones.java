/* 771. Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and
stones representing the stones you have. Each character in stones is a type of stone
you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0 */


import java.util.HashSet;
import java.util.Set;

public class JewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int res = 0;

        for (int i=0; i<jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int i=0; i<stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                res++;
            }
        }
        return res;
    }
}

// Time Complexity: O(m + n)
// Space Complexity: O(m)   -> (for set of jewels)


/* 
// Brute-force

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;

        for (int i=0; i<jewels.length(); i++) {
            for (int j=0; j<stones.length(); j++) {
                if (jewels.charAt(i) ==  stones.charAt(j)) {
                    res++;
                }
            }
        }
        return res;
    }
}

// Time Complexity: (m*n)
// Space Complexity: O(1)
 */