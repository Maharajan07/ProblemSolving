/* 2816. Double a Number Represented as a Linked List

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.
 
Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.  */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode dummy = head;

        while (dummy != null) {
            st.push(dummy.val);
            dummy = dummy.next;
        }

        int carry = 0;
        ListNode doubleHead = null;

        while (!st.isEmpty() || carry > 0) {
            int val = st.isEmpty() ? 0 : st.pop();
            int total = val*2 + carry;
            int digit = total%10;
            carry = total/10;

            ListNode newNode = new ListNode(digit);
            newNode.next = doubleHead;
            doubleHead = newNode;
        }
        return doubleHead;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)

/* 
// without using stack

class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        ListNode prev = null;
        int carry = 0;

        while (temp != null) {
            int total = (temp.val)*2 + carry;
            temp.val = total%10;
            carry = total/10;
            prev = temp;
            temp = temp.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return reverse(head);
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
 */