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
    public ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1 , ListNode head2){
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
    
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 !=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 !=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return ans.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode  mid = findmid(head);
        ListNode part1 = head;
        ListNode part2 = mid.next;
        mid.next = null;
        
        part1 = sortList(part1);
        part2 = sortList(part2);
        ListNode ans = merge(part1 , part2);
        
        return ans;
        
    }
}