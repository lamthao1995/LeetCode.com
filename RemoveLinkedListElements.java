/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
       // if(head.val == val) return head.next;
        ListNode prev = new ListNode(val + 1), cur = head; prev.next = head;
        head = prev;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                 prev = cur;
                 cur = cur.next;
            }
           
        }
        return head.next;
    }
}