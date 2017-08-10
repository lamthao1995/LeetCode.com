/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode cur = head, temp1 = odd, temp2 = even;
        while(cur != null && cur.next != null){
           temp1.next = cur;
           temp2.next = cur.next;
           cur = cur.next.next;
           temp1 = temp1.next;
           temp2 = temp2.next;
        }
        temp2.next = null;
        //temp1.next = even.next;
        if(cur != null){
            temp1.next = cur;
            temp1 = temp1.next;
        }
        temp1.next = even.next;
        return odd.next;
        
    }
}