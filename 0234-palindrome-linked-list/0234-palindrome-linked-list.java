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
    public boolean isPalindrome(ListNode head) {
        ListNode t= head, h2 = null;
        while(head!=null){
            ListNode h1 = new ListNode(head.val);
                h1.next = h2;
                h2= h1;
                head = head.next;
            
            
        }
        while(t!=null){
            if(t.val != h2.val)
                return false;
            t= t.next;
            h2 = h2.next;
        }
        return true;
        
        
    }
}