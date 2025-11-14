/* 2481. Minimum Cuts to Divide a Circle

A valid cut in a circle can be:

A cut that is represented by a straight line that touches two points on the edge of the circle and passes through its center, or
A cut that is represented by a straight line that touches one point on the edge of the circle and its center.
Some valid and invalid cuts are shown in the figures below.


Given the integer n, return the minimum number of cuts needed to divide a circle into n equal slices.

Example 1:
Input: n = 4
Output: 2

Example 2:
Input: n = 3
Output: 3
Explanation:
At least 3 cuts are needed to divide the circle into 3 equal slices. =
Also note that the first cut will not divide the circle into distinct parts. */


class Solution {
    public int numberOfCuts(int n) {
        if(n == 1) return 0;
        return (n%2 == 0) ? n/2 : n;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)