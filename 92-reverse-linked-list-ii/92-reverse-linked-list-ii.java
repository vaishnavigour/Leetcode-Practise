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
        if(head==null)
            return null;
        if(right==left)
            return head;
        ListNode curr  = head;
        ListNode prev = null;
        for(int i=1;i<left ; i++){
            prev =curr;
            curr = curr.next;
        }
        ListNode first = prev;
        ListNode sec = curr;
        ListNode next ;
        int k =right-left;
        while(curr!=null && k>=0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
            k--;
        }
        sec.next = curr;
        if(first!=null)
            first.next = prev;
        else
            head =prev;
        return head;
    }
}