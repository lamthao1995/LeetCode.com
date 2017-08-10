/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode t = null; ListNode root = t;
        if(l1.val < l2.val){
            t = l1;
            l1 = l1.next;
        }else{
            t = l2;
            l2 = l2.next;
        }
        root = t;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                t.next = l1;
                l1 = l1.next;
            }else{
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        if(l2 == null) t.next = l1;
        else t.next = l2;
        return root;
    }
}