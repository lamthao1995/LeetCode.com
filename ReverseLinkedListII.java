/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root, prev = null;
        for(int i = 1; i <= m; i++){
            prev = p;
            p = p.next;    
        }
        ListNode part2 = p;
        for(int i = 1; i <= n - m; i++){
            p = p.next;
        }
        ListNode part3 = null;
        if(p.next != null){
            part3 = p.next;
            p.next = null;
        }
        ListNode reverse = part2;
        reverse = reverse(reverse);
        part2.next = part3;
        prev.next = reverse;
        return root.next;
    }
    public ListNode reverse(ListNode root){
        ListNode cur = root, prev = null, next = cur;
        while(cur != null){
            next = prev;
            prev = cur;
            cur = cur.next;
            prev.next = next;
        }
        return prev;
        //return head and tail
    }
}