class Solution {
    public int numberOfSpecialChars(String word) {
        int[] seen = new int[26];
        int count = 0;

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int idx = 0;

            // 0 - not seen
            // 1 - seen as lowercase
            // 2 - seen as uppercase
            // 3 - seen as both

            if (ch >= 'a' && ch <= 'z') {
                idx = ch - 'a';

                if (seen[idx] == 2) {   // already seen as uppercase
                    count++;    // count as special char
                    seen[idx] = 3;  // mark as both
                }
                else if (seen[idx] == 0) {  // seen as lowercase for the first time
                    seen[idx] = 1;
                }
            }
            if (ch >= 'A' && ch <= 'Z') {
                idx = ch - 'A';

                if (seen[idx] == 1) {   // already seen as lowercase
                    count++;    // count as special char
                    seen[idx] = 3;  // mark as both
                }
                else if (seen[idx] == 0) { // seen as uppercase for the first time
                    seen[idx] = 2;
                }
            }
        }
        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)