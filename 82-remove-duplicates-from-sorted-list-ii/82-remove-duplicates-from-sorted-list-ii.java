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
    public ListNode deleteDuplicates(ListNode head) {
        //make a dummy/Sentinel node to omit all the base conditions and 
        //point the next of dummy to head of given node
        ListNode dummy = new ListNode(0 , head);
        //Make a node previous to store the last distinct value that
        //we have found
        ListNode previous = dummy;
        
        while(head != null){
            if((head.next !=null) && head.val == head.next.val){
                //skipping the entire duplicate sublist
                while(head.next!=null && head.val == head.next.val){
                    head = head.next;
                }
                previous.next = head.next;
            }
            else{
                previous = previous.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}