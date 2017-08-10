/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        cur.next = head;
        for(int i = len - k % len; i > 1; i--){
            head = head.next;
        }
        cur = head.next;
        head.next = null;
        return cur;
        
    }
}