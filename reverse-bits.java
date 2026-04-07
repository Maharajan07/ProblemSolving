/* 190. Reverse Bits

Reverse bits of a given 32 bits signed integer.

Example 1:
Input: n = 43261596
Output: 964176192
Explanation:
    Integer	    Binary
    43261596	00000010100101000001111010011100
    964176192	00111001011110000010100101000000

Example 2:
Input: n = 2147483644
Output: 1073741822
Explanation:
    Integer	    Binary
    2147483644	01111111111111111111111111111100
    1073741822	0011111111111111111１１１１１１１１１１１０ */


class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for (int i=0; i<32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }

        return res;
    }
}

// Time Complexity: O(32) constant time
// Space Complexity: O(1)