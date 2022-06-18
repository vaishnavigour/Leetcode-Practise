/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if(head1==null || head2==null)
            return null;
        ListNode d1 = head1;
        ListNode d2 = head2;
        while(d1!=d2){
            if(d1!=null)
                d1 =d1.next;
            else
                d1 =head2;
            if(d2!=null)
                d2 = d2.next;
            else
                d2 = head1;
        }
        return d1;
    }
}