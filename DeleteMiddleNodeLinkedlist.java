/* 2095. Delete the Middle Node of a Linked List

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Example 1:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 

Example 2:
Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
For n = 4, node 2 with value 3 is the middle node, which is marked in red.

Example 3:
Input: head = [2,1]
Output: [2]
Explanation:
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1. */


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
class DeleteMiddleNodeLinkedlist {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}


/* 
// method -2

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode len = dummy;
        ListNode fast = dummy;
        
        int count = 0;

        while (len.next != null) {
            len = len.next;
            count++;
        }

        for (int i=0; i<count/2; i++) {
            fast = fast.next;
        }
        fast.next = fast.next.next;

        return dummy.next;
    }
} */

// Time Complexity: O(n)
// Space Complexity: O(1)