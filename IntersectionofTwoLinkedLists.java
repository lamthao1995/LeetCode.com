/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        if(headA == headB)
            return headA;
        ListNode runner = headA;
        while(runner.next != null){
            runner = runner.next;
        }
        runner.next = headB;
        ListNode low = headA.next;
        if(low == null) return returnNode(runner);
        ListNode fast = low.next;
        while(fast != low){
            low = low.next;
            if(fast == null || fast.next == null)
                return returnNode(runner);
            fast = fast.next.next;
            if(fast == null)
                return returnNode(runner);
        }
        low = headA;
        while(low != fast){
            low = low.next;
            fast = fast.next;
        }
        runner.next = null;
        return low;
    }
    public ListNode returnNode(ListNode r){
        r.next = null;
        return null;
    }
}