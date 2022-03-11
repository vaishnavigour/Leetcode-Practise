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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p =head;
        if(head==null)
            return head;
        
        int n =0;
         
        
        while(p !=null){
            n++;
            p = p.next; 
        }
        k= k%n;
        while(k>0){
            ListNode curr =head;
            // if(curr.next ==null)
            //     return curr;
            while(curr.next.next !=null){
                curr = curr.next;
            }
            ListNode q = curr.next;
            curr.next = null;
            q.next =head;
            head = q;
            
            k--;
        }
        return head;
        
        
    }
}