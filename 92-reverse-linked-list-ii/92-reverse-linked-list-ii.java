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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        for(int i=1;i<left ; i++){
            prev= curr;
            curr=curr.next;
        }
        ListNode first = prev;
        ListNode sec = curr;
        int k = right-left;
        while(k-->=0 && curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        sec.next =curr;
        if(first==null)
            head =prev;
        else
            first.next = prev;
        return head;
    }
}