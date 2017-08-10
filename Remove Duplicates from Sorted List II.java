/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else
        {
            head.next = deleteDuplicates(head.next);    
        }
        return head;
    }
}