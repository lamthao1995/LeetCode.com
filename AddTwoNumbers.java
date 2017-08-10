/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        return add(new ListNode(0), 0, l1, l2);
    }
    public ListNode add(ListNode r, int hold, ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) {
            if(hold == 1) return new ListNode(1);
            return null;
        }
       //boolean c1 = false, c2 = false;
        int rs = hold;
        if(l1 != null){
            rs += l1.val;
        }
        if(l2 != null){
            rs += l2.val;
        }
        if(rs >= 10){
            r.val = rs % 10;
            r.next = add(new ListNode(0), 1, 
                         l1 == null ? null : l1.next, 
                         l2 == null ? null : l2.next);
        }else{
            r.val = rs;
            r.next = add(new ListNode(0), 0, 
                         l1 == null ? null : l1.next, 
                         l2 == null ? null : l2.next);
        }
        return r;
    }
}