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
    public ListNode middleNode(ListNode head) {
        ListNode slow =head;
        ListNode fast =head;
        ListNode prev = null;
        if(head==null|| head.next==null)
            return head;
        while(fast!= null && fast.next!=null){
            fast=fast.next.next;
            prev = slow;
            slow=slow.next;
        }
        return prev;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode mid = middleNode(head);
        mid.next = mid.next.next;
        return head;
    }
    
}