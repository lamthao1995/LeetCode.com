/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
                
        }
        if(slow == head){
            return;
        }
        Queue<ListNode> s = new LinkedList();
        Stack<ListNode> e = new Stack();
        fast = head;
        while(fast != slow){
            s.add(fast);
            fast = fast.next;
        }
        while(slow != null){
            e.push(slow);
            slow = slow.next;
        }
    	ListNode root = s.poll();
        root.next = e.pop();
        head = root;
        root = root.next;
        while(!s.isEmpty() && !e.isEmpty()){
            root.next = s.poll(); root = root.next;
            root.next = e.pop(); root = root.next;
        }
        if(!s.isEmpty()){
            root.next = s.poll();
             root.next.next = null;
             root = root.next;
        }
        if(!e.isEmpty()){
            root.next = e.pop();
            root.next.next = null;
            root = root.next;
        }
        if(root != null) root.next= null;
        
    }
}