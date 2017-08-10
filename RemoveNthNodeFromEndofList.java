/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head, cur = head, prev = null;
        for(int i = 1; i < n; i++){
            last = last.next;
        }
        
        if(last == null) return null;
        while(last.next != null){
            last = last.next;
            prev = cur;
            cur = cur.next;
        }
        if(prev != null) prev.next = cur.next;
        else head = head.next;
        return head;
        
    }
}